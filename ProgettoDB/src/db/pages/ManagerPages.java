package db.pages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import db.logic.Logic;

public class ManagerPages {
	private JFrame frame;
	private Logic logic;

	/**
	 * Constructor.
	 */
	public ManagerPages(final Logic logic) {
		this.logic = logic;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Hotel Malenia - Manager");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		/*
		 * Go to all cards visualization.
		 */
		JButton btnVisualizzaResoconto = new JButton("Visualizza schede clienti");
		btnVisualizzaResoconto.addActionListener(e -> {
			this.frame.setVisible(false);
			this.logic.goToSpecificPage("AllCards", this.frame);
		});
		
		btnVisualizzaResoconto.setForeground(Color.ORANGE);
		btnVisualizzaResoconto.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVisualizzaResoconto.setBackground(Color.DARK_GRAY);
		btnVisualizzaResoconto.setBounds(276, 65, 385, 93);
		panel.add(btnVisualizzaResoconto);
		
		JButton btnListini = new JButton("Tariffe e gestione economica");
		btnListini.addActionListener(e -> {
			this.frame.setVisible(false);
			this.logic.goToSpecificPage("Prices", this.frame);
		});
				
		btnListini.setForeground(Color.ORANGE);
		btnListini.setFont(new Font("Verdana", Font.BOLD, 12));
		btnListini.setBackground(Color.DARK_GRAY);
		btnListini.setBounds(276, 188, 385, 93);
		panel.add(btnListini);
		
		/*
		 * Logout from application part
		 */
		JButton logout = new JButton("Logout");
		logout.addActionListener(e -> {
			this.frame.dispose();
			this.logic.logout();
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
	
	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frame;
	}
}
