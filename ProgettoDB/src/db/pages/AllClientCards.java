package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class AllClientCards {

	private JFrame frame;
	private JTextField codeField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllClientCards window = new AllClientCards();
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
	public AllClientCards() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		cardsViewScrollPane.setBounds(10, 34, 754, 444);
		frame.getContentPane().add(cardsViewScrollPane);
		
		table = new JTable();
		cardsViewScrollPane.setViewportView(table);
		
		JLabel viewTitle = new JLabel("Inserisci codice");
		viewTitle.setForeground(Color.ORANGE);
		viewTitle.setHorizontalAlignment(SwingConstants.CENTER);
		viewTitle.setFont(new Font("Verdana", Font.BOLD, 12));
		viewTitle.setBounds(774, 34, 145, 23);
		frame.getContentPane().add(viewTitle);
		
		codeField = new JTextField();
		codeField.setBackground(Color.BLACK);
		codeField.setForeground(Color.PINK);
		codeField.setFont(new Font("Verdana", Font.BOLD, 12));
		codeField.setBounds(774, 59, 145, 20);
		frame.getContentPane().add(codeField);
		codeField.setColumns(10);
		
		JButton goToCard = new JButton("Vedi Scheda");
		goToCard.setForeground(Color.ORANGE);
		goToCard.setBackground(Color.DARK_GRAY);
		goToCard.setFont(new Font("Verdana", Font.BOLD, 12));
		goToCard.setBounds(774, 90, 145, 23);
		frame.getContentPane().add(goToCard);
		
		JButton viewAllBtn = new JButton("Vedi tutte");
		viewAllBtn.setForeground(Color.ORANGE);
		viewAllBtn.setBackground(Color.DARK_GRAY);
		viewAllBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		viewAllBtn.setBounds(774, 184, 145, 23);
		frame.getContentPane().add(viewAllBtn);
		
		JButton viewActualBtn = new JButton("Vedi attuali");
		viewActualBtn.setForeground(Color.ORANGE);
		viewActualBtn.setBackground(Color.DARK_GRAY);
		viewActualBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		viewActualBtn.setBounds(774, 222, 145, 23);
		frame.getContentPane().add(viewActualBtn);
		
		JButton logout = new JButton("Logout");
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBounds(830, 455, 89, 23);
		frame.getContentPane().add(logout);
	}
}
