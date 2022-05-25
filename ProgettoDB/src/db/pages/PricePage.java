package db.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PricePage {

	private JFrame frmListini;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PricePage window = new PricePage();
					window.frmListini.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frmListini.setTitle("Listini");
		frmListini.setBounds(100, 100, 945, 528);
		frmListini.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
