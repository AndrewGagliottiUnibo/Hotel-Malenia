package db.pages.specific;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import db.logic.Logic;
import javax.swing.JTextArea;

public class AllClientCards {

	private JFrame frmSchedeClienti;
	private JTextField codeField;
	private ClientCard chosenCard;
	private JTextArea textAreaCard;
	private JTextArea textAreaRoom;
	private Logic logic;

	/**
	 * Constructor.
	 */
	public AllClientCards(final Logic logic) {
		this.logic = logic;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSchedeClienti = new JFrame();
		frmSchedeClienti.setTitle("Schede clienti");
		frmSchedeClienti.getContentPane().setBackground(Color.DARK_GRAY);
		frmSchedeClienti.setBounds(100, 100, 945, 528);
		frmSchedeClienti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSchedeClienti.getContentPane().setLayout(null);

		JLabel cardsView = new JLabel("Visualizzazione schede clienti");
		cardsView.setBounds(0, 0, 929, 23);
		cardsView.setBackground(Color.DARK_GRAY);
		cardsView.setHorizontalAlignment(SwingConstants.CENTER);
		cardsView.setForeground(Color.RED);
		cardsView.setFont(new Font("Verdana", Font.BOLD, 18));
		frmSchedeClienti.getContentPane().add(cardsView);

		JScrollPane cardsViewScrollPane = new JScrollPane();
		cardsViewScrollPane.setBounds(10, 34, 307, 444);
		frmSchedeClienti.getContentPane().add(cardsViewScrollPane);
		
		this.textAreaCard = new JTextArea();
		textAreaCard.setEnabled(false);
		textAreaCard.setBackground(Color.BLACK);
		textAreaCard.setForeground(Color.PINK);
		textAreaCard.setFont(new Font("Verdana", Font.BOLD, 12));
		cardsViewScrollPane.setViewportView(textAreaCard);
		
		JLabel titleLabelCard = new JLabel("Codice scheda");
		titleLabelCard.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabelCard.setForeground(Color.ORANGE);
		titleLabelCard.setBackground(Color.BLACK);
		titleLabelCard.setFont(new Font("Verdana", Font.BOLD, 12));
		cardsViewScrollPane.setColumnHeaderView(titleLabelCard);

		JLabel viewTitle = new JLabel("Inserisci codice");
		viewTitle.setForeground(Color.ORANGE);
		viewTitle.setHorizontalAlignment(SwingConstants.CENTER);
		viewTitle.setFont(new Font("Verdana", Font.BOLD, 12));
		viewTitle.setBounds(643, 34, 276, 23);
		frmSchedeClienti.getContentPane().add(viewTitle);

		codeField = new JTextField();
		codeField.setBackground(Color.BLACK);
		codeField.setForeground(Color.PINK);
		codeField.setFont(new Font("Verdana", Font.BOLD, 12));
		codeField.setBounds(643, 59, 276, 20);
		frmSchedeClienti.getContentPane().add(codeField);
		codeField.setColumns(10);

		JButton goToCard = new JButton("Vedi Scheda");
		goToCard.addActionListener(e -> {
			var chosenClient = this.codeField.getText();
			this.chosenCard = new ClientCard(chosenClient, this.logic);
			this.chosenCard.getFrame().setVisible(true);
			this.frmSchedeClienti.dispose();
		});
		
		goToCard.setForeground(Color.ORANGE);
		goToCard.setBackground(Color.DARK_GRAY);
		goToCard.setFont(new Font("Verdana", Font.BOLD, 12));
		goToCard.setBounds(643, 90, 276, 23);
		frmSchedeClienti.getContentPane().add(goToCard);

		JButton viewAllBtn = new JButton("Vedi tutte");
		viewAllBtn.addActionListener(e -> {
			ResultSet result;
			try {
				/*
				 * Query for cards code.
				 */
				result = this.fillPage("codScheda", false);
				while (result.next()) {
					int row = result.getRow();

					for (int i = 0; i < row; i++) {
						this.textAreaCard.append(result.getString(1) + "\n");
					}
				}
				
				/*
				 * Query for room number
				 */
				result = this.fillPage("numeroCamera", false);
				while (result.next()) {
					int rowRoom = result.getRow();

					for (int i = 0; i < rowRoom; i++) {
						this.textAreaRoom.append(result.getString(1) + "\n");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		viewAllBtn.setForeground(Color.ORANGE);
		viewAllBtn.setBackground(Color.DARK_GRAY);
		viewAllBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		viewAllBtn.setBounds(643, 184, 276, 23);
		frmSchedeClienti.getContentPane().add(viewAllBtn);

		JButton viewActualBtn = new JButton("Vedi attuali");
		viewActualBtn.addActionListener(e -> {
			ResultSet result;
			try {
				/*
				 * Query for cards code.
				 */
				result = this.fillPage("codScheda", true);
				while (result.next()) {
					int row = result.getRow();

					for (int i = 0; i < row; i++) {
						this.textAreaCard.append(result.getString(1) + "\n");
					}
				}
				
				/*
				 * Query for room number
				 */
				result = this.fillPage("numeroCamera", true);
				while (result.next()) {
					int rowRoom = result.getRow();

					for (int i = 0; i < rowRoom; i++) {
						this.textAreaRoom.append(result.getString(1) + "\n");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		viewActualBtn.setForeground(Color.ORANGE);
		viewActualBtn.setBackground(Color.DARK_GRAY);
		viewActualBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		viewActualBtn.setBounds(643, 222, 276, 23);
		frmSchedeClienti.getContentPane().add(viewActualBtn);

		JButton logout = new JButton("Logout");
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBounds(699, 455, 220, 23);
		logout.addActionListener(e -> {
			this.frmSchedeClienti.dispose();
			this.logic.logout();
		});
		frmSchedeClienti.getContentPane().add(logout);
		
		JScrollPane roomViewScrollPane = new JScrollPane();
		roomViewScrollPane.setBounds(327, 34, 306, 444);
		frmSchedeClienti.getContentPane().add(roomViewScrollPane);
		
		JLabel lblNumeroCamera = new JLabel("Numero camera");
		lblNumeroCamera.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroCamera.setForeground(Color.ORANGE);
		lblNumeroCamera.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNumeroCamera.setBackground(Color.BLACK);
		roomViewScrollPane.setColumnHeaderView(lblNumeroCamera);
		
		this.textAreaRoom = new JTextArea();
		textAreaRoom.setEnabled(false);
		textAreaRoom.setForeground(Color.PINK);
		textAreaRoom.setFont(new Font("Verdana", Font.BOLD, 12));
		textAreaRoom.setBackground(Color.BLACK);
		roomViewScrollPane.setViewportView(textAreaRoom);
	}

	/**
	 * Calls a query for recovering a specific data from SCHEDA table.
	 * @param cell
	 * @param value
	 * @return
	 */
	private ResultSet fillPage(final String cell, final boolean value) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			if(value) {
				/*
				 * NOT NULL connection.
				 */
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
						this.logic.getOwnPassword());
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("SELECT " + cell + " FROM SCHEDA "
											+ "WHERE numeroCamera IS NOT NULL");
			return myRs;
		} else {
				/*
				 * with NULL connection.
				 */
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
						this.logic.getOwnPassword());
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("SELECT " + cell + " FROM SCHEDA");

			return myRs;
		}
		
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frmSchedeClienti;
	}
}
