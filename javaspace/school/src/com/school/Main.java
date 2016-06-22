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

import java.awt.Component;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFormattedTextField;

public class Main {
	
	Connection con;
	static java.sql.Statement st;
	public java.sql.Statement getStatement(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
	          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root","mysql@121");
	          st= con.createStatement();
		}catch(Exception e){
			System.out.println("Error with database connectivity ::" + e);
		}
		return st;    
	}

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField;
	private JTextField view_id;
	private JTextField view_name;
	private JTable table;
	DefaultTableModel tablemodel = new DefaultTableModel();
	String[] headings= {"S.No", "Name", "Father", "D.O.B", "class", "section"};
	private JTextField trVehicleId;
	private JTextField trVehicleName;
	private JTextField trRoute;
	private JTextField trDriverName;
	private JTextField trDriverContact;
	private JTextField trCost;
	DefaultTableModel trtblmodel = new DefaultTableModel();
	String[] trtblheadings= {"S.No", "Vehicle Id", "Vehicle Name", "Route", "Driver Name", "Driver Number", "cost"};
	private ArrayList<JTextField> trText = new ArrayList<JTextField>();
	private int i=0;
	private JTable trTable;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
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
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dashboard", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(null);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setIcon(new ImageIcon(Main.class.getResource("/com/school/setup.jpg")));
		//btnSettings.setSize(500, 10);
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnSettings.setBounds(50, 66, 95, 92);
		panel_9.add(btnSettings);
		
		JButton btnTeachers = new JButton("Teachers");
		btnTeachers.setIcon(new ImageIcon(Main.class.getResource("/com/school/staff.jpg")));
		btnTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnTeachers.setBounds(205, 66, 102, 92);
		panel_9.add(btnTeachers);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setIcon(new ImageIcon(Main.class.getResource("/com/school/admin.jpg")));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		btnAdmin.setBounds(349, 66, 102, 92);
		panel_9.add(btnAdmin);
		
		JButton btnLedger = new JButton("Ledger");
		btnLedger.setIcon(new ImageIcon(Main.class.getResource("/com/school/money-bag.png")));
		btnLedger.setBounds(490, 66, 94, 92);
		panel_9.add(btnLedger);
		
		JButton btnLibrary = new JButton("Library");
		btnLibrary.setIcon(new ImageIcon(Main.class.getResource("/com/school/library.jpg")));
		btnLibrary.setBounds(50, 180, 115, 92);
		panel_9.add(btnLibrary);
		
		JButton btnSections = new JButton("Sections");
		btnSections.setIcon(new ImageIcon(Main.class.getResource("/com/school/school_management.jpg")));
		btnSections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnSections.setBounds(205, 180, 102, 92);
		panel_9.add(btnSections);
		
		 
		
		JButton btnExams = new JButton("Exams");
		btnExams.setIcon(new ImageIcon(Main.class.getResource("/com/school/examination.jpg")));
		btnExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(8);
			}
		});
		btnExams.setBounds(349, 180, 65, 52);
		panel_9.add(btnExams);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setIcon(new ImageIcon(Main.class.getResource("/com/school/admin.jpg")));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnStudents.setBounds(490, 180, 94, 92);
		panel_9.add(btnStudents);
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Configuration", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Student Manager", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 621, 386);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_1.addTab("New Admission", null, panel_10, null);
		panel_10.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(10, 5, 596, 61);
		panel_10.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblHomeDashboard = new JLabel("Home > Dashboard");
		lblHomeDashboard.setBounds(10, 11, 108, 14);
		panel_13.add(lblHomeDashboard);
		
		JLabel lblNewAdmission = new JLabel("New Admission");
		lblNewAdmission.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewAdmission.setBounds(10, 30, 126, 31);
		panel_13.add(lblNewAdmission);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 596, 269);
		panel_10.add(scrollPane);
		
		JPanel panel_14 = new JPanel();
		scrollPane.setViewportView(panel_14);
		panel_14.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/com/school/admin.jpg")));
		label.setBounds(10, 11, 100, 102);
		panel_14.add(label);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setBounds(120, 11, 82, 26);
		panel_14.add(lblSection);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(120, 37, 82, 26);
		panel_14.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(120, 61, 82, 26);
		panel_14.add(lblAge);
		
		JLabel lblDob = new JLabel("D.O.B.");
		lblDob.setBounds(120, 87, 82, 26);
		panel_14.add(lblDob);
		
		JLabel lblTelephone = new JLabel("TelePhone");
		lblTelephone.setBounds(120, 113, 82, 26);
		panel_14.add(lblTelephone);
		
		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setBounds(120, 139, 82, 26);
		panel_14.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(120, 166, 82, 26);
		panel_14.add(lblPassword);
		
		JLabel lblSection_1 = new JLabel("Section");
		lblSection_1.setBounds(120, 193, 82, 26);
		panel_14.add(lblSection_1);
		
		
		
		JButton btnResest = new JButton("Resest");
		btnResest.setBounds(451, 244, 89, 23);
		panel_14.add(btnResest);
		
		JLabel lblFatthersName = new JLabel("Fatther's Name");
		lblFatthersName.setBounds(345, 11, 82, 26);
		panel_14.add(lblFatthersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setBounds(345, 37, 82, 26);
		panel_14.add(lblMothersName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(345, 61, 82, 26);
		panel_14.add(lblGender);
		
		JLabel lblHouseNo = new JLabel("House No.");
		lblHouseNo.setBounds(345, 87, 82, 26);
		panel_14.add(lblHouseNo);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(345, 113, 82, 26);
		panel_14.add(lblNationality);
		
		JLabel lblPeriod = new JLabel("Period");
		lblPeriod.setBounds(345, 139, 82, 26);
		panel_14.add(lblPeriod);
		
		JLabel lblTotalFees = new JLabel("Total Fees");
		lblTotalFees.setBounds(345, 166, 82, 26);
		panel_14.add(lblTotalFees);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 43, 117, 20);
		panel_14.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(188, 69, 117, 20);
		panel_14.add(textField_2);
		
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter()); 
		datePicker.setTextEditable(true); 
		/*textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(188, 93, 117, 20);*/
		datePicker.setBounds(188, 93, 117, 20);
		panel_14.add(datePicker);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(188, 119, 117, 20);
		panel_14.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(188, 145, 117, 20);
		panel_14.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(188, 171, 117, 20);
		panel_14.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(188, 198, 117, 20);
		panel_14.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(437, 11, 117, 20);
		panel_14.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(437, 37, 117, 20);
		panel_14.add(textField_9);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(437, 87, 117, 20);
		panel_14.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(437, 113, 117, 20);
		panel_14.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(437, 139, 117, 20);
		panel_14.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(437, 166, 117, 20);
		panel_14.add(textField_14);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"a", "b", "c"}));
		comboBox.setBounds(188, 11, 117, 23);
		panel_14.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox_1.setBounds(437, 61, 117, 23);
		panel_14.add(comboBox_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try
		         {    
					 String name = textField_1.getText();
					 String age = textField_2.getText();
					 java.sql.Date dob = (java.sql.Date) datePicker.getModel().getValue();
					 String phone = textField_4.getText();
					 String userId = textField_5.getText();
					 String pwd = textField_6.getText();
					 String cls = textField_7.getText();
					 String fname = textField_8.getText();
					 String mname = textField_9.getText();
					 String house = textField_11.getText();
					 String period = textField_12.getText();
					 String Nationality  = textField_13.getText();
					 int fees = Integer.parseInt(textField_14.getText());
					 String section = (String)comboBox.getSelectedItem();
					 String gender = (String)comboBox_1.getSelectedItem();
							 
			          
			          
					  getStatement().execute("insert into students values('"+name+"','"+age+"','"+dob+"','"+phone+"','"+userId+"','"+pwd+"','"+section+"','"+fname+"','"+mname+"','"+house+"','"+Nationality+"','"+fees+"','"+gender+"','"+cls+"')");
					  
					  System.out.println("yes the database has been updated");
		         }         
		     catch(Exception e)
		        {
		    	 e.printStackTrace();
		        }
			}
		});
		btnSubmit.setBounds(345, 244, 89, 23);
		panel_14.add(btnSubmit);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_1.addTab("Fees Manager", null, panel_11, null);
		
		textField = new JTextField();
		panel_11.add(textField);
		textField.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		panel_11.add(formattedTextField);
		
		JPanel panel_12 = new JPanel();
		tabbedPane_1.addTab("View Student", null, panel_12, null);
		panel_12.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 19, 14);
		panel_12.add(lblId);
		
		view_id = new JTextField();
		view_id.setBounds(30, 8, 86, 20);
		panel_12.add(view_id);
		view_id.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(167, 11, 33, 14);
		panel_12.add(lblName_1);
		
		view_name = new JTextField();
		view_name.setBounds(210, 8, 86, 20);
		panel_12.add(view_name);
		view_name.setColumns(10);
		
		
		
		JLabel lblClass = new JLabel("class");
		lblClass.setBounds(355, 11, 33, 14);
		panel_12.add(lblClass);
		
		table = new JTable();
		
		table.setBounds(40, 39, 500, 300);
		panel_12.add(table);
		
		
		JComboBox view_class = new JComboBox();
		view_class.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				tablemodel = new DefaultTableModel();
				tablemodel.setColumnIdentifiers(headings);
				String cls = (String)event.getItem();
				String query = "select name, fatherName, dob, class, section from students where class='"+cls+"'";
				
				try{
					
					ResultSet rs = getStatement().executeQuery(query);
					int i = 1;
					String[] col= new String[5];
					while(rs.next()){
						tablemodel.addRow(new Object[]{i++, rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
					}
				}catch(Exception e){
					System.out.println("Could not fecth data cuz :: " + e);
				}
				finally{
					table.setModel(tablemodel);
				}
				
			}
		});
		view_class.setModel(new DefaultComboBoxModel(new String[] {"Select Class", "1", "2", "3", "4", "5", "6", "7", "8"}));
		view_class.setBounds(398, 8, 139, 20);
		panel_12.add(view_class);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Staff Manager", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Section Manager", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Admin Manager", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Transport Manager", null, panel_6, null);
		panel_6.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(10, 11, 601, 364);
		panel_6.add(tabbedPane_2);
		
		JPanel panel_15 = new JPanel();
		tabbedPane_2.addTab("Create New", null, panel_15, null);
		panel_15.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle Id");
		lblNewLabel.setBounds(56, 62, 93, 14);
		panel_15.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("Vehicle Name");
		label_1.setBounds(56, 94, 93, 14);
		panel_15.add(label_1);
		
		JLabel label_2 = new JLabel("Route");
		label_2.setBounds(56, 137, 93, 14);
		panel_15.add(label_2);
		
		JLabel label_3 = new JLabel("Driver Name");
		label_3.setBounds(56, 177, 93, 14);
		panel_15.add(label_3);
		
		JLabel label_4 = new JLabel("Driver Contact No.");
		label_4.setBounds(56, 216, 93, 14);
		panel_15.add(label_4);
		
		JLabel label_5 = new JLabel("Cost");
		label_5.setBounds(56, 254, 93, 14);
		panel_15.add(label_5);
		
		trVehicleId = new JTextField();
		trVehicleId.setBounds(227, 59, 200, 20);
		panel_15.add(trVehicleId);
		trVehicleId.setColumns(10);
		
		trVehicleName = new JTextField();
		trVehicleName.setColumns(10);
		trVehicleName.setBounds(227, 91, 200, 20);
		panel_15.add(trVehicleName);
		
		trRoute = new JTextField();
		trRoute.setColumns(10);
		trRoute.setBounds(227, 134, 200, 20);
		panel_15.add(trRoute);
		
		trDriverName = new JTextField();
		trDriverName.setColumns(10);
		trDriverName.setBounds(227, 174, 200, 20);
		panel_15.add(trDriverName);
		
		trDriverContact = new JTextField();
		trDriverContact.setColumns(10);
		trDriverContact.setBounds(227, 213, 200, 20);
		panel_15.add(trDriverContact);
		
		trCost = new JTextField();
		trCost.setColumns(10);
		trCost.setBounds(227, 251, 200, 20);
		panel_15.add(trCost);
		
		JButton trSubmit = new JButton("Submit");
		trSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String vehicleId = trVehicleId.getText();
				String vehicleName = trVehicleName.getText();
				String route = trRoute.getText();
				String driverName = trDriverName.getText();
				String driverNumber = trDriverContact.getText();
				String cost = trCost.getText();
				
				String query = "insert into transport values ('"+vehicleId+"', '"+vehicleName+"', '"+route+"', '"+driverName+"', '"+driverNumber+"', '"+cost+"')";
				
				
				try{
					getStatement().execute(query);
					
				}catch(Exception e){
					System.out.println("transport data insert failed  " + e);
				}finally{
					trVehicleId.setText("");
					trVehicleName.setText("");
					trRoute.setText("");
					trDriverName.setText("");
					trDriverContact.setText("");
					trCost.setText("");
				}
			}
		});
		trSubmit.setBounds(227, 302, 89, 23);
		panel_15.add(trSubmit);
		
		JButton trReset = new JButton("Reset");
		trReset.setBounds(326, 302, 89, 23);
		panel_15.add(trReset);
		
		JPanel panel_16 = new JPanel();
		tabbedPane_2.addTab("Manage Transportation", null, panel_16, null);
		panel_16.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(10, 11, 576, 263);
		panel_16.add(panel_17);
		
		trTable = new JTable();
		panel_17.add(trTable);
		
		trtblmodel = new DefaultTableModel();
		trtblmodel.setColumnIdentifiers(trtblheadings);
		String qry = "select vehicleId, vehicleName, route, driverName, driverNumber, cost from transport";
		
		try{
			
			ResultSet rs = getStatement().executeQuery(qry);
			
			int row=1;
			while(rs.next()){
				trtblmodel.addRow(new Object[]{row++, rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
				
				System.out.println("row added with values :: "+  rs.getString(1) + " " + rs.getString(2)+" " +rs.getString(3) +  " " + rs.getString(4) +   " " +  rs.getString(5) +   " " +  rs.getString(6) );
			}
		}catch(Exception e){
			System.out.println("Could not fecth data cuz :: " + e);
		}
		finally{
			trTable.setModel(trtblmodel);
			System.out.println(" table model is getting initalized ");
		}
		
		JButton trEdit = new JButton("Edit");
		trEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				trtblmodel = new DefaultTableModel();
				trtblmodel.setColumnIdentifiers(trtblheadings);
				String qry = "select vehicleId, vehicleName, route, driverName, driverNumber, cost from transport";
				
				try{
					
					ResultSet rs = getStatement().executeQuery(qry);
					
					int row=1;
					while(rs.next()){
						trText.add(new JTextField(rs.getString(1)));
						trText.add(new JTextField(rs.getString(2)));
						trText.add(new JTextField(rs.getString(3)));
						trText.add(new JTextField(rs.getString(4)));
						trText.add(new JTextField(rs.getString(5)));
						trText.add(new JTextField(rs.getString(6)));
						trtblmodel.addRow(new Object[]{row++,(JTextField)trText.get(0), rs.getString(i+1),rs.getString(i+2),rs.getString(i+3),rs.getString(i+4),rs.getString(i+5)});
						i=+6;
					}
				}catch(Exception e){
					System.out.println("Could not fecth data cuz :: " + e);
				}
				finally{
					trTable.setModel(trtblmodel);
				}
			}
		});
		trEdit.setBounds(328, 302, 89, 23);
		panel_16.add(trEdit);
		
		JButton trUpdate = new JButton("Update");
		trUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int j =0;
				while(j<i){
					String vid = ((JTextField)trText.get(i)).getText();
					String vehicleName = ((JTextField)trText.get(i+1)).getText();
					String route = ((JTextField)trText.get(i+2)).getText();
					String driverName = ((JTextField)trText.get(i+3)).getText();
					String driverNumber = ((JTextField)trText.get(i+4)).getText();
					int cost = Integer.parseInt(((JTextField)trText.get(i+5)).getText());

					String qry = "update transport set vehicleName='"+vehicleName+"', route='"+route+"', driverName='"+driverName+"', driverNumber='"+driverNumber+"', cost = '"+cost+"' where vehicleId='"+vid+"'";
					try{
						int k= getStatement().executeUpdate(qry);
					}catch(Exception e){
						System.out.println("Error in updating" + e);
					}finally{
						j+=6;
					}
					
				}
				
				
				
				
			}
		});
		trUpdate.setBounds(436, 302, 89, 23);
		panel_16.add(trUpdate);
		
		
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Event Manager", null, panel_7, null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("School Results", null, panel_8, null);
	}
}
