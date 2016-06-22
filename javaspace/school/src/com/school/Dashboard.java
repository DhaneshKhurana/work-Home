package com.school;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePickerImpl;

public class Dashboard extends JPanel {
	
	JButton bsettings, bteachers, badmin, bledger, blib, bsec, bexam, bstudent;
	
	public Dashboard(){
		bsettings = new JButton("Settings", null);
		bteachers = new JButton("Teachers", null);
		badmin = new JButton("Admin", null);
		bledger = new JButton("Ledger", null);
		blib = new JButton("Library", null);
		bsec = new JButton("Section", null);
		bexam = new JButton("Examination", null);
		bstudent = new JButton("Student", null);
	}
	
	public void paintComponent(){
		
	}
}
