package db.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import db.pages.BedroomServicePages;
import db.pages.EntertaimentServicePages;
import db.pages.LoginPages;
import db.pages.ManagerPages;
import db.pages.ReceptionPages;
import db.pages.RestaurantPages;
import db.pages.specific.AllClientCards;
import db.pages.specific.AllReservations;
import db.pages.specific.PricePage;
import db.pages.specific.RegistrationCard;

public class LogicsImpl implements Logic {

	/**
	 * Codes.
	 */
	private static final String REC_CODE = "REC1";
	private static final String DIR_CODE = "DIR1";
	private static final String SAL_CODE = "SAL1";
	private static final String SERV_CODE = "SERV1";
	private static final String CAM_CODE = "CAM1";

	/**
	 * Specific views.
	 */
	private static final String ALL_RES = "AllReservations";
	private static final String REG = "Registration";
	private static final String ALL_CARD = "AllCards";
	private static final String PRI = "Prices";

	private String code;
	private String password;
	private LoginPages mainPage;

	/**
	 * Constructor.
	 */
	public LogicsImpl(LoginPages mainPage) {
		this.mainPage = mainPage;
	}

	@Override
	public void login(final String code, final String password) {
		this.code = code;
		this.password = password;

		if (this.code.equals(REC_CODE)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			ReceptionPages rec = new ReceptionPages(this);
			rec.getFrame().setVisible(true);
		} else if (this.code.equals(DIR_CODE)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			ManagerPages man = new ManagerPages(this);
			man.getFrame().setVisible(true);
		} else if (this.code.equals(SAL_CODE)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			RestaurantPages res = new RestaurantPages(this);
			res.getFrame().setVisible(true);
		} else if (this.code.equals(SERV_CODE)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			EntertaimentServicePages ent = new EntertaimentServicePages(this);
			ent.getFrame().setVisible(true);
		} else if (this.code.equals(CAM_CODE)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			BedroomServicePages bed = new BedroomServicePages(this);
			bed.getFrame().setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Errore in fase di login");
			this.mainPage.getFrame().setVisible(true);
		}
	}

	@Override
	public void logout() {
		this.mainPage.getFrame().setVisible(true);
	}

	@Override
	public void goToSpecificPage(final String specificGUI, final JFrame frame) {
		if (specificGUI.equals(ALL_RES)) {
			AllReservations allRes = new AllReservations(this);
			allRes.getFrame().setVisible(true);
		} else if (specificGUI.equals(REG)) {
			RegistrationCard reg = new RegistrationCard(this);
			reg.getFrame().setVisible(true);
		} else if (specificGUI.equals(ALL_CARD)) {
			AllClientCards aCC = new AllClientCards(this);
			aCC.getFrame().setVisible(true);
		} else if (specificGUI.equals(PRI)) {
			PricePage pri = new PricePage(this);
			pri.getFrame().setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Qualcosa e' andato storto, chiudo l'applicativo");
			System.exit(0);
		}
	}

