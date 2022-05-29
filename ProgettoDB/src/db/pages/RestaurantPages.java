package db.pages;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import db.logic.Logic;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class RestaurantPages {

	private JFrame frame;
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
		
		JButton lunch = new JButton("Pranzo");
		lunch.addActionListener(e -> {
			this.logic.showRestaurantTables();
		});
		
		lunch.setForeground(Color.ORANGE);
		lunch.setFont(new Font("Verdana", Font.BOLD, 12));
		lunch.setBackground(Color.BLACK);
		lunch.setBounds(808, 68, 111, 23);
		panel.add(lunch);
		
		JButton breakfast = new JButton("Colazione");
		breakfast.setBackground(Color.BLACK);
		breakfast.setForeground(Color.ORANGE);
		breakfast.setFont(new Font("Verdana", Font.BOLD, 12));
		breakfast.setBounds(808, 34, 111, 23);
		panel.add(breakfast);
		
		JButton dinner = new JButton("Cena");
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
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.PINK);
		textArea.setFont(new Font("Verdana", Font.BOLD, 12));
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		scrollPane.setViewportView(textArea);
	}
}
