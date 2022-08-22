package db.logic;

import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JTextArea;

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
     * 
     * @param result
     */
    void showRoomsToBeCleaned(JTextArea result);

    /**
     * Restaurant method: return the reserved tables for breakfast.
     * 
     * @return set of rooms.
     */
    ResultSet showBreakfastTables();

    /**
     * Restaurant method: return the reserved tables for Launch.
     * 
     * @return set of rooms.
     */
    ResultSet showLaunchTables();

    /**
     * Restaurant method: return the reserved tables for Dinner.
     * 
     * @return set of rooms.
     */
    ResultSet showDinnerTables();

    /**
     * Show the actual price for a specific product.
     * 
     * @param item
     * @return value of chosen item.
     */
    int getSpecificPrice(String item);

    /**
     * Query 1 - Register a new client.
     * 
     * @param name
     * @param surname
     * @param identifierCode
     * @param dateOfBirth
     * @param cellNumber
     * @param beginningDate
     * @param remainingDays
     * @param chosenOffer
     * @param cardNumber
     * @param roomNumber
     * @param vacationType
     * @param monthOfVacation
     * @param yearOfVacation
     */
    void registerNewClient(String name, String surname, String identifierCode, String dateOfBirth, int cellNumber,
	    String beginningDate, int remainingDays, String chosenOffer, int cardNumber, int roomNumber,
	    String vacationType, String monthOfVacation, int yearOfVacation);

    /**
     * Query 2. Does the checkout of the client.
     * 
     * @param roomNumber
     */
    void checkoutClient(int roomNumber);

    /**
     * Query 3 - Register a new reservation.
     * 
     * @param reservationType
     * @param serviceType
     * @param season
     * @param year
     * @param day
     * @param hour
     * @param roomNumber
     */
    void registerNewReservation(String reservationType, String serviceType, String date, String season, int year,
	    String day, int hour, int roomNumber);

    /**
     * Query 4 - Delete a reservation.
     * 
     * @param reservationType
     * @param roomNumber
     * @param day
     * @param hour
     */
    void deleteReservation(String reservationType, int roomNumber, String day, int hour);

    /**
     * Query 5 - View all clients actually in the Hotel.
     * @param roomNumber
     * @return set of clients viewed.
     */
    ResultSet viewReservations(int roomNumber);

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
     * Modify the price in input. query 10.
     * 
     * @param price
     * @param nome
     * @return the operation done successfully or not.
     */
    boolean modifyPrice(int price, String tipoListino);

    /**
     * query 11.
     * 
     * @param codCliente
     * @return a ResultSet with the informations about a specific client.
     */
    ResultSet ReviewClient(int codCliente);

    /**
     * @return password value.
     */
    String getOwnPassword();

}
