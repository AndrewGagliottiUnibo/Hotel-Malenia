package db.pages.specific;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import db.logic.Logic;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ClientCard {

	private JFrame frame;
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
	private JRadioButton rdbtnIntGlutine;
	private JLabel lblStanzaAssegnata;
	private JTextField roomFIeld;
	private JRadioButton rdbtnIntBB;
	private JRadioButton rdbtnIntCompleto;
	private JRadioButton rdbtnIntAllInclusive;
	private JLabel lblTipoSoggiorno;
	private JTextField resField;
	private JLabel lblResoconto;
	private Logic logic;
	private String chosenClient;

	/**
	 * Create the application.
	 */
	public ClientCard(final String chosenClient, final Logic logic) {
		this.chosenClient = chosenClient;
		this.logic = logic;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Scheda Cliente");
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
		name.setBounds(10, 92, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel codeCard = new JLabel("");
		codeCard.setForeground(Color.RED);
		codeCard.setFont(new Font("Verdana", Font.BOLD, 18));
		codeCard.setBounds(10, 11, 333, 48);
		frame.getContentPane().add(codeCard);
		
		cfField = new JTextField();
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
		surname.setColumns(10);
		surname.setBounds(114, 92, 86, 20);
		frame.getContentPane().add(surname);
		
		JLabel birthday = new JLabel("Data di nascita");
		birthday.setForeground(Color.ORANGE);
		birthday.setFont(new Font("Verdana", Font.BOLD, 12));
		birthday.setBounds(10, 213, 190, 14);
		frame.getContentPane().add(birthday);
		
		dateField = new JTextField();
		dateField.setColumns(10);
		dateField.setBounds(10, 235, 190, 20);
		frame.getContentPane().add(dateField);
		
		JLabel lblSoggiorno = new JLabel("Inizio soggiorno");
		lblSoggiorno.setForeground(Color.ORANGE);
		lblSoggiorno.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSoggiorno.setBounds(395, 70, 145, 14);
		frame.getContentPane().add(lblSoggiorno);
		
		dayFIeld = new JTextField();
		dayFIeld.setColumns(10);
		dayFIeld.setBounds(395, 92, 190, 20);
		frame.getContentPane().add(dayFIeld);
		
		checkoutField = new JTextField();
		checkoutField.setColumns(10);
		checkoutField.setBounds(395, 306, 190, 20);
		frame.getContentPane().add(checkoutField);
		
		JLabel lblOrarioCheckout = new JLabel("Orario check-out");
		lblOrarioCheckout.setForeground(Color.ORANGE);
		lblOrarioCheckout.setFont(new Font("Verdana", Font.BOLD, 12));
		lblOrarioCheckout.setBounds(395, 284, 145, 14);
		frame.getContentPane().add(lblOrarioCheckout);
		
		checkinFIeld = new JTextField();
		checkinFIeld.setColumns(10);
		checkinFIeld.setBounds(395, 235, 190, 20);
		frame.getContentPane().add(checkinFIeld);
		
		JLabel lblOrarioCheckin = new JLabel("Orario check-in");
		lblOrarioCheckin.setForeground(Color.ORANGE);
		lblOrarioCheckin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblOrarioCheckin.setBounds(395, 213, 145, 14);
		frame.getContentPane().add(lblOrarioCheckin);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.ORANGE);
		lblTelefono.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTelefono.setBounds(10, 284, 190, 14);
		frame.getContentPane().add(lblTelefono);
		
		telField = new JTextField();
		telField.setColumns(10);
		telField.setBounds(10, 306, 190, 20);
		frame.getContentPane().add(telField);
		
		JRadioButton rdbtnIntLattosio = new JRadioButton("Int - Lattosio");
		rdbtnIntLattosio.setForeground(Color.ORANGE);
		rdbtnIntLattosio.setBackground(Color.DARK_GRAY);
		rdbtnIntLattosio.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntLattosio.setBounds(10, 359, 190, 23);
		frame.getContentPane().add(rdbtnIntLattosio);
		
		rdbtnIntGlutine = new JRadioButton("Int - Glutine");
		rdbtnIntGlutine.setForeground(Color.ORANGE);
		rdbtnIntGlutine.setBackground(Color.DARK_GRAY);
		rdbtnIntGlutine.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntGlutine.setBounds(10, 398, 190, 23);
		frame.getContentPane().add(rdbtnIntGlutine);
		
		lblStanzaAssegnata = new JLabel("Stanza assegnata");
		lblStanzaAssegnata.setForeground(Color.ORANGE);
		lblStanzaAssegnata.setFont(new Font("Verdana", Font.BOLD, 12));
		lblStanzaAssegnata.setBounds(395, 359, 145, 14);
		frame.getContentPane().add(lblStanzaAssegnata);
		
		roomFIeld = new JTextField();
		roomFIeld.setColumns(10);
		roomFIeld.setBounds(395, 381, 190, 20);
		frame.getContentPane().add(roomFIeld);
		
		rdbtnIntBB = new JRadioButton("B&B");
		rdbtnIntBB.setForeground(Color.ORANGE);
		rdbtnIntBB.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntBB.setBackground(Color.DARK_GRAY);
		rdbtnIntBB.setBounds(642, 92, 190, 23);
		frame.getContentPane().add(rdbtnIntBB);
		
		rdbtnIntCompleto = new JRadioButton("Completo");
		rdbtnIntCompleto.setForeground(Color.ORANGE);
		rdbtnIntCompleto.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntCompleto.setBackground(Color.DARK_GRAY);
		rdbtnIntCompleto.setBounds(642, 118, 190, 23);
		frame.getContentPane().add(rdbtnIntCompleto);
		
		rdbtnIntAllInclusive = new JRadioButton("All-inclusive");
		rdbtnIntAllInclusive.setForeground(Color.ORANGE);
		rdbtnIntAllInclusive.setFont(new Font("Verdana", Font.BOLD, 12));
		rdbtnIntAllInclusive.setBackground(Color.DARK_GRAY);
		rdbtnIntAllInclusive.setBounds(642, 146, 190, 23);
		frame.getContentPane().add(rdbtnIntAllInclusive);
		
		lblTipoSoggiorno = new JLabel("Tipo soggiorno");
		lblTipoSoggiorno.setForeground(Color.ORANGE);
		lblTipoSoggiorno.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTipoSoggiorno.setBounds(643, 71, 145, 14);
		frame.getContentPane().add(lblTipoSoggiorno);
		
		resField = new JTextField();
		resField.setBounds(642, 235, 159, 20);
		frame.getContentPane().add(resField);
		resField.setColumns(10);
		
		lblResoconto = new JLabel("Resoconto");
		lblResoconto.setForeground(Color.MAGENTA);
		lblResoconto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblResoconto.setBounds(643, 214, 145, 14);
		frame.getContentPane().add(lblResoconto);
		
		JButton viewPreno = new JButton("Vedi Prenotazioni");
		viewPreno.addActionListener(e -> {
			this.frame.dispose();
			this.logic.goToSpecificPage("ALL_RES", this.frame);
		});
		viewPreno.setFont(new Font("Verdana", Font.BOLD, 12));
		viewPreno.setBackground(Color.DARK_GRAY);
		viewPreno.setForeground(Color.MAGENTA);
		viewPreno.setBounds(641, 305, 160, 23);
		frame.getContentPane().add(viewPreno);
		
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
			this.logic.CheckoutClient(Integer.parseInt(this.chosenClient));
			this.frame.dispose();
		});
		checkoutButton.setForeground(Color.MAGENTA);
		checkoutButton.setFont(new Font("Verdana", Font.BOLD, 12));
		checkoutButton.setBackground(Color.DARK_GRAY);
		checkoutButton.setBounds(732, 398, 187, 46);
		frame.getContentPane().add(checkoutButton);
		
		JButton btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.addActionListener(e -> {
			String result = "";
			
			/*
			 * Query of the actual debt of the client.
			 */
			Statement myStmt = null;
			ResultSet myRs = null;
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
				myStmt = conn.createStatement();
				myRs = myStmt.executeQuery("SELECT SCHEDA.resoconto FROM SCHEDA WHERE numeroCamera = " + this.chosenClient);
				
				result = myRs.getString(1);			
				myRs.close();
				
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			
			this.resField.setText(result);	});
		
		
		btnAggiorna.setForeground(Color.ORANGE);
		btnAggiorna.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAggiorna.setBackground(Color.DARK_GRAY);
		btnAggiorna.setBounds(642, 257, 159, 23);
		frame.getContentPane().add(btnAggiorna);
		
		this.setTextGlobal();
	}
	
	/**
	 * Set the texts for all GUIs.
	 */
	private void setTextGlobal() {
		
		ResultSet result = this.logic.dataClient(Integer.parseInt(this.chosenClient));
		int i = 0;

		try {
			while(result.next()) {
				if (i == 0) {
					this.name.setText(result.getString(1));
				} else if (i == 1) {
					this.surname.setText(result.getString(1));				
				} else if (i == 2) {
					this.cfField.setText(result.getString(1));
				} else if (i == 4) {
					this.dateField.setText(result.getString(1));
				} else if (i == 5) {
					this.telField.setText(result.getString(1));
				} else if (i == 6 && result.getString(1) == "0") {
					this.rdbtnIntGlutine.setSelected(true);
				} else if (i == 7) {
					this.dayFIeld.setText(result.getString(1));
				} else if (i == 8) {
					this.checkinFIeld.setText(result.getString(1));
				} else if (i == 8) {
					this.checkoutField.setText(result.getString(1));
				} else if (i == 9) {
					this.roomFIeld.setText(result.getString(1));
				} else if (i == 10) {
					if(result.getString(1) == "BB") {
						this.rdbtnIntBB.setSelected(true);
					} else if(result.getString(1) == "PensioneCompleta") {
						this.rdbtnIntCompleto.setSelected(true);
					} else {
						this.rdbtnIntAllInclusive.setSelected(true);
					}
				}
				i++;
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
