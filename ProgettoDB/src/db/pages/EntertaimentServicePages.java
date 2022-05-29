package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import db.logic.Logic;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntertaimentServicePages {

	private JFrame frame;
	private JTextField textField;
	private Logic logic;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public EntertaimentServicePages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Hotel Malenia - Servizio Intrattenimento");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel role = new JLabel("Servizio intrattenimento");
		role.setHorizontalAlignment(SwingConstants.CENTER);
		role.setForeground(Color.RED);
		role.setFont(new Font("Verdana", Font.BOLD, 18));
		frame.getContentPane().add(role, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel roomNumber = new JLabel("Numero camera");
		roomNumber.setBackground(Color.DARK_GRAY);
		roomNumber.setForeground(Color.ORANGE);
		roomNumber.setFont(new Font("Verdana", Font.BOLD, 12));
		roomNumber.setBounds(65, 118, 120, 28);
		panel.add(roomNumber);
		
		textField = new JTextField();
		textField.setForeground(Color.PINK);
		textField.setFont(new Font("Verdana", Font.BOLD, 12));
		textField.setBackground(Color.BLACK);
		textField.setBounds(65, 148, 106, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton casinoEntrance = new JButton("Ingresso al casin\u00F2");
		casinoEntrance.setFont(new Font("Verdana", Font.BOLD, 12));
		casinoEntrance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		casinoEntrance.setBounds(28, 182, 171, 23);
		panel.add(casinoEntrance);
		
		JButton gymEntrance = new JButton("Ingresso palestra");
		gymEntrance.setFont(new Font("Verdana", Font.BOLD, 12));
		gymEntrance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		gymEntrance.setBounds(28, 216, 171, 23);
		panel.add(gymEntrance);
		
		JButton beachEntrance = new JButton("Ingresso Spiaggia");
		beachEntrance.setFont(new Font("Verdana", Font.BOLD, 12));
		beachEntrance.setBounds(28, 250, 171, 23);
		panel.add(beachEntrance);
		
		JButton showTerm = new JButton("Terme");
		showTerm.setFont(new Font("Verdana", Font.BOLD, 12));
		showTerm.setBounds(799, 60, 120, 23);
		panel.add(showTerm);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.PINK);
		textArea.setEditable(false);
		textArea.setFont(new Font("Verdana", Font.BOLD, 12));
		textArea.setBounds(408, 94, 511, 361);
		panel.add(textArea);
		
		JButton showCasino = new JButton("Casin\u00F2");
		showCasino.setFont(new Font("Verdana", Font.BOLD, 12));
		showCasino.setBounds(669, 60, 120, 23);
		panel.add(showCasino);
		
		JButton showGym = new JButton("Palestra");
		showGym.setFont(new Font("Verdana", Font.BOLD, 12));
		showGym.setBounds(539, 60, 120, 23);
		panel.add(showGym);
		
		JButton showBeach = new JButton("Spiaggia");
		showBeach.setFont(new Font("Verdana", Font.BOLD, 12));
		showBeach.setBounds(409, 60, 120, 23);
		panel.add(showBeach);
		
		JLabel occupationSection = new JLabel("Vedi prenotazioni (oggi)");
		occupationSection.setForeground(Color.ORANGE);
		occupationSection.setFont(new Font("Verdana", Font.BOLD, 12));
		occupationSection.setBackground(Color.DARK_GRAY);
		occupationSection.setBounds(408, 21, 283, 28);
		panel.add(occupationSection);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(e -> {
			frame.dispose();
			this.logic.logout();
			
		});
		logout.setBackground(Color.DARK_GRAY);
		logout.setForeground(Color.ORANGE);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBounds(28, 432, 89, 23);
		panel.add(logout);
	}
}
