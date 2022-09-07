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
import javax.swing.JTextField;

import db.logic.Logic;

public class ClientCard {

    private JFrame frame;
    private JTextField name;
    private JTextField cfField;
    private JLabel surnameRegistered;
    private JLabel amministrativeData;
    private JTextField surname;
    private JTextField dateField;
    private JTextField dayFIeld;
    private JTextField telField;
    private JLabel lblRoom;
    private JTextField roomFIeld;
    private JLabel lblVacation;
    private JTextField wageField;
    private JLabel lblWage;
    private String chosenClient;
    private JLabel lblExpire;
    private JTextField expirationDateField;
    private JTextField codeCardField;
    private JLabel lblUniversalIdentifier;
    private JTextField vacationTypeField;
    private JTextField monthField;
    private JLabel lblMonth;
    private JTextField yearField;
    private JLabel lblYear;
    private Logic logic;

    /**
     * Create the application.
     */
    public ClientCard(final String chosenClient, final Logic logic) {
	this.chosenClient = chosenClient;
	this.logic = logic;
	this.initialize();
	this.loadData();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("Scheda Cliente");
	frame.setResizable(false);
	frame.getContentPane().setBackground(Color.DARK_GRAY);
	frame.setBounds(100, 100, 945, 528);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel nameRegistered = new JLabel("Nome");
	nameRegistered.setForeground(Color.ORANGE);
	nameRegistered.setFont(new Font("Verdana", Font.BOLD, 12));
	nameRegistered.setBounds(10, 70, 86, 14);
	frame.getContentPane().add(nameRegistered);

	name = new JTextField();
	name.setEditable(false);
	name.setBounds(10, 92, 86, 20);
	frame.getContentPane().add(name);
	name.setColumns(10);

	JLabel codeCard = new JLabel("Dati sensibili");
	codeCard.setForeground(Color.RED);
	codeCard.setFont(new Font("Verdana", Font.BOLD, 18));
	codeCard.setBounds(10, 11, 333, 48);
	frame.getContentPane().add(codeCard);

	cfField = new JTextField();
	cfField.setEditable(false);
	cfField.setColumns(10);
	cfField.setBounds(10, 163, 190, 20);
	frame.getContentPane().add(cfField);

	JLabel cf = new JLabel("Codice Fiscale");
	cf.setForeground(Color.ORANGE);
	cf.setFont(new Font("Verdana", Font.BOLD, 12));
	cf.setBounds(10, 141, 190, 14);
	frame.getContentPane().add(cf);

	surnameRegistered = new JLabel("Cognome");
	surnameRegistered.setForeground(Color.ORANGE);
	surnameRegistered.setFont(new Font("Verdana", Font.BOLD, 12));
	surnameRegistered.setBounds(114, 70, 86, 14);
	frame.getContentPane().add(surnameRegistered);

	amministrativeData = new JLabel("Dati amministrativi");
	amministrativeData.setForeground(Color.RED);
	amministrativeData.setFont(new Font("Verdana", Font.BOLD, 18));
	amministrativeData.setBounds(395, 11, 209, 48);
	frame.getContentPane().add(amministrativeData);

	surname = new JTextField();
	surname.setEditable(false);
	surname.setColumns(10);
	surname.setBounds(114, 92, 86, 20);
	frame.getContentPane().add(surname);

	JLabel birthday = new JLabel("Data di nascita");
	birthday.setForeground(Color.ORANGE);
	birthday.setFont(new Font("Verdana", Font.BOLD, 12));
	birthday.setBounds(10, 213, 190, 14);
	frame.getContentPane().add(birthday);

	dateField = new JTextField();
	dateField.setEditable(false);
	dateField.setColumns(10);
	dateField.setBounds(10, 235, 190, 20);
	frame.getContentPane().add(dateField);

	JLabel lblBeginning = new JLabel("Inizio soggiorno");
	lblBeginning.setForeground(Color.ORANGE);
	lblBeginning.setFont(new Font("Verdana", Font.BOLD, 12));
	lblBeginning.setBounds(395, 70, 145, 14);
	frame.getContentPane().add(lblBeginning);

	dayFIeld = new JTextField();
	dayFIeld.setEditable(false);
	dayFIeld.setColumns(10);
	dayFIeld.setBounds(395, 92, 190, 20);
	frame.getContentPane().add(dayFIeld);

	JLabel lblPhone = new JLabel("Telefono");
	lblPhone.setForeground(Color.ORANGE);
	lblPhone.setFont(new Font("Verdana", Font.BOLD, 12));
	lblPhone.setBounds(10, 284, 190, 14);
	frame.getContentPane().add(lblPhone);

	telField = new JTextField();
	telField.setEditable(false);
	telField.setColumns(10);
	telField.setBounds(10, 306, 190, 20);
	frame.getContentPane().add(telField);

	lblRoom = new JLabel("Stanza assegnata");
	lblRoom.setForeground(Color.ORANGE);
	lblRoom.setFont(new Font("Verdana", Font.BOLD, 12));
	lblRoom.setBounds(10, 352, 145, 14);
	frame.getContentPane().add(lblRoom);

	roomFIeld = new JTextField();
	roomFIeld.setEditable(false);
	roomFIeld.setColumns(10);
	roomFIeld.setBounds(10, 374, 190, 20);
	frame.getContentPane().add(roomFIeld);

	lblVacation = new JLabel("Tipo soggiorno");
	lblVacation.setForeground(Color.ORANGE);
	lblVacation.setFont(new Font("Verdana", Font.BOLD, 12));
	lblVacation.setBounds(395, 176, 145, 14);
	frame.getContentPane().add(lblVacation);

	wageField = new JTextField();
	wageField.setBounds(642, 91, 159, 20);
	frame.getContentPane().add(wageField);
	wageField.setColumns(10);

	lblWage = new JLabel("Resoconto");
	lblWage.setForeground(Color.MAGENTA);
	lblWage.setFont(new Font("Verdana", Font.BOLD, 12));
	lblWage.setBounds(643, 70, 145, 14);
	frame.getContentPane().add(lblWage);

	JButton viewReservation = new JButton("Vedi Prenotazioni");
	viewReservation.addActionListener(e -> {
	    this.logic.goToSpecificPage("AllReservations", this.frame);
	    this.frame.dispose();
	});
	viewReservation.setFont(new Font("Verdana", Font.BOLD, 12));
	viewReservation.setBackground(Color.DARK_GRAY);
	viewReservation.setForeground(Color.MAGENTA);
	viewReservation.setBounds(642, 176, 187, 48);
	frame.getContentPane().add(viewReservation);

	JButton logout = new JButton("Logout");
	logout.addActionListener(e -> {
	    this.frame.dispose();
	    this.logic.logout();
	});
	logout.setForeground(Color.ORANGE);
	logout.setFont(new Font("Verdana", Font.BOLD, 12));
	logout.setBackground(Color.DARK_GRAY);
	logout.setBounds(732, 455, 187, 23);
	frame.getContentPane().add(logout);

	JButton checkoutButton = new JButton("Checkout");
	checkoutButton.addActionListener(e -> {
	    this.logic.checkoutClient(Integer.parseInt(this.roomFIeld.getText()));
	    this.frame.dispose();
	    this.logic.logout();
	});
	checkoutButton.setForeground(Color.RED);
	checkoutButton.setFont(new Font("Verdana", Font.BOLD, 12));
	checkoutButton.setBackground(Color.DARK_GRAY);
	checkoutButton.setBounds(642, 348, 187, 46);
	frame.getContentPane().add(checkoutButton);

	JButton btnUpdate = new JButton("Aggiorna");
	btnUpdate.addActionListener(e -> {
	    Connection conn = null;
	    PreparedStatement myStm = null;
	    try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
			this.logic.getOwnPassword());
		myStm = conn.prepareStatement(
			"UPDATE SOGGIORNO SET resoconto = ? WHERE codScheda = ? AND soggiornante = true");

		myStm.setDouble(1, Double.parseDouble(this.wageField.getText()));
		myStm.setString(2, this.chosenClient);
		myStm.executeUpdate();

	    } catch (Exception exc) {
		exc.printStackTrace();
	    }
	});

	btnUpdate.setForeground(Color.MAGENTA);
	btnUpdate.setFont(new Font("Verdana", Font.BOLD, 12));
	btnUpdate.setBackground(Color.DARK_GRAY);
	btnUpdate.setBounds(642, 113, 159, 23);
	frame.getContentPane().add(btnUpdate);

	lblExpire = new JLabel("Fine soggiorno");
	lblExpire.setForeground(Color.ORANGE);
	lblExpire.setFont(new Font("Verdana", Font.BOLD, 12));
	lblExpire.setBounds(395, 123, 145, 14);
	frame.getContentPane().add(lblExpire);

	expirationDateField = new JTextField();
	expirationDateField.setEditable(false);
	expirationDateField.setColumns(10);
	expirationDateField.setBounds(395, 145, 190, 20);
	frame.getContentPane().add(expirationDateField);

	codeCardField = new JTextField();
	codeCardField.setEditable(false);
	codeCardField.setColumns(10);
	codeCardField.setBounds(395, 374, 190, 20);
	frame.getContentPane().add(codeCardField);

	lblUniversalIdentifier = new JLabel("Codice universale scheda");
	lblUniversalIdentifier.setForeground(Color.ORANGE);
	lblUniversalIdentifier.setFont(new Font("Verdana", Font.BOLD, 12));
	lblUniversalIdentifier.setBounds(395, 352, 190, 14);
	frame.getContentPane().add(lblUniversalIdentifier);

	vacationTypeField = new JTextField();
	vacationTypeField.setEditable(false);
	vacationTypeField.setColumns(10);
	vacationTypeField.setBounds(395, 201, 190, 20);
	frame.getContentPane().add(vacationTypeField);

	monthField = new JTextField();
	monthField.setEditable(false);
	monthField.setColumns(10);
	monthField.setBounds(395, 260, 190, 20);
	frame.getContentPane().add(monthField);

	lblMonth = new JLabel("Mese soggiorno");
	lblMonth.setForeground(Color.ORANGE);
	lblMonth.setFont(new Font("Verdana", Font.BOLD, 12));
	lblMonth.setBounds(395, 235, 145, 14);
	frame.getContentPane().add(lblMonth);

	yearField = new JTextField();
	yearField.setEditable(false);
	yearField.setColumns(10);
	yearField.setBounds(395, 321, 190, 20);
	frame.getContentPane().add(yearField);

	lblYear = new JLabel("Anno soggiorno");
	lblYear.setForeground(Color.ORANGE);
	lblYear.setFont(new Font("Verdana", Font.BOLD, 12));
	lblYear.setBounds(395, 296, 145, 14);
	frame.getContentPane().add(lblYear);
    }

    /**
     * Loads all fields in the GUI.
     */
    private void loadData() {

	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;

	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.logic.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT nome, cognome, codFiscale, dataNascita, numeroTelefonico, "
		    + "numeroCamera, dataInizio, dataFine, tipologiaSoggiornoScelto, meseSoggiornoScelto, "
		    + "annoSoggiornoScelto, codScheda, resoconto FROM CLIENTE, SOGGIORNO "
		    + "WHERE SOGGIORNO.codScheda = ? AND SOGGIORNO.codFiscaleCliente = CLIENTE.codFiscale");

	    myStm.setInt(1, Integer.valueOf(this.chosenClient));
	    result = myStm.executeQuery();
	    result.next();
	    this.name.setText(result.getString(1));
	    this.surname.setText(result.getString(2));
	    this.cfField.setText(result.getString(3));
	    this.dateField.setText(result.getString(4));
	    this.telField.setText(result.getString(5));
	    this.roomFIeld.setText(result.getString(6));
	    this.dayFIeld.setText(result.getString(7));
	    this.expirationDateField.setText(result.getString(8));
	    this.vacationTypeField.setText(result.getString(9));
	    this.monthField.setText(result.getString(10));
	    this.yearField.setText(result.getString(11));
	    this.codeCardField.setText(result.getString(12));
	    this.wageField.setText(result.getString(13));

	} catch (Exception exc) {
	    exc.printStackTrace();
	}
    }

    /**
     * @return actual frame.
     */
    public JFrame getFrame() {
	return this.frame;
    }
}
