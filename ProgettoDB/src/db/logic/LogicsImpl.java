package db.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import db.pages.BedroomServicePages;
import db.pages.EntertaimentServicePages;
import db.pages.LoginPages;
import db.pages.ManagerPages;
import db.pages.ReceptionPages;
import db.pages.RestaurantPages;

public class LogicsImpl implements Logic {

	/**
	 * Static variable.
	 */
	private static final String REC_CODE = "REC1";
	private static final String DIR_CODE = "DIR1";
	private static final String SAL_CODE = "SAL1";
	private static final String SERV_CODE = "SERV1";
	private static final String CAM_CODE = "CAM1";
	private static final String REC_PASSWORD = "REC1";
	private static final String DIR_PASSWORD = "DIR1";
	private static final String SAL_PASSWORD = "SAL1";
	private static final String SERV_PASSWORD = "SERV1";
	private static final String CAM_PASSWORD = "CAM1";
	private String code;
	private String password;
	static LoginPages mainPage;
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
			rec.frmHotelMalenia.setVisible(true);
		} else if (this.code.equals(DIR_CODE) && this.password.equals(DIR_PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			ManagerPages man = new ManagerPages();
			man.frmHotelMalenia.setVisible(true);
		} else if (this.code.equals(SAL_CODE) && this.password.equals(SAL_PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			RestaurantPages res = new RestaurantPages(this);
			// todo
		} else if (this.code.equals(SERV_CODE) && this.password.equals(SERV_PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			EntertaimentServicePages ent = new EntertaimentServicePages();
			// todo
		} else if (this.code.equals(CAM_CODE) && this.password.equals(CAM_PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			BedroomServicePages bed = new BedroomServicePages(this);
			// todo
		} else {
			JOptionPane.showMessageDialog(null, "Errore in fase di login");
		}
	}

	@Override
	public void logout() {
		this.mainPage.frame.setVisible(true);
	}

	@Override
	public boolean reportCleanedRoom(int roomNumber) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			PreparedStatement pstmt = conn.prepareStatement("UPDATE Schede WHERE numeroCamera =" + roomNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

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
	public ResultSet showRestaurantTables() {
		// TODO Auto-generated method stub
		return null;
	}

	public int actualPrice(String s) {
		Connection conn;
		int recordNumber = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root", "dariostudente");
			ResultSet pstmt = (ResultSet) conn
					.prepareStatement("SELECT valoreMonetario FROM Listini WHERE" + "nome = " + s);
			recordNumber = pstmt.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}