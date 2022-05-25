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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;

public class ClientsCardView {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

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
		specificCardView.setBounds(727, 58, 129, 23);
		cardsView.add(specificCardView);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 713, 444);
		cardsView.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setBackground(Color.LIGHT_GRAY);
		table.setFont(new Font("Verdana", Font.BOLD, 12));
		table.setBounds(0, 21, 700, 423);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Codice", "Stanza", "Cognome", "Soggiorno", "Data inizio", "Data fine", "Resoconto"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		panel.add(table);
		
		JLabel codeLabel = new JLabel("Codice");
		codeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		codeLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		codeLabel.setBounds(0, 0, 99, 20);
		panel.add(codeLabel);
		
		JLabel roomLabel = new JLabel("Stanza");
		roomLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		roomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roomLabel.setBounds(100, 0, 99, 20);
		panel.add(roomLabel);
		
		JLabel surnameLabel = new JLabel("Cognome");
		surnameLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLabel.setBounds(200, 0, 99, 20);
		panel.add(surnameLabel);
		
		JLabel endLabel = new JLabel("Fine");
		endLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		endLabel.setHorizontalAlignment(SwingConstants.CENTER);
		endLabel.setBounds(501, 0, 99, 20);
		panel.add(endLabel);
		
		JLabel beginLabel = new JLabel("Inizio");
		beginLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		beginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		beginLabel.setBounds(401, 0, 99, 20);
		panel.add(beginLabel);
		
		JLabel moneyLabel = new JLabel("Resoconto");
		moneyLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setBounds(601, 0, 99, 20);
		panel.add(moneyLabel);
		
		JLabel typeLabel = new JLabel("Soggiorno");
		typeLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setBounds(302, 0, 99, 20);
		panel.add(typeLabel);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(701, 0, 12, 444);
		panel.add(scrollBar);
		
		JLabel codeLabelForShow = new JLabel("Inserisci codice");
		codeLabelForShow.setForeground(Color.ORANGE);
		codeLabelForShow.setBackground(Color.DARK_GRAY);
		codeLabelForShow.setFont(new Font("Verdana", Font.BOLD, 12));
		codeLabelForShow.setBounds(727, 11, 129, 23);
		cardsView.add(codeLabelForShow);
		
		textField = new JTextField();
		textField.setForeground(Color.PINK);
		textField.setBackground(Color.BLACK);
		textField.setFont(new Font("Verdana", Font.BOLD, 12));
		textField.setBounds(727, 33, 129, 20);
		cardsView.add(textField);
		textField.setColumns(10);
		
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
