package db.pages.specific;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import db.logic.Logic;

public class AllClientCards {

	private JFrame frmSchedeClienti;
	private JTextField codeField;
	private JTable table;
	private ClientCard chosenCard;
	private Logic logic;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public AllClientCards() {
		initialize();
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
		cardsViewScrollPane.setBounds(10, 34, 754, 444);
		frmSchedeClienti.getContentPane().add(cardsViewScrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Codice", "Stanza", "Cognome", "Soggiorno", "Inizio", "Fine", "Resoconto"
			}
		));
		table.setFont(new Font("Monospaced", Font.PLAIN, 13));
		cardsViewScrollPane.setViewportView(table);
		
		JLabel viewTitle = new JLabel("Inserisci codice");
		viewTitle.setForeground(Color.ORANGE);
		viewTitle.setHorizontalAlignment(SwingConstants.CENTER);
		viewTitle.setFont(new Font("Verdana", Font.BOLD, 12));
		viewTitle.setBounds(774, 34, 145, 23);
		frmSchedeClienti.getContentPane().add(viewTitle);
		
		codeField = new JTextField();
		codeField.setBackground(Color.BLACK);
		codeField.setForeground(Color.PINK);
		codeField.setFont(new Font("Verdana", Font.BOLD, 12));
		codeField.setBounds(774, 59, 145, 20);
		frmSchedeClienti.getContentPane().add(codeField);
		codeField.setColumns(10);
		
		JButton goToCard = new JButton("Vedi Scheda");
		goToCard.addActionListener(e -> {
			var chosenClient = this.codeField.getText();
			
			//Query here
			this.chosenCard = new ClientCard(chosenClient);
			this.chosenCard.getFrame().setVisible(true);
			this.frmSchedeClienti.dispose();
			
		});
		goToCard.setForeground(Color.ORANGE);
		goToCard.setBackground(Color.DARK_GRAY);
		goToCard.setFont(new Font("Verdana", Font.BOLD, 12));
		goToCard.setBounds(774, 90, 145, 23);
		frmSchedeClienti.getContentPane().add(goToCard);
		
		JButton viewAllBtn = new JButton("Vedi tutte");
		viewAllBtn.addActionListener(e -> {
			
			//Query here
		});
		viewAllBtn.setForeground(Color.ORANGE);
		viewAllBtn.setBackground(Color.DARK_GRAY);
		viewAllBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		viewAllBtn.setBounds(774, 184, 145, 23);
		frmSchedeClienti.getContentPane().add(viewAllBtn);
		
		JButton viewActualBtn = new JButton("Vedi attuali");
		viewActualBtn.addActionListener(e -> {
			
			//Query here
		});
		viewActualBtn.setForeground(Color.ORANGE);
		viewActualBtn.setBackground(Color.DARK_GRAY);
		viewActualBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		viewActualBtn.setBounds(774, 222, 145, 23);
		frmSchedeClienti.getContentPane().add(viewActualBtn);
		
		JButton logout = new JButton("Logout");
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBounds(830, 455, 89, 23);
		logout.addActionListener(e -> {
			this.frmSchedeClienti.dispose();
			this.logic.logout();
		});
		frmSchedeClienti.getContentPane().add(logout);
	}
	
	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frmSchedeClienti;
	}
}
