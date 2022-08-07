package db.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import db.logic.Logic;

public class RestaurantPages {

	private JFrame frame;
	private JTextArea textArea;
	private Logic logic;

	/**
	 * Constructor
	 */
	public RestaurantPages(final Logic logic) {
		this.initialize();
		this.logic = logic;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Hotel Malenia - Ristorante");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel role = new JLabel("Servizio ristorazione");
		role.setHorizontalAlignment(SwingConstants.CENTER);
		role.setFont(new Font("Verdana", Font.BOLD, 18));
		role.setForeground(Color.RED);
		role.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(role, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		/*
		 * Shows people coming for breakfast.
		 */
		JButton breakfast = new JButton("Colazione");
		breakfast.addActionListener(e -> {
			this.logic.showRestaurantTables("Colazione");
			this.textArea.setText("");
			
			Connection conn = null;
			PreparedStatement myStm = null;
			ResultSet result = null;
			
			try {
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , this.logic.getOwnPassword());
				myStm = conn.prepareStatement("SELECT SCHEDA.numeroCamera FROM SCHEDA "
											+ "WHERE SCHEDA.numeroCamera IS NOT NULL");
				result = myStm.executeQuery();
				
				while(result.next()) {
					this.textArea.append(result.getString(1) + "\n");
				}
				
			} catch (SQLException exc) {
				exc.printStackTrace();
			}
		});
		
		breakfast.setBackground(Color.BLACK);
		breakfast.setForeground(Color.ORANGE);
		breakfast.setFont(new Font("Verdana", Font.BOLD, 12));
		breakfast.setBounds(808, 34, 111, 23);
		panel.add(breakfast);
		
		/*
		 * Shows people coming for lunch.
		 */
		JButton lunch = new JButton("Pranzo");
		lunch.addActionListener(e -> {
			this.logic.showRestaurantTables("Pranzo");
			this.textArea.setText("");
			
			Connection conn = null;
			PreparedStatement myStm = null;
			ResultSet result = null;
			
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , this.logic.getOwnPassword());
				myStm = conn.prepareStatement("SELECT SCHEDA.numeroCamera FROM SCHEDA "
											+ "WHERE datiGestionali_tariffa = ? "
											+ "AND datiGestionali_tariffa = ?");
				myStm.setString(1, "AllInclusive");
				myStm.setString(2, "PensioneCompleta");
				result = myStm.executeQuery();
				
				while(result.next()) {
					this.textArea.append(result.getString(1) + "\n");
				}
				
			} catch (SQLException exc) {
				exc.printStackTrace();
			}
		});
		
		lunch.setForeground(Color.ORANGE);
		lunch.setFont(new Font("Verdana", Font.BOLD, 12));
		lunch.setBackground(Color.BLACK);
		lunch.setBounds(808, 68, 111, 23);
		panel.add(lunch);
		

		
		/*
		 * Shows people coming for dinner.
		 */
		JButton dinner = new JButton("Cena");
		dinner.addActionListener(e -> {
			this.logic.showRestaurantTables("Cena");
			this.textArea.setText("");
			
			Connection conn = null;
			PreparedStatement myStm = null;
			ResultSet result = null;
			
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , this.logic.getOwnPassword());
				myStm = conn.prepareStatement("SELECT SCHEDA.numeroCamera FROM SCHEDA "
											+ "WHERE datiGestionali_tariffa = ? "
											+ "AND datiGestionali_tariffa = ?");
				myStm.setString(1, "AllInclusive");
				myStm.setString(2, "PensioneCompleta");
				result = myStm.executeQuery();
				while(result.next()) {
					this.textArea.append(result.getString(1) + "\n");
				}
				
			} catch (SQLException exc) {
				exc.printStackTrace();
			}
		});
		
		dinner.setForeground(Color.ORANGE);
		dinner.setFont(new Font("Verdana", Font.BOLD, 12));
		dinner.setBackground(Color.BLACK);
		dinner.setBounds(808, 102, 111, 23);
		panel.add(dinner);
		
		/*
		 * Logout from application part
		 */
		JButton logout = new JButton("Logout");
		logout.addActionListener(e -> {
			frame.dispose();
			this.logic.logout();
		});
		
		logout.setForeground(Color.ORANGE);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(830, 432, 89, 23);
		panel.add(logout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 792, 444);
		panel.add(scrollPane);
		
		/*
		 * TextArea to be updated when you require a particular set of clients to be shown.
		 */
		this.textArea = new JTextArea();
		textArea.setForeground(Color.PINK);
		textArea.setFont(new Font("Verdana", Font.BOLD, 12));
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		scrollPane.setViewportView(textArea);
	}
	
	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frame;
	}
}
