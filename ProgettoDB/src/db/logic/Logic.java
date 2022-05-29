package db.logic;

import java.sql.Connection;
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
	
	int actualPrice(String s);
	/**
	 * Restaurant method: due to the input argument, let you make a query
	 * returning the indicated value
	 */
	ResultSet showRestaurantTables();
	
	boolean insertPrice(int price);
	/**
	 * Restaurant method: due to the input argument, let you make a query
	 * inserting a price into the DB -- TODO
	 */
	
	
	/**
	 * BedroomService method: due to the input argument, let you make a query
	 * where you report when a bedroom has been cleaned or not.
	 * @param roomNumber
	 */
	boolean reportCleanedRoom(int roomNumber);
	
	
	/**
	 * BedroomService method: let you make a query where you recover
	 * from the db all the rooms that must be cleaned.
	 */
	ResultSet showRoomToBeCleaned();
}
