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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			myStm = conn.prepareStatement("SELECT valoreMonetario FROM Listini WHERE nome = ?"); // manca la colonna nome!!
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
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			PreparedStatement pstmt = conn
					.prepareStatement("UPDATE valoreMonetario =" + price + " FROM Listini WHERE" + "nome = " + nome);
			pstmt.execute();
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
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			PreparedStatement pstmt0 = conn.prepareStatement(
					"NSERT INTO SCHEDA (codScheda, numeroCamera, intolleranze, resoconto, datiTariffa, durataSoggiorno, orarioCheckin,"
							+ " orarioCheckout)" + "VALUES(codScheda=" + codScheda + ",numeroCamera" + numeroCamera
							+ " ,intolleranze" + intolleranze + "," + "resoconto" + resoconto + ",durataSoggiorno"
							+ durataSoggiorno + "" + ",orarioCheckin" + orarioCheckin + ",orarioCheckout"
							+ orarioCheckout + ")"
							+ "INSERT INTO CLIENTE (nome, cognome, codiceFiscale, dataNascita,numeroTel, tipologiaSoggiorno)"
							+ "VALUES (nome" + nome + ", cognome" + cognome + ", codiceFiscale" + codiceFiscale
							+ ", dataNascita" + dataNascita + "," + "numeroTel" + numeroTel + ", tipologiaSoggiorno"
							+ tipologiaSoggiorno + ")"
							+ "INSERT INTO IDENTIFICAZIONE (codiceCliente, numeroScheda)VALUES (?, SCHEDA.codScheda)");
			pstmt0.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean CheckoutClient(int nCamera) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			PreparedStatement pstmt0 = conn.prepareStatement(
					"UPDATE SCHEDA SET numeroCamera = " + nCamera + ", orarioCheckout = ?, resoconto = "
							+ "WHERE codScheda IN (SELECT codScheda FROM SCHEDA WHERE numeroCamera = " + nCamera + ")");
			pstmt0.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean additionCost(int nCamera, int price, int resoconto, int tipoServizio) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			PreparedStatement pstmt0 = conn.prepareStatement("SELECT tariffa FROM SERVIZIO WHERE tipoServizio ="
					+ tipoServizio + "" + "UPDATE SCHEDA SET resoconto = resoconto" + resoconto + " + SERVIZIO.tariffa"
					+ "WHERE codScheda IN (SELECT codScheda FROM SCHEDA WHERE numeroCamera =" + nCamera + ")");
			pstmt0.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ResultSet visualClients(int nCamera) {
		Connection conn = null;
		Statement myStmt = null;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			myStmt = conn.createStatement();
			result = myStmt.executeQuery("SELECT codScheda FROM SCHEDA" + "WHERE numeroCamera = "
					+ "SELECT tipoPrenotazione, data, ora FROM REGISTRAZIONE,PRENOTAZIONE"
					+ "WHERE REGISTRAZIONE.schedaRegistrata = SCHEDA.codScheda AND"
					+ "REGISTRAZIONE.codPrenotazione = PRENOTAZIONE.tipoPrenotazione"
					+ "ORDER BY SCHEDA.data DESC, SCHEDA.ora DESC");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ResultSet dataClient(int nCamera) {
		Connection conn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM SCHEDA WHERE numeroCamera = " + nCamera + "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return myRs;

	}

	@Override
	public boolean registerNewReservation(int tipoPrenotazione, int data, int ora, int nCamera, int resoconto) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			PreparedStatement pstmt0 = conn.prepareStatement("SELECT codScheda FROM SCHEDA WHERE numeroCamera = "
					+ nCamera + "INSERT INTO PRENOTAZIONE (tipoPrenotazione, data, ora)" + "VALUES (" + tipoPrenotazione
					+ ", " + data + ", " + ora + ")" + "INSERT INTO REGISTRAZIONE (codPrenotazione, schedaRegistrata)"
					+ "VALUES (PRENOTAZIONE.tipoPrenotazione, SCHEDA.codScheda)" + "UPDATE SCHEDA SET resoconto ="
					+ resoconto + "" + "WHERE codScheda IN (SELECT schedaRegistrata FROM REGISTRAZIONE"
					+ "WHERE schedaRegistrata = SCHEDA.codScheda");
			pstmt0.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteReservation(int tipoPrenotazione) {
		Connection conn;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT tariffa FROM SERVIZIO, ACCESSO "
										+ "WHERE ACCESSO.numeroPrenotazione = " + tipoPrenotazione);
			var price = myRs.getString(1);
			PreparedStatement pstmt0 = conn
					.prepareStatement("DELETE FROM PRENOTAZIONE, REGISTRAZIONE WHERE PRENOTAZIONE.tipoPrenotazione ="
							+ tipoPrenotazione + ""
							+ "AND REGISTRAZIONE.codPrenotazione = ? AND PRENOTAZIONE.tipoPrenotazione = REGISTRAZIONE.codPrenotazione"
							+ "UPDATE SCHEDA SET resoconto = resoconto - " + price
							+ "WHERE codScheda IN (SELECT schedaRegistrata FROM REGISTRAZIONE WHERE schedaRegistrata = SCHEDA.codScheda)");
			pstmt0.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ResultSet servicesUsedByClient(int nCamera) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT codScheda FROM SCHEDA WHERE numeroCamera = " + nCamera
					+ "SELECT * FROM PRENOTAZIONE WHERE tipoPrenotazione IN "
					+ "(SELECT codPrenotazione FROM REGISTRAZIONE WHERE schedaRegistrata = SCHEDA.codScheda)");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myRs;
	}

	@Override
	public ResultSet totalAmount() {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM SCHEDA WHERE numeroCamera IS NOT NULL");
			myRs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myRs;

	}

	@Override
	public ResultSet ReviewClient(int codCliente) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", this.getOwnPassword());
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM SCHEDA, IDENTIFICAZIONE, CLIENTE WHERE SCHEDA.codScheda = ?"
					+ "AND SCHEDA.codScheda = IDENTIFICAZIONE.numeroScheda AND IDENTIFICAZIONE.codiceCliente ="
					+ codCliente + ") "
					+ "SELECT * FROM IDENTIFICAZIONE.codScheda WHERE IDENTIFICAZIONE.codiceCliente =" + codCliente
					+ ")");
			myRs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myRs;
	}
	
	@Override
	public String getOwnPassword() {
		return this.password;
	}
}
