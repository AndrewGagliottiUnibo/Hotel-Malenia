package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurantPages {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantPages window = new RestaurantPages();
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
	public RestaurantPages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Hotel Malenia - Ristorante");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 945, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel role = new JLabel("Servizio ristorazione");
		role.setHorizontalAlignment(SwingConstants.CENTER);
		role.setFont(new Font("Verdana", Font.BOLD, 18));
		role.setForeground(Color.RED);
		role.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(role, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.BOLD, 12));
		textArea.setEditable(false);
		textArea.setForeground(Color.PINK);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(0, 27, 508, 439);
		panel.add(textArea);
		
		JButton lunch = new JButton("Pranzo");
		lunch.setForeground(Color.BLACK);
		lunch.setFont(new Font("Verdana", Font.BOLD, 12));
		lunch.setBackground(Color.WHITE);
		lunch.setBounds(203, 0, 89, 23);
		panel.add(lunch);
		
		JButton breakfast = new JButton("Colazione");
		breakfast.setBackground(Color.WHITE);
		breakfast.setForeground(Color.BLACK);
		breakfast.setFont(new Font("Verdana", Font.BOLD, 12));
		breakfast.setBounds(0, 0, 119, 23);
		panel.add(breakfast);
		
		JButton dinner = new JButton("Cena");
		dinner.setForeground(Color.BLACK);
		dinner.setFont(new Font("Verdana", Font.BOLD, 12));
		dinner.setBackground(Color.WHITE);
		dinner.setBounds(418, 0, 89, 23);
		panel.add(dinner);
		
		JLabel roomNumber = new JLabel("Inserisci il numero di camera");
		roomNumber.setForeground(Color.ORANGE);
		roomNumber.setFont(new Font("Verdana", Font.BOLD, 12));
		roomNumber.setBackground(Color.DARK_GRAY);
		roomNumber.setBounds(565, 30, 223, 14);
		panel.add(roomNumber);
		
		textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.PINK);
		textField.setFont(new Font("Verdana", Font.BOLD, 12));
		textField.setBounds(565, 55, 193, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel productTitle = new JLabel("Seleziona un prodotto da addizionare");
		productTitle.setForeground(Color.ORANGE);
		productTitle.setFont(new Font("Verdana", Font.BOLD, 12));
		productTitle.setBackground(Color.DARK_GRAY);
		productTitle.setBounds(565, 86, 285, 14);
		panel.add(productTitle);
		
		JButton btnNewButton = new JButton("Caff\u00E9");
		btnNewButton.setBounds(518, 111, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnCappucino = new JButton("Cappucino");
		btnCappucino.setBounds(617, 111, 96, 23);
		panel.add(btnCappucino);
		
		JButton btnInfuso = new JButton("Infuso");
		btnInfuso.setBounds(822, 111, 89, 23);
		panel.add(btnInfuso);
		
		JButton btnVariante = new JButton("Variante");
		btnVariante.setBounds(518, 145, 89, 23);
		panel.add(btnVariante);
		
		JButton btnSpremuta = new JButton("Spremuta");
		btnSpremuta.setBounds(617, 145, 96, 23);
		panel.add(btnSpremuta);
		
		JButton btnSucco = new JButton("Succo");
		btnSucco.setBounds(518, 179, 89, 23);
		panel.add(btnSucco);
		
		JButton btnBevanda = new JButton("Bevanda");
		btnBevanda.setBounds(723, 111, 89, 23);
		panel.add(btnBevanda);
		
		JButton btnColazioneInCamera = new JButton("Colazione in camera");
		btnColazioneInCamera.setBounds(723, 145, 188, 23);
		panel.add(btnColazioneInCamera);
		
		JButton btnCaliceVino = new JButton("Calice Vino");
		btnCaliceVino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCaliceVino.setBounds(518, 213, 119, 23);
		panel.add(btnCaliceVino);
		
		JButton btnBottigliaVino = new JButton("Bottiglia Vino");
		btnBottigliaVino.setBounds(518, 242, 119, 23);
		panel.add(btnBottigliaVino);
		
		JButton btnBirraMedia = new JButton("Birra media");
		btnBirraMedia.setBounds(792, 179, 119, 23);
		panel.add(btnBirraMedia);
		
		JButton btnBirraGrande = new JButton("Birra Grande");
		btnBirraGrande.setBounds(792, 213, 119, 23);
		panel.add(btnBirraGrande);
		
		textField_1 = new JTextField();
		textField_1.setBounds(647, 214, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(647, 243, 86, 20);
		panel.add(textField_2);
		
		JButton btnSpritz = new JButton("Spritz");
		btnSpritz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSpritz.setBounds(518, 276, 89, 23);
		panel.add(btnSpritz);
		
		JButton btnCocktail = new JButton("Cocktail");
		btnCocktail.setBounds(743, 276, 89, 23);
		panel.add(btnCocktail);
		
		JButton btnAnalcolico = new JButton("Analcolico");
		btnAnalcolico.setBounds(617, 276, 116, 23);
		panel.add(btnAnalcolico);
		
		JTextArea newBuy = new JTextArea();
		newBuy.setEditable(false);
		newBuy.setBackground(Color.BLACK);
		newBuy.setForeground(Color.PINK);
		newBuy.setBounds(605, 312, 187, 22);
		panel.add(newBuy);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPages login = new LoginPages();
				login.frame.setVisible(true);
			}
		});
		logout.setForeground(Color.ORANGE);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBackground(Color.DARK_GRAY);
		logout.setBounds(812, 406, 89, 23);
		panel.add(logout);
	}
}
