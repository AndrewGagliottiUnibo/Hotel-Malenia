package db.pages.specific;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.logic.Logic;

public class AllReservations {

    private JFrame frame;
    private JTextField specificViewField;
    private JTextField dayDeleteField;
    private JTextArea textArea;
    private Logic logic;
    private JTextField reservationTypeField;
    private JTextField deleteReservationField;
    private JTextField hourDeleteField;
    private JTextField clientDeleteField;
    private JTextField seasonField;
    private JTextField yearField;

    /**
     * Constructor.
     */
    public AllReservations(final Logic logic) {
	this.logic = logic;
	this.initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setResizable(false);
	frame.getContentPane().setForeground(Color.ORANGE);
	frame.getContentPane().setFont(new Font("Verdana", Font.BOLD, 12));
	frame.getContentPane().setBackground(Color.DARK_GRAY);
	frame.setTitle("Prenotazioni");
	frame.setBounds(100, 100, 945, 528);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblNewLabel = new JLabel("Prenotazioni");
	lblNewLabel.setBounds(0, 0, 929, 23);
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setForeground(Color.RED);
	lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
	frame.getContentPane().add(lblNewLabel);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 26, 680, 452);
	frame.getContentPane().add(scrollPane);

	this.textArea = new JTextArea();
	textArea.setEditable(false);
	textArea.setForeground(Color.PINK);
	textArea.setFont(new Font("Verdana", Font.BOLD, 12));
	textArea.setBackground(Color.BLACK);
	scrollPane.setViewportView(textArea);

	JLabel viewSpecificLabel = new JLabel("Vedi prenotazioni per cliente");
	viewSpecificLabel.setForeground(Color.RED);
	viewSpecificLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	viewSpecificLabel.setBackground(Color.DARK_GRAY);
	viewSpecificLabel.setBounds(700, 100, 219, 14);
	frame.getContentPane().add(viewSpecificLabel);

