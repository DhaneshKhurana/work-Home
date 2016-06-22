package com.school;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Id");
		lblName.setBounds(98, 63, 27, 14);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(216, 60, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(216, 97, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(98, 100, 61, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel msg = new JLabel("");
		msg.setBounds(109, 179, 212, 28);
		frame.getContentPane().add(msg);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String id = textField.getText();
				String pwd = passwordField.getText();
				System.out.println("values i put in  :: " + id+ " :: " + pwd);
				String query = "select id, password from admin where id='"+id+"' and password = '"+pwd+"'";
				
				try{
					
					ResultSet rs = Main.st.executeQuery(query);
					if(rs.next()){
						if(rs.getString(1)!=null && rs.getString(1)!=""){
							if(rs.getString(1).equals(id) && rs.getString(2).equals(pwd)){
								msg.setText("login Succesful");
							}
							else{
								msg.setText("Username or password Incorrect");
							}
						}
						else
						{
							msg.setText("No such UserName Exists!");
						}
					}
				}catch(Exception e){
						System.out.println("Login me problem hai :: "+ e);
				}
			}
		});
		btnSubmit.setBounds(164, 145, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		
	}
}
