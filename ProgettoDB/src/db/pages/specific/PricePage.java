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
import db.logic.Logic;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

public class PricePage {

	private JFrame frmListini;
	private JTextField productNameField;
	private JTextField priceNameField;
	private JTextArea textArea;
	private Logic logic;

	/**
	 * Constructor.
	 */
	public PricePage(final Logic logic) {
		this.logic = logic;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListini = new JFrame();
		frmListini.setResizable(false);
		frmListini.getContentPane().setBackground(Color.DARK_GRAY);
		frmListini.setTitle("Listini");
		frmListini.setBounds(100, 100, 945, 528);
		frmListini.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListini.getContentPane().setLayout(null);
		
		JLabel pricesGestion = new JLabel("Gestione listini");
		pricesGestion.setBounds(0, 0, 929, 23);
		pricesGestion.setHorizontalAlignment(SwingConstants.CENTER);
		pricesGestion.setForeground(Color.RED);
		pricesGestion.setFont(new Font("Verdana", Font.BOLD, 18));
		frmListini.getContentPane().add(pricesGestion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 442, 428);
		frmListini.getContentPane().add(scrollPane);
		
		this.textArea = new JTextArea();
		textArea.setForeground(Color.PINK);
		textArea.setFont(new Font("Verdana", Font.BOLD, 12));
		textArea.setBackground(Color.BLACK);
		scrollPane.setViewportView(textArea);
		
		JButton showPricesServices = new JButton("Vedi tariffe servizi");
		showPricesServices.addActionListener(new ActionListener() {
		});
		showPricesServices.addActionListener(e -> {
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			try {
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root" , this.logic.getOwnPassword());
				System.out.println("Database connected");
				// 2. Create a statement
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("SELECT * FROM LISTINI");
				while(myRs.next()) {
					this.textArea.append(myRs.getString(1) + "\n");
				}
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		});
		showPricesServices.setForeground(Color.ORANGE);
		showPricesServices.setBackground(Color.DARK_GRAY);
		showPricesServices.setFont(new Font("Verdana", Font.BOLD, 12));
		showPricesServices.setBounds(10, 23, 195, 23);
		frmListini.getContentPane().add(showPricesServices);
		
		JLabel insertNameLabel = new JLabel("Inserisci il prodotto da modificare");
		insertNameLabel.setForeground(Color.ORANGE);
		insertNameLabel.setBackground(Color.DARK_GRAY);
		insertNameLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		insertNameLabel.setBounds(466, 34, 453, 14);
		frmListini.getContentPane().add(insertNameLabel);
		
		productNameField = new JTextField();
		productNameField.setForeground(Color.PINK);
		productNameField.setBackground(Color.BLACK);
		productNameField.setBounds(466, 59, 453, 20);
		frmListini.getContentPane().add(productNameField);
		productNameField.setColumns(10);
		
		JLabel insertPriceField = new JLabel("Inserisci il prezzo");
		insertPriceField.setForeground(Color.ORANGE);
		insertPriceField.setBackground(Color.DARK_GRAY);
		insertPriceField.setFont(new Font("Verdana", Font.BOLD, 12));
		insertPriceField.setBounds(466, 90, 453, 14);
		frmListini.getContentPane().add(insertPriceField);
		
		priceNameField = new JTextField();
		priceNameField.setFont(new Font("Verdana", Font.BOLD, 12));
		priceNameField.setForeground(Color.PINK);
		priceNameField.setColumns(10);
		priceNameField.setBackground(Color.BLACK);
		priceNameField.setBounds(466, 115, 453, 20);
		frmListini.getContentPane().add(priceNameField);
		
		JButton applyBtn = new JButton("Applica");
		applyBtn.addActionListener(e -> {
			this.logic.modifyPrice(Integer.parseInt(this.priceNameField.getText()), this.productNameField.getText());
			this.productNameField.setText("");
			this.priceNameField.setText("");
		});
		
		applyBtn.setForeground(Color.ORANGE);
		applyBtn.setBackground(Color.DARK_GRAY);
		applyBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		applyBtn.setBounds(462, 146, 457, 23);
		frmListini.getContentPane().add(applyBtn);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(e -> {
			frmListini.dispose();
			this.logic.logout();
		});
				
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(830, 455, 89, 23);
		frmListini.getContentPane().add(logout);
		
		JButton showPricesVacationTypes = new JButton("Vedi tariffe soggiorni");
		showPricesVacationTypes.setForeground(Color.ORANGE);
		showPricesVacationTypes.setFont(new Font("Verdana", Font.BOLD, 12));
		showPricesVacationTypes.setBackground(Color.DARK_GRAY);
		showPricesVacationTypes.setBounds(257, 23, 195, 23);
		frmListini.getContentPane().add(showPricesVacationTypes);
	}
	
	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frmListini;
	}
}
