package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;

public class ClientsCardView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientsCardView window = new ClientsCardView();
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
	public ClientsCardView() {
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
		
		JLabel specificView = new JLabel("Visualizzazione schede");
		specificView.setHorizontalAlignment(SwingConstants.CENTER);
		specificView.setForeground(Color.RED);
		specificView.setFont(new Font("Verdana", Font.BOLD, 18));
		frame.getContentPane().add(specificView, BorderLayout.NORTH);
		
		JPanel cardsView = new JPanel();
		cardsView.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(cardsView, BorderLayout.CENTER);
		cardsView.setLayout(null);
		
		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(767, 432, 89, 23);
		cardsView.add(logout);
		
		JButton specificCardView = new JButton("Vedi dettagli");
		specificCardView.setFont(new Font("Verdana", Font.BOLD, 12));
		specificCardView.setForeground(Color.ORANGE);
		specificCardView.setBackground(Color.DARK_GRAY);
		specificCardView.setBounds(727, 11, 129, 23);
		cardsView.add(specificCardView);
		
		JPanel filters = new JPanel();
		filters.setBackground(Color.BLACK);
		frame.getContentPane().add(filters, BorderLayout.WEST);
		GridBagLayout gbl_filters = new GridBagLayout();
		gbl_filters.columnWidths = new int[]{0, 0};
		gbl_filters.rowHeights = new int[]{0, 0, 0};
		gbl_filters.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_filters.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		filters.setLayout(gbl_filters);
		
		JButton allCards = new JButton("Tutte");
		GridBagConstraints gbc_allCards = new GridBagConstraints();
		gbc_allCards.insets = new Insets(0, 0, 5, 0);
		gbc_allCards.gridx = 0;
		gbc_allCards.gridy = 0;
		filters.add(allCards, gbc_allCards);
		
		JButton actualCards = new JButton("Attuali");
		GridBagConstraints gbc_actualCards = new GridBagConstraints();
		gbc_actualCards.gridx = 0;
		gbc_actualCards.gridy = 1;
		filters.add(actualCards, gbc_actualCards);
	}
}
