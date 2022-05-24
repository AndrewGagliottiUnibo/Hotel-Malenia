package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ManagerPages {

	private JFrame frame;

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
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Listini");
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNewButton_1.setBounds(575, 287, 344, 92);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Soggiorni");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setForeground(Color.ORANGE);
		btnNewButton_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNewButton_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1.setBounds(575, 32, 344, 92);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Visualizzare scheda");
		btnNewButton_1_2.setForeground(Color.ORANGE);
		btnNewButton_1_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNewButton_1_2.setBackground(Color.DARK_GRAY);
		btnNewButton_1_2.setBounds(10, 32, 344, 92);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Servizi");
		btnNewButton_1_3.setForeground(Color.ORANGE);
		btnNewButton_1_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNewButton_1_3.setBackground(Color.DARK_GRAY);
		btnNewButton_1_3.setBounds(10, 287, 344, 92);
		panel.add(btnNewButton_1_3);
	}
}
