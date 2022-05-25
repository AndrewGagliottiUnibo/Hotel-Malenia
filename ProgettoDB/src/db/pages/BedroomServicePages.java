package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class BedroomServicePages {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BedroomServicePages window = new BedroomServicePages();
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
	public BedroomServicePages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Hotel Malenia - Servizio camere");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.PINK);
		textArea.setFont(new Font("Verdana", Font.BOLD, 15));
		textArea.setBackground(Color.BLACK);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JLabel role = new JLabel("Servizio pulizia delle camere");
		role.setHorizontalAlignment(SwingConstants.CENTER);
		role.setForeground(Color.RED);
		role.setFont(new Font("Verdana", Font.BOLD, 18));
		frame.getContentPane().add(role, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton requestRoomToBeCleared = new JButton("Vedi camere da pulire");
		requestRoomToBeCleared.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection myConn = null;
				 Statement myStmt = null;
				 ResultSet myRs = null;
				
				try {
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , "dariostudente");
					System.out.println("Database connected");
					// 2. Create a statement
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery("SELECT * FROM SCHEDA WHERE numeroCamera IS NOT NULL");
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		requestRoomToBeCleared.setFont(new Font("Verdana", Font.BOLD, 12));
		requestRoomToBeCleared.setForeground(Color.BLACK);
		requestRoomToBeCleared.setBackground(Color.WHITE);
		GridBagConstraints gbc_requestRoomToBeCleared = new GridBagConstraints();
		gbc_requestRoomToBeCleared.weighty = 0.3;
		gbc_requestRoomToBeCleared.insets = new Insets(0, 0, 5, 0);
		gbc_requestRoomToBeCleared.gridx = 0;
		gbc_requestRoomToBeCleared.gridy = 0;
		panel.add(requestRoomToBeCleared, gbc_requestRoomToBeCleared);
		
		JLabel roomCleared = new JLabel("Segnala camera pulita");
		roomCleared.setForeground(Color.ORANGE);
		GridBagConstraints gbc_roomCleared = new GridBagConstraints();
		gbc_roomCleared.insets = new Insets(0, 0, 5, 0);
		gbc_roomCleared.gridx = 0;
		gbc_roomCleared.gridy = 9;
		panel.add(roomCleared, gbc_roomCleared);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 10;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton reportRoomButton = new JButton("Invia");
		reportRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		reportRoomButton.setFont(new Font("Verdana", Font.BOLD, 12));
		reportRoomButton.setBackground(Color.WHITE);
		reportRoomButton.setForeground(Color.BLACK);
		GridBagConstraints gbc_reportRoomButton = new GridBagConstraints();
		gbc_reportRoomButton.insets = new Insets(0, 0, 5, 0);
		gbc_reportRoomButton.gridx = 0;
		gbc_reportRoomButton.gridy = 11;
		panel.add(reportRoomButton, gbc_reportRoomButton);
		
		JButton exitButton = new JButton("Logout");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPages login = new LoginPages();
				login.frame.setVisible(true);
			}
		});
		exitButton.setFont(new Font("Verdana", Font.BOLD, 12));
		exitButton.setForeground(Color.ORANGE);
		exitButton.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.weighty = 0.3;
		gbc_exitButton.gridx = 0;
		gbc_exitButton.gridy = 14;
		panel.add(exitButton, gbc_exitButton);
	}
}
