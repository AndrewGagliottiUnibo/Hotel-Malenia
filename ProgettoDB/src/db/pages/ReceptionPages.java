package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ReceptionPages {

	static JFrame frame;
	private JTextField txtBenvenutoreceptionist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionPages window = new ReceptionPages();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReceptionPages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtBenvenutoreceptionist = new JTextField();
		txtBenvenutoreceptionist.setForeground(Color.RED);
		txtBenvenutoreceptionist.setBackground(Color.DARK_GRAY);
		txtBenvenutoreceptionist.setHorizontalAlignment(SwingConstants.CENTER);
		txtBenvenutoreceptionist.setText("Receptionist");
		txtBenvenutoreceptionist.setFont(new Font("Verdana", Font.BOLD, 18));
		txtBenvenutoreceptionist.setBounds(0, 0, 929, 43);
		frame.getContentPane().add(txtBenvenutoreceptionist);
		txtBenvenutoreceptionist.setColumns(10);

		JButton preno = new JButton("Prenotazione");
		preno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection myConn = null;
				Statement myStmt = null;
				ResultSet myRs = null;

				try {
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
							"dariostudente");
					System.out.println("Database connected");
					// 2. Create a statement
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery(
							"INSERT INTO PRENOTAZIONE (tipoPrenotazione, data, ora)" + "VALUES (?, ?, ?)");

					myRs = myStmt.executeQuery("INSERT INTO REGISTRAZIONE (codPrenotazione, schedaRegistrata)"
							+ "VALUES (PRENOTAZIONE.tipoPrenotazione, SCHEDA.codScheda)");
					myRs = myStmt.executeQuery("UPDATE SCHEDA" + "SET resoconto = resoconto + ?"
							+ "WHERE codScheda IN (SELECT schedaRegistrata" + "FROM REGISTRAZIONE"
							+ "WHERE schedaRegistrata = SCHEDA.codScheda)");
				} catch (Exception exc) {
					exc.printStackTrace();
				}

			}
		});
		preno.setBackground(Color.DARK_GRAY);
		preno.setForeground(Color.ORANGE);
		preno.setFont(new Font("Verdana", Font.BOLD, 12));
		preno.setBounds(272, 54, 385, 75);
		frame.getContentPane().add(preno);

		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPages login = new LoginPages();
				login.frame.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(Color.ORANGE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_2.setBounds(744, 428, 156, 34);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnRegistraCliente = new JButton("Registra cliente");
		btnRegistraCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection myConn = null;
				Statement myStmt = null;
				ResultSet myRs = null;

				try {
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
							"dariostudente");
					System.out.println("Database connected");
					// 2. Create a statement
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery("INSERT INTO SCHEDA (codScheda, numeroCamera, intolleranze, "
							+ "resoconto, datiTariffa, durataSoggiorno, orarioCheckin, orarioCheckout) + "
							+ "VALUES (?, ?, ’ ’, ?, ?, ?, ’ ’, ’ ’)");

					myRs = myStmt.executeQuery(
							"INSERT INTO CLIENTE (nome, cognome, codiceFiscale, dataNascita, numeroTel, tipologiaSoggiorno) + "
									+ "VALUES (?, ?, ?, ?, ?, ?)");
					myRs = myStmt.executeQuery("INSERT INTO IDENTIFICAZIONE (codiceCliente, numeroScheda)"
							+ "VALUES (?, SCHEDA.codScheda)");
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}

		});

		btnRegistraCliente.setBackground(Color.DARK_GRAY);
		btnRegistraCliente.setForeground(Color.ORANGE);
		btnRegistraCliente.setFont(new Font("Verdana", Font.BOLD, 12));
		btnRegistraCliente.setBounds(272, 226, 385, 75);
		frame.getContentPane().add(btnRegistraCliente);

		JButton btnVisualizzaResoconto = new JButton("Visualizza prenotazione");
		btnVisualizzaResoconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection myConn = null;
				Statement myStmt = null;
				ResultSet myRs = null;

				try {
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
							"dariostudente");
					System.out.println("Database connected");
					// 2. Create a statement
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery("SELECT codScheda FROM SCHEDA" + "WHERE numeroCamera = ?"
							+ "SELECT tipoPrenotazione, data, ora FROM REGISTRAZIONE,"
							+ "PRENOTAZIONE WHERE REGISTRAZIONE.schedaRegistrata = SCHEDA.codScheda" + "AND\n"
							+ "REGISTRAZIONE.codPrenotazione = PRENOTAZIONE.tipoPrenotazione"
							+ "ORDER BY SCHEDA.data DESC, SCHEDA.ora DESC");

				} catch (Exception exc) {
					exc.printStackTrace();
				}

			}
		});
		btnVisualizzaResoconto.setBackground(Color.DARK_GRAY);
		btnVisualizzaResoconto.setForeground(Color.ORANGE);
		btnVisualizzaResoconto.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVisualizzaResoconto.setBounds(272, 140, 385, 75);
		frame.getContentPane().add(btnVisualizzaResoconto);

		JButton btnClientiInStruttura = new JButton("Clienti in struttura");
		btnClientiInStruttura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection myConn = null;
				Statement myStmt = null;
				ResultSet myRs = null;

				try {
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
							"dariostudente");
					System.out.println("Database connected");
					// 2. Create a statement
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery("SELECT * FROM SCHEDA" + "WHERE numeroCamera IS NOT NULL");

				} catch (Exception exc) {
					exc.printStackTrace();
				}

			}
		});
		btnClientiInStruttura.setForeground(Color.ORANGE);
		btnClientiInStruttura.setFont(new Font("Verdana", Font.BOLD, 12));
		btnClientiInStruttura.setBackground(Color.DARK_GRAY);
		btnClientiInStruttura.setBounds(272, 312, 385, 75);
		frame.getContentPane().add(btnClientiInStruttura);
	}
}
