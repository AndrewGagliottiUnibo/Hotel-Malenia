package db.pages.specific;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.logic.Logic;

public class AllReservations {

	private JFrame frmPrenotazioni;
	private JTextField specificViewField;
	private JTextField deleteField;
	private JTable table;
	private Logic logic;

	/**
	 * Constructor.
	 */
	public AllReservations(final Logic logic) {
		this.logic = logic;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrenotazioni = new JFrame();
		frmPrenotazioni.getContentPane().setForeground(Color.ORANGE);
		frmPrenotazioni.getContentPane().setFont(new Font("Verdana", Font.BOLD, 12));
		frmPrenotazioni.getContentPane().setBackground(Color.DARK_GRAY);
		frmPrenotazioni.setTitle("Prenotazioni");
		frmPrenotazioni.setBounds(100, 100, 945, 528);
		frmPrenotazioni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrenotazioni.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Prenotazioni");
		lblNewLabel.setBounds(0, 0, 929, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		frmPrenotazioni.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 680, 452);
		frmPrenotazioni.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Tipo prenotazione", "Data", "Ora", "Scheda", "Camera" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(table);

		JLabel viewSpecificLabel = new JLabel("Vedi prenotazioni per scheda");
		viewSpecificLabel.setForeground(Color.ORANGE);
		viewSpecificLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		viewSpecificLabel.setBackground(Color.DARK_GRAY);
		viewSpecificLabel.setBounds(700, 127, 219, 14);
		frmPrenotazioni.getContentPane().add(viewSpecificLabel);

		JButton showAll = new JButton("Vedi prenotazioni");
		showAll.addActionListener(e -> {
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			try {
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
						"dariostudente");
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("SELECT * FROM PRENOTAZIONI");
				while (myRs.next()) {
					int row = myRs.getRow();

					for (int i = 0; i < row; i++) {
						//this..replaceSelection("SCHEDA: " + myRs.getString(i));
					}
				}

			} catch (Exception exc) {
				exc.printStackTrace();
			}
		});
		showAll.setForeground(Color.ORANGE);
		showAll.setFont(new Font("Verdana", Font.BOLD, 12));
		showAll.setBackground(Color.DARK_GRAY);
		showAll.setBounds(700, 26, 219, 23);
		frmPrenotazioni.getContentPane().add(showAll);

		specificViewField = new JTextField();
		specificViewField.setFont(new Font("Verdana", Font.BOLD, 12));
		specificViewField.setForeground(Color.PINK);
		specificViewField.setBackground(Color.BLACK);
		specificViewField.setBounds(700, 152, 219, 20);
		frmPrenotazioni.getContentPane().add(specificViewField);
		specificViewField.setColumns(10);

		JButton commitSpecificBtn = new JButton("Vedi");
		commitSpecificBtn.addActionListener(e -> {
			var choice = this.specificViewField.getText();
			ResultSet myRs = null;
			try {
				myRs = this.logic.dataClient(Integer.parseInt(choice));
				while (myRs.next()) {
					int row = myRs.getRow();

					for (int i = 0; i < row; i++) {
						this.specificViewField.replaceSelection("SCHEDA: " + myRs.getString(i));
					}
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}

			// Query with text cast to Integer.parseInt(choice);
			// Update table
		});
		commitSpecificBtn.setForeground(Color.ORANGE);
		commitSpecificBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		commitSpecificBtn.setBackground(Color.DARK_GRAY);
		commitSpecificBtn.setBounds(700, 182, 219, 23);
		frmPrenotazioni.getContentPane().add(commitSpecificBtn);

		JButton logout = new JButton("Logout");
		logout.addActionListener(e -> {
			this.frmPrenotazioni.dispose();
			this.logic.logout();
		});
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(700, 455, 219, 23);
		frmPrenotazioni.getContentPane().add(logout);

		JLabel codeCardLabel = new JLabel("Inserisci codice prenotazione");
		codeCardLabel.setForeground(Color.ORANGE);
		codeCardLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		codeCardLabel.setBackground(Color.DARK_GRAY);
		codeCardLabel.setBounds(700, 298, 219, 14);
		frmPrenotazioni.getContentPane().add(codeCardLabel);

		deleteField = new JTextField();
		deleteField.setFont(new Font("Verdana", Font.BOLD, 12));
		deleteField.setForeground(Color.PINK);
		deleteField.setBackground(Color.BLACK);
		deleteField.setColumns(10);
		deleteField.setBounds(700, 323, 219, 20);
		frmPrenotazioni.getContentPane().add(deleteField);

		JButton deleteReservationBtn = new JButton("Cancella");
		deleteReservationBtn.addActionListener(e -> {
			var choice = this.deleteField.getText();
			this.logic.deleteReservation(0, 0);
		});
		deleteReservationBtn.setForeground(Color.ORANGE);
		deleteReservationBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		deleteReservationBtn.setBackground(Color.DARK_GRAY);
		deleteReservationBtn.setBounds(700, 353, 219, 23);
		frmPrenotazioni.getContentPane().add(deleteReservationBtn);
	}

	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frmPrenotazioni;
	}
}
