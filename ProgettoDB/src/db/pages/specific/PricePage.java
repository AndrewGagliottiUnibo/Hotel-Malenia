package db.pages.specific;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.logic.Logic;

public class PricePage {

    private JFrame frame;
    private JTextField serviceField;
    private JTextField priceServiceField;
    private JTextArea textArea;
    private JTextField seasonServiceField;
    private JTextField yearServiceField;
    private JTextField vacationField;
    private JTextField vacationPriceField;
    private JTextField monthVacationField;
    private JTextField yearVacationField;
    private JButton applyBtnVacation;
    private JButton modifyBtnVacation;
    private JButton modifyBtnService;
    private JButton applyBtnService;
    private JButton showPricesVacationTypes;
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
	frame = new JFrame();
	frame.setResizable(false);
	frame.getContentPane().setBackground(Color.DARK_GRAY);
	frame.setTitle("Listini");
	frame.setBounds(100, 100, 945, 528);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel pricesGestion = new JLabel("Gestione tariffe");
	pricesGestion.setBounds(0, 0, 929, 23);
	pricesGestion.setHorizontalAlignment(SwingConstants.CENTER);
	pricesGestion.setForeground(Color.RED);
	pricesGestion.setFont(new Font("Verdana", Font.BOLD, 18));
	frame.getContentPane().add(pricesGestion);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 50, 442, 428);
	frame.getContentPane().add(scrollPane);

	this.textArea = new JTextArea();
	textArea.setForeground(Color.PINK);
	textArea.setFont(new Font("Verdana", Font.BOLD, 12));
	textArea.setBackground(Color.BLACK);
	scrollPane.setViewportView(textArea);

	JLabel lblServiceField = new JLabel("Inserisci il servizio");
	lblServiceField.setForeground(Color.ORANGE);
	lblServiceField.setBackground(Color.DARK_GRAY);
	lblServiceField.setFont(new Font("Verdana", Font.BOLD, 12));
	lblServiceField.setBounds(466, 34, 226, 14);
	frame.getContentPane().add(lblServiceField);

	serviceField = new JTextField();
	serviceField.setForeground(Color.PINK);
	serviceField.setBackground(Color.BLACK);
	serviceField.setBounds(462, 52, 230, 20);
	frame.getContentPane().add(serviceField);
	serviceField.setColumns(10);

	JLabel lblPrice = new JLabel("Inserisci il prezzo del servizio");
	lblPrice.setForeground(Color.ORANGE);
	lblPrice.setBackground(Color.DARK_GRAY);
	lblPrice.setFont(new Font("Verdana", Font.BOLD, 12));
	lblPrice.setBounds(462, 83, 230, 14);
	frame.getContentPane().add(lblPrice);

	priceServiceField = new JTextField();
	priceServiceField.setFont(new Font("Verdana", Font.BOLD, 12));
	priceServiceField.setForeground(Color.PINK);
	priceServiceField.setColumns(10);
	priceServiceField.setBackground(Color.BLACK);
	priceServiceField.setBounds(462, 100, 230, 20);
	frame.getContentPane().add(priceServiceField);

	seasonServiceField = new JTextField();
	seasonServiceField.setForeground(Color.PINK);
	seasonServiceField.setFont(new Font("Verdana", Font.BOLD, 12));
	seasonServiceField.setColumns(10);
	seasonServiceField.setBackground(Color.BLACK);
	seasonServiceField.setBounds(462, 148, 230, 20);
	frame.getContentPane().add(seasonServiceField);

	JLabel lblSeason = new JLabel("Inserisci la stagione");
	lblSeason.setForeground(Color.ORANGE);
	lblSeason.setFont(new Font("Verdana", Font.BOLD, 12));
	lblSeason.setBackground(Color.DARK_GRAY);
	lblSeason.setBounds(462, 131, 230, 14);
	frame.getContentPane().add(lblSeason);

	yearServiceField = new JTextField();
	yearServiceField.setForeground(Color.PINK);
	yearServiceField.setFont(new Font("Verdana", Font.BOLD, 12));
	yearServiceField.setColumns(10);
	yearServiceField.setBackground(Color.BLACK);
	yearServiceField.setBounds(462, 196, 230, 20);
	frame.getContentPane().add(yearServiceField);

	JLabel lblYear = new JLabel("Inserisci l'anno");
	lblYear.setForeground(Color.ORANGE);
	lblYear.setFont(new Font("Verdana", Font.BOLD, 12));
	lblYear.setBackground(Color.DARK_GRAY);
	lblYear.setBounds(462, 179, 230, 14);
	frame.getContentPane().add(lblYear);

	vacationField = new JTextField();
	vacationField.setForeground(Color.PINK);
	vacationField.setFont(new Font("Verdana", Font.BOLD, 12));
	vacationField.setColumns(10);
	vacationField.setBackground(Color.BLACK);
	vacationField.setBounds(462, 262, 230, 20);
	frame.getContentPane().add(vacationField);

	JLabel lblVacation = new JLabel("Inserisci il soggiorno");
	lblVacation.setForeground(new Color(0, 128, 0));
	lblVacation.setFont(new Font("Verdana", Font.BOLD, 12));
	lblVacation.setBackground(Color.DARK_GRAY);
	lblVacation.setBounds(462, 245, 230, 14);
	frame.getContentPane().add(lblVacation);

	vacationPriceField = new JTextField();
	vacationPriceField.setForeground(Color.PINK);
	vacationPriceField.setFont(new Font("Verdana", Font.BOLD, 12));
	vacationPriceField.setColumns(10);
	vacationPriceField.setBackground(Color.BLACK);
	vacationPriceField.setBounds(462, 310, 230, 20);
	frame.getContentPane().add(vacationPriceField);

	JLabel lblPriceVacation = new JLabel("Inserisci il prezzo del soggiorno");
	lblPriceVacation.setForeground(new Color(0, 128, 0));
	lblPriceVacation.setFont(new Font("Verdana", Font.BOLD, 12));
	lblPriceVacation.setBackground(Color.DARK_GRAY);
	lblPriceVacation.setBounds(462, 293, 230, 14);
	frame.getContentPane().add(lblPriceVacation);

	monthVacationField = new JTextField();
	monthVacationField.setForeground(Color.PINK);
	monthVacationField.setFont(new Font("Verdana", Font.BOLD, 12));
	monthVacationField.setColumns(10);
	monthVacationField.setBackground(Color.BLACK);
	monthVacationField.setBounds(462, 358, 230, 20);
	frame.getContentPane().add(monthVacationField);

	JLabel monthVacationLbl = new JLabel("Inserisci il mese");
	monthVacationLbl.setForeground(new Color(0, 128, 0));
	monthVacationLbl.setFont(new Font("Verdana", Font.BOLD, 12));
	monthVacationLbl.setBackground(Color.DARK_GRAY);
	monthVacationLbl.setBounds(462, 341, 230, 14);
	frame.getContentPane().add(monthVacationLbl);

	yearVacationField = new JTextField();
	yearVacationField.setForeground(Color.PINK);
	yearVacationField.setFont(new Font("Verdana", Font.BOLD, 12));
	yearVacationField.setColumns(10);
	yearVacationField.setBackground(Color.BLACK);
	yearVacationField.setBounds(462, 408, 230, 20);
	frame.getContentPane().add(yearVacationField);

	JLabel yearVacationLbl = new JLabel("Inserisci l'anno");
	yearVacationLbl.setForeground(new Color(0, 128, 0));
	yearVacationLbl.setFont(new Font("Verdana", Font.BOLD, 12));
	yearVacationLbl.setBackground(Color.DARK_GRAY);
	yearVacationLbl.setBounds(462, 391, 230, 14);
	frame.getContentPane().add(yearVacationLbl);

	/*
	 * Show services prices.
	 */
	JButton showPricesServices = new JButton("Vedi tariffe servizi");
	showPricesServices.addActionListener(e -> {
	    Connection conn = null;
	    PreparedStatement myStm = null;
	    ResultSet result = null;
	    try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
			this.logic.getOwnPassword());
		myStm = conn.prepareStatement("SELECT * FROM SERVIZIO ORDER BY anno DESC");
		result = myStm.executeQuery();
		this.textArea.setText("");
		while (result.next()) {
		    this.textArea.append(result.getString(1) + "\t");
		    this.textArea.append(result.getString(2) + "\t");
		    this.textArea.append(result.getString(3).substring(0, 4) + "\t");
		    this.textArea.append("€ " + result.getString(4) + "\n");
		}
	    } catch (Exception exc) {
		exc.printStackTrace();
	    }

	});
	showPricesServices.setForeground(Color.ORANGE);
	showPricesServices.setBackground(Color.DARK_GRAY);
	showPricesServices.setFont(new Font("Verdana", Font.BOLD, 12));
	showPricesServices.setBounds(10, 23, 195, 23);
	frame.getContentPane().add(showPricesServices);

	/*
	 * Show vacation type prices.
	 */
	showPricesVacationTypes = new JButton("Vedi tariffe soggiorni");
	showPricesVacationTypes.addActionListener(e -> {
	    Connection conn = null;
	    PreparedStatement myStm = null;
	    ResultSet result = null;
	    try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemahotel", "root",
			this.logic.getOwnPassword());
		myStm = conn.prepareStatement("SELECT * FROM TIPOLOGIASOGGIORNO ORDER BY anno DESC");
		result = myStm.executeQuery();
		this.textArea.setText("");
		while (result.next()) {
		    this.textArea.append(result.getString(1) + "\t");
		    this.textArea.append(result.getString(2) + "\t");
		    this.textArea.append(result.getString(3).substring(0, 4) + "\t");
		    this.textArea.append("€ " + result.getString(4) + "\n");
		}
	    } catch (Exception exc) {
		exc.printStackTrace();
	    }

	});
	showPricesVacationTypes.setForeground(Color.ORANGE);
	showPricesVacationTypes.setFont(new Font("Verdana", Font.BOLD, 12));
	showPricesVacationTypes.setBackground(Color.DARK_GRAY);
	showPricesVacationTypes.setBounds(257, 23, 195, 23);
	frame.getContentPane().add(showPricesVacationTypes);

	/*
	 * Modify a service.
	 */
	this.modifyBtnService = new JButton("Modifica presente");
	modifyBtnService.setForeground(Color.ORANGE);
	modifyBtnService.setFont(new Font("Verdana", Font.BOLD, 12));
	modifyBtnService.setBackground(Color.DARK_GRAY);
	modifyBtnService.setBounds(720, 148, 171, 45);
	this.modifyBtnService.addActionListener(e -> {
	    this.logic.updateService(this.serviceField.getText(), this.seasonServiceField.getText(),
		    Integer.parseInt(this.yearServiceField.getText()),
		    Integer.parseInt(this.priceServiceField.getText()));
	});
	frame.getContentPane().add(modifyBtnService);

	/*
	 * Modify a vacation type.
	 */
	this.modifyBtnVacation = new JButton("Modifica presente");
	modifyBtnVacation.setForeground(new Color(0, 128, 0));
	modifyBtnVacation.setFont(new Font("Verdana", Font.BOLD, 12));
	modifyBtnVacation.setBackground(Color.DARK_GRAY);
	modifyBtnVacation.setBounds(720, 358, 171, 45);
	this.modifyBtnVacation.addActionListener(e -> {
	    this.logic.updateVacationType(this.vacationField.getText(), this.monthVacationField.getText(),
		    Integer.parseInt(this.yearVacationField.getText()),
		    Integer.parseInt(this.vacationPriceField.getText()));
	});
	frame.getContentPane().add(modifyBtnVacation);

	/*
	 * Apply a new service.
	 */
	this.applyBtnService = new JButton("Applica nuovo");
	applyBtnService.addActionListener(e -> {
	    this.logic.insertService(this.serviceField.getText(), this.seasonServiceField.getText(),
		    Integer.parseInt(this.yearServiceField.getText()),
		    Integer.parseInt(this.priceServiceField.getText()));
	});

	applyBtnService.setForeground(Color.ORANGE);
	applyBtnService.setBackground(Color.DARK_GRAY);
	applyBtnService.setFont(new Font("Verdana", Font.BOLD, 12));
	applyBtnService.setBounds(720, 83, 171, 45);
	frame.getContentPane().add(applyBtnService);

	/*
	 * Apply a new vacation type.
	 */
	this.applyBtnVacation = new JButton("Applica nuovo");
	applyBtnVacation.setForeground(new Color(0, 128, 0));
	applyBtnVacation.setFont(new Font("Verdana", Font.BOLD, 12));
	applyBtnVacation.setBackground(Color.DARK_GRAY);
	applyBtnVacation.setBounds(720, 285, 171, 45);
	this.applyBtnVacation.addActionListener(e -> {
	    this.logic.insertVacationType(this.vacationField.getText(), this.monthVacationField.getText(),
		    Integer.parseInt(this.yearVacationField.getText()),
		    Integer.parseInt(this.vacationPriceField.getText()));
	});
	frame.getContentPane().add(applyBtnVacation);

	/*
	 * Logout button.
	 */
	JButton logout = new JButton("Logout");
	logout.addActionListener(e -> {
	    frame.dispose();
	    this.logic.logout();
	});

	logout.setFont(new Font("Verdana", Font.BOLD, 12));
	logout.setForeground(Color.ORANGE);
	logout.setBackground(Color.DARK_GRAY);
	logout.setBounds(830, 455, 89, 23);
	frame.getContentPane().add(logout);
    }

    /**
     * @return actual frame.
     */
    public JFrame getFrame() {
	return this.frame;
    }
}
