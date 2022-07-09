package db.logic;

import java.sql.ResultSet;
import javax.swing.JFrame;

public interface Logic {

	/**
	 * Load a different part of the application.
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
	 * @param specificGUI
	 * @param frame
	 */
	void goToSpecificPage(String specificGUI, JFrame frame); 
	
	/**
	 * BedroomService method: let you make a query where you recover
	 * from the db all the rooms that must be cleaned.
	 */
	ResultSet showRoomToBeCleaned();
	
	/**
	 * Restaurant method: due to the input argument, let you make a query
	 * returning the indicated value.
	 * @param one of the three restaurant services
	 */
	ResultSet showRestaurantTables(String service);
	
	/**
	 * Show the actual price for a specific product.
	 * @param s
	 * @return
	 */
	int actualPrice(String s); 
	
	/**
	 * Modify the price in input.
	 * @param price
	 * @param nome
	 * @return
	 */
	boolean modifyPrice(int price, String nome); //query 11 pagina 9
	
	void registerNewReservation(String nome, String cognome, int data, int Ncamera); //query 1

	void CheckoutClient(String nome, String cognome, int Ncamera); // query 2 
	
	boolean additionalCost(int Ncamera, int price); //query 6 
	
	
}
