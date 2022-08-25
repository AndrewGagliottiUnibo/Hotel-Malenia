package db.pages;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import db.logic.Logic;

public class ReceptionPages {

	private JFrame frame;
	private JTextField txtBenvenutoreceptionist;
	private Logic logic; 
	
	/**
	 * Constructor.
	 * @param logic of the application
	 */
	public ReceptionPages(final Logic logic) {
		initialize();
		this.logic = logic;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Hotel Malenia - Reception");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtBenvenutoreceptionist = new JTextField();
		txtBenvenutoreceptionist.setForeground(Color.RED);
		txtBenvenutoreceptionist.setBackground(Color.DARK_GRAY);
		txtBenvenutoreceptionist.setHorizontalAlignment(SwingConstants.CENTER);
		txtBenvenutoreceptionist.setText("Receptionist");
		txtBenvenutoreceptionist.setFont(new Font("Verdana", Font.BOLD, 18));
		txtBenvenutoreceptionist.setBounds(0, 0, 929, 43);
		frame.getContentPane().add(txtBenvenutoreceptionist);
		txtBenvenutoreceptionist.setColumns(10);

		/*
		 * Go to specific view for all reservations.
		 */
		JButton preno = new JButton("Prenotazioni");
		preno.addActionListener(e -> {
			this.frame.setVisible(false);
			this.logic.goToSpecificPage("AllReservations", this.frame);
		});
		
		preno.setBackground(Color.DARK_GRAY);
		preno.setForeground(Color.ORANGE);
		preno.setFont(new Font("Verdana", Font.BOLD, 12));
		preno.setBounds(272, 75, 385, 75);
		frame.getContentPane().add(preno);

		/*
		 * Logout from application part
		 */
		JButton logout = new JButton("Logout");
		logout.addActionListener(e -> {
			this.frame.dispose();
			this.logic.logout();	
		});
		
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBounds(744, 428, 156, 34);
		frame.getContentPane().add(logout);

		/*
		 * Go to specific view for register a new client.
		 */
		JButton btnRegistraCliente = new JButton("Registra cliente");
		btnRegistraCliente.addActionListener(e -> {
			this.frame.setVisible(false);
			this.logic.goToSpecificPage("Registration", this.frame);
		});

		btnRegistraCliente.setBackground(Color.DARK_GRAY);
		btnRegistraCliente.setForeground(Color.ORANGE);
		btnRegistraCliente.setFont(new Font("Verdana", Font.BOLD, 12));
		btnRegistraCliente.setBounds(272, 161, 385, 75);
		frame.getContentPane().add(btnRegistraCliente);

		/*
		 * Go to specific view of all clients in the hotel.
		 */
		JButton btnClientiInStruttura = new JButton("Clienti in hotel");
		btnClientiInStruttura.addActionListener(e -> {
			this.frame.setVisible(false);
			this.logic.goToSpecificPage("AllCards", this.frame);
		});
		
		btnClientiInStruttura.setForeground(Color.ORANGE);
		btnClientiInStruttura.setFont(new Font("Verdana", Font.BOLD, 12));
		btnClientiInStruttura.setBackground(Color.DARK_GRAY);
		btnClientiInStruttura.setBounds(272, 247, 385, 75);
		frame.getContentPane().add(btnClientiInStruttura);
	}
	
	/**
	 * @return actual frame.
	 */
	public JFrame getFrame() {
		return this.frame;
	}
}
