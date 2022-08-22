package db.pages;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import db.logic.Logic;
import db.logic.LogicsImpl;
import java.awt.Font;
import java.util.Arrays;
import java.awt.Color;

public class LoginPages {

    private JFrame frame;
    private JTextField codeField;
    private JPasswordField passwordField;
    private Logic logic;
    private JPasswordField passwordFieldAgain;

    /**
     * Create the application.
     */
    public LoginPages() {

	/*
	 * Set the logic behind the GUIs
	 */
	this.logic = new LogicsImpl(this);

	/*
	 * Set GUI parameters.
	 */
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
	password.setBounds(130, 256, 188, 42);
	panel.add(password);

	JLabel code = new JLabel("Codice");
	code.setForeground(Color.ORANGE);
	code.setFont(new Font("Verdana", Font.BOLD, 18));
	code.setBounds(130, 168, 188, 42);
	panel.add(code);

	codeField = new JTextField();
	codeField.setBounds(356, 183, 303, 20);
	panel.add(codeField);
	codeField.setColumns(10);

	passwordField = new JPasswordField();
	passwordField.setColumns(10);
	passwordField.setBounds(356, 271, 303, 20);
	panel.add(passwordField);

	/*
	 * Button login
	 */
	JButton loginBtn = new JButton("Login");
	loginBtn.addActionListener(e -> {

	    if (Arrays.equals(this.passwordField.getPassword(), this.passwordFieldAgain.getPassword())) {
		frame.setVisible(false);
		this.logic.login(codeField.getText(), passwordField.getPassword());
	    } else {
		JOptionPane.showMessageDialog(null, "Errore in fase di login");
	    }

	    this.codeField.setText("");
	    this.passwordField.setText("");
	    this.passwordFieldAgain.setText("");
	});

	loginBtn.setForeground(Color.ORANGE);
	loginBtn.setBackground(Color.DARK_GRAY);
	loginBtn.setBounds(722, 422, 89, 23);
	panel.add(loginBtn);

	passwordFieldAgain = new JPasswordField();
	passwordFieldAgain.setColumns(10);
	passwordFieldAgain.setBounds(356, 364, 303, 20);
	panel.add(passwordFieldAgain);

	JLabel passwordAgainLabel = new JLabel("Ripeti password");
	passwordAgainLabel.setForeground(Color.ORANGE);
	passwordAgainLabel.setFont(new Font("Verdana", Font.BOLD, 18));
	passwordAgainLabel.setBounds(130, 349, 188, 42);
	panel.add(passwordAgainLabel);
    }

    /**
     * @return actual frame.
     */
    public JFrame getFrame() {
	return this.frame;
    }
}