	@Override
	public ResultSet showRoomToBeCleaned() {
		Connection conn = null;
		PreparedStatement myStm = null;
		ResultSet result = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			myStm = conn.prepareStatement("SELECT * FROM SCHEDA WHERE numeroCamera IS NOT NULL");
			result = myStm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ResultSet showRestaurantTables(final String service) {
		Connection conn = null;
		PreparedStatement myStm = null;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			myStm = conn.prepareStatement("SELECT SCHEDA.numeroCamera FROM SCHEDA WHERE datiGestionali_tariffa = ?");
			myStm.setString(1, service);
			result = myStm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int actualPrice(String nome) {
		Connection conn = null;
		PreparedStatement myStm = null;
		ResultSet result = null;
		int recordNumber = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			myStm = conn.prepareStatement("SELECT valoreMonetario FROM Listini WHERE nome = ?"); // manca la colonna
																									// nome!!
			myStm.setString(1, nome);
			result = myStm.executeQuery();
			recordNumber = result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordNumber;
	}

	@Override
	public boolean modifyPrice(int price, String nome) {
		Connection conn = null;
		PreparedStatement myStm = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			// query non funzionante forse "UPDATE Listini SET valoreMonetario = ? WHERE
			// nome = ?"
			myStm = conn.prepareStatement("UPDATE valoreMonetario = ? FROM Listini WHERE nome = ?");
			myStm.setInt(1, price);
			myStm.setString(2, nome);
			myStm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean registerNewClient(String nome, String cognome, int codiceFiscale, String dataNascita, int numeroTel,
			String tipologiaSoggiorno, int codScheda, int numeroCamera, int intolleranze, int resoconto,
			int durataSoggiorno, String orarioCheckin, String orarioCheckout) {
		Connection conn = null;
		PreparedStatement myStm = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			// Elimino le intolleranze, perché il codice fiscale è un int? Manca la colonna
			// tariffa - prima query
			// Mancano dati nella tabella SOGGIORNO, ergo attualemente non funziona (ma
			// nessun problema) - seconda query
			// Non capisce da dove prendere codScheda (non riesco a farla funzionare) -
			// terza query
			myStm = conn.prepareStatement(
					"INSERT INTO SCHEDA (codScheda, numeroCamera, resoconto, durataSoggiorno, orarioCheckin, orarioCheckout)"
							+ "VALUES (? ,?, ?, ?, ?, ?)"
							+ "INSERT INTO CLIENTE (nome, cognome, codiceFiscale, dataNascita, numeroTel, tipologiaSoggiorno)"
							+ "VALUES (? ,?, ?, ?, ?, ?)"
							+ "INSERT INTO IDENTIFICAZIONE (codiceCliente, numeroScheda)VALUES (?, SCHEDA.codScheda)");
			myStm.setInt(1, codScheda);
			myStm.setInt(2, numeroCamera);
			myStm.setInt(3, resoconto);
			myStm.setInt(4, durataSoggiorno);
			myStm.setString(5, orarioCheckin);
			myStm.setString(6, orarioCheckout);

			myStm.setString(7, nome);
			myStm.setString(8, cognome);
			myStm.setInt(9, codiceFiscale);
			myStm.setString(10, dataNascita);
			myStm.setInt(11, numeroTel);
			myStm.setString(12, tipologiaSoggiorno);

			myStm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean CheckoutClient(int nCamera) {
		Connection conn = null;
		PreparedStatement myStm = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			// Orario checkout perché non ci sta? E resoconto?
			myStm = conn.prepareStatement("UPDATE SCHEDA SET numeroCamera = ?, orarioCheckout = ?, resoconto = ?"
					+ "WHERE codScheda IN (SELECT codScheda FROM SCHEDA WHERE numeroCamera = ?)");
			myStm.setInt(1, nCamera);
			myStm.setInt(4, nCamera);
			myStm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean additionCost(int nCamera, int price, int resoconto, int tipoServizio) {
		Connection conn = null;
		PreparedStatement myStm = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			// price mai usato! Comunque query non funzionante, non capisco cosa dovrebbe
			// fare
			myStm = conn.prepareStatement("SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ? "
					+ "UPDATE SCHEDA SET resoconto = ? SERVIZIO.tariffa"
					+ "WHERE codScheda IN (SELECT codScheda FROM SCHEDA WHERE numeroCamera = ?");
			myStm.setInt(1, tipoServizio);
			myStm.setInt(2, resoconto);
			myStm.setInt(3, nCamera);

			myStm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ResultSet visualClients(int nCamera) {
		Connection conn = null;
		PreparedStatement myStm = null;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			// Non riconosce codScheda, problema con chiave esterna? Anche qui non so come
			// fare - seconda query
			myStm = conn.prepareStatement("SELECT codScheda FROM SCHEDA WHERE numeroCamera = ? "
					+ "SELECT tipoPrenotazione, data, ora FROM REGISTRAZIONE,PRENOTAZIONE"
					+ "WHERE REGISTRAZIONE.schedaRegistrata = SCHEDA.codScheda AND"
					+ "REGISTRAZIONE.codPrenotazione = PRENOTAZIONE.tipoPrenotazione"
					+ "ORDER BY SCHEDA.data DESC, SCHEDA.ora DESC");
			myStm.setInt(1, nCamera);

			result = myStm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ResultSet dataClient(int nCamera) {
		Connection conn = null;
		PreparedStatement myStm = null;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			myStm = conn.prepareStatement("SELECT * FROM SCHEDA WHERE numeroCamera = ?");
			myStm.setInt(1, nCamera);

			result = myStm.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public boolean registerNewReservation(int tipoPrenotazione, int data, int ora, int nCamera, int resoconto) {
		Connection conn = null;
		PreparedStatement myStm = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			// Data, tipoPrenotazione ed ora non sono delle String? nelle altre query lo
			// erano - seconda query
			// PRENOTAZIONE.tipoPrenotazione, SCHEDA.codScheda non vengono identificate -
			// terza query
			myStm = conn.prepareStatement("SELECT codScheda FROM SCHEDA WHERE numeroCamera = ? "
					+ "INSERT INTO PRENOTAZIONE (tipoPrenotazione, data, ora) VALUES (?, ?, ?) "
					+ "INSERT INTO REGISTRAZIONE (codPrenotazione, schedaRegistrata)"
					+ "VALUES (PRENOTAZIONE.tipoPrenotazione, SCHEDA.codScheda)" + "UPDATE SCHEDA SET resoconto = ? "
					+ "WHERE codScheda IN (SELECT schedaRegistrata FROM REGISTRAZIONE"
					+ "WHERE schedaRegistrata = SCHEDA.codScheda");
			myStm.setInt(1, nCamera);
			myStm.setInt(2, tipoPrenotazione);
			myStm.setInt(3, data);
			myStm.setInt(4, ora);
			myStm.setInt(5, resoconto);
			myStm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteReservation(int tipoPrenotazione) {
		Connection conn = null;
		PreparedStatement myStm = null;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			myStm = conn
					.prepareStatement("SELECT tariffa FROM SERVIZIO, ACCESSO WHERE ACCESSO.numeroPrenotazione = ? ");
			myStm.setInt(1, tipoPrenotazione);
			result = myStm.executeQuery();
			// Tariffa nel db è un int, qui è una string? non sarebbe meglio usare
			// "result.getInt(1)"?
			var price = result.getString(1);
			// Non riconosce molte varibili come SCHEDA.codScheda ad esempio
			myStm = conn
					.prepareStatement("DELETE FROM PRENOTAZIONE, REGISTRAZIONE WHERE PRENOTAZIONE.tipoPrenotazione = ? "
							+ "AND REGISTRAZIONE.codPrenotazione = ? AND PRENOTAZIONE.tipoPrenotazione = REGISTRAZIONE.codPrenotazione"
							+ "UPDATE SCHEDA SET resoconto = resoconto - " + price
							+ "WHERE codScheda IN (SELECT schedaRegistrata FROM REGISTRAZIONE WHERE schedaRegistrata = SCHEDA.codScheda)");

			myStm.setInt(1, tipoPrenotazione);

			myStm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ResultSet servicesUsedByClient(int nCamera) {
		Connection conn = null;
		PreparedStatement myStm = null;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			// SCHEDA.codScheda non viene riconosciuta - seconda query
			myStm = conn.prepareStatement("SELECT codScheda FROM SCHEDA WHERE numeroCamera = ? "
					+ "SELECT * FROM PRENOTAZIONE WHERE tipoPrenotazione IN "
					+ "(SELECT codPrenotazione FROM REGISTRAZIONE WHERE schedaRegistrata = SCHEDA.codScheda)");

			myStm.setInt(1, nCamera);

			result = myStm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ResultSet totalAmount() {
		Connection conn = null;
		PreparedStatement myStm = null;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			myStm = conn.prepareStatement("SELECT * FROM SCHEDA WHERE numeroCamera IS NOT NULL");
			result = myStm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public ResultSet ReviewClient(int codCliente) {
		Connection conn = null;
		PreparedStatement myStm = null;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
					this.getOwnPassword());
			// Non dovrebbe esserci la var codScheda? - prima query
			// Solito problema di SCHEDA.codScheda
			myStm = conn.prepareStatement("SELECT * FROM SCHEDA, IDENTIFICAZIONE, CLIENTE WHERE SCHEDA.codScheda = ?"
					+ "AND SCHEDA.codScheda = IDENTIFICAZIONE.numeroScheda AND IDENTIFICAZIONE.codiceCliente = ?) "
					+ "SELECT * FROM IDENTIFICAZIONE.codScheda WHERE IDENTIFICAZIONE.codiceCliente = ?)");
			
			myStm.setInt(2, codCliente);
			myStm.setInt(3, codCliente);
			result = myStm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String getOwnPassword() {
		return this.password;
	}
}
