package db.pages.specific;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import db.logic.Logic;
import java.awt.Font;
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
	private JTextField dayFIeld;
	private JTextField checkoutField;
	private JTextField checkinFIeld;
	private JTextField telField;
	private JLabel lblStanzaAssegnata;
	private JTextField roomFIeld;
	private JRadioButton rdbtnIntBB;
	private JRadioButton rdbtnIntCompleto;
	private JRadioButton rdbtnIntAllInclusive;
	private JLabel lblTipoSoggiorno;
	private JTextField codCardField;
	private JLabel codLabel;
	private String soggiorno;
	private Logic logic;

	// Basic value for allergies
	private int lattosio = 0;
	private int glutine = 0;
	private JTextField resField;
	private JLabel lblRoom;
	private JTextField roomField;

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

		JLabel codeCard = new JLabel("Dati personali");
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

		JLabel lblSoggiorno = new JLabel("Durata soggiorno");
		lblSoggiorno.setForeground(Color.ORANGE);
		lblSoggiorno.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSoggiorno.setBounds(395, 70, 145, 14);
		frmRegistraCliente.getContentPane().add(lblSoggiorno);

		dayFIeld = new JTextField();
		dayFIeld.setForeground(Color.BLACK);
		dayFIeld.setBackground(Color.WHITE);
		dayFIeld.setFont(new Font("Verdana", Font.PLAIN, 12));
		dayFIeld.setColumns(10);
		dayFIeld.setBounds(395, 92, 190, 20);
		frmRegistraCliente.getContentPane().add(dayFIeld);

		checkoutField = new JTextField();
		checkoutField.setForeground(Color.BLACK);
		checkoutField.setBackground(Color.WHITE);
		checkoutField.setFont(new Font("Verdana", Font.PLAIN, 12));
		checkoutField.setColumns(10);
		checkoutField.setBounds(395, 306, 190, 20);
		frmRegistraCliente.getContentPane().add(checkoutField);

		JLabel lblOrarioCheckout = new JLabel("Orario check-out");
		lblOrarioCheckout.setForeground(Color.ORANGE);
		lblOrarioCheckout.setFont(new Font("Verdana", Font.BOLD, 12));
		lblOrarioCheckout.setBounds(395, 284, 145, 14);
		frmRegistraCliente.getContentPane().add(lblOrarioCheckout);

		checkinFIeld = new JTextField();
		checkinFIeld.setForeground(Color.BLACK);
		checkinFIeld.setBackground(Color.WHITE);
		checkinFIeld.setFont(new Font("Verdana", Font.PLAIN, 12));
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
		telField.setForeground(Color.BLACK);
		telField.setBackground(Color.WHITE);
		telField.setFont(new Font("Verdana", Font.PLAIN, 12));
		telField.setColumns(10);
		telField.setBounds(10, 306, 190, 20);
		frmRegistraCliente.getContentPane().add(telField);

		lblStanzaAssegnata = new JLabel("Stanza assegnata");
		lblStanzaAssegnata.setForeground(Color.ORANGE);
		lblStanzaAssegnata.setFont(new Font("Verdana", Font.BOLD, 12));
		lblStanzaAssegnata.setBounds(395, 359, 145, 14);
		frmRegistraCliente.getContentPane().add(lblStanzaAssegnata);

		roomFIeld = new JTextField();
		roomFIeld.setForeground(Color.BLACK);
		roomFIeld.setBackground(Color.WHITE);
		roomFIeld.setFont(new Font("Verdana", Font.PLAIN, 12));
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
		logout.addActionListener(e -> {
			this.frmRegistraCliente.dispose();
			this.logic.logout();
		});
		logout.setForeground(Color.ORANGE);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(734, 455, 185, 23);
		frmRegistraCliente.getContentPane().add(logout);

		/*
		 * For logic coherence, we put the listeners for the radio buttons here.
		 */
		this.rdbtnIntAllInclusive.addActionListener(e -> {
			this.soggiorno = "AllInclusive";
		});

		this.rdbtnIntBB.addActionListener(e -> {
			this.soggiorno = "BB";
		});

		this.rdbtnIntCompleto.addActionListener(e -> {
			this.soggiorno = "PensioneCompleta";
		});

		JButton registrationButton = new JButton("Registra");
		registrationButton.addActionListener(e -> {
			
			int intollerance = 0;
			if (this.glutine == 0) {
				intollerance = this.lattosio;
			} else if (this.lattosio == 0) {
				intollerance = this.glutine;
			}

			this.logic.registerNewClient(this.name.getText(), this.surname.getText(),
					this.cfField.getText(), this.dateField.getText(),
					Integer.parseInt(this.telField.getText()), this.soggiorno,
					Integer.parseInt(this.codCardField.getText()), Integer.parseInt(this.roomFIeld.getText()),
					intollerance, Integer.parseInt(this.resField.getText()), Integer.parseInt(this.dayFIeld.getText()),
					this.checkinFIeld.getText(), this.checkoutField.getText());
		});

		registrationButton.setForeground(Color.MAGENTA);
		registrationButton.setFont(new Font("Verdana", Font.BOLD, 12));
		registrationButton.setBackground(Color.DARK_GRAY);
		registrationButton.setBounds(734, 388, 185, 56);
		frmRegistraCliente.getContentPane().add(registrationButton);

		codCardField = new JTextField();
		codCardField.setForeground(Color.BLACK);
		codCardField.setFont(new Font("Verdana", Font.PLAIN, 12));
		codCardField.setColumns(10);
		codCardField.setBounds(734, 362, 185, 20);
		frmRegistraCliente.getContentPane().add(codCardField);

		codLabel = new JLabel("Codice scheda:");
		codLabel.setForeground(Color.ORANGE);
		codLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		codLabel.setBounds(734, 340, 185, 14);
		frmRegistraCliente.getContentPane().add(codLabel);

		JLabel resLabel = new JLabel("Resoconto attuale");
		resLabel.setForeground(Color.ORANGE);
		resLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		resLabel.setBounds(395, 141, 145, 14);
		frmRegistraCliente.getContentPane().add(resLabel);

		resField = new JTextField();
		resField.setForeground(Color.BLACK);
		resField.setFont(new Font("Verdana", Font.PLAIN, 12));
		resField.setColumns(10);
		resField.setBackground(Color.WHITE);
		resField.setBounds(395, 163, 190, 20);
		frmRegistraCliente.getContentPane().add(resField);
		
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
	}

	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frmRegistraCliente;
	}
}
