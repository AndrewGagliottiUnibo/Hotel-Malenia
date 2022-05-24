package db.pages;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPages {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Create the application.
	 */
	public LoginPages() {
		frame = new JFrame();
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
		
		textField = new JTextField();
		textField.setBounds(356, 232, 303, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(356, 320, 303, 20);
		panel.add(textField_1);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = code.getText();
				String Password1 = password.getText();

				if (Username.equals("Receptionist1") && Password1.equals("Receptionist1")) {
					JOptionPane.showMessageDialog(null, "Login Successful");
				}
				if (Username.equals("Dirigente1") && Password1.equals("Dirigente1")) {
					JOptionPane.showMessageDialog(null, "Login Successful");
				}	
				else
					JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
			}
		});
		loginBtn.setForeground(Color.ORANGE);
		loginBtn.setBackground(Color.DARK_GRAY);
		loginBtn.setBounds(722, 422, 89, 23);
		panel.add(loginBtn);
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

	}
}
