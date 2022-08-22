package db.logic;

import java.sql.ResultSet;
import javax.swing.JFrame;

public interface Logic {

	/**
	 * Load a different part of the application.
	 * 
	 * @param code
	 * @param password
	 */
	void login(String code, char[] password);

	/**
	 * Let you return to the login page.
	 */
	void logout();

	/**
	 * Show a sub page of the application.
	 * 
	 * @param specificGUI
	 * @param frame
	 */
	void goToSpecificPage(String specificGUI, JFrame frame);

	/**
	 * BedroomService method: let you make a query where you recover from the db all
	 * the rooms that must be cleaned.
	 */
	ResultSet showRoomToBeCleaned();

	/**
	 * Restaurant method: return the reserved tables for breakfast.
	 * 
	 */
	ResultSet showBreakfastTables();
	
	 /**
     * Restaurant method: return the reserved tables for Launch.
     * 
     */
    ResultSet showLaunchTables();
    
    /**
    * Restaurant method: return the reserved tables for Dinner.
    * 
    */
   ResultSet showDinnerTables();

	/**
	 * Show the actual price for a specific product.
	 * 
	 * @param tipoListino
	 * @return
	 */
	int actualPrice(String tipoListino);

	/**
	 * query 1.
	 * 
	 * @param nome
	 * @param cognome
	 * @param codiceFiscale
	 * @param dataNascita
	 * @param numeroTel
	 * @param dataInizio
	 * @param offertaScelta
	 * @param tipologiaSoggiorno
	 * @param codScheda
	 * @param numeroCamera
	 * @param intolleranze
	 * @param resoconto
	 * @param durataSoggiorno
	 * @param meseSoggiorno
	 * @param annoSoggiorno
	 * @return operation done successfully or not.
	 */
	boolean registerNewClient(String nome, String cognome, String codiceFiscale, String dataNascita, int numeroTel,
	        String dataInizio, String offertaScelta, String tipologiaSoggiorno, int codScheda, int numeroCamera, int intolleranze, int resoconto,
			int durataSoggiorno, String meseSoggiorno, int annoSoggiorno);

	/**
	 * query 2. Does the checkout of the client.
	 * 
	 * @param nCamera
	 * @return operation done successfully or not.
	 */
	boolean CheckoutClient(int nCamera);

	/**
	 * query 3.
	 * 
	 * @param tipoPrenotazione
	 * @param data
	 * @param ora
	 * @param nCamera
	 * @param resoconto
	 * @return operation done successfully or not.
	 */
	 boolean registerNewReservation(String tipoPrenotazione, String tipoServizio, 
	      String stagione, int anno, String giorno, String ora, int nCamera, int resoconto);

	/**
	 * query 4.
	 * 
	 * @param tipoPrenotazione
	 * @param resoconto
	 * @return operation done successfully or not.
	 */
	 boolean deleteReservation(int tipoPrenotazione, int numeroCamera, String giorno, int ora);

	/**
	 * query 5.
	 * 
	 * @param nCamera
	 * @return a ResultSet of clients.
	 */
	ResultSet visualClients(int nCamera);

	/**
	 * query 6.
	 * 
	 * @param nCamera
	 * @param price
	 * @param resoconto
	 * @param tipoServizio
	 * @return operation done successfully or not.
	 */
	boolean additionCost(int nCamera, int price, int resoconto, int tipoServizio);

	/**
	 * query 7.
	 * 
	 * @param nCamera
	 * @return a ResultSet with the chosen Card.
	 */
	ResultSet dataClient(int nCamera);

	/**
	 * query 8.
	 * 
	 * @param nCamera
	 * @return a ResultSet with the services got for a client.
	 */
	ResultSet servicesUsedByClient(int nCamera);

	/**
	 * query 9.
	 * 
	 * @return a ResultSet with all clients in the hotel.
	 */
	ResultSet totalAmount();

	/**
	 * query 10.
	 * 
	 * @param codCliente
	 * @return a ResultSet with the informations about a specific client.
	 */
	ResultSet ReviewClient(int codCliente);
	
	/**
	 * Modify the price in input. query 11
	 * 
	 * @param tipoServizio
	 * @param stagione
	 * @param anno
	 * @param tariffa
	 * @param tipologiaSoggiorno
	 * @param mese
	 * @param annoSoggiorno
	 * @param prezzo
	 * @return the operation done successfully or not.
	 */
	boolean modifyPrice(String tipoServizio, String stagione, int anno, int tariffa, String tipologiaSoggiorno,
		    int mese, int annoSoggiorno, int prezzo);
	
	/**
	 * @return password value.
	 */
	String getOwnPassword();

}
