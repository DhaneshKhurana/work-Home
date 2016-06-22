package chatClient;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame {
		
		private JTextField textfield;
		private JTextArea chatWindow;
		private ObjectOutputStream output;
		private ObjectInputStream input;
		private String serverIP;
		private Socket connection;
		
		//Constructor
		Client(String ip)
		{
			super("Instant Messanger - CLIENT");
			serverIP=ip;
			textfield = new JTextField("Enter your text here");
			textfield.setEditable(true);				//try making it true permanently
			textfield.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							sendText(e.getActionCommand());
							textfield.setText("");
						}
					}
				);
			chatWindow = new JTextArea();
			add(new JScrollPane(chatWindow), BorderLayout.CENTER);
			add(textfield, BorderLayout.SOUTH);
			setSize(300,400);
			setVisible(true);
		}
		
		// Setup and start Server
		public void startClient()
		{
			boolean a = true;
			while(a)
				{
					try
					{
						connectToServer();
						setupStreams();
						whileChatting();
					}
					catch(Exception eof)
					{
						showMessage("Server has ended the connection");
					}
					finally
					{
						closeClient();
						a= false;
					}
				}
		}
		
		//connecting To Server
		private void connectToServer(){
			try{
				showMessage("attempting to connect \n");
				connection = new Socket(InetAddress.getByName(serverIP),7000);
				showMessage("connected to " + connection.getInetAddress().getHostName());
			}catch(IOException io){
				io.printStackTrace();
			}
		}
		
		//setting up streams
		private void setupStreams(){
			try{
				output= new ObjectOutputStream(connection.getOutputStream());
				output.flush();
				input= new ObjectInputStream(connection.getInputStream());
			}catch(IOException io){
				io.printStackTrace();
			}
		}
		
		//whileChatting
		private void whileChatting(){
			String message="";
			try{
				do{
					message =(String) input.readObject();
					showMessage("SERVER - "+message);
				}while(!message.equals("END"));
			//showMessage("out of while loop");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		private void showMessage(String message){
			SwingUtilities.invokeLater(
					new Runnable(){
						public void run(){
							chatWindow.append(message+"\n");
						}
					}
				);
			
		}
		
		private void sendText(String message){
			try{
				output.writeObject(message);
				showMessage(message);
			}catch(IOException io){
				io.printStackTrace();
			}
			
		}
		
		private void closeClient(){
			try{
				showMessage("closing connection");
				output.close();
				input.close();
				connection.close();
			}catch(IOException io){
				io.printStackTrace();
			}
		}
		
	}


