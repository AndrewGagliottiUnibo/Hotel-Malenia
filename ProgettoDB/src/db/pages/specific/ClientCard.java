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
	private JTextField telField;
	private JLabel lblStanzaAssegnata;
	private JTextField roomFIeld;
	private JLabel lblTipoSoggiorno;
	private JTextField resField;
	private JLabel lblResoconto;
	private Logic logic;
	private String chosenClient;
	private JLabel lblexpire;
	private JTextField expirationDateField;
	private JTextField codeCardField;
	private JLabel lblUniversalIdentifier;

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
		name.setBounds(10, 92, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel codeCard = new JLabel("Dati sensibili");
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
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.ORANGE);
		lblTelefono.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTelefono.setBounds(10, 284, 190, 14);
		frame.getContentPane().add(lblTelefono);
		
		telField = new JTextField();
		telField.setColumns(10);
		telField.setBounds(10, 306, 190, 20);
		frame.getContentPane().add(telField);
		
		lblStanzaAssegnata = new JLabel("Stanza assegnata");
		lblStanzaAssegnata.setForeground(Color.ORANGE);
		lblStanzaAssegnata.setFont(new Font("Verdana", Font.BOLD, 12));
		lblStanzaAssegnata.setBounds(10, 352, 145, 14);
		frame.getContentPane().add(lblStanzaAssegnata);
		
		roomFIeld = new JTextField();
		roomFIeld.setColumns(10);
		roomFIeld.setBounds(10, 374, 190, 20);
		frame.getContentPane().add(roomFIeld);
		
		lblTipoSoggiorno = new JLabel("Tipo soggiorno");
		lblTipoSoggiorno.setForeground(Color.ORANGE);
		lblTipoSoggiorno.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTipoSoggiorno.setBounds(395, 176, 145, 14);
		frame.getContentPane().add(lblTipoSoggiorno);
		
		resField = new JTextField();
		resField.setBounds(642, 91, 159, 20);
		frame.getContentPane().add(resField);
		resField.setColumns(10);
		
		lblResoconto = new JLabel("Resoconto");
		lblResoconto.setForeground(Color.MAGENTA);
		lblResoconto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblResoconto.setBounds(643, 70, 145, 14);
		frame.getContentPane().add(lblResoconto);
		
		JButton viewPreno = new JButton("Vedi Prenotazioni");
		viewPreno.addActionListener(e -> {
			this.frame.dispose();
			this.logic.goToSpecificPage("ALL_RES", this.frame);
		});
		viewPreno.setFont(new Font("Verdana", Font.BOLD, 12));
		viewPreno.setBackground(Color.DARK_GRAY);
		viewPreno.setForeground(Color.MAGENTA);
		viewPreno.setBounds(642, 176, 187, 48);
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
		checkoutButton.setForeground(Color.RED);
		checkoutButton.setFont(new Font("Verdana", Font.BOLD, 12));
		checkoutButton.setBackground(Color.DARK_GRAY);
		checkoutButton.setBounds(642, 348, 187, 46);
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
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.logic.getOwnPassword());
				myStmt = conn.createStatement();
				myRs = myStmt.executeQuery("SELECT SCHEDA.resoconto FROM SCHEDA WHERE numeroCamera = " + this.chosenClient);
				
				result = myRs.getString(1);			
				myRs.close();
				
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			
			this.resField.setText(result);	});
		
		
		btnAggiorna.setForeground(Color.MAGENTA);
		btnAggiorna.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAggiorna.setBackground(Color.DARK_GRAY);
		btnAggiorna.setBounds(642, 113, 159, 23);
		frame.getContentPane().add(btnAggiorna);
		
		lblexpire = new JLabel("Durata soggiorno");
		lblexpire.setForeground(Color.ORANGE);
		lblexpire.setFont(new Font("Verdana", Font.BOLD, 12));
		lblexpire.setBounds(395, 123, 145, 14);
		frame.getContentPane().add(lblexpire);
		
		expirationDateField = new JTextField();
		expirationDateField.setColumns(10);
		expirationDateField.setBounds(395, 145, 190, 20);
		frame.getContentPane().add(expirationDateField);
		
		codeCardField = new JTextField();
		codeCardField.setColumns(10);
		codeCardField.setBounds(395, 374, 190, 20);
		frame.getContentPane().add(codeCardField);
		
		lblUniversalIdentifier = new JLabel("Codice universale scheda");
		lblUniversalIdentifier.setForeground(Color.ORANGE);
		lblUniversalIdentifier.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUniversalIdentifier.setBounds(395, 352, 190, 14);
		frame.getContentPane().add(lblUniversalIdentifier);
		
		this.setTextGlobal();
	}
	
	/**
	 * Set the texts for all GUIs.
	 */
	private void setTextGlobal() {
		
		ResultSet result = this.logic.viewClientCard(Integer.parseInt(this.chosenClient));
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