	JButton showAll = new JButton("Vedi prenotazioni area");
	showAll.addActionListener(e -> {

	    Connection myConn = null;
	    PreparedStatement myStmt = null;
	    ResultSet myRs = null;
	    try {
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
			this.logic.getOwnPassword());
		myStmt = myConn.prepareStatement(
			"SELECT numeroCamera, tipoPrenotazione, giorno, ora, codFiscaleCliente FROM PRENOTAZIONE "
				+ "JOIN (SELECT numeroCamera, codFiscaleCliente, dataInizio "
				+ "FROM SOGGIORNO WHERE soggiornante = true) AS SOG "
				+ "ON PRENOTAZIONE.codFiscaleClienteRegistrato = SOG.codFiscaleCliente "
				+ "AND PRENOTAZIONE.dataInizioSoggiornoRegistrato = SOG.dataInizio "
				+ "AND PRENOTAZIONE.tipoPrenotazione = ?");
		myStmt.setString(1, this.reservationTypeField.getText());
		myRs = myStmt.executeQuery();

		this.reservationTypeField.setText("");
		this.textArea.setText("");

		while (myRs.next()) {
		    this.textArea.append(myRs.getString(1) + "\t");
		    this.textArea.append(myRs.getString(2) + "\t");
		    this.textArea.append(myRs.getString(3) + "\t");
		    this.textArea.append(myRs.getString(4) + "\t");
		    this.textArea.append(myRs.getString(5) + "\n");
		}

	    } catch (Exception exc) {
		exc.printStackTrace();
	    }
	});
	showAll.setForeground(Color.ORANGE);
	showAll.setFont(new Font("Verdana", Font.BOLD, 12));
	showAll.setBackground(Color.DARK_GRAY);
	showAll.setBounds(700, 66, 219, 23);
	frame.getContentPane().add(showAll);

	specificViewField = new JTextField();
	specificViewField.setFont(new Font("Verdana", Font.BOLD, 12));
	specificViewField.setForeground(Color.PINK);
	specificViewField.setBackground(Color.BLACK);
	specificViewField.setBounds(700, 113, 219, 20);
	frame.getContentPane().add(specificViewField);
	specificViewField.setColumns(10);

	JButton commitSpecificBtn = new JButton("Vedi prenotazione cliente");
	commitSpecificBtn.addActionListener(e -> {
	    Connection myConn = null;
	    PreparedStatement myStmt = null;
	    ResultSet myRs = null;
	    try {
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
			this.logic.getOwnPassword());
		myStmt = myConn.prepareStatement(
			"SELECT numeroCamera, tipoPrenotazione, giorno, ora, codFiscaleCliente FROM PRENOTAZIONE "
				+ "JOIN (SELECT numeroCamera, codFiscaleCliente, dataInizio FROM SOGGIORNO "
				+ "WHERE numeroCamera = ? AND soggiornante = true) AS SOG "
				+ "ON PRENOTAZIONE.codFiscaleClienteRegistrato = SOG.codFiscaleCliente AND "
				+ "PRENOTAZIONE.dataInizioSoggiornoRegistrato = SOG.dataInizio");
		myStmt.setInt(1, Integer.parseInt(this.specificViewField.getText()));
		myRs = myStmt.executeQuery();

		this.specificViewField.setText("");
		this.textArea.setText("");

		while (myRs.next()) {
		    this.textArea.append(myRs.getString(1) + "\t");
		    this.textArea.append(myRs.getString(2) + "\t");
		    this.textArea.append(myRs.getString(3) + "\t");
		    this.textArea.append(myRs.getString(4) + "\t");
		    this.textArea.append(myRs.getString(5) + "\n");
		}

	    } catch (Exception exc) {
		exc.printStackTrace();
	    }
	});
	commitSpecificBtn.setForeground(Color.RED);
	commitSpecificBtn.setFont(new Font("Verdana", Font.BOLD, 12));
	commitSpecificBtn.setBackground(Color.DARK_GRAY);
	commitSpecificBtn.setBounds(700, 135, 219, 23);
	frame.getContentPane().add(commitSpecificBtn);

	JButton logout = new JButton("Logout");
	logout.addActionListener(e -> {
	    this.frame.dispose();
	    this.logic.logout();
	});
	logout.setFont(new Font("Verdana", Font.BOLD, 12));
	logout.setForeground(Color.ORANGE);
	logout.setBackground(Color.DARK_GRAY);
	logout.setBounds(700, 455, 219, 23);
	frame.getContentPane().add(logout);

	JLabel codeLabelDay = new JLabel("Inserisci giorno");
	codeLabelDay.setForeground(new Color(0, 128, 0));
	codeLabelDay.setFont(new Font("Verdana", Font.BOLD, 12));
	codeLabelDay.setBackground(Color.DARK_GRAY);
	codeLabelDay.setBounds(700, 260, 219, 14);
	frame.getContentPane().add(codeLabelDay);

	dayDeleteField = new JTextField();
	dayDeleteField.setFont(new Font("Verdana", Font.BOLD, 12));
	dayDeleteField.setForeground(Color.PINK);
	dayDeleteField.setBackground(Color.BLACK);
	dayDeleteField.setColumns(10);
	dayDeleteField.setBounds(700, 275, 219, 20);
	frame.getContentPane().add(dayDeleteField);

	JButton deleteReservationBtn = new JButton("Cancella");
	deleteReservationBtn.addActionListener(e -> {
	    this.logic.deleteReservation(this.deleteReservationField.getText(),
		    Integer.parseInt(this.clientDeleteField.getText()), this.dayDeleteField.getText(),
		    this.hourDeleteField.getText(), this.seasonField.getText(),
		    Integer.parseInt(this.yearField.getText()));

	    this.deleteReservationField.setText("");
	    this.clientDeleteField.setText("");
	    this.dayDeleteField.setText("");
	    this.hourDeleteField.setText("");
	    this.seasonField.setText("");
	    this.yearField.setText("");
	    this.textArea.setText("");
	});
	deleteReservationBtn.setForeground(new Color(0, 128, 0));
	deleteReservationBtn.setFont(new Font("Verdana", Font.BOLD, 12));
	deleteReservationBtn.setBackground(Color.DARK_GRAY);
	deleteReservationBtn.setBounds(700, 421, 219, 23);
	frame.getContentPane().add(deleteReservationBtn);

	reservationTypeField = new JTextField();
	reservationTypeField.setForeground(Color.PINK);
	reservationTypeField.setFont(new Font("Verdana", Font.BOLD, 12));
	reservationTypeField.setColumns(10);
	reservationTypeField.setBackground(Color.BLACK);
	reservationTypeField.setBounds(700, 46, 219, 20);
	frame.getContentPane().add(reservationTypeField);

	JLabel labelReservationType = new JLabel("Vedi prenotazioni per tipo");
	labelReservationType.setForeground(Color.ORANGE);
	labelReservationType.setFont(new Font("Verdana", Font.BOLD, 12));
	labelReservationType.setBackground(Color.DARK_GRAY);
	labelReservationType.setBounds(700, 27, 219, 14);
	frame.getContentPane().add(labelReservationType);

	JLabel codeCardLabel = new JLabel("Inserisci prenotazione");
	codeCardLabel.setForeground(new Color(0, 128, 0));
	codeCardLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	codeCardLabel.setBackground(Color.DARK_GRAY);
	codeCardLabel.setBounds(700, 179, 219, 14);
	frame.getContentPane().add(codeCardLabel);

	deleteReservationField = new JTextField();
	deleteReservationField.setForeground(Color.PINK);
	deleteReservationField.setFont(new Font("Verdana", Font.BOLD, 12));
	deleteReservationField.setColumns(10);
	deleteReservationField.setBackground(Color.BLACK);
	deleteReservationField.setBounds(700, 194, 219, 20);
	frame.getContentPane().add(deleteReservationField);

	hourDeleteField = new JTextField();
	hourDeleteField.setForeground(Color.PINK);
	hourDeleteField.setFont(new Font("Verdana", Font.BOLD, 12));
	hourDeleteField.setColumns(10);
	hourDeleteField.setBackground(Color.BLACK);
	hourDeleteField.setBounds(700, 313, 219, 20);
	frame.getContentPane().add(hourDeleteField);

	JLabel lblHour = new JLabel("Inserisci ora");
	lblHour.setForeground(new Color(0, 128, 0));
	lblHour.setFont(new Font("Verdana", Font.BOLD, 12));
	lblHour.setBackground(Color.DARK_GRAY);
	lblHour.setBounds(700, 298, 219, 14);
	frame.getContentPane().add(lblHour);

	JLabel lblClient = new JLabel("Inserisci camera");
	lblClient.setForeground(new Color(0, 128, 0));
	lblClient.setFont(new Font("Verdana", Font.BOLD, 12));
	lblClient.setBackground(Color.DARK_GRAY);
	lblClient.setBounds(700, 218, 219, 14);
	frame.getContentPane().add(lblClient);

	clientDeleteField = new JTextField();
	clientDeleteField.setForeground(Color.PINK);
	clientDeleteField.setFont(new Font("Verdana", Font.BOLD, 12));
	clientDeleteField.setColumns(10);
	clientDeleteField.setBackground(Color.BLACK);
	clientDeleteField.setBounds(700, 233, 219, 20);
	frame.getContentPane().add(clientDeleteField);

	seasonField = new JTextField();
	seasonField.setForeground(Color.PINK);
	seasonField.setFont(new Font("Verdana", Font.BOLD, 12));
	seasonField.setColumns(10);
	seasonField.setBackground(Color.BLACK);
	seasonField.setBounds(700, 349, 219, 20);
	frame.getContentPane().add(seasonField);

	JLabel lblSeason = new JLabel("Inserisci stagione");
	lblSeason.setForeground(new Color(0, 128, 0));
	lblSeason.setFont(new Font("Verdana", Font.BOLD, 12));
	lblSeason.setBackground(Color.DARK_GRAY);
	lblSeason.setBounds(700, 334, 219, 14);
	frame.getContentPane().add(lblSeason);

	yearField = new JTextField();
	yearField.setForeground(Color.PINK);
	yearField.setFont(new Font("Verdana", Font.BOLD, 12));
	yearField.setColumns(10);
	yearField.setBackground(Color.BLACK);
	yearField.setBounds(700, 390, 219, 20);
	frame.getContentPane().add(yearField);

	JLabel lblYear = new JLabel("Inserisci anno");
	lblYear.setForeground(new Color(0, 128, 0));
	lblYear.setFont(new Font("Verdana", Font.BOLD, 12));
	lblYear.setBackground(Color.DARK_GRAY);
	lblYear.setBounds(700, 375, 219, 14);
	frame.getContentPane().add(lblYear);
    }

    /**
     * @return actual frame.
     */
    public JFrame getFrame() {
	return this.frame;
    }
}
