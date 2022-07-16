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
	void login(String code, String password);

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
	 * Restaurant method: due to the input argument, let you make a query returning
	 * the indicated value.
	 * 
	 * @param one of the three restaurant services
	 */
	ResultSet showRestaurantTables(String service);

	/**
	 * Show the actual price for a specific product.
	 * 
	 * @param s
	 * @return
	 */
	int actualPrice(String s);

	/**
	 * query 1.
	 * 
	 * @param nome
	 * @param cognome
	 * @param codiceFiscale
	 * @param dataNascita
	 * @param numeroTel
	 * @param tipologiaSoggiorno
	 * @param codScheda
	 * @param numeroCamera
	 * @param intolleranze
	 * @param resoconto
	 * @param datiTariffa
	 * @param durataSoggiorno
	 * @param orarioCheckin
	 * @param orarioCheckout
	 * @return operation done successfully or not.
	 */
	boolean registerNewClient(String nome, String cognome, int codiceFiscale, String dataNascita, int numeroTel,
			String tipologiaSoggiorno, int codScheda, int numeroCamera, int intolleranze, int resoconto,
			int durataSoggiorno, String orarioCheckin, String orarioCheckout);

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
	boolean registerNewReservation(int tipoPrenotazione, int data, int ora, int nCamera, int resoconto);

	/**
	 * query 4.
	 * 
	 * @param tipoPrenotazione
	 * @param resoconto
	 * @return operation done successfully or not.
	 */
	boolean deleteReservation(int tipoPrenotazione);

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
	 * Modify the price in input. query 10
	 * 
	 * @param price
	 * @param nome
	 * @return the operation done successfully or not.
	 */
	boolean modifyPrice(int price, String nome);

	/**
	 * query 11.
	 * 
	 * @param codCliente
	 * @return a ResultSet with the informations about a specific client.
	 */
	ResultSet ReviewClient(int codCliente);
}
