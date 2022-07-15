package db.pages.specific;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.logic.Logic;

import javax.swing.JTextField;

public class ClientsInHotel {

	private JFrame frmClientiInStruttura;
	private JTable table;
	private JTextField textField;
	private ClientCard chosenCard;
	private Logic logic;

	/**
	 * Constructor.
	 */
	public ClientsInHotel(final Logic logic) {
		this.logic = logic;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientiInStruttura = new JFrame();
		frmClientiInStruttura.getContentPane().setBackground(Color.DARK_GRAY);
		frmClientiInStruttura.setTitle("Clienti in struttura");
		frmClientiInStruttura.setBounds(100, 100, 945, 528);
		frmClientiInStruttura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientiInStruttura.getContentPane().setLayout(null);

		JLabel title = new JLabel("Clienti attualmente presenti in struttura");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.RED);
		title.setFont(new Font("Verdana", Font.BOLD, 18));
		title.setBackground(Color.DARK_GRAY);
		title.setBounds(0, 0, 929, 23);
		frmClientiInStruttura.getContentPane().add(title);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 809, 453);
		frmClientiInStruttura.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Codice scheda", "Numero camera", "Cognome" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(table);

		JButton logout = new JButton("Logout");
		logout.addActionListener(e -> {
			this.frmClientiInStruttura.dispose();
			this.logic.logout();
		});
		logout.setForeground(Color.ORANGE);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(829, 455, 89, 23);
		frmClientiInStruttura.getContentPane().add(logout);

		JButton showAllBtn = new JButton("Vedi");
		showAllBtn.addActionListener(e -> {
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			myRs = this.logic.totalAmount();
			try {
				while (myRs.next()) {
					String s = myRs.getString(1);
				}
				myRs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		});
		showAllBtn.setForeground(Color.ORANGE);
		showAllBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		showAllBtn.setBackground(Color.DARK_GRAY);
		showAllBtn.setBounds(830, 25, 89, 23);
		frmClientiInStruttura.getContentPane().add(showAllBtn);

		JLabel codeLabel = new JLabel("Codice");
		codeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		codeLabel.setForeground(Color.ORANGE);
		codeLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		codeLabel.setBackground(Color.ORANGE);
		codeLabel.setBounds(829, 114, 90, 14);
		frmClientiInStruttura.getContentPane().add(codeLabel);

		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.BOLD, 12));
		textField.setForeground(Color.PINK);
		textField.setBackground(Color.BLACK);
		textField.setBounds(829, 139, 89, 20);
		frmClientiInStruttura.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnScheda = new JButton("Scheda");
		btnScheda.addActionListener(e -> {
			var choice = this.textField.getText();

			// Query here
			this.chosenCard = new ClientCard(choice, this.logic);
			this.chosenCard.getFrame().setVisible(true);
			this.frmClientiInStruttura.dispose();
			ResultSet myRs = null;
			try {
				myRs = this.logic.dataClient(Integer.parseInt(choice));  //visualizzare scheda cliente in base al n camera
				while (myRs.next()) {
					String s = myRs.getString(1);
					tableM
				}
				myRs.close();
			} catch (Exception exc) {
				exc.printStackTrace();
			}

		});
		btnScheda.setForeground(Color.ORANGE);
		btnScheda.setFont(new Font("Verdana", Font.BOLD, 12));
		btnScheda.setBackground(Color.DARK_GRAY);
		btnScheda.setBounds(829, 170, 89, 23);
		frmClientiInStruttura.getContentPane().add(btnScheda);
	}

	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frmClientiInStruttura;
	}
}
