package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;

public class RestaurantPages {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantPages window = new RestaurantPages();
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
	public RestaurantPages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.BOLD, 12));
		textArea.setEditable(false);
		textArea.setForeground(Color.PINK);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(0, 27, 273, 439);
		panel.add(textArea);
		
		JButton lunch = new JButton("Pranzo");
		lunch.setForeground(Color.ORANGE);
		lunch.setFont(new Font("Verdana", Font.BOLD, 12));
		lunch.setBackground(Color.DARK_GRAY);
		lunch.setBounds(93, 0, 89, 23);
		panel.add(lunch);
		
		JButton breakfast = new JButton("Colazione");
		breakfast.setBackground(Color.DARK_GRAY);
		breakfast.setForeground(Color.ORANGE);
		breakfast.setFont(new Font("Verdana", Font.BOLD, 12));
		breakfast.setBounds(0, 0, 89, 23);
		panel.add(breakfast);
		
		JButton dinner = new JButton("Cena");
		dinner.setForeground(Color.ORANGE);
		dinner.setFont(new Font("Verdana", Font.BOLD, 12));
		dinner.setBackground(Color.DARK_GRAY);
		dinner.setBounds(184, 0, 89, 23);
		panel.add(dinner);
	}
}
