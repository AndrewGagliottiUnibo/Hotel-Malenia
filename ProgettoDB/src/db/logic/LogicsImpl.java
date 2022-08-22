package db.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
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
    private static final String REC_CODE = "REC";
    private static final String DIR_CODE = "DIR";
    private static final String SAL_CODE = "SAL";
    private static final String SERV_CODE = "SERV";
    private static final String CAM_CODE = "CAM";

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
    public LogicsImpl(final LoginPages mainPage) {
	this.mainPage = mainPage;
    }

    @Override
    public void login(final String code, final char[] password) {
	this.code = code;
	this.password = String.valueOf(password);

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
    public void showRoomsToBeCleaned(final JTextArea textArea) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;

	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO WHERE numeroCamera IS NOT NULL");
	    result = myStm.executeQuery();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	try {
	    int row = result.getRow();

	    while (result.next()) {
		for (int i = 0; i < row; i++) {
		    textArea.append("Camera: " + result.getString(i) + "\n");
		}
	    }
	} catch (Exception ecc) {
	    ecc.printStackTrace();
	}
    }

    @Override
    public ResultSet showBreakfastTables() {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT numeroCamera FROM SOGGIORNO " + "WHERE soggiornante = 1");
	    result = myStm.executeQuery();
	} catch (SQLException exc) {
	    exc.printStackTrace();
	}
	return result;
    }

    @Override
    public ResultSet showLaunchTables() {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT numeroCamera FROM SOGGIORNO " + "WHERE tipologiaSoggiornoScelto = ? "
		    + "AND tipologiaSoggiornoScelto = ? " + "AND soggiornante = 1");
	    myStm.setString(1, "AllInclusive");
	    myStm.setString(2, "PensioneCompleta");
	    result = myStm.executeQuery();
	} catch (SQLException exc) {
	    exc.printStackTrace();
	}
	return result;
    }

    @Override
    public ResultSet showDinnerTables() {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT numeroCamera FROM SOGGIORNO " + "WHERE tipologiaSoggiornoScelto = ? "
		    + "AND tipologiaSoggiornoScelto = ?");
	    myStm.setString(1, "AllInclusive");
	    myStm.setString(2, "PensioneCompleta");
	    result = myStm.executeQuery();
	} catch (SQLException exc) {
	    exc.printStackTrace();
	}
	return result;
    }

    @Override
    public int getSpecificPrice(final String item) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	int recordNumber = 0;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT valoreMonetario FROM Listini WHERE tipoListino = ?");
	    myStm.setString(1, item);
	    result = myStm.executeQuery();
	    recordNumber = result.getInt(1);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return recordNumber;
    }

    @Override
    public void registerNewClient(final String name, final String surname, final String identifierCode,
	    final String dateOfBirth, final int cellNumber, final String beginningDate, final int remainingDays,
	    final String chosenOffer, final int cardNumber, final int roomNumber, final String vacationType,
	    final String monthOfVacation, final int yearOfVacation) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("INSERT INTO CLIENTE (codFiscale, nome, cognome, dataNascita, numeroTel) "
		    + "VALUES (?, ?, ?, ?, ?); "
		    + "INSERT INTO SOGGIORNO (dataInizio, codFiscaleCliente, durataSoggiorno, soggiornante, "
		    + "offertaScelta, codScheda, numeroCamera, resoconto, tipologiaSoggiornoScelto, "
		    + "meseSoggiornoScelto, annoSoggiornoScelto, codReceptionistInserente) "
		    + "VALUES (?, ?, ?, 1, ?, ?, ?, 0, ?, ?, ?, 10) ");
	    myStm.setString(1, identifierCode);
	    myStm.setString(2, name);
	    myStm.setString(3, surname);
	    myStm.setString(4, dateOfBirth);
	    myStm.setInt(5, cellNumber);

	    myStm.setString(6, beginningDate);
	    myStm.setString(7, identifierCode);
	    myStm.setInt(8, remainingDays);
	    myStm.setString(9, chosenOffer);
	    myStm.setInt(10, cardNumber);
	    myStm.setInt(11, roomNumber);
	    myStm.setString(12, vacationType);
	    myStm.setString(13, monthOfVacation);
	    myStm.setInt(14, yearOfVacation);
	    myStm.executeQuery();

	    myStm = conn
		    .prepareStatement("SELECT prezzo FROM TIPOLOGIASOGGIORNO WHERE tipologia = ?, mese = ?, anno = ?");
	    myStm.setString(1, vacationType);
	    myStm.setString(2, monthOfVacation);
	    myStm.setInt(3, yearOfVacation);
	    result = myStm.executeQuery();
	    int price = result.getInt(1);

	    myStm = conn.prepareStatement("UPDATE SOGGIORNO SET resoconto = resoconto + ? "
		    + "WHERE codFiscaleCliente = ? AND dataInizio = ?");
	    myStm.setInt(12, price);
	    myStm.setString(13, identifierCode);
	    myStm.setString(14, beginningDate);
	    myStm.executeQuery();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void checkoutClient(final int roomNumber) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn
		    .prepareStatement("SELECT dataInizio FROM SOGGIORNO WHERE numeroCamera = ? AND soggiornante = 1");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	    String beginningDate = result.getString(1);

	    myStm = conn.prepareStatement("UPDATE SOGGIORNO SET soggiornante = 0, resoconto = 0 "
		    + "WHERE numeroCamera = ? AND soggiornante = 1 AND dataInizio = ?");
	    myStm.setInt(1, roomNumber);
	    myStm.setString(1, beginningDate);
	    myStm.executeQuery();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void registerNewReservation(final String reservationType, final String serviceType, final String date,
	    final String season, final int year, final String day, final int hour, final int roomNumber) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT codFiscaleCliente, dataInizio FROM SOGGIORNO "
		    + "WHERE numeroCamera = ? AND soggiornante = 1");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	    String identifier = result.getString(1);
	    String beginningDate = result.getString(2);

	    myStm = conn.prepareStatement("INSERT INTO PRENOTAZIONE (tipoPrenotazione, data, ora, "
		    + "dataInizioSoggiornoRegistrato, codFiscaleClienteRegistrato, tipoServizioUsufruito, "
		    + "stagioneServizioUsufruito, annoServizioUsufruito, codReceptionistOperante) "
		    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 10)");
	    myStm.setString(1, reservationType);
	    myStm.setString(2, date);
	    myStm.setInt(3, hour);
	    myStm.setString(4, beginningDate);
	    myStm.setString(5, identifier);
	    myStm.setString(6, serviceType);
	    myStm.setString(7, season);
	    myStm.setInt(8, year);
	    myStm.setString(9, serviceType);
	    myStm.executeQuery();

	    myStm = conn.prepareStatement(
		    "SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ? AND stagione = ? AND anno = ?");
	    myStm.setString(1, serviceType);
	    myStm.setString(2, season);
	    myStm.setInt(3, year);
	    result = myStm.executeQuery();
	    int value = result.getInt(1);

	    myStm = conn.prepareStatement("UPDATE SOGGIORNO SET resoconto = resoconto + ? "
		    + "WHERE codFiscaleCliente = ? AND dataInizio = ?");
	    myStm.setInt(1, value);
	    myStm.setString(2, identifier);
	    myStm.setString(3, beginningDate);
	    myStm.executeQuery();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void deleteReservation(final String reservationType, final int roomNumber, final String day,
	    final int hour) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT codFiscaleCliente, dataInizio FROM SOGGIORNO "
		    + "WHERE numeroCamera = ? AND soggiornante = 1");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	    String identifier = result.getString(1);
	    String beginningDate = result.getString(2);

	    myStm = conn.prepareStatement("DELETE FROM PRENOTAZIONE WHERE tipoPrenotazione = ? AND giorno = ? "
		    + "AND ora = ? AND dataInizioSoggiornoRegistrato = ? AND codFiscaleClienteRegistrato = ?");

	    myStm.setString(1, reservationType);
	    myStm.setString(2, day);
	    myStm.setInt(3, hour);
	    myStm.setString(4, beginningDate);
	    myStm.setString(4, identifier);
	    myStm.executeQuery();
	    myStm = conn.prepareStatement(
		    "SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ? " + "AND stagione = ? AND anno = ?");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public ResultSet viewReservations(final int roomNumber) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO, PRENOTAZIONE WHERE numeroCamera = ? "
		    + "AND PRENOTAZIONE.codFiscaleClienteRegistrato = SOGGIORNO.codFiscaleCliente "
		    + "AND soggiornante = 1");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return result;
    }

    @Override
    public ResultSet viewClientCard(final int roomNumber) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO WHERE numeroCamera = ? " + "AND soggiornante = 1");
	    myStm.setInt(1, roomNumber);

	    result = myStm.executeQuery();

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return result;

    }

    @Override
    public boolean modifyPrice(String tipoServizio, String stagione, int anno, int tariffa, String tipologiaSoggiorno,
	    int mese, int annoSoggiorno, int prezzo) {
	Connection conn = null;
	PreparedStatement myStm = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("INSERT INTO SERVIZIO (tipoServizio, stagione, anno, tariffa) "
		    + "VALUES (?, ?, ?, ?) " + "INSERT INTO TIPOLOGIASOGGIORNO (tipologia, mese, anno, prezzo) "
		    + "VALUES (?, ?, ?, ?); " + "");
	    myStm.setString(1, tipoServizio);
	    myStm.setString(2, stagione);
	    myStm.setInt(3, anno);
	    myStm.setInt(4, tariffa);
	    myStm.setString(5, tipologiaSoggiorno);

	    myStm.setInt(6, mese);
	    myStm.setInt(7, annoSoggiorno);
	    myStm.setInt(8, prezzo);
	    myStm.executeQuery();
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	return true;
    }

    @Override
    public boolean additionCost(String tipoServizio, String stagione, int anno, int numeroCamera,
	    String tipoPrenotazione, String giorno, int ora) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement(
		    "SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ? AND stagione = ? AND anno = ?");
	    myStm.setString(1, tipoServizio);
	    myStm.setString(2, stagione);
	    myStm.setInt(3, anno);
	    result = myStm.executeQuery();
	    int tariffa = result.getInt(1);

	    myStm = conn.prepareStatement("SELECT dataInizio, codFiscaleCliente FROM SOGGIORNO "
		    + "WHERE numeroCamera = ? AND soggiornante = 1");
	    myStm.setInt(1, numeroCamera);
	    result = myStm.executeQuery();
	    String dataInizio = result.getString(1);
	    String codFiscale = result.getString(2);

	    myStm = conn.prepareStatement(
		    "INSERT INTO PRENOTAZIONE (tipoPrenotazione, giorno, ora, dataInizioSoggiornoRegistrato, "
			    + "codFiscaleClienteRegistrato, tipoServizioUsufruito, "
			    + "stagioneServizioUsufruito, annoServizioUsufruito, codReceptionistOperante) "
			    + "VALUES (?, ?, ?, ?, ?, ?, stagione, anno, 10)");
	    myStm.setString(1, tipoPrenotazione);
	    myStm.setString(2, giorno);
	    myStm.setInt(3, ora);
	    myStm.setString(4, dataInizio);
	    myStm.setString(5, codFiscale);
	    myStm.setString(6, tipoServizio);
	    myStm.setString(7, stagione);
	    myStm.setInt(8, anno);
	    myStm.executeQuery();

	    myStm = conn.prepareStatement("UPDATE SOGGIORNO SET resoconto = resoconto + ? "
		    + "WHERE codFiscaleCliente = ? AND dataInizio = ?");
	    myStm.setInt(1, tariffa);
	    myStm.setString(2, codFiscale);
	    myStm.setString(3, dataInizio);

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

	    myStm = conn.prepareStatement("SELECT tipoServizio, stagione, anno, tariffa FROM SERVIZIO "
		    + "RIGHT JOIN (SELECT tipoServizioUsufruito, stagioneServizioUsufruito, annoServizioUsufruito "
		    + "FROM PRENOTAZIONE, SOGGIORNO WHERE numeroCamera = ? AND PRENOTAZIONE.codFiscaleClienteRegistrato = "
		    + "SOGGIORNO.codFiscaleCliente AND soggiornante = 1) AS PREN "
		    + "ON SERVIZIO.tipoServizio = PREN.tipoServizioUsufruito AND SERVIZIO.stagione = PREN.stagioneServizioUsufruito "
		    + "AND SERVIZIO.anno = PREN.annoServizioUsufruito");

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
	    myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO WHERE soggiornante = 1");
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
	    myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO WHERE dataInizio = ? AND durataSoggiorno = ? "
		    + "AND soggiornante = ? AND offertaScelta= ? AND numeroCamera = ? "
		    + "AND tipologiaSoggiornoScelto = ? AND meseSoggiornoScelto = ? AND annoSoggiornoScelto = ? ");

	    myStm.setInt(1, codCliente);
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
