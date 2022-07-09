package db.pages.specific;

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

public class AllReservations {

	private JFrame frmPrenotazioni;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	
	/**
	 * Create the application.
	 */
	public AllReservations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrenotazioni = new JFrame();
		frmPrenotazioni.getContentPane().setForeground(Color.ORANGE);
		frmPrenotazioni.getContentPane().setFont(new Font("Verdana", Font.BOLD, 12));
		frmPrenotazioni.getContentPane().setBackground(Color.DARK_GRAY);
		frmPrenotazioni.setTitle("Prenotazioni");
		frmPrenotazioni.setBounds(100, 100, 945, 528);
		frmPrenotazioni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrenotazioni.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prenotazioni");
		lblNewLabel.setBounds(0, 0, 929, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		frmPrenotazioni.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 680, 452);
		frmPrenotazioni.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Tipo prenotazione", "Data", "Ora", "Scheda", "Camera"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		JLabel viewSpecificLabel = new JLabel("Vedi prenotazioni per scheda");
		viewSpecificLabel.setForeground(Color.ORANGE);
		viewSpecificLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		viewSpecificLabel.setBackground(Color.DARK_GRAY);
		viewSpecificLabel.setBounds(700, 127, 219, 14);
		frmPrenotazioni.getContentPane().add(viewSpecificLabel);
		
		JButton showAll = new JButton("Vedi prenotazioni");
		showAll.setForeground(Color.ORANGE);
		showAll.setFont(new Font("Verdana", Font.BOLD, 12));
		showAll.setBackground(Color.DARK_GRAY);
		showAll.setBounds(700, 26, 219, 23);
		frmPrenotazioni.getContentPane().add(showAll);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.BOLD, 12));
		textField.setForeground(Color.PINK);
		textField.setBackground(Color.BLACK);
		textField.setBounds(700, 152, 219, 20);
		frmPrenotazioni.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton commitSpecificBtn = new JButton("Vedi");
		commitSpecificBtn.setForeground(Color.ORANGE);
		commitSpecificBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		commitSpecificBtn.setBackground(Color.DARK_GRAY);
		commitSpecificBtn.setBounds(700, 182, 219, 23);
		frmPrenotazioni.getContentPane().add(commitSpecificBtn);
		
		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(830, 455, 89, 23);
		frmPrenotazioni.getContentPane().add(logout);
		
		JButton backBtn = new JButton("Indietro");
		backBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		backBtn.setForeground(Color.ORANGE);
		backBtn.setBackground(Color.DARK_GRAY);
		backBtn.setBounds(731, 455, 89, 23);
		frmPrenotazioni.getContentPane().add(backBtn);
		
		JLabel codeCardLabel = new JLabel("Inserisci codice prenotazione");
		codeCardLabel.setForeground(Color.ORANGE);
		codeCardLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		codeCardLabel.setBackground(Color.DARK_GRAY);
		codeCardLabel.setBounds(700, 298, 219, 14);
		frmPrenotazioni.getContentPane().add(codeCardLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.BOLD, 12));
		textField_1.setForeground(Color.PINK);
		textField_1.setBackground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(700, 323, 219, 20);
		frmPrenotazioni.getContentPane().add(textField_1);
		
		JButton deleteReservationBtn = new JButton("Cancella");
		deleteReservationBtn.setForeground(Color.ORANGE);
		deleteReservationBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		deleteReservationBtn.setBackground(Color.DARK_GRAY);
		deleteReservationBtn.setBounds(700, 353, 219, 23);
		frmPrenotazioni.getContentPane().add(deleteReservationBtn);
	}

	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frmPrenotazioni;
	}
}
