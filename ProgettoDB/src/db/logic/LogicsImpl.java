package db.logic;

import java.sql.Connection;
import java.sql.Date;
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
	    myStm = conn.prepareStatement("SELECT numeroCamera FROM SOGGIORNO WHERE soggiornante = true");
	    result = myStm.executeQuery();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	try {

	    while (result.next()) {
		textArea.append("Camera: " + result.getString(1) + "\n");
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
	    myStm = conn.prepareStatement(
		    "SELECT numeroCamera FROM SOGGIORNO WHERE soggiornante = true " + "ORDER BY numeroCamera");
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
	    myStm = conn.prepareStatement("SELECT numeroCamera FROM SOGGIORNO WHERE (tipologiaSoggiornoScelto = ? "
		    + "OR tipologiaSoggiornoScelto = ?) AND soggiornante = true " + "ORDER BY numeroCamera");
	    myStm.setString(1, "ALI");
	    myStm.setString(2, "PB");
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
	    myStm = conn.prepareStatement("SELECT numeroCamera FROM SOGGIORNO WHERE (tipologiaSoggiornoScelto = ? "
		    + "OR tipologiaSoggiornoScelto = ?) AND soggiornante = true " + "ORDER BY numeroCamera");
	    myStm.setString(1, "ALI");
	    myStm.setString(2, "PB");
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
	    final String dateOfBirth, final String cellNumber, final String beginningDate, final String remainingDays,
	    final String chosenOffer, final int cardNumber, final int roomNumber, final String vacationType,
	    final String monthOfVacation, final int yearOfVacation, final int daysOfReservations) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn
		    .prepareStatement("INSERT INTO CLIENTE (codFiscale, nome, cognome, dataNascita, numeroTelefonico) "
			    + "VALUES (?, ?, ?, ?, ?)");
	    myStm.setString(1, identifierCode);
	    myStm.setString(2, name);
	    myStm.setString(3, surname);
	    myStm.setString(4, dateOfBirth);
	    myStm.setString(5, cellNumber);
	    myStm.executeUpdate();

	    myStm = conn.prepareStatement(
		    "INSERT INTO SOGGIORNO (dataInizio, codFiscaleCliente, durataSoggiorno, soggiornante, "
			    + "offertaScelta, codScheda, numeroCamera, resoconto, tipologiaSoggiornoScelto, "
			    + "meseSoggiornoScelto, annoSoggiornoScelto, codReceptionistInserente) "
			    + "VALUES (?, ?, ?, true, ?, ?, ?, 0, ?, ?, ?, 10)");
	    myStm.setString(1, beginningDate);
	    myStm.setString(2, identifierCode);
	    myStm.setString(3, remainingDays);
	    myStm.setString(4, chosenOffer);
	    myStm.setInt(5, cardNumber);
	    myStm.setInt(6, roomNumber);
	    myStm.setString(7, vacationType);
	    myStm.setString(8, monthOfVacation);
	    myStm.setInt(9, yearOfVacation);
	    myStm.executeUpdate();

	    myStm = conn.prepareStatement(
		    "SELECT prezzo FROM TIPOLOGIASOGGIORNO WHERE tipologia = ? AND mese = ? AND anno = ?");
	    myStm.setString(1, vacationType);
	    myStm.setString(2, monthOfVacation);
	    myStm.setInt(3, yearOfVacation);
	    result = myStm.executeQuery();

	    result.next();
	    int price = result.getInt(1);

	    /*
	     * Update for table resoconto in database.
	     */
	    for (int i = 0; i < daysOfReservations; i++) {
		myStm = conn.prepareStatement("UPDATE SOGGIORNO SET resoconto = resoconto + ? "
			+ "WHERE codFiscaleCliente = ? AND dataInizio = ?");
		myStm.setInt(1, price);
		myStm.setString(2, identifierCode);
		myStm.setString(3, beginningDate);
		myStm.executeUpdate();
	    }

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
	    myStm = conn.prepareStatement(
		    "SELECT dataInizio FROM SOGGIORNO WHERE numeroCamera = ? AND soggiornante = true");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	    if (!result.next()) {
		return;
	    }
	    final String beginningDate = result.getString(1);

	    myStm = conn.prepareStatement("UPDATE SOGGIORNO SET soggiornante = false, resoconto = 0 "
		    + "WHERE numeroCamera = ? AND soggiornante = true AND dataInizio = ?");
	    myStm.setInt(1, roomNumber);
	    myStm.setString(2, beginningDate);
	    myStm.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void registerNewReservation(final String reservationType, final String serviceType, final String date,
	    final String season, final int year, final String day, final String hour, final int roomNumber) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT codFiscaleCliente, dataInizio FROM SOGGIORNO "
		    + "WHERE numeroCamera = ? AND soggiornante = true");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	    result.next();
	    String identifier = result.getString(1);
	    String beginningDate = result.getString(2);

	    myStm = conn.prepareStatement("INSERT INTO PRENOTAZIONE (tipoPrenotazione, giorno, ora, "
		    + "dataInizioSoggiornoRegistrato, codFiscaleClienteRegistrato, tipoServizioUsufruito, "
		    + "stagioneServizioUsufruito, annoServizioUsufruito, codReceptionistOperante) "
		    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 10)");
	    myStm.setString(1, reservationType);
	    myStm.setString(2, date);
	    myStm.setString(3, hour);
	    myStm.setString(4, beginningDate);
	    myStm.setString(5, identifier);
	    myStm.setString(6, serviceType);
	    myStm.setString(7, season);
	    myStm.setInt(8, year);
	    myStm.executeUpdate();

	    myStm = conn.prepareStatement(
		    "SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ? AND stagione = ? AND anno = ?");
	    myStm.setString(1, serviceType);
	    myStm.setString(2, season);
	    myStm.setInt(3, year);
	    result = myStm.executeQuery();
	    result.next();
	    int value = result.getInt(1);

	    myStm = conn.prepareStatement("UPDATE SOGGIORNO SET resoconto = resoconto + ? "
		    + "WHERE codFiscaleCliente = ? AND dataInizio = ?");
	    myStm.setInt(1, value);
	    myStm.setString(2, identifier);
	    myStm.setString(3, beginningDate);
	    myStm.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void deleteReservation(final String reservationType, final int roomNumber, final String day,
	    final String hour) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT codFiscaleCliente, dataInizio FROM SOGGIORNO "
		    + "WHERE numeroCamera = ? AND soggiornante = true");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	    result.next();
	    final String identifier = result.getString(1);
	    final String beginningDate = result.getString(2);

	    myStm = conn.prepareStatement("DELETE FROM PRENOTAZIONE WHERE tipoPrenotazione = ? AND giorno = ? "
		    + "AND ora = ? AND dataInizioSoggiornoRegistrato = ? AND codFiscaleClienteRegistrato = ?");
	    myStm.setString(1, reservationType);
	    myStm.setString(2, day);
	    myStm.setString(3, hour);
	    myStm.setString(4, beginningDate);
	    myStm.setString(4, identifier);
	    myStm.executeUpdate();
	    myStm = conn.prepareStatement(
		    "SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ? " + "AND stagione = ? AND anno = ?");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	    result.next();
	    int price = result.getInt(1);

	    myStm = conn.prepareStatement(
		    "UPDATE SOGGIORNO SET resoconto = resoconto - ? WHERE codFiscaleCliente = ? AND dataInizio = ?");
	    myStm.setInt(1, price);
	    myStm.setString(2, identifier);
	    myStm.setString(3, beginningDate);
	    myStm.executeUpdate();
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
		    + "AND soggiornante = true");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return result;
    }

    @Override
    public void addCost(final String serviceType, final String season, final int year, final int roomNumber,
	    final String reservationType, final String day, final String hour) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement(
		    "SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ? AND stagione = ? AND anno = ?");
	    myStm.setString(1, serviceType);
	    myStm.setString(2, season);
	    myStm.setInt(3, year);
	    result = myStm.executeQuery();
	    result.next();
	    Double wage = result.getDouble(1);

	    myStm = conn.prepareStatement("SELECT dataInizio, codFiscaleCliente FROM SOGGIORNO "
		    + "WHERE numeroCamera = ? AND soggiornante = true");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	    result.next();
	    Date beginningDate = result.getDate(1);
	    String identifier = result.getString(2);

	    myStm = conn.prepareStatement(
		    "INSERT INTO PRENOTAZIONE (tipoPrenotazione, giorno, ora, dataInizioSoggiornoRegistrato, "
			    + "codFiscaleClienteRegistrato, tipoServizioUsufruito, "
			    + "stagioneServizioUsufruito, annoServizioUsufruito, codReceptionistOperante) "
			    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 10)");
	    myStm.setString(1, reservationType);
	    myStm.setString(2, day);
	    myStm.setString(3, hour);
	    myStm.setDate(4, beginningDate);
	    myStm.setString(5, identifier);
	    myStm.setString(6, serviceType);
	    myStm.setString(7, season);
	    myStm.setInt(8, year);
	    myStm.executeUpdate();

	    myStm = conn.prepareStatement("UPDATE SOGGIORNO SET resoconto = resoconto + ? "
		    + "WHERE codFiscaleCliente = ? AND dataInizio = ?");
	    myStm.setDouble(1, wage);
	    myStm.setString(2, identifier);
	    myStm.setDate(3, beginningDate);
	    myStm.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public ResultSet viewClientCard(final int roomNumber) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO WHERE numeroCamera = ? AND soggiornante = true");
	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return result;

    }

    @Override
    public ResultSet servicesUsedByClient(final int roomNumber) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());

	    myStm = conn.prepareStatement("SELECT tipoServizio, stagione, anno, tariffa FROM SERVIZIO "
		    + "RIGHT JOIN (SELECT tipoServizioUsufruito, stagioneServizioUsufruito, annoServizioUsufruito "
		    + "FROM PRENOTAZIONE, SOGGIORNO WHERE numeroCamera = ? AND PRENOTAZIONE.codFiscaleClienteRegistrato = "
		    + "SOGGIORNO.codFiscaleCliente AND soggiornante = true) AS PREN "
		    + "ON SERVIZIO.tipoServizio = PREN.tipoServizioUsufruito AND SERVIZIO.stagione = PREN.stagioneServizioUsufruito "
		    + "AND SERVIZIO.anno = PREN.annoServizioUsufruito");

	    myStm.setInt(1, roomNumber);
	    result = myStm.executeQuery();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return result;
    }

    @Override
    public ResultSet viewAllClients() {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO WHERE soggiornante = true");
	    result = myStm.executeQuery();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return result;

    }

    @Override
    public ResultSet viewFilteredClients(String beginningDate, int remainingDays, boolean isInHotel,
	    String vacationType, int roomNumber, String vacationChosen, String monthChosen, int yearChosen) {
	Connection conn = null;
	PreparedStatement myStm = null;
	ResultSet result = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO WHERE dataInizio = ? "
		    + "AND durataSoggiorno = ? AND soggiornante = ? AND offertaScelta = ? "
		    + "AND numeroCamera = ? AND tipologiaSoggiornoScelto = ? AND meseSoggiornoScelto = ? "
		    + "AND annoSoggiornoScelto = ? ");

	    myStm.setString(1, beginningDate);
	    myStm.setInt(2, remainingDays);
	    myStm.setBoolean(3, isInHotel);
	    myStm.setString(4, vacationType);
	    myStm.setInt(5, roomNumber);
	    myStm.setString(6, vacationChosen);
	    myStm.setString(7, monthChosen);
	    myStm.setInt(8, yearChosen);
	    result = myStm.executeQuery();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return result;
    }

    @Override
    public void insertVacationType(String vacationType, String month, int year, int price) {
	Connection conn = null;
	PreparedStatement myStm = null;
	try {
	    /*
	     * TipologiaSoggiorno table.
	     */
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement(
		    "INSERT INTO TIPOLOGIASOGGIORNO (tipologia, mese, anno, prezzo) VALUES (?, ?, ?, ?)");
	    myStm.setString(1, vacationType);
	    myStm.setString(2, month);
	    myStm.setInt(3, year);
	    myStm.setInt(4, price);
	    myStm.executeUpdate();

	    /*
	     * Condizionamento table.
	     */
	    myStm = conn.prepareStatement(
		    "INSERT INTO CONDIZIONAMENTO (codDirigenteOperante, tipoSoggiornoCondizionato, meseSoggiornoCondizionato, annoSoggiornoCondizionato) "
			    + "VALUES (?, ?, ?, ?)");
	    myStm.setInt(1, 10);
	    myStm.setString(2, vacationType);
	    myStm.setString(3, month);
	    myStm.setInt(4, year);
	    myStm.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void insertService(String serviceType, String season, int year, int price) {
	Connection conn = null;
	PreparedStatement myStm = null;
	try {
	    /*
	     * Servizio table.
	     */
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement(
		    "INSERT INTO SERVIZIO (tipoServizio, stagione, anno, tariffa) VALUES (?, ?, ?, ?)");
	    myStm.setString(1, serviceType);
	    myStm.setString(2, season);
	    myStm.setInt(3, year);
	    myStm.setInt(4, price);
	    myStm.executeUpdate();

	    /*
	     * Coordinazione table.
	     */
	    myStm = conn.prepareStatement(
		    "INSERT INTO COORDINAZIONE (codDirigenteCoordinante, tipoServizioCoordinato, stagioneServizioCoordinato, annoServizioCoordinato) "
			    + "VALUES (?, ?, ?, ?)");
	    myStm.setInt(1, 10);
	    myStm.setString(2, serviceType);
	    myStm.setString(3, season);
	    myStm.setInt(4, year);
	    myStm.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void updateVacationType(String vacationType, String month, int year, int price) {
	Connection conn = null;
	PreparedStatement myStm = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement(
		    "UPDATE TIPOLOGIASOGGIORNO SET prezzo = ? WHERE tipologia = ? AND mese = ? AND anno = ?");
	    myStm.setInt(1, price);
	    myStm.setString(2, vacationType);
	    myStm.setString(3, month);
	    myStm.setInt(4, year);
	    myStm.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void updateService(String serviceType, String season, int year, int price) {
	Connection conn = null;
	PreparedStatement myStm = null;
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
		    this.getOwnPassword());
	    myStm = conn.prepareStatement(
		    "UPDATE SERVIZIO SET tariffa = ? " + "WHERE tipoServizio = ? AND stagione = ? AND anno = ?");
	    myStm.setInt(1, price);
	    myStm.setString(2, serviceType);
	    myStm.setString(3, season);
	    myStm.setInt(4, year);
	    myStm.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public String getOwnPassword() {
	return this.password;
    }
}
