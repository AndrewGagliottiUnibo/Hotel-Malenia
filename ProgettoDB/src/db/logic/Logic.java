package db.logic;

import java.sql.ResultSet;

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
	boolean modifyPrice(int price, String nome);
	
}
