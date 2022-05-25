package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.Resultset;

import db.connections.Database_Conn;

public class ManagerPages {
	private JFrame frame;
	JFrame caller = null;
	Database_Conn j;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPages window = new ManagerPages();
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
	public ManagerPages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnVisualizzaResoconto = new JButton("Visualizza schede");
		btnVisualizzaResoconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection myConn = null;
				 Statement myStmt = null;
				 ResultSet myRs = null;
				
				try {
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , "dariostudente");
					System.out.println("Database connected");
					// 2. Create a statement
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery("SELECT * FROM SCHEDE");
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
				
			}
		});
		btnVisualizzaResoconto.setForeground(Color.ORANGE);
		btnVisualizzaResoconto.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVisualizzaResoconto.setBackground(Color.DARK_GRAY);
		btnVisualizzaResoconto.setBounds(276, 65, 385, 93);
		panel.add(btnVisualizzaResoconto);
		
		JButton btnListini = new JButton("Listini");
		btnListini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection myConn = null;
				 Statement myStmt = null;
				 ResultSet myRs = null;
				
				try {
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , "dariostudente");
					System.out.println("Database connected");
					// 2. Create a statement
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery("SELECT * FROM LISTINI");
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnListini.setForeground(Color.ORANGE);
		btnListini.setFont(new Font("Verdana", Font.BOLD, 12));
		btnListini.setBackground(Color.DARK_GRAY);
		btnListini.setBounds(276, 188, 385, 93);
		panel.add(btnListini);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPages login = new LoginPages();
				login.frame.setVisible(true);
				
			}
		});
		logout.setFont(new Font("Tahoma", Font.BOLD, 11));
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(830, 432, 89, 23);
		panel.add(logout);
		
		JLabel lblNewLabel = new JLabel("Manager");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	}
}
