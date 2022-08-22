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
  public LogicsImpl(LoginPages mainPage) {
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
  public void showRoomToBeCleaned(final JTextArea textArea) {
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
		 
		 while(result.next()) {
			 for(int i = 0; i < row; i++) {
				 textArea.append("Camera: " + result.getString(i) + "\n");
			 }
		 }
	 } catch(Exception ecc) {
		 ecc.printStackTrace();
	 }
  }

  @Override
  public ResultSet showBreakfastTables() {
    Connection conn = null;
    PreparedStatement myStm = null;
    ResultSet result = null;
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , this.getOwnPassword());
        myStm = conn.prepareStatement("SELECT numeroCamera FROM SOGGIORNO "
                                    + "WHERE soggiornante = 1");
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
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , this.getOwnPassword());
        myStm = conn.prepareStatement("SELECT numeroCamera FROM SOGGIORNO "
            + "WHERE tipologiaSoggiornoScelto = ? AND tipologiaSoggiornoScelto = ? AND soggiornante = 1");
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
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , this.getOwnPassword());
        myStm = conn.prepareStatement("SELECT numeroCamera FROM SOGGIORNO "
            + "WHERE tipologiaSoggiornoScelto = ? AND tipologiaSoggiornoScelto = ?");
        myStm.setString(1, "AllInclusive");
        myStm.setString(2, "PensioneCompleta");
        result = myStm.executeQuery();
    } catch (SQLException exc) {
        exc.printStackTrace();
    }
    return result;
  }

  @Override
  public int actualPrice(String tipoListino) {
    Connection conn = null;
    PreparedStatement myStm = null;
    ResultSet result = null;
    int recordNumber = 0;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
          this.getOwnPassword());
      myStm = conn.prepareStatement("SELECT valoreMonetario FROM Listini WHERE tipoListino = ?");
      myStm.setString(1, tipoListino);
      result = myStm.executeQuery();
      recordNumber = result.getInt(1);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return recordNumber;
  }

  @Override
  public boolean modifyPrice(int price, String tipoListino) {
    Connection conn = null;
    PreparedStatement myStm = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
          this.getOwnPassword());
      myStm = conn.prepareStatement("UPDATE Listini SET valoreMonetario = ? WHERE tipoListino = ?");
      myStm.setInt(1, price);
      myStm.setString(2, tipoListino);
      myStm.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public boolean registerNewClient(String nome, String cognome, String codiceFiscale,
      String dataNascita, int numeroTel, String dataInizio, String offertaScelta, String tipologiaSoggiorno, int codScheda, int numeroCamera,
      int intolleranze, int resoconto, int durataSoggiorno, String meseSoggiorno, int annoSoggiorno) {
    Connection conn = null;
    PreparedStatement myStm = null;
    ResultSet result = null;
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
          "INSERT INTO CLIENTE (codFiscale, nome, cognome, dataNascita, numeroTel)"
              + "VALUES (?, ?, ?, ?, ?)"
              + "INSERT INTO SOGGIORNO (dataInizio, codFiscaleCliente, durataSoggiorno, soggiornante, "
              + "offertaScelta, codScheda, numeroCamera, resoconto, tipologiaSoggiornoScelto, "
              + "meseSoggiornoScelto, annoSoggiornoScelto, codReceptionistInserente) "
              + "VALUES (?, ?, ?, 1, ?, ?, ?, 0, ?, ?, ?, 10) ");
      myStm.setString(1, codiceFiscale);
      myStm.setString(2, nome);
      myStm.setString(3, cognome);
      myStm.setString(4, dataNascita);
      myStm.setInt(5, numeroTel);
     
      myStm.setString(6, dataInizio);
      myStm.setString(7, codiceFiscale);
      myStm.setInt(8, durataSoggiorno);
      myStm.setString(9, offertaScelta);
      myStm.setInt(10, codScheda);
      myStm.setInt(11, numeroCamera);
      myStm.setString(12, tipologiaSoggiorno);
      myStm.setString(13, meseSoggiorno);
      myStm.setInt(14, annoSoggiorno);
      myStm.executeQuery();
      
      myStm = conn.prepareStatement(
          "SELECT prezzo FROM TIPOLOGIASOGGIORNO "
              + "WHERE tipologia = ?, mese = ?, anno = ?");
      myStm.setString(1, tipologiaSoggiorno);
      myStm.setString(2, meseSoggiorno);
      myStm.setInt(3, annoSoggiorno);
      result = myStm.executeQuery();
      int price = result.getInt(1);
      
      myStm = conn.prepareStatement(
          "UPDATE SOGGIORNO SET resoconto = resoconto + ? "
              + "WHERE codFiscaleCliente = ? AND dataInizio = ?");
      myStm.setInt(12, price);
      myStm.setString(13, codiceFiscale);
      myStm.setString(14, dataInizio);
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
    ResultSet result = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
          this.getOwnPassword());
      myStm = conn
          .prepareStatement("SELECT dataInizio FROM SOGGIORNO WHERE numeroCamera = ? "
              + "AND soggiornante = 1");
      myStm.setInt(1, nCamera);
      result = myStm.executeQuery();
      String dataInizio = result.getString(1);
     
      myStm = conn
          .prepareStatement("UPDATE SOGGIORNO SET soggiornante = 0, resoconto = 0 "
              + "WHERE numeroCamera = ? AND soggiornante = 1 AND dataInizio = ?");
      myStm.setInt(1, nCamera);
      myStm.setString(1, dataInizio);
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
      // Da rivedere!!
      myStm = conn.prepareStatement("SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ? "
          + "UPDATE SCHEDA SET resoconto = ? + SERVIZIO.tariffa "
          + "WHERE codScheda IN (SELECT codScheda FROM SCHEDA WHERE numeroCamera = ?)");
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
      // Visual client by numeroCamera, implentare in base al codiceFiscale del cliente
      myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO, PRENOTAZIONE WHERE numeroCamera = ? "
          + "AND PRENOTAZIONE.codFiscaleClienteRegistrato = SOGGIORNO.codFiscaleCliente "
          + "AND soggiornante = 1");
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
      // definire in base al numero camera?
      myStm = conn.prepareStatement("SELECT * FROM SOGGIORNO WHERE numeroCamera = ? "
          + "AND soggiornante = 1");
      myStm.setInt(1, nCamera);

      result = myStm.executeQuery();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;

  }

  @Override
  public boolean registerNewReservation(String tipoPrenotazione, String tipoServizio, 
      String stagione, int anno, String giorno, String ora, int nCamera, int resoconto) {
    Connection conn = null;
    PreparedStatement myStm = null;
    ResultSet result = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
          this.getOwnPassword());
      myStm = conn.prepareStatement("SELECT codFiscaleCliente, dataInizio FROM SOGGIORNO "
          + "WHERE numeroCamera = ? AND soggiornante = 1");
      myStm.setInt(1, nCamera);
      result = myStm.executeQuery();
      String codFiscaleCliente = result.getString(1);
      String dataInizio = result.getString(2);
      
      myStm = conn.prepareStatement("INSERT INTO PRENOTAZIONE (tipoPrenotazione, data, ora, "
          + "dataInizioSoggiornoRegistrato, codFiscaleClienteRegistrato, tipoServizioUsufruito, "
          + "stagioneServizioUsufruito, annoServizioUsufruito, codReceptionistOperante) "
          + "VALUES (?, ’ ’, ’ ’, dataInizio, codFiscaleCliente, ?, ?, ?, 10)");
      myStm.setString(1, tipoPrenotazione);
      myStm.setString(2, tipoServizio);
      myStm.setString(3, stagione);
      myStm.setInt(4, anno);
      myStm.executeQuery();
      
      myStm = conn.prepareStatement("SELECT tariffa FROM SERVIZIO "
          + "WHERE tipoServizio = ? AND stagione = ? AND anno = ?");
      myStm.setString(1, tipoServizio);
      myStm.setString(2, stagione);
      myStm.setInt(3, anno);
      result = myStm.executeQuery();
      int tariffa = result.getInt(1);
      
      myStm = conn.prepareStatement("UPDATE SOGGIORNO SET resoconto = resoconto + ? "
          + "WHERE codFiscaleCliente = ? AND dataInizio = ?");
      myStm.setInt(1, tariffa);
      myStm.setString(2, codFiscaleCliente);
      myStm.setString(3, dataInizio);
      myStm.executeQuery();
      
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public boolean deleteReservation(int tipoPrenotazione, int numeroCamera, String giorno, int ora) {
    Connection conn = null;
    PreparedStatement myStm = null;
    ResultSet result = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
          this.getOwnPassword());
      myStm = conn.prepareStatement(
          "SELECT codFiscaleCliente, dataInizio FROM SOGGIORNO "
          + "WHERE numeroCamera = ? AND soggiornante = 1");
      myStm.setInt(1, numeroCamera);
      result = myStm.executeQuery();
      String codFiscale = result.getString(1);
      String dataInizio = result.getString(2);

      myStm = conn.prepareStatement(
          "DELETE FROM PRENOTAZIONE WHERE tipoPrenotazione = ? AND giorno = ? "
              + "AND ora = ? AND dataInizioSoggiornoRegistrato = ? AND codFiscaleClienteRegistrato = ?");

      myStm.setInt(1, tipoPrenotazione);
      myStm.setString(2, giorno);
      myStm.setInt(3, ora);
      myStm.setString(4, dataInizio);
      myStm.setString(4, codFiscale);
      myStm.executeQuery();
      // come fare qui?
      myStm = conn.prepareStatement(
          "SELECT tariffa FROM SERVIZIO WHERE tipoServizio = ? "
          + "AND stagione = ? AND anno = ?");
      myStm.setInt(1, numeroCamera);
      result = myStm.executeQuery();
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
      myStm = conn.prepareStatement(
          "SELECT * FROM SCHEDA, IDENTIFICAZIONE, CLIENTE WHERE "
              + "SCHEDA.codScheda = IDENTIFICAZIONE.numeroScheda AND IDENTIFICAZIONE.codiceCliente = ?");

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
