package db.pages;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.logic.Logic;

public class PricePage {

	private JFrame frmListini;
	private JTextField productNameField;
	private JTextField priceNameField;
	private JTable table;
	private Logic logic;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PricePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListini = new JFrame();
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Prodotto", "Valore"
			}
		));
		table.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		JButton showPrices = new JButton("Vedi listini");
		showPrices.setForeground(Color.ORANGE);
		showPrices.setBackground(Color.DARK_GRAY);
		showPrices.setFont(new Font("Verdana", Font.BOLD, 12));
		showPrices.setBounds(10, 22, 167, 23);
		frmListini.getContentPane().add(showPrices);
		
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
		
		JButton allIncBtn = new JButton("Applica a All-inclusive");
		allIncBtn.setForeground(Color.ORANGE);
		allIncBtn.setBackground(Color.DARK_GRAY);
		allIncBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		allIncBtn.setBounds(462, 214, 457, 23);
		frmListini.getContentPane().add(allIncBtn);
		
		JButton bEBBtn = new JButton("Applica a B&B");
		bEBBtn.setForeground(Color.ORANGE);
		bEBBtn.setBackground(Color.DARK_GRAY);
		bEBBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		bEBBtn.setBounds(462, 146, 457, 23);
		frmListini.getContentPane().add(bEBBtn);
		
		JButton comPenBtn = new JButton("Applica a Pensione Completa");
		comPenBtn.setForeground(Color.ORANGE);
		comPenBtn.setBackground(Color.DARK_GRAY);
		comPenBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		comPenBtn.setBounds(462, 180, 457, 23);
		frmListini.getContentPane().add(comPenBtn);
		
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
	}
}
