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

    private JFrame frame;
    private JTextField codeField;
    private ClientCard chosenCard;
    private JTextArea textAreaCard;
    private JTextArea textAreaRoom;
    private Logic logic;
    private JTextArea textAreaSurname;

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
	frame = new JFrame();
	frame.setResizable(false);
	frame.setTitle("Schede clienti");
	frame.getContentPane().setBackground(Color.DARK_GRAY);
	frame.setBounds(100, 100, 945, 528);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel cardsView = new JLabel("Visualizzazione schede clienti");
	cardsView.setBounds(0, 0, 929, 23);
	cardsView.setBackground(Color.DARK_GRAY);
	cardsView.setHorizontalAlignment(SwingConstants.CENTER);
	cardsView.setForeground(Color.RED);
	cardsView.setFont(new Font("Verdana", Font.BOLD, 18));
	frame.getContentPane().add(cardsView);

	JScrollPane cardsViewScrollPane = new JScrollPane();
	cardsViewScrollPane.setBounds(10, 34, 209, 444);
	frame.getContentPane().add(cardsViewScrollPane);

	this.textAreaCard = new JTextArea();
	textAreaCard.setEnabled(false);
	textAreaCard.setBackground(Color.BLACK);
	textAreaCard.setForeground(Color.PINK);
	textAreaCard.setFont(new Font("Verdana", Font.BOLD, 12));
	cardsViewScrollPane.setViewportView(textAreaCard);

	JLabel titleLabelCard = new JLabel("Codice scheda");
	titleLabelCard.setHorizontalAlignment(SwingConstants.CENTER);
	titleLabelCard.setForeground(Color.BLACK);
	titleLabelCard.setBackground(Color.BLACK);
	titleLabelCard.setFont(new Font("Verdana", Font.BOLD, 12));
	cardsViewScrollPane.setColumnHeaderView(titleLabelCard);

	JLabel viewTitle = new JLabel("Inserisci codice");
	viewTitle.setForeground(Color.ORANGE);
	viewTitle.setHorizontalAlignment(SwingConstants.CENTER);
	viewTitle.setFont(new Font("Verdana", Font.BOLD, 12));
	viewTitle.setBounds(643, 34, 276, 23);
	frame.getContentPane().add(viewTitle);

	codeField = new JTextField();
	codeField.setBackground(Color.BLACK);
	codeField.setForeground(Color.PINK);
	codeField.setFont(new Font("Verdana", Font.BOLD, 12));
	codeField.setBounds(665, 59, 254, 20);
	frame.getContentPane().add(codeField);
	codeField.setColumns(10);

	JButton goToCard = new JButton("Vedi Scheda");
	goToCard.addActionListener(e -> {
	    var chosenClient = this.codeField.getText();
	    this.chosenCard = new ClientCard(chosenClient, this.logic);
	    this.chosenCard.getFrame().setVisible(true);
	    this.frame.dispose();
	});

	goToCard.setForeground(Color.ORANGE);
	goToCard.setBackground(Color.DARK_GRAY);
	goToCard.setFont(new Font("Verdana", Font.BOLD, 12));
	goToCard.setBounds(665, 90, 254, 23);
	frame.getContentPane().add(goToCard);

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

		/*
		 * Query for cards code.
		 */
		result = this.fillSurname("codFiscale", false);
		while (result.next()) {
		    int row = result.getRow();

		    for (int i = 0; i < row; i++) {
			this.textAreaSurname.append(result.getString(1) + "\n");
		    }
		}
	    } catch (SQLException e1) {
		e1.printStackTrace();
	    }
	});

	viewAllBtn.setForeground(Color.ORANGE);
	viewAllBtn.setBackground(Color.DARK_GRAY);
	viewAllBtn.setFont(new Font("Verdana", Font.BOLD, 12));
	viewAllBtn.setBounds(665, 184, 254, 23);
	frame.getContentPane().add(viewAllBtn);

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

		/*
		 * Query for cards code.
		 */
		result = this.fillSurname("codFiscale", true);
		while (result.next()) {
		    int row = result.getRow();

		    for (int i = 0; i < row; i++) {
			this.textAreaSurname.append(result.getString(1) + "\n");
		    }
		}
	    } catch (SQLException e1) {
		e1.printStackTrace();
	    }
	});
	viewActualBtn.setForeground(Color.ORANGE);
	viewActualBtn.setBackground(Color.DARK_GRAY);
	viewActualBtn.setFont(new Font("Verdana", Font.BOLD, 12));
	viewActualBtn.setBounds(665, 222, 254, 23);
	frame.getContentPane().add(viewActualBtn);

	JButton logout = new JButton("Logout");
	logout.setForeground(Color.ORANGE);
	logout.setBackground(Color.DARK_GRAY);
	logout.setFont(new Font("Verdana", Font.BOLD, 12));
	logout.setBounds(699, 455, 220, 23);
	logout.addActionListener(e -> {
	    this.frame.dispose();
	    this.logic.logout();
	});
	frame.getContentPane().add(logout);

	JScrollPane roomViewScrollPane = new JScrollPane();
	roomViewScrollPane.setBounds(226, 34, 209, 444);
	frame.getContentPane().add(roomViewScrollPane);

	JLabel lblNumeroCamera = new JLabel("Numero camera");
	lblNumeroCamera.setHorizontalAlignment(SwingConstants.CENTER);
	lblNumeroCamera.setForeground(Color.BLACK);
	lblNumeroCamera.setFont(new Font("Verdana", Font.BOLD, 12));
	lblNumeroCamera.setBackground(Color.BLACK);
	roomViewScrollPane.setColumnHeaderView(lblNumeroCamera);

	this.textAreaRoom = new JTextArea();
	textAreaRoom.setEnabled(false);
	textAreaRoom.setForeground(Color.PINK);
	textAreaRoom.setFont(new Font("Verdana", Font.BOLD, 12));
	textAreaRoom.setBackground(Color.BLACK);
	roomViewScrollPane.setViewportView(textAreaRoom);

	JScrollPane surnameViewScrollPane = new JScrollPane();
	surnameViewScrollPane.setBounds(446, 34, 209, 444);
	frame.getContentPane().add(surnameViewScrollPane);

	JLabel surnameLabel = new JLabel("Cognome");
	surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	surnameLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	surnameLabel.setForeground(Color.BLACK);
	surnameLabel.setBackground(Color.BLACK);
	surnameViewScrollPane.setColumnHeaderView(surnameLabel);

	this.textAreaSurname = new JTextArea();
	textAreaSurname.setForeground(Color.PINK);
	textAreaSurname.setFont(new Font("Verdana", Font.BOLD, 12));
	textAreaSurname.setBackground(Color.BLACK);
	surnameViewScrollPane.setViewportView(textAreaSurname);
    }

    /**
     * Calls a query for recovering a specific data from SOGGIORNO table.
     * 
     * @param cell
     * @param value
     * @return
     */
    private ResultSet fillPage(final String cell, final boolean value) {
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;

	try {
	    if (value) {
		/*
		 * NOT NULL connection.
		 */
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
			this.logic.getOwnPassword());
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("SELECT " + cell + " FROM SOGGIORNO " + "WHERE soggiornante = 1");
		return myRs;
	    } else {
		/*
		 * with NULL connection.
		 */
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
			this.logic.getOwnPassword());
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("SELECT " + cell + " FROM SOGGIORNO");

		return myRs;
	    }

	} catch (Exception exc) {
	    exc.printStackTrace();
	}

	return myRs;
    }

    /**
     * Recovers all surnames from CLIENTE tables.
     * 
     * @param cell
     * @param value
     * @return set with surnames.
     */
    private ResultSet fillSurname(final String cell, final boolean value) {
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;

	try {
	    if (value) {
		/*
		 * NOT NULL connection.
		 */
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
			this.logic.getOwnPassword());
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("SELECT " + cell + " FROM CLIENTE, SOGGIORNO " + "WHERE soggiornante = 1");
		return myRs;
	    } else {
		/*
		 * with NULL connection.
		 */
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
			this.logic.getOwnPassword());
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("SELECT " + cell + " FROM CLIENTE");

		return myRs;
	    }

	} catch (Exception exc) {
	    exc.printStackTrace();
	}

	return myRs;
    }

    /**
     * @return actual frame.
     */
    public JFrame getFrame() {
	return this.frame;
    }
}
