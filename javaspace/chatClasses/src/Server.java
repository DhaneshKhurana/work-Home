import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame{
	
	static final long serialVersionUID = 2;
	private JTextField textfield;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
	//Constructor
	Server()
	{
		super("Instant Messanger - SERVER");
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
	public void startServer()
	{
		try
		{
			server = new ServerSocket(7000, 100);
			boolean a = true;
			while(a)
			{
				try
				{
					waitingForConnection();
					setupStreams();
					whileChatting();
				}
				catch(Exception eof)
				{
					showMessage("Server has ended the connection");
				}
				finally
				{
					closeServer();
					a = false;
				}
			}
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
	}
	
	//waiting for connection
	private void waitingForConnection(){
		try{
			showMessage("waiting for someone to connect");
			connection = server.accept();
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
		String message;
		try{
			do{
				message =(String) input.readObject();
				showMessage("CLIENT - "+message);
			}while(!message.equalsIgnoreCase("END"));
			//showMessage("got out of while");
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
	
	private void closeServer(){
		try{
			showMessage("Closing connection");
			output.close();
			input.close();
			connection.close();
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
}





