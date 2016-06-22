package com.school;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Home {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnWelcome = new JMenu("Welcome");
		menuBar.add(mnWelcome);
		
		JMenuItem mntmProfile = new JMenuItem("Profile");
		mnWelcome.add(mntmProfile);
		
		JMenuItem mntmLogout = new JMenuItem("LogOut");
		mnWelcome.add(mntmLogout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		frame.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dashboard", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Configuration", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Student Manager", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Staff Manager", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Section Manager", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Admin Manager", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Transport Manager", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Event Manager", null, panel_7, null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("School Results", null, panel_8, null);
	}
}
