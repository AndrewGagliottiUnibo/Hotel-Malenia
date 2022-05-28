package db.pages;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import db.logic.Logic;
import db.logic.LogicsImpl;
import java.awt.Font;
import java.awt.Color;

public class LoginPages {

	public JFrame frame;
	private JTextField codeField;
	private JTextField passwordField;
	private Logic logic;
	
	/**
	 * Create the application.
	 */
	public LoginPages() {
		
		/**
		 * Set the logic behind the GUIs
		 */
		this.logic = new LogicsImpl();
		frame = new JFrame();
		frame.setTitle("Hotel Malenia - Login");
		frame.setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Hotel Malenia");
		title.setForeground(Color.RED);
		title.setFont(new Font("Verdana", Font.BOLD, 33));
		title.setBounds(69, 38, 322, 157);
		panel.add(title);
		
		JLabel password = new JLabel("Password");
		password.setForeground(Color.ORANGE);
		password.setFont(new Font("Verdana", Font.BOLD, 18));
		password.setBounds(130, 305, 132, 42);
		panel.add(password);
		
		JLabel code = new JLabel("Codice");
		code.setForeground(Color.ORANGE);
		code.setFont(new Font("Verdana", Font.BOLD, 18));
		code.setBounds(130, 217, 132, 42);
		panel.add(code);
		
		codeField = new JTextField();
		codeField.setBounds(356, 232, 303, 20);
		panel.add(codeField);
		codeField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(356, 320, 303, 20);
		panel.add(passwordField);
		
		/*
		 * Button logic here
		 */
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(e -> {
			this.logic.login(codeField.getText(), passwordField.getText());
			frame.dispose();
		});
		
		loginBtn.setForeground(Color.ORANGE);
		loginBtn.setBackground(Color.DARK_GRAY);
		loginBtn.setBounds(722, 422, 89, 23);
		panel.add(loginBtn);
	}
}
