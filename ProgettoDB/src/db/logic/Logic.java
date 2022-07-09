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
	 * Modify the price in input.
	 * 
	 * @param price
	 * @param nome
	 * @return
	 */

	boolean registerNewClient(String nome, String cognome, int data, int nCamera); // query 1 

	boolean CheckoutClient(int nCamera); // query 2
	
	boolean registerNewReservation(int tipoPrenotazione, int data, int ora, int nCamera); //query 3
	
	boolean deleteReservation(int tipoPrenotazione); //query 4

	ResultSet visualClients(int nCamera); // query 5

	boolean additionalCost(int nCamera, int price); // query 6
	
	ResultSet dataClient(int nCamera); //query 7
	
	boolean servicesUsedByClient(int nCamera); //query 8
	
	ResultSet totalAmount(); //query 9
	
	ResultSet clientFilter(int tipoPrenotazione, int intolleranze, int resoconto, int nCamera); //query 10

	boolean modifyPrice(int price, String nome); // query 11 
	
	ResultSet ReviewClient(int codCliente); //query 12
	

	

}
