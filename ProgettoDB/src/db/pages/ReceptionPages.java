package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

	public JFrame frmHotelMalenia;
	private JTextField txtBenvenutoreceptionist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionPages window = new ReceptionPages();
					window.frmHotelMalenia.setVisible(true);
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
		frmHotelMalenia = new JFrame();
		frmHotelMalenia.setTitle("Hotel Malenia - Reception");
		frmHotelMalenia.setResizable(false);
		frmHotelMalenia.getContentPane().setBackground(Color.DARK_GRAY);
		frmHotelMalenia.setBounds(100, 100, 945, 528);
		frmHotelMalenia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotelMalenia.getContentPane().setLayout(null);

		txtBenvenutoreceptionist = new JTextField();
		txtBenvenutoreceptionist.setForeground(Color.RED);
		txtBenvenutoreceptionist.setBackground(Color.DARK_GRAY);
		txtBenvenutoreceptionist.setHorizontalAlignment(SwingConstants.CENTER);
		txtBenvenutoreceptionist.setText("Receptionist");
		txtBenvenutoreceptionist.setFont(new Font("Verdana", Font.BOLD, 18));
		txtBenvenutoreceptionist.setBounds(0, 0, 929, 43);
		frmHotelMalenia.getContentPane().add(txtBenvenutoreceptionist);
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
		preno.setBounds(272, 75, 385, 75);
		frmHotelMalenia.getContentPane().add(preno);

		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHotelMalenia.dispose();
				LoginPages login = new LoginPages();
				login.frame.setVisible(true);
			}
		});
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBounds(744, 428, 156, 34);
		frmHotelMalenia.getContentPane().add(logout);

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
		btnRegistraCliente.setBounds(272, 161, 385, 75);
		frmHotelMalenia.getContentPane().add(btnRegistraCliente);

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
		btnClientiInStruttura.setBounds(272, 247, 385, 75);
		frmHotelMalenia.getContentPane().add(btnClientiInStruttura);
	}
}
