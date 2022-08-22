package db.pages;

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
import javax.swing.JScrollPane;

public class EntertaimentServicePages {

    private JFrame frame;
    private JTextField textField;
    private Logic logic;

    /**
     * Create the application.
     */
    public EntertaimentServicePages(final Logic logic) {
	this.logic = logic;
	this.initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setResizable(false);
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
	roomNumber.setBounds(65, 21, 106, 28);
	panel.add(roomNumber);

	textField = new JTextField();
	textField.setForeground(Color.PINK);
	textField.setFont(new Font("Verdana", Font.BOLD, 12));
	textField.setBackground(Color.BLACK);
	textField.setBounds(65, 51, 106, 20);
	panel.add(textField);
	textField.setColumns(10);

	JButton casinoEntrance = new JButton("Ingresso al casino'");
	casinoEntrance.setFont(new Font("Verdana", Font.BOLD, 12));
	casinoEntrance.addActionListener(e -> {
	    
	    
	});
	casinoEntrance.setBounds(28, 85, 171, 23);
	panel.add(casinoEntrance);

	JButton gymEntrance = new JButton("Ingresso palestra");
	gymEntrance.setFont(new Font("Verdana", Font.BOLD, 12));
	gymEntrance.addActionListener(e -> {
	    
	    
	});
	gymEntrance.setBounds(28, 119, 171, 23);
	panel.add(gymEntrance);

	JButton beachEntrance = new JButton("Ingresso Spiaggia");
	beachEntrance.setFont(new Font("Verdana", Font.BOLD, 12));
	beachEntrance.addActionListener(e -> {
	    
	    
	});
	beachEntrance.setBounds(28, 153, 171, 23);
	panel.add(beachEntrance);

	JButton showTerm = new JButton("Terme");
	showTerm.setForeground(new Color(128, 0, 0));
	showTerm.setBackground(Color.DARK_GRAY);
	showTerm.setFont(new Font("Verdana", Font.BOLD, 12));
	showTerm.addActionListener(e -> {
	    
	    
	});
	showTerm.setBounds(799, 60, 120, 23);
	panel.add(showTerm);

	JButton showCasino = new JButton("Casino'");
	showCasino.setFont(new Font("Verdana", Font.BOLD, 12));
	showCasino.addActionListener(e -> {
	    
	    
	});
	showCasino.setBounds(669, 60, 120, 23);
	panel.add(showCasino);

	JButton showGym = new JButton("Palestra");
	showGym.setFont(new Font("Verdana", Font.BOLD, 12));
	showGym.addActionListener(e -> {
	    
	    
	});
	showGym.setBounds(539, 60, 120, 23);
	panel.add(showGym);

	JButton showBeach = new JButton("Spiaggia");
	showBeach.setFont(new Font("Verdana", Font.BOLD, 12));
	showBeach.addActionListener(e -> {
	    
	    
	});
	showBeach.setBounds(409, 60, 120, 23);
	panel.add(showBeach);

	JLabel occupationSection = new JLabel("Vedi prenotazioni");
	occupationSection.setForeground(Color.ORANGE);
	occupationSection.setFont(new Font("Verdana", Font.BOLD, 12));
	occupationSection.setBackground(Color.DARK_GRAY);
	occupationSection.setBounds(408, 21, 283, 28);
	panel.add(occupationSection);
	
	JButton normalMassageButton = new JButton("Massaggio Normale");
	normalMassageButton.setBackground(Color.DARK_GRAY);
	normalMassageButton.setForeground(new Color(128, 0, 0));
	normalMassageButton.addActionListener(e -> {
	    
	    
	});
	normalMassageButton.setFont(new Font("Verdana", Font.BOLD, 12));
	normalMassageButton.setBounds(28, 256, 171, 23);
	panel.add(normalMassageButton);

	JButton mugShowerButton = new JButton("Doccia fango");
	mugShowerButton.setBackground(Color.DARK_GRAY);
	mugShowerButton.setForeground(new Color(128, 0, 0));
	mugShowerButton.addActionListener(e -> {
	    
	    
	});
	mugShowerButton.setFont(new Font("Verdana", Font.BOLD, 12));
	mugShowerButton.setBounds(28, 290, 171, 23);
	panel.add(mugShowerButton);

	JButton thermalBathButton = new JButton("Bagno Termale");
	thermalBathButton.setBackground(Color.DARK_GRAY);
	thermalBathButton.setForeground(new Color(128, 0, 0));
	thermalBathButton.setFont(new Font("Verdana", Font.BOLD, 12));
	thermalBathButton.addActionListener(e -> {
	    
	    
	});
	thermalBathButton.setBounds(28, 324, 171, 23);
	panel.add(thermalBathButton);

	JButton hydroMassageButton = new JButton("Idromassaggio");
	hydroMassageButton.setForeground(new Color(128, 0, 0));
	hydroMassageButton.setBackground(Color.DARK_GRAY);
	hydroMassageButton.setFont(new Font("Verdana", Font.BOLD, 12));
	hydroMassageButton.addActionListener(e -> {
	    
	    
	});
	hydroMassageButton.setBounds(28, 359, 171, 23);
	panel.add(hydroMassageButton);

	/*
	 * Logout from application part
	 */
	JButton logout = new JButton("Logout");
	logout.addActionListener(e -> {
	    this.frame.dispose();
	    this.logic.logout();
	});

	logout.setBackground(Color.DARK_GRAY);
	logout.setForeground(Color.ORANGE);
	logout.setFont(new Font("Verdana", Font.BOLD, 12));
	logout.setBounds(28, 432, 89, 23);
	panel.add(logout);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(409, 95, 510, 360);
	panel.add(scrollPane);

	JTextArea textArea = new JTextArea();
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
