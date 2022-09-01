package db.pages.specific;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import db.logic.Logic;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NewReservation {

    private JFrame frmNuovaPrenotazione;
    private JTextField roomField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField parkingDaysField;
    private JTextField seasonField;
    private JTextField yearField;
    private Logic logic;

    /**
     * Constructor.
     */
    public NewReservation(final Logic logic) {
	this.logic = logic;
	this.initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frmNuovaPrenotazione = new JFrame();
	frmNuovaPrenotazione.setResizable(false);
	frmNuovaPrenotazione.getContentPane().setForeground(Color.ORANGE);
	frmNuovaPrenotazione.getContentPane().setFont(new Font("Verdana", Font.BOLD, 12));
	frmNuovaPrenotazione.getContentPane().setBackground(Color.DARK_GRAY);
	frmNuovaPrenotazione.setTitle("Nuova prenotazione");
	frmNuovaPrenotazione.setBounds(100, 100, 945, 528);
	frmNuovaPrenotazione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmNuovaPrenotazione.getContentPane().setLayout(null);

	JLabel title = new JLabel("Nuova prenotazione");
	title.setBounds(0, 0, 929, 23);
	title.setHorizontalAlignment(SwingConstants.CENTER);
	title.setForeground(Color.RED);
	title.setFont(new Font("Verdana", Font.BOLD, 18));
	frmNuovaPrenotazione.getContentPane().add(title);

	JLabel roomLabel = new JLabel("Numero camera");
	roomLabel.setForeground(Color.ORANGE);
	roomLabel.setBackground(Color.DARK_GRAY);
	roomLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	roomLabel.setBounds(20, 77, 138, 23);
	frmNuovaPrenotazione.getContentPane().add(roomLabel);

	roomField = new JTextField();
	roomField.setForeground(Color.PINK);
	roomField.setBackground(Color.BLACK);
	roomField.setFont(new Font("Verdana", Font.BOLD, 12));
	roomField.setColumns(10);
	roomField.setBounds(20, 99, 209, 20);
	frmNuovaPrenotazione.getContentPane().add(roomField);

	/*
	 * Parking.
	 */
	JButton parkingPlus = new JButton("Parcheggio +");
	parkingPlus.addActionListener(e -> {
	    var days = Integer.parseInt(this.parkingDaysField.getText());
	    for (int i = 0; i < days; i++) {
		this.logic.registerNewReservation("Parchegio", "Parchegio", "NULL", this.seasonField.getText(),
			Integer.parseInt(this.yearField.getText()), "NULL", this.timeField.getText(),
			Integer.parseInt(this.roomField.getText()));
	    }
	});
	parkingPlus.setForeground(Color.ORANGE);
	parkingPlus.setBackground(Color.DARK_GRAY);
	parkingPlus.setFont(new Font("Verdana", Font.BOLD, 12));
	parkingPlus.setBounds(253, 369, 209, 49);
	frmNuovaPrenotazione.getContentPane().add(parkingPlus);

	/*
	 * Massage.
	 */
	JButton massagePlus = new JButton("Massaggio +");
	massagePlus.addActionListener(e -> {
	    this.logic.registerNewReservation("Massaggio", "Massaggio", this.dateField.getText(),
		    this.seasonField.getText(), Integer.parseInt(this.yearField.getText()), this.dateField.getText(),
		    this.timeField.getText(), Integer.parseInt(this.roomField.getText()));
	});
	massagePlus.setForeground(Color.ORANGE);
	massagePlus.setBackground(Color.DARK_GRAY);
	massagePlus.setFont(new Font("Verdana", Font.BOLD, 12));
	massagePlus.setBounds(655, 253, 209, 49);
	frmNuovaPrenotazione.getContentPane().add(massagePlus);

	/*
	 * Dirt massage.
	 */
	JButton dirtPlus = new JButton("Fango +");
	dirtPlus.addActionListener(e -> {
	    this.logic.registerNewReservation("Fango", "Fango", this.dateField.getText(), this.seasonField.getText(),
		    Integer.parseInt(this.yearField.getText()), this.dateField.getText(), this.timeField.getText(),
		    Integer.parseInt(this.roomField.getText()));
	});
	dirtPlus.setForeground(Color.ORANGE);
	dirtPlus.setBackground(Color.DARK_GRAY);
	dirtPlus.setFont(new Font("Verdana", Font.BOLD, 12));
	dirtPlus.setBounds(655, 313, 209, 49);
	frmNuovaPrenotazione.getContentPane().add(dirtPlus);

	/*
	 * Bath.
	 */
	JButton bathPlus = new JButton("Bagno +");
	bathPlus.addActionListener(e -> {
	    this.logic.registerNewReservation("Bagno", "Bagno", this.dateField.getText(), this.seasonField.getText(),
		    Integer.parseInt(this.yearField.getText()), this.dateField.getText(), this.timeField.getText(),
		    Integer.parseInt(this.roomField.getText()));
	});
	bathPlus.setForeground(Color.ORANGE);
	bathPlus.setBackground(Color.DARK_GRAY);
	bathPlus.setFont(new Font("Verdana", Font.BOLD, 12));
	bathPlus.setBounds(655, 193, 209, 49);
	frmNuovaPrenotazione.getContentPane().add(bathPlus);

	/*
	 * Idro bath.
	 */
	JButton bubblePlus = new JButton("Idromassaggio +");
	bubblePlus.addActionListener(e -> {
	    this.logic.registerNewReservation("Idromassaggio", "Idromassaggio", this.dateField.getText(),
		    this.seasonField.getText(), Integer.parseInt(this.yearField.getText()), this.dateField.getText(),
		    this.timeField.getText(), Integer.parseInt(this.roomField.getText()));
	});
	bubblePlus.setForeground(Color.ORANGE);
	bubblePlus.setBackground(Color.DARK_GRAY);
	bubblePlus.setFont(new Font("Verdana", Font.BOLD, 12));
	bubblePlus.setBounds(655, 369, 209, 49);
	frmNuovaPrenotazione.getContentPane().add(bubblePlus);

	JLabel dateLabel = new JLabel("Data");
	dateLabel.setForeground(Color.ORANGE);
	dateLabel.setBackground(Color.DARK_GRAY);
	dateLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	dateLabel.setBounds(655, 77, 138, 23);
	frmNuovaPrenotazione.getContentPane().add(dateLabel);

	dateField = new JTextField();
	dateField.setForeground(Color.PINK);
	dateField.setBackground(Color.BLACK);
	dateField.setFont(new Font("Verdana", Font.BOLD, 12));
	dateField.setColumns(10);
	dateField.setBounds(655, 101, 209, 20);
	frmNuovaPrenotazione.getContentPane().add(dateField);

	JLabel timeLabel = new JLabel("Ora");
	timeLabel.setForeground(Color.ORANGE);
	timeLabel.setBackground(Color.DARK_GRAY);
	timeLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	timeLabel.setBounds(655, 132, 138, 23);
	frmNuovaPrenotazione.getContentPane().add(timeLabel);

	timeField = new JTextField();
	timeField.setForeground(Color.PINK);
	timeField.setBackground(Color.BLACK);
	timeField.setFont(new Font("Verdana", Font.BOLD, 12));
	timeField.setColumns(10);
	timeField.setBounds(655, 156, 209, 20);
	frmNuovaPrenotazione.getContentPane().add(timeField);

	JButton logout = new JButton("Logout");
	logout.addActionListener(e -> {
	    this.frmNuovaPrenotazione.dispose();
	    this.logic.logout();
	});

	logout.setForeground(Color.ORANGE);
	logout.setBackground(Color.DARK_GRAY);
	logout.setFont(new Font("Verdana", Font.BOLD, 12));
	logout.setBounds(710, 455, 209, 23);
	frmNuovaPrenotazione.getContentPane().add(logout);

	JLabel classicReservationTitle = new JLabel("Prenotazioni classiche");
	classicReservationTitle.setHorizontalAlignment(SwingConstants.CENTER);
	classicReservationTitle.setForeground(Color.MAGENTA);
	classicReservationTitle.setFont(new Font("Verdana", Font.BOLD, 16));
	classicReservationTitle.setBounds(10, 52, 264, 14);
	frmNuovaPrenotazione.getContentPane().add(classicReservationTitle);

	JLabel timeReservationTitle = new JLabel("Prenotazioni Orarie");
	timeReservationTitle.setHorizontalAlignment(SwingConstants.CENTER);
	timeReservationTitle.setForeground(Color.MAGENTA);
	timeReservationTitle.setFont(new Font("Verdana", Font.BOLD, 16));
	timeReservationTitle.setBounds(655, 52, 264, 14);
	frmNuovaPrenotazione.getContentPane().add(timeReservationTitle);

	JLabel parkingDays = new JLabel("Giorni di parcheggio");
	parkingDays.setForeground(Color.ORANGE);
	parkingDays.setFont(new Font("Verdana", Font.BOLD, 12));
	parkingDays.setBackground(Color.DARK_GRAY);
	parkingDays.setBounds(253, 315, 138, 23);
	frmNuovaPrenotazione.getContentPane().add(parkingDays);

	parkingDaysField = new JTextField();
	parkingDaysField.setForeground(Color.PINK);
	parkingDaysField.setFont(new Font("Verdana", Font.BOLD, 12));
	parkingDaysField.setColumns(10);
	parkingDaysField.setBackground(Color.BLACK);
	parkingDaysField.setBounds(253, 338, 209, 20);
	frmNuovaPrenotazione.getContentPane().add(parkingDaysField);

	/*
	 * Gym.
	 */
	JButton btnGym = new JButton("Palestra +");
	btnGym.addActionListener(e -> {
	    this.logic.registerNewReservation("Palestra", "Palestra", "NULL", this.seasonField.getText(),
		    Integer.parseInt(this.yearField.getText()), "NULL", this.timeField.getText(),
		    Integer.parseInt(this.roomField.getText()));
	});

	btnGym.setForeground(Color.ORANGE);
	btnGym.setFont(new Font("Verdana", Font.BOLD, 12));
	btnGym.setBackground(Color.DARK_GRAY);
	btnGym.setBounds(253, 99, 209, 49);
	frmNuovaPrenotazione.getContentPane().add(btnGym);

	/*
	 * Casino.
	 */
	JButton btnCasino = new JButton("Casino' +");
	btnCasino.addActionListener(e -> {
	    this.logic.registerNewReservation("Casino'", "Casino'", "NULL", this.seasonField.getText(),
		    Integer.parseInt(this.yearField.getText()), "NULL", this.timeField.getText(),
		    Integer.parseInt(this.roomField.getText()));
	});

	btnCasino.setForeground(Color.ORANGE);
	btnCasino.setFont(new Font("Verdana", Font.BOLD, 12));
	btnCasino.setBackground(Color.DARK_GRAY);
	btnCasino.setBounds(253, 160, 209, 49);
	frmNuovaPrenotazione.getContentPane().add(btnCasino);

	/*
	 * Beach.
	 */
	JButton btnBeach = new JButton("Siaggia +");
	btnBeach.addActionListener(e -> {
	    this.logic.registerNewReservation("Spiaggia", "Spiaggia", "NULL", this.seasonField.getText(),
		    Integer.parseInt(this.yearField.getText()), "NULL", this.timeField.getText(),
		    Integer.parseInt(this.roomField.getText()));
	});

	btnBeach.setForeground(Color.ORANGE);
	btnBeach.setFont(new Font("Verdana", Font.BOLD, 12));
	btnBeach.setBackground(Color.DARK_GRAY);
	btnBeach.setBounds(253, 220, 209, 49);
	frmNuovaPrenotazione.getContentPane().add(btnBeach);

	seasonField = new JTextField();
	seasonField.setForeground(Color.PINK);
	seasonField.setFont(new Font("Verdana", Font.BOLD, 12));
	seasonField.setColumns(10);
	seasonField.setBackground(Color.BLACK);
	seasonField.setBounds(20, 154, 209, 20);
	frmNuovaPrenotazione.getContentPane().add(seasonField);

	JLabel seasonLabel = new JLabel("Stagione");
	seasonLabel.setForeground(Color.ORANGE);
	seasonLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	seasonLabel.setBackground(Color.DARK_GRAY);
	seasonLabel.setBounds(20, 132, 138, 23);
	frmNuovaPrenotazione.getContentPane().add(seasonLabel);

	yearField = new JTextField();
	yearField.setForeground(Color.PINK);
	yearField.setFont(new Font("Verdana", Font.BOLD, 12));
	yearField.setColumns(10);
	yearField.setBackground(Color.BLACK);
	yearField.setBounds(20, 215, 209, 20);
	frmNuovaPrenotazione.getContentPane().add(yearField);

	JLabel yearLabel = new JLabel("Anno");
	yearLabel.setForeground(Color.ORANGE);
	yearLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	yearLabel.setBackground(Color.DARK_GRAY);
	yearLabel.setBounds(20, 193, 138, 23);
	frmNuovaPrenotazione.getContentPane().add(yearLabel);
    }
}
