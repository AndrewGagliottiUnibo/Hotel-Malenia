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
import db.pages.specific.ClientsInHotel;
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
	 * Passwords.
	 */
	private static final String REC_PASSWORD = "REC1";
	private static final String DIR_PASSWORD = "DIR1";
	private static final String SAL_PASSWORD = "SAL1";
	private static final String SERV_PASSWORD = "SERV1";
	private static final String CAM_PASSWORD = "CAM1";

	/**
	 * Specific views.
	 */
	private static final String ALL_RES = "AllReservations";
	private static final String REG = "Registration";
	private static final String CLI = "ClientsInHotel";
	private static final String ALL_CARD = "AllCards";
	private static final String PRI = "Prices";

	private String code;
	private String password;
	private LoginPages mainPage;
	Connection conn;

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

		if (this.code.equals(REC_CODE) && this.password.equals(REC_PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			ReceptionPages rec = new ReceptionPages(this);
			rec.getFrame().setVisible(true);
		} else if (this.code.equals(DIR_CODE) && this.password.equals(DIR_PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			ManagerPages man = new ManagerPages(this);
			man.getFrame().setVisible(true);
		} else if (this.code.equals(SAL_CODE) && this.password.equals(SAL_PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			RestaurantPages res = new RestaurantPages(this);
			res.getFrame().setVisible(true);
		} else if (this.code.equals(SERV_CODE) && this.password.equals(SERV_PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			EntertaimentServicePages ent = new EntertaimentServicePages(this);
			ent.getFrame().setVisible(true);
		} else if (this.code.equals(CAM_CODE) && this.password.equals(CAM_PASSWORD)) {
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
		/*
		 * --TODO
		 */
		if (specificGUI.equals(ALL_RES)) {
			AllReservations allRes = new AllReservations();
		} else if (specificGUI.equals(REG)) {
			RegistrationCard reg = new RegistrationCard();
		} else if (specificGUI.equals(CLI)) {
			ClientsInHotel cli = new ClientsInHotel();
		} else if (specificGUI.equals(ALL_CARD)) {
			AllClientCards aCC = new AllClientCards();
		} else if (specificGUI.equals(PRI)) {
			PricePage pri = new PricePage();
		} else {
			JOptionPane.showMessageDialog(null, "Qualcosa � andato storto, chiudo l'applicativo");
			System.exit(0);
		}
	}

	@Override
	public ResultSet showRoomToBeCleaned() {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			System.out.println("Database connected");
			// 2. Create a statement
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM SCHEDA WHERE numeroCamera IS NOT NULL");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myRs;
	}

	@Override
	public ResultSet showRestaurantTables(final String service) {
		Connection conn;
		int recordNumber = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			ResultSet pstmt = (ResultSet) conn
					.prepareStatement("SELECT valoreMonetario FROM Listini WHERE" + "nome = ");
			recordNumber = pstmt.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int actualPrice(String s) {
		Connection conn;
		int recordNumber = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			ResultSet pstmt = (ResultSet) conn
					.prepareStatement("SELECT valoreMonetario FROM Listini WHERE" + "nome = " + s);
			recordNumber = pstmt.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordNumber;
	}

	@Override
	public boolean modifyPrice(int price, String nome) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			PreparedStatement pstmt = conn
					.prepareStatement("UPDATE valoreMonetario =" + price + " FROM Listini WHERE" + "nome = " + nome);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean registerNewReservation(String nome, String cognome, int data, int nCamera) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			PreparedStatement pstmt0 = conn.prepareStatement("SELECT codScheda FROM SCHEDA WHERE numeroCamera = "
					+ nCamera + "INSERT INTO PRENOTAZIONE (tipoPrenotazione, data, ora) VALUES (?, ?, ?)");

			PreparedStatement pstmt1 = conn
					.prepareStatement("INSERT INTO REGISTRAZIONE (codPrenotazione, schedaRegistrata) "
							+ "VALUES (PRENOTAZIONE.tipoPrenotazione, SCHEDA.codScheda)" + "UPDATE SCHEDA"
							+ "SET resoconto = resoconto + ?" + "WHERE codScheda IN (SELECT schedaRegistrata"
							+ "FROM REGISTRAZIONE" + "WHERE schedaRegistrata = SCHEDA.codScheda)");
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE SCHEDA SET numeroCamera = " + nCamera + ", orarioCheckout = ?, resoconto = "
							+ "WHERE codScheda IN (SELECT codScheda FROM SCHEDA WHERE numeroCamera = " + nCamera + ")");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean additionalCost(int Ncamera, int price) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			PreparedStatement pstmt = conn.prepareStatement("SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ?"
					+ "UPDATE SCHEDA SET resoconto = resoconto + SERVIZIO.tariffa"
					+ "WHERE codScheda IN (SELECT codScheda FROM SCHEDA WHERE numeroCamera = ?)");

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public int totalAmount() {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM SCHEDA WHERE numeroCamera IS NOT NULL");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}


	public boolean clientRegistration(int nCamera, String intolleranze , int orarioCheckin , int orarioCheckout) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			PreparedStatement pstmt0 = conn.prepareStatement(
					"INSERT INTO SCHEDA (codScheda, numeroCamera, intolleranze, resoconto, datiTariffa, durataSoggiorno, orarioCheckin, orarioCheckout)"
							+ "VALUES (?, ?, ’ ’, ?, ?, ?, ’ ’, ’ ’)");
			PreparedStatement pstmt1 = conn.prepareStatement(
					"INSERT INTO CLIENTE (nome, cognome, codiceFiscale, dataNascita,numeroTel, tipologiaSoggiorno VALUES (?, ?, ?, ?, ?, ?)"
							+ "INSERT INTO IDENTIFICAZIONE (codiceCliente, numeroScheda)"
							+ "VALUES (?, SCHEDA.codScheda)");

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
}

