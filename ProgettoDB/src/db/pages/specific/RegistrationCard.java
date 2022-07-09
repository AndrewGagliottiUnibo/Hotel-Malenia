package db.pages.specific;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class RegistrationCard {

	private JFrame frmRegistraCliente;
	private JTextField name;
	private JTextField cfField;
	private JLabel surnameRegistered;
	private JLabel amministrativeData;
	private JTextField surname;
	private JTextField dateField;
	private JTextField beginFIeld;
	private JTextField endFIeld;
	private JTextField checkoutField;
	private JTextField checkinFIeld;
	private JTextField telField;
	private JRadioButton rdbtnIntGlutine;
	private JLabel lblStanzaAssegnata;
	private JTextField roomFIeld;
	private JRadioButton rdbtnIntBB;
	private JRadioButton rdbtnIntCompleto;
	private JRadioButton rdbtnIntAllInclusive;
	private JLabel lblTipoSoggiorno;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public RegistrationCard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistraCliente = new JFrame();
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
		name.setBounds(10, 92, 86, 20);
		frmRegistraCliente.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel codeCard = new JLabel("Dati personali");
		codeCard.setForeground(Color.RED);
		codeCard.setFont(new Font("Verdana", Font.BOLD, 18));
		codeCard.setBounds(10, 11, 333, 48);
		frmRegistraCliente.getContentPane().add(codeCard);
		
		cfField = new JTextField();
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
		surname.setColumns(10);
		surname.setBounds(114, 92, 86, 20);
		frmRegistraCliente.getContentPane().add(surname);
		
		JLabel birthday = new JLabel("Data di nascita");
		birthday.setForeground(Color.ORANGE);
		birthday.setFont(new Font("Verdana", Font.BOLD, 12));
		birthday.setBounds(10, 213, 190, 14);
		frmRegistraCliente.getContentPane().add(birthday);
		
		dateField = new JTextField();
		dateField.setColumns(10);
		dateField.setBounds(10, 235, 190, 20);
		frmRegistraCliente.getContentPane().add(dateField);
		
		JLabel lblInizioSoggiorno = new JLabel("Inizio soggiorno");
		lblInizioSoggiorno.setForeground(Color.ORANGE);
		lblInizioSoggiorno.setFont(new Font("Verdana", Font.BOLD, 12));
		lblInizioSoggiorno.setBounds(395, 70, 145, 14);
		frmRegistraCliente.getContentPane().add(lblInizioSoggiorno);
		
		beginFIeld = new JTextField();
		beginFIeld.setColumns(10);
		beginFIeld.setBounds(395, 92, 190, 20);
		frmRegistraCliente.getContentPane().add(beginFIeld);
		
		JLabel lblFineSoggiorno = new JLabel("Fine Soggiorno");
		lblFineSoggiorno.setForeground(Color.ORANGE);
		lblFineSoggiorno.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFineSoggiorno.setBounds(395, 141, 145, 14);
		frmRegistraCliente.getContentPane().add(lblFineSoggiorno);
		
		endFIeld = new JTextField();
		endFIeld.setColumns(10);
		endFIeld.setBounds(395, 163, 190, 20);
		frmRegistraCliente.getContentPane().add(endFIeld);
		
		checkoutField = new JTextField();
		checkoutField.setColumns(10);
		checkoutField.setBounds(395, 306, 190, 20);
		frmRegistraCliente.getContentPane().add(checkoutField);
		
		JLabel lblOrarioCheckout = new JLabel("Orario check-out");
		lblOrarioCheckout.setForeground(Color.ORANGE);
		lblOrarioCheckout.setFont(new Font("Verdana", Font.BOLD, 12));
		lblOrarioCheckout.setBounds(395, 284, 145, 14);
		frmRegistraCliente.getContentPane().add(lblOrarioCheckout);
		
		checkinFIeld = new JTextField();
		checkinFIeld.setColumns(10);
		checkinFIeld.setBounds(395, 235, 190, 20);
		frmRegistraCliente.getContentPane().add(checkinFIeld);
		
		JLabel lblOrarioCheckin = new JLabel("Orario check-in");
		lblOrarioCheckin.setForeground(Color.ORANGE);
		lblOrarioCheckin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblOrarioCheckin.setBounds(395, 213, 145, 14);
		frmRegistraCliente.getContentPane().add(lblOrarioCheckin);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.ORANGE);
		lblTelefono.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTelefono.setBounds(10, 284, 190, 14);
		frmRegistraCliente.getContentPane().add(lblTelefono);
		
		telField = new JTextField();
		telField.setColumns(10);
		telField.setBounds(10, 306, 190, 20);
		frmRegistraCliente.getContentPane().add(telField);
		
		JRadioButton rdbtnIntLattosio = new JRadioButton("Int - Lattosio");
		rdbtnIntLattosio.setForeground(Color.ORANGE);
		rdbtnIntLattosio.setBackground(Color.DARK_GRAY);
		rdbtnIntLattosio.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntLattosio.setBounds(10, 359, 190, 23);
		frmRegistraCliente.getContentPane().add(rdbtnIntLattosio);
		
		rdbtnIntGlutine = new JRadioButton("Int - Glutine");
		rdbtnIntGlutine.setForeground(Color.ORANGE);
		rdbtnIntGlutine.setBackground(Color.DARK_GRAY);
		rdbtnIntGlutine.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntGlutine.setBounds(10, 398, 190, 23);
		frmRegistraCliente.getContentPane().add(rdbtnIntGlutine);
		
		lblStanzaAssegnata = new JLabel("Stanza assegnata");
		lblStanzaAssegnata.setForeground(Color.ORANGE);
		lblStanzaAssegnata.setFont(new Font("Verdana", Font.BOLD, 12));
		lblStanzaAssegnata.setBounds(395, 359, 145, 14);
		frmRegistraCliente.getContentPane().add(lblStanzaAssegnata);
		
		roomFIeld = new JTextField();
		roomFIeld.setColumns(10);
		roomFIeld.setBounds(395, 381, 190, 20);
		frmRegistraCliente.getContentPane().add(roomFIeld);
		
		rdbtnIntBB = new JRadioButton("B&B");
		rdbtnIntBB.setForeground(Color.ORANGE);
		rdbtnIntBB.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntBB.setBackground(Color.DARK_GRAY);
		rdbtnIntBB.setBounds(642, 92, 190, 23);
		frmRegistraCliente.getContentPane().add(rdbtnIntBB);
		
		rdbtnIntCompleto = new JRadioButton("Completo");
		rdbtnIntCompleto.setForeground(Color.ORANGE);
		rdbtnIntCompleto.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntCompleto.setBackground(Color.DARK_GRAY);
		rdbtnIntCompleto.setBounds(642, 118, 190, 23);
		frmRegistraCliente.getContentPane().add(rdbtnIntCompleto);
		
		rdbtnIntAllInclusive = new JRadioButton("All-inclusive");
		rdbtnIntAllInclusive.setForeground(Color.ORANGE);
		rdbtnIntAllInclusive.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntAllInclusive.setBackground(Color.DARK_GRAY);
		rdbtnIntAllInclusive.setBounds(642, 146, 190, 23);
		frmRegistraCliente.getContentPane().add(rdbtnIntAllInclusive);
		
		lblTipoSoggiorno = new JLabel("Tipo soggiorno");
		lblTipoSoggiorno.setForeground(Color.ORANGE);
		lblTipoSoggiorno.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTipoSoggiorno.setBounds(643, 71, 145, 14);
		frmRegistraCliente.getContentPane().add(lblTipoSoggiorno);
		
		JButton logout = new JButton("Logout");
		logout.setForeground(Color.ORANGE);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(830, 455, 89, 23);
		frmRegistraCliente.getContentPane().add(logout);
		
		JButton backButton = new JButton("Indietro");
		backButton.setForeground(Color.ORANGE);
		backButton.setFont(new Font("Verdana", Font.BOLD, 12));
		backButton.setBackground(Color.DARK_GRAY);
		backButton.setBounds(734, 455, 89, 23);
		frmRegistraCliente.getContentPane().add(backButton);
		
		JButton registrationButton = new JButton("Registra");
		registrationButton.addActionListener(e -> {
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;

			try {
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
						"dariostudente");
				System.out.println("Database connected");
				// 2. Create a statement
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("INSERT INTO SCHEDA (codScheda, numeroCamera, intolleranze, "
						+ "resoconto, datiTariffa, durataSoggiorno, orarioCheckin, orarioCheckout) + "
						+ "VALUES (?, ?, � �, ?, ?, ?, � �, � �)");

				myRs = myStmt.executeQuery(
						"INSERT INTO CLIENTE (nome, cognome, codiceFiscale, dataNascita, numeroTel, tipologiaSoggiorno) + "
								+ "VALUES (?, ?, ?, ?, ?, ?)");
				myRs = myStmt.executeQuery("INSERT INTO IDENTIFICAZIONE (codiceCliente, numeroScheda)"
						+ "VALUES (?, SCHEDA.codScheda)");
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		});
		
		registrationButton.setForeground(Color.MAGENTA);
		registrationButton.setFont(new Font("Verdana", Font.BOLD, 12));
		registrationButton.setBackground(Color.DARK_GRAY);
		registrationButton.setBounds(734, 388, 185, 56);
		frmRegistraCliente.getContentPane().add(registrationButton);
	}
	
	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frmRegistraCliente;
	}
}
