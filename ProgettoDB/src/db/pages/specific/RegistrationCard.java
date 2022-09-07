package db.pages.specific;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import db.logic.Logic;
import java.awt.Font;
import javax.swing.JButton;

public class RegistrationCard {

    private JFrame frmRegistraCliente;
    private JTextField name;
    private JTextField cfField;
    private JLabel surnameRegistered;
    private JLabel amministrativeData;
    private JTextField surname;
    private JTextField dateField;
    private JTextField beginningField;
    private JTextField telField;
    private JTextField codCardField;
    private JLabel codLabel;
    private JTextField expireField;
    private JLabel lblRoom;
    private JTextField roomField;
    private JLabel lblExpire;
    private JLabel lblVacation;
    private JTextField vacationField;
    private JLabel lblMonth;
    private JTextField monthField;
    private JLabel lblYear;
    private JTextField yearField;
    private Logic logic;
    private JTextField daysField;

    /**
     * Constructor.
     */
    public RegistrationCard(final Logic logic) {
	this.logic = logic;
	this.initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frmRegistraCliente = new JFrame();
	frmRegistraCliente.setResizable(false);
	frmRegistraCliente.setTitle("Registra Cliente");
	frmRegistraCliente.getContentPane().setBackground(Color.DARK_GRAY);
	frmRegistraCliente.setBounds(100, 100, 945, 528);
	frmRegistraCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmRegistraCliente.getContentPane().setLayout(null);

	JLabel nameRegistered = new JLabel("Nome");
	nameRegistered.setForeground(Color.ORANGE);
	nameRegistered.setFont(new Font("Verdana", Font.BOLD, 12));
	nameRegistered.setBounds(10, 70, 86, 14);
	frmRegistraCliente.getContentPane().add(nameRegistered);

	name = new JTextField();
	name.setForeground(Color.BLACK);
	name.setBackground(Color.WHITE);
	name.setFont(new Font("Verdana", Font.PLAIN, 12));
	name.setBounds(10, 92, 86, 20);
	frmRegistraCliente.getContentPane().add(name);
	name.setColumns(10);

	JLabel codeCard = new JLabel("Dati sensibili");
	codeCard.setForeground(Color.RED);
	codeCard.setFont(new Font("Verdana", Font.BOLD, 18));
	codeCard.setBounds(10, 11, 333, 48);
	frmRegistraCliente.getContentPane().add(codeCard);

	cfField = new JTextField();
	cfField.setForeground(Color.BLACK);
	cfField.setBackground(Color.WHITE);
	cfField.setFont(new Font("Verdana", Font.PLAIN, 12));
	cfField.setColumns(10);
	cfField.setBounds(10, 163, 190, 20);
	frmRegistraCliente.getContentPane().add(cfField);

	JLabel cf = new JLabel("Codice Fiscale");
	cf.setForeground(Color.ORANGE);
	cf.setFont(new Font("Verdana", Font.BOLD, 12));
	cf.setBounds(10, 141, 190, 14);
	frmRegistraCliente.getContentPane().add(cf);

	surnameRegistered = new JLabel("Cognome");
	surnameRegistered.setForeground(Color.ORANGE);
	surnameRegistered.setFont(new Font("Verdana", Font.BOLD, 12));
	surnameRegistered.setBounds(114, 70, 86, 14);
	frmRegistraCliente.getContentPane().add(surnameRegistered);

	amministrativeData = new JLabel("Dati amministrativi");
	amministrativeData.setForeground(Color.RED);
	amministrativeData.setFont(new Font("Verdana", Font.BOLD, 18));
	amministrativeData.setBounds(395, 11, 209, 48);
	frmRegistraCliente.getContentPane().add(amministrativeData);

	surname = new JTextField();
	surname.setForeground(Color.BLACK);
	surname.setBackground(Color.WHITE);
	surname.setFont(new Font("Verdana", Font.PLAIN, 12));
	surname.setColumns(10);
	surname.setBounds(114, 92, 86, 20);
	frmRegistraCliente.getContentPane().add(surname);

	JLabel birthday = new JLabel("Data di nascita");
	birthday.setForeground(Color.ORANGE);
	birthday.setFont(new Font("Verdana", Font.BOLD, 12));
	birthday.setBounds(10, 213, 190, 14);
	frmRegistraCliente.getContentPane().add(birthday);

	dateField = new JTextField();
	dateField.setForeground(Color.BLACK);
	dateField.setBackground(Color.WHITE);
	dateField.setFont(new Font("Verdana", Font.PLAIN, 12));
	dateField.setColumns(10);
	dateField.setBounds(10, 235, 190, 20);
	frmRegistraCliente.getContentPane().add(dateField);

	JLabel lblBeginning = new JLabel("Inizio soggiorno");
	lblBeginning.setForeground(Color.ORANGE);
	lblBeginning.setFont(new Font("Verdana", Font.BOLD, 12));
	lblBeginning.setBounds(395, 70, 145, 14);
	frmRegistraCliente.getContentPane().add(lblBeginning);

	beginningField = new JTextField();
	beginningField.setForeground(Color.BLACK);
	beginningField.setBackground(Color.WHITE);
	beginningField.setFont(new Font("Verdana", Font.PLAIN, 12));
	beginningField.setColumns(10);
	beginningField.setBounds(395, 92, 190, 20);
	frmRegistraCliente.getContentPane().add(beginningField);

	JLabel lblPhone = new JLabel("Telefono");
	lblPhone.setForeground(Color.ORANGE);
	lblPhone.setFont(new Font("Verdana", Font.BOLD, 12));
	lblPhone.setBounds(10, 284, 190, 14);
	frmRegistraCliente.getContentPane().add(lblPhone);

	telField = new JTextField();
	telField.setForeground(Color.BLACK);
	telField.setBackground(Color.WHITE);
	telField.setFont(new Font("Verdana", Font.PLAIN, 12));
	telField.setColumns(10);
	telField.setBounds(10, 306, 190, 20);
	frmRegistraCliente.getContentPane().add(telField);

	JButton logout = new JButton("Logout");
	logout.addActionListener(e -> {
	    this.frmRegistraCliente.dispose();
	    this.logic.logout();
	});
	logout.setForeground(Color.ORANGE);
	logout.setFont(new Font("Verdana", Font.BOLD, 12));
	logout.setBackground(Color.DARK_GRAY);
	logout.setBounds(734, 455, 185, 23);
	frmRegistraCliente.getContentPane().add(logout);

	JButton registrationButton = new JButton("Registra");
	registrationButton.addActionListener(e -> {

	    /*
	     * Register a client.
	     */
	    this.logic.registerNewClient(this.name.getText(), this.surname.getText(), this.cfField.getText(),
		    this.dateField.getText(), this.telField.getText(), this.beginningField.getText(),
		    this.expireField.getText(), this.vacationField.getText(),
		    Integer.parseInt(this.codCardField.getText()), Integer.parseInt(this.roomField.getText()),
		    this.vacationField.getText(), this.monthField.getText(), Integer.parseInt(this.yearField.getText()),
		    Integer.parseInt(this.daysField.getText()));

	    /*
	     * Clearing fields.
	     */
	    this.name.setText("");
	    this.surname.setText("");
	    this.cfField.setText("");
	    this.dateField.setText("");
	    this.telField.setText("");
	    this.roomField.setText("");
	    this.beginningField.setText("");
	    this.expireField.setText("");
	    this.vacationField.setText("");
	    this.monthField.setText("");
	    this.yearField.setText("");
	});

	registrationButton.setForeground(Color.MAGENTA);
	registrationButton.setFont(new Font("Verdana", Font.BOLD, 12));
	registrationButton.setBackground(Color.DARK_GRAY);
	registrationButton.setBounds(692, 288, 185, 56);
	frmRegistraCliente.getContentPane().add(registrationButton);

	codCardField = new JTextField();
	codCardField.setForeground(Color.BLACK);
	codCardField.setFont(new Font("Verdana", Font.PLAIN, 12));
	codCardField.setColumns(10);
	codCardField.setBounds(692, 207, 185, 20);
	frmRegistraCliente.getContentPane().add(codCardField);

	codLabel = new JLabel("Codice uniersale scheda:");
	codLabel.setForeground(Color.MAGENTA);
	codLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	codLabel.setBounds(692, 185, 185, 14);
	frmRegistraCliente.getContentPane().add(codLabel);

	expireField = new JTextField();
	expireField.setForeground(Color.BLACK);
	expireField.setFont(new Font("Verdana", Font.PLAIN, 12));
	expireField.setColumns(10);
	expireField.setBackground(Color.WHITE);
	expireField.setBounds(395, 163, 190, 20);
	frmRegistraCliente.getContentPane().add(expireField);

	lblRoom = new JLabel("Stanza assegnata");
	lblRoom.setForeground(Color.ORANGE);
	lblRoom.setFont(new Font("Verdana", Font.BOLD, 12));
	lblRoom.setBounds(10, 359, 190, 14);
	frmRegistraCliente.getContentPane().add(lblRoom);

	roomField = new JTextField();
	roomField.setForeground(Color.BLACK);
	roomField.setFont(new Font("Verdana", Font.PLAIN, 12));
	roomField.setColumns(10);
	roomField.setBackground(Color.WHITE);
	roomField.setBounds(10, 381, 190, 20);
	frmRegistraCliente.getContentPane().add(roomField);

	lblExpire = new JLabel("Fine soggiorno");
	lblExpire.setForeground(Color.ORANGE);
	lblExpire.setFont(new Font("Verdana", Font.BOLD, 12));
	lblExpire.setBounds(395, 142, 145, 14);
	frmRegistraCliente.getContentPane().add(lblExpire);

	lblVacation = new JLabel("Tipo soggiorno");
	lblVacation.setForeground(Color.ORANGE);
	lblVacation.setFont(new Font("Verdana", Font.BOLD, 12));
	lblVacation.setBounds(395, 210, 145, 14);
	frmRegistraCliente.getContentPane().add(lblVacation);

	vacationField = new JTextField();
	vacationField.setColumns(10);
	vacationField.setBounds(395, 235, 190, 20);
	frmRegistraCliente.getContentPane().add(vacationField);

	lblMonth = new JLabel("Mese soggiorno");
	lblMonth.setForeground(Color.ORANGE);
	lblMonth.setFont(new Font("Verdana", Font.BOLD, 12));
	lblMonth.setBounds(395, 281, 145, 14);
	frmRegistraCliente.getContentPane().add(lblMonth);

	monthField = new JTextField();
	monthField.setColumns(10);
	monthField.setBounds(395, 306, 190, 20);
	frmRegistraCliente.getContentPane().add(monthField);

	lblYear = new JLabel("Anno soggiorno");
	lblYear.setForeground(Color.ORANGE);
	lblYear.setFont(new Font("Verdana", Font.BOLD, 12));
	lblYear.setBounds(395, 356, 145, 14);
	frmRegistraCliente.getContentPane().add(lblYear);

	yearField = new JTextField();
	yearField.setColumns(10);
	yearField.setBounds(395, 381, 190, 20);
	frmRegistraCliente.getContentPane().add(yearField);

	daysField = new JTextField();
	daysField.setForeground(Color.BLACK);
	daysField.setFont(new Font("Verdana", Font.PLAIN, 12));
	daysField.setColumns(10);
	daysField.setBounds(692, 257, 185, 20);
	frmRegistraCliente.getContentPane().add(daysField);

	JLabel lblDaysOfReservations = new JLabel("Giorni di permanenza");
	lblDaysOfReservations.setForeground(Color.MAGENTA);
	lblDaysOfReservations.setFont(new Font("Verdana", Font.BOLD, 12));
	lblDaysOfReservations.setBounds(692, 235, 185, 14);
	frmRegistraCliente.getContentPane().add(lblDaysOfReservations);
    }

    /**
     * @return actual frame.
     */
    public JFrame getFrame() {
	return this.frmRegistraCliente;
    }
}
