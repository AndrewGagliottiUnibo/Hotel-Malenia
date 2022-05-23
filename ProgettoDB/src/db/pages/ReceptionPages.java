package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ReceptionPages {

	private JFrame frame;
	private JTextField txtBenvenutoreceptionist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionPages window = new ReceptionPages();
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
	public ReceptionPages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtBenvenutoreceptionist = new JTextField();
		txtBenvenutoreceptionist.setForeground(Color.RED);
		txtBenvenutoreceptionist.setBackground(Color.DARK_GRAY);
		txtBenvenutoreceptionist.setHorizontalAlignment(SwingConstants.CENTER);
		txtBenvenutoreceptionist.setText("BENVENUTO @RECEPTIONIST");
		txtBenvenutoreceptionist.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtBenvenutoreceptionist.setBounds(0, 0, 929, 43);
		frame.getContentPane().add(txtBenvenutoreceptionist);
		txtBenvenutoreceptionist.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERISCI PRENOTAZIONE");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 92, 385, 93);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("LOGOUT");
		btnNewButton_2.setForeground(Color.ORANGE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNewButton_2.setBounds(0, 455, 929, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnCanellaPrenotazione = new JButton("CANCELLA PRENOTAZIONE");
		btnCanellaPrenotazione.setBackground(Color.DARK_GRAY);
		btnCanellaPrenotazione.setForeground(Color.ORANGE);
		btnCanellaPrenotazione.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnCanellaPrenotazione.setBounds(10, 209, 385, 93);
		frame.getContentPane().add(btnCanellaPrenotazione);
		
		JButton btnRegistraCliente = new JButton("REGISTRA CLIENTE");
		btnRegistraCliente.setBackground(Color.DARK_GRAY);
		btnRegistraCliente.setForeground(Color.ORANGE);
		btnRegistraCliente.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnRegistraCliente.setBounds(534, 209, 385, 93);
		frame.getContentPane().add(btnRegistraCliente);
		
		JButton btnVisualizzaResoconto = new JButton("VISUALIZZA SCHEDE");
		btnVisualizzaResoconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualizzaResoconto.setBackground(Color.DARK_GRAY);
		btnVisualizzaResoconto.setForeground(Color.ORANGE);
		btnVisualizzaResoconto.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnVisualizzaResoconto.setBounds(534, 92, 385, 93);
		frame.getContentPane().add(btnVisualizzaResoconto);
		
		JButton btnClientiInStruttura = new JButton("CLIENTI IN STRUTTURA");
		btnClientiInStruttura.setForeground(Color.ORANGE);
		btnClientiInStruttura.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnClientiInStruttura.setBackground(Color.DARK_GRAY);
		btnClientiInStruttura.setBounds(272, 313, 385, 93);
		frame.getContentPane().add(btnClientiInStruttura);
	}
}
