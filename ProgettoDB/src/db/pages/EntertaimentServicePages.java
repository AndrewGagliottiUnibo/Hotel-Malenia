package db.pages;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private JTextField roomNumberField;
    private JTextField dayField;
    private JTextField timeField;
    private JTextField seasonField;
    private JTextField yearField;
    private JTextField roomNumberShow;
    private JTextArea textArea;
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
	roomNumber.setBounds(10, 21, 106, 28);
	panel.add(roomNumber);

	roomNumberField = new JTextField();
	roomNumberField.setForeground(Color.PINK);
	roomNumberField.setFont(new Font("Verdana", Font.BOLD, 12));
	roomNumberField.setBackground(Color.BLACK);
	roomNumberField.setBounds(10, 51, 106, 20);
	panel.add(roomNumberField);
	roomNumberField.setColumns(10);

	JButton casinoEntrance = new JButton("Ingresso al casino'");
	casinoEntrance.setFont(new Font("Verdana", Font.BOLD, 12));
	casinoEntrance.addActionListener(e -> {
	    this.logic.addCost("Casino'", this.seasonField.getText(), Integer.parseInt(this.yearField.getText()),
		    Integer.parseInt(this.roomNumberField.getText()), "Casino'", null, null);
	});

	casinoEntrance.setBounds(141, 129, 156, 23);
	panel.add(casinoEntrance);

	JButton gymEntrance = new JButton("Ingresso palestra");
	gymEntrance.setFont(new Font("Verdana", Font.BOLD, 12));
	gymEntrance.addActionListener(e -> {
	    this.logic.addCost("Palestra", this.seasonField.getText(), Integer.parseInt(this.yearField.getText()),
		    Integer.parseInt(this.roomNumberField.getText()), "Palestra", null, null);
	});

	gymEntrance.setBounds(141, 95, 156, 23);
	panel.add(gymEntrance);

	JButton beachEntrance = new JButton("Ingresso Spiaggia");
	beachEntrance.setFont(new Font("Verdana", Font.BOLD, 12));
	beachEntrance.addActionListener(e -> {
	    this.logic.addCost("Spiaggia", this.seasonField.getText(), Integer.parseInt(this.yearField.getText()),
		    Integer.parseInt(this.roomNumberField.getText()), "Spiaggia", null, null);
	});

	beachEntrance.setBounds(141, 61, 156, 23);
	panel.add(beachEntrance);

	JButton showTerm = new JButton("Terme");
	showTerm.setForeground(new Color(128, 0, 0));
	showTerm.setBackground(Color.DARK_GRAY);
	showTerm.setFont(new Font("Verdana", Font.BOLD, 12));
	showTerm.addActionListener(e -> {
	    this.showReservations("Terme");
	});

	showTerm.setBounds(799, 60, 120, 23);
	panel.add(showTerm);

	JButton showCasino = new JButton("Casino");
	showCasino.setFont(new Font("Verdana", Font.BOLD, 12));
	showCasino.addActionListener(e -> {
	    this.showReservations("Casino");
	});

	showCasino.setBounds(669, 60, 120, 23);
	panel.add(showCasino);

	JButton showGym = new JButton("Palestra");
	showGym.setFont(new Font("Verdana", Font.BOLD, 12));
	showGym.addActionListener(e -> {
	    this.showReservations("Palestra");
	});

	showGym.setBounds(539, 60, 120, 23);
	panel.add(showGym);

	JButton showBeach = new JButton("Spiaggia");
	showBeach.setFont(new Font("Verdana", Font.BOLD, 12));
	showBeach.addActionListener(e -> {
	    this.showReservations("Spiaggia");
	});

	showBeach.setBounds(409, 60, 120, 23);
	panel.add(showBeach);

	JLabel occupationSection = new JLabel("Vedi prenotazioni camera:");
	occupationSection.setForeground(Color.ORANGE);
	occupationSection.setFont(new Font("Verdana", Font.BOLD, 12));
	occupationSection.setBackground(Color.DARK_GRAY);
	occupationSection.setBounds(408, 21, 184, 28);
	panel.add(occupationSection);

	JButton normalMassageButton = new JButton("Massaggio Normale");
	normalMassageButton.setBackground(Color.DARK_GRAY);
	normalMassageButton.setForeground(new Color(128, 0, 0));
	normalMassageButton.addActionListener(e -> {
	    this.logic.registerNewReservation("Massaggio", "Massaggio", this.dayField.getText(),
		    this.seasonField.getText(), Integer.parseInt(this.yearField.getText()), this.dayField.getText(),
		    this.timeField.getText(), Integer.parseInt(this.roomNumberField.getText()));
	});

	normalMassageButton.setFont(new Font("Verdana", Font.BOLD, 12));
	normalMassageButton.setBounds(141, 226, 166, 23);
	panel.add(normalMassageButton);

	JButton mugShowerButton = new JButton("Doccia fango");
	mugShowerButton.setBackground(Color.DARK_GRAY);
	mugShowerButton.setForeground(new Color(128, 0, 0));
	mugShowerButton.addActionListener(e -> {
	    this.logic.registerNewReservation("Fango", "Fango", this.dayField.getText(), this.seasonField.getText(),
		    Integer.parseInt(this.yearField.getText()), this.dayField.getText(), this.timeField.getText(),
		    Integer.parseInt(this.roomNumberField.getText()));
	});

	mugShowerButton.setFont(new Font("Verdana", Font.BOLD, 12));
	mugShowerButton.setBounds(141, 260, 166, 23);
	panel.add(mugShowerButton);

	JButton thermalBathButton = new JButton("Bagno Termale");
	thermalBathButton.setBackground(Color.DARK_GRAY);
	thermalBathButton.setForeground(new Color(128, 0, 0));
	thermalBathButton.setFont(new Font("Verdana", Font.BOLD, 12));
	thermalBathButton.addActionListener(e -> {
	    this.logic.registerNewReservation("Bagno", "Bagno", this.dayField.getText(), this.seasonField.getText(),
		    Integer.parseInt(this.yearField.getText()), this.dayField.getText(), this.timeField.getText(),
		    Integer.parseInt(this.roomNumberField.getText()));
	});

	thermalBathButton.setBounds(141, 294, 166, 23);
	panel.add(thermalBathButton);

	JButton hydroMassageButton = new JButton("Idromassaggio");
	hydroMassageButton.setForeground(new Color(128, 0, 0));
	hydroMassageButton.setBackground(Color.DARK_GRAY);
	hydroMassageButton.setFont(new Font("Verdana", Font.BOLD, 12));
	hydroMassageButton.addActionListener(e -> {
	    this.logic.registerNewReservation("Idromassaggio", "Idromassaggio", this.dayField.getText(),
		    this.seasonField.getText(), Integer.parseInt(this.yearField.getText()), this.dayField.getText(),
		    this.timeField.getText(), Integer.parseInt(this.roomNumberField.getText()));
	});

	hydroMassageButton.setBounds(141, 329, 166, 23);
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
	logout.setBounds(10, 432, 89, 23);
	panel.add(logout);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(409, 95, 510, 360);
	panel.add(scrollPane);

	this.textArea = new JTextArea();
	textArea.setForeground(Color.PINK);
	textArea.setFont(new Font("Verdana", Font.BOLD, 12));
	textArea.setEditable(false);
	textArea.setBackground(Color.BLACK);
	scrollPane.setViewportView(textArea);

	JLabel dayLabel = new JLabel("Giorno");
	dayLabel.setForeground(Color.ORANGE);
	dayLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	dayLabel.setBackground(Color.DARK_GRAY);
	dayLabel.setBounds(10, 226, 106, 28);
	panel.add(dayLabel);

	dayField = new JTextField();
	dayField.setForeground(Color.PINK);
	dayField.setFont(new Font("Verdana", Font.BOLD, 12));
	dayField.setColumns(10);
	dayField.setBackground(Color.BLACK);
	dayField.setBounds(10, 256, 106, 20);
	panel.add(dayField);

	JLabel timeLabel = new JLabel("Ora");
	timeLabel.setForeground(Color.ORANGE);
	timeLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	timeLabel.setBackground(Color.DARK_GRAY);
	timeLabel.setBounds(10, 285, 106, 28);
	panel.add(timeLabel);

	timeField = new JTextField();
	timeField.setForeground(Color.PINK);
	timeField.setFont(new Font("Verdana", Font.BOLD, 12));
	timeField.setColumns(10);
	timeField.setBackground(Color.BLACK);
	timeField.setBounds(10, 315, 106, 20);
	panel.add(timeField);

	JLabel seasonLabelServices = new JLabel("Stagione");
	seasonLabelServices.setForeground(Color.ORANGE);
	seasonLabelServices.setFont(new Font("Verdana", Font.BOLD, 12));
	seasonLabelServices.setBackground(Color.DARK_GRAY);
	seasonLabelServices.setBounds(10, 69, 106, 28);
	panel.add(seasonLabelServices);

	seasonField = new JTextField();
	seasonField.setForeground(Color.PINK);
	seasonField.setFont(new Font("Verdana", Font.BOLD, 12));
	seasonField.setColumns(10);
	seasonField.setBackground(Color.BLACK);
	seasonField.setBounds(10, 99, 106, 20);
	panel.add(seasonField);

	yearField = new JTextField();
	yearField.setForeground(Color.PINK);
	yearField.setFont(new Font("Verdana", Font.BOLD, 12));
	yearField.setColumns(10);
	yearField.setBackground(Color.BLACK);
	yearField.setBounds(10, 144, 106, 20);
	panel.add(yearField);

	JLabel yearLabelServices = new JLabel("Anno");
	yearLabelServices.setForeground(Color.ORANGE);
	yearLabelServices.setFont(new Font("Verdana", Font.BOLD, 12));
	yearLabelServices.setBackground(Color.DARK_GRAY);
	yearLabelServices.setBounds(10, 114, 106, 28);
	panel.add(yearLabelServices);

	roomNumberShow = new JTextField();
	roomNumberShow.setForeground(Color.PINK);
	roomNumberShow.setFont(new Font("Verdana", Font.BOLD, 12));
	roomNumberShow.setColumns(10);
	roomNumberShow.setBackground(Color.BLACK);
	roomNumberShow.setBounds(590, 25, 106, 20);
	panel.add(roomNumberShow);
    }

    /**
     * Write all reservation from type in input.
     * 
     * @param string
     */
    private void showReservations(final String string) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;

	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.logic.getOwnPassword());
	    myStm = conn.prepareStatement(
		    "SELECT codFiscale FROM SOGGIORNO WHERE numeroCamera = ? AND soggiornante = true");
	    myStm.setInt(1, Integer.parseInt(this.roomNumberShow.getText()));
	    result = myStm.executeQuery();
	    result.next();
	    final String identifier = result.getString(1);

	    myStm = conn.prepareStatement(
		    "SELECT tipoPrenotazione, giorno, ora FROM PRENOTAZIONE WHERE codFiscaleClienteRegistrato = ?");
	    myStm.setString(1, identifier);
	    result = myStm.executeQuery();

	    /*
	     * Printing data.
	     */
	    while (result.next()) {
		int row = result.getRow();

		for (int i = 0; i < row; i++) {
		    this.textArea.append(result.getString(1) + "\n");
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    /**
     * @return actual frame.
     */
    public JFrame getFrame() {
	return this.frame;
    }
}
