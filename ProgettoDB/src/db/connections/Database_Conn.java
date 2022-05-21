//package db.connections;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.*;
//public class Database_Conn {
//
//	public static void main(String[] args) throws SQLException {
//
//		Connection myConn = null;
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		
//		try {
//			// 1. Get a connection to database
//			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , "dariostudente");
//			System.out.println("Database connected");
//			// 2. Create a statement
//			myStmt = myConn.createStatement();
//			
//			
//			myRs = myStmt.executeQuery("select * from employees");
//			
//			 //4. Process the result set
//			while (myRs.next()) {
//				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
//			}
//		}
//		catch (Exception exc) {
//			exc.printStackTrace();
//		}
//		finally {
//			if (myRs != null) {
//				myRs.close();
//			}
//			
//			if (myStmt != null) {
//				myStmt.close();
//			}
//			
//			if (myConn != null) {
//				myConn.close();
//				System.out.println("Connection closed");
//			}
//		}
//	}
//}
