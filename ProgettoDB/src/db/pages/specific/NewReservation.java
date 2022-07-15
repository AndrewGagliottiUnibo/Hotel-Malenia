package db.pages.specific;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;

import db.logic.Logic;

import javax.swing.JTextField;
import javax.swing.JButton;

public class NewReservation {

	private JFrame frmNuovaPrenotazione;
	private JTextField codeField;
	private JTextField dateField;
	private JTextField timeField;
	private JTextField parkingDaysField;
	private Logic logic;
	
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;

	/**
	 * Constructor.
	 */
	public NewReservation(final Logic logic) {
		this.logic = logic;
		this.initialize();initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuovaPrenotazione = new JFrame();
		frmNuovaPrenotazione.getContentPane().setForeground(Color.ORANGE);
		frmNuovaPrenotazione.getContentPane().setFont(new Font("Verdana", Font.BOLD, 12));
		frmNuovaPrenotazione.getContentPane().setBackground(Color.DARK_GRAY);
		frmNuovaPrenotazione.setTitle("Nuova prenotazione");
		frmNuovaPrenotazione.setBounds(100, 100, 945, 528);
		frmNuovaPrenotazione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNuovaPrenotazione.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Nuova prenotazione");
		title.setBounds(0, 0, 929, 23);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.RED);
		title.setFont(new Font("Verdana", Font.BOLD, 18));
		frmNuovaPrenotazione.getContentPane().add(title);
		
		JLabel cardLabel = new JLabel("Codice scheda");
		cardLabel.setForeground(Color.ORANGE);
		cardLabel.setBackground(Color.DARK_GRAY);
		cardLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		cardLabel.setBounds(10, 74, 138, 23);
		frmNuovaPrenotazione.getContentPane().add(cardLabel);
		
		codeField = new JTextField();
		codeField.setForeground(Color.PINK);
		codeField.setBackground(Color.BLACK);
		codeField.setFont(new Font("Verdana", Font.BOLD, 12));
		codeField.setColumns(10);
		codeField.setBounds(10, 108, 209, 20);
		frmNuovaPrenotazione.getContentPane().add(codeField);
		
		JButton breakfastPlus = new JButton("Colazione +");
		breakfastPlus.addActionListener(e -> {
			
			var client = this.codeField.getText();
			this.logic.registerNewReservation(Integer.parseInt(this.codeField.getText()), Integer.parseInt(this.dateField.getText()),
					Integer.parseInt(this.timeField.getText()),0,0);
		});
		breakfastPlus.setForeground(Color.ORANGE);
		breakfastPlus.setBackground(Color.DARK_GRAY);
		breakfastPlus.setFont(new Font("Verdana", Font.BOLD, 12));
		breakfastPlus.setBounds(10, 182, 209, 23);
		frmNuovaPrenotazione.getContentPane().add(breakfastPlus);
		
		JButton lunchPlus = new JButton("Pranzo +");
		lunchPlus.addActionListener(e -> {
			var client = this.codeField.getText();
			//Query adding taking choice as input
		});
		lunchPlus.setForeground(Color.ORANGE);
		lunchPlus.setBackground(Color.DARK_GRAY);
		lunchPlus.setFont(new Font("Verdana", Font.BOLD, 12));
		lunchPlus.setBounds(10, 215, 209, 23);
		frmNuovaPrenotazione.getContentPane().add(lunchPlus);
		
		JButton dinnerPlus = new JButton("Cena +");
		dinnerPlus.addActionListener(e -> {
			var client = this.codeField.getText();
			//Query adding taking choice as input
		});
		dinnerPlus.setForeground(Color.ORANGE);
		dinnerPlus.setBackground(Color.DARK_GRAY);
		dinnerPlus.setFont(new Font("Verdana", Font.BOLD, 12));
		dinnerPlus.setBounds(10, 249, 209, 23);
		frmNuovaPrenotazione.getContentPane().add(dinnerPlus);
		
		JButton parkingPlus = new JButton("Parcheggio +");
		parkingPlus.addActionListener(e -> {
			var client = this.codeField.getText();
			var days = this.parkingDaysField.getText();
			//Query adding taking choice, days as input
		});
		parkingPlus.setForeground(Color.ORANGE);
		parkingPlus.setBackground(Color.DARK_GRAY);
		parkingPlus.setFont(new Font("Verdana", Font.BOLD, 12));
		parkingPlus.setBounds(10, 368, 209, 23);
		frmNuovaPrenotazione.getContentPane().add(parkingPlus);
		
		JButton massagePlus = new JButton("Massaggio +");
		massagePlus.addActionListener(e -> {
			var client = this.codeField.getText();
			var date = this.dateField.getText();
			var time = this.timeField.getText();
			//Query adding taking choice, date, time as input
		});
		massagePlus.setForeground(Color.ORANGE);
		massagePlus.setBackground(Color.DARK_GRAY);
		massagePlus.setFont(new Font("Verdana", Font.BOLD, 12));
		massagePlus.setBounds(358, 233, 209, 23);
		frmNuovaPrenotazione.getContentPane().add(massagePlus);
		
		JButton dirtPlus = new JButton("Fango +");
		dirtPlus.addActionListener(e -> {
			var client = this.codeField.getText();
			var date = this.dateField.getText();
			var time = this.timeField.getText();
			//Query adding taking choice, date, time as input
		});
		dirtPlus.setForeground(Color.ORANGE);
		dirtPlus.setBackground(Color.DARK_GRAY);
		dirtPlus.setFont(new Font("Verdana", Font.BOLD, 12));
		dirtPlus.setBounds(358, 267, 209, 23);
		frmNuovaPrenotazione.getContentPane().add(dirtPlus);
		
		JButton bathPlus = new JButton("Bagno +");
		bathPlus.addActionListener(e -> {
			var client = this.codeField.getText();
			var date = this.dateField.getText();
			var time = this.timeField.getText();
			//Query adding taking choice, date, time as input
		});
		bathPlus.setForeground(Color.ORANGE);
		bathPlus.setBackground(Color.DARK_GRAY);
		bathPlus.setFont(new Font("Verdana", Font.BOLD, 12));
		bathPlus.setBounds(358, 301, 209, 23);
		frmNuovaPrenotazione.getContentPane().add(bathPlus);
		
		JButton bubblePlus = new JButton("Idromassaggio +");
		bubblePlus.addActionListener(e -> {
			var client = this.codeField.getText();
			var date = this.dateField.getText();
			var time = this.timeField.getText();
			//Query adding taking choice, date, time as input
		});
		bubblePlus.setForeground(Color.ORANGE);
		bubblePlus.setBackground(Color.DARK_GRAY);
		bubblePlus.setFont(new Font("Verdana", Font.BOLD, 12));
		bubblePlus.setBounds(358, 335, 209, 23);
		frmNuovaPrenotazione.getContentPane().add(bubblePlus);
		
		JLabel dateLabel = new JLabel("Data");
		dateLabel.setForeground(Color.ORANGE);
		dateLabel.setBackground(Color.DARK_GRAY);
		dateLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		dateLabel.setBounds(358, 77, 138, 23);
		frmNuovaPrenotazione.getContentPane().add(dateLabel);
		
		dateField = new JTextField();
		dateField.setForeground(Color.PINK);
		dateField.setBackground(Color.BLACK);
		dateField.setFont(new Font("Verdana", Font.BOLD, 12));
		dateField.setColumns(10);
		dateField.setBounds(358, 111, 209, 20);
		frmNuovaPrenotazione.getContentPane().add(dateField);
		
		JLabel timeLabel = new JLabel("Ora");
		timeLabel.setForeground(Color.ORANGE);
		timeLabel.setBackground(Color.DARK_GRAY);
		timeLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		timeLabel.setBounds(358, 148, 138, 23);
		frmNuovaPrenotazione.getContentPane().add(timeLabel);
		
		timeField = new JTextField();
		timeField.setForeground(Color.PINK);
		timeField.setBackground(Color.BLACK);
		timeField.setFont(new Font("Verdana", Font.BOLD, 12));
		timeField.setColumns(10);
		timeField.setBounds(358, 182, 209, 20);
		frmNuovaPrenotazione.getContentPane().add(timeField);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(e -> {
			this.frmNuovaPrenotazione.dispose();
			this.logic.logout();	
		});
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.DARK_GRAY);
		logout.setFont(new Font("Verdana", Font.BOLD, 12));
		logout.setBounds(710, 455, 209, 23);
		frmNuovaPrenotazione.getContentPane().add(logout);
		
		JLabel classicReservationTitle = new JLabel("Prenotazioni classiche");
		classicReservationTitle.setHorizontalAlignment(SwingConstants.CENTER);
		classicReservationTitle.setForeground(Color.MAGENTA);
		classicReservationTitle.setFont(new Font("Verdana", Font.BOLD, 16));
		classicReservationTitle.setBounds(10, 49, 264, 14);
		frmNuovaPrenotazione.getContentPane().add(classicReservationTitle);
		
		JLabel timeReservationTitle = new JLabel("Prenotazioni Orarie");
		timeReservationTitle.setHorizontalAlignment(SwingConstants.CENTER);
		timeReservationTitle.setForeground(Color.MAGENTA);
		timeReservationTitle.setFont(new Font("Verdana", Font.BOLD, 16));
		timeReservationTitle.setBounds(358, 52, 264, 14);
		frmNuovaPrenotazione.getContentPane().add(timeReservationTitle);
		
		JLabel parkingDays = new JLabel("Giorni di parcheggio");
		parkingDays.setForeground(Color.ORANGE);
		parkingDays.setFont(new Font("Verdana", Font.BOLD, 12));
		parkingDays.setBackground(Color.DARK_GRAY);
		parkingDays.setBounds(10, 306, 138, 23);
		frmNuovaPrenotazione.getContentPane().add(parkingDays);
		
		parkingDaysField = new JTextField();
		parkingDaysField.setForeground(Color.PINK);
		parkingDaysField.setFont(new Font("Verdana", Font.BOLD, 12));
		parkingDaysField.setColumns(10);
		parkingDaysField.setBackground(Color.BLACK);
		parkingDaysField.setBounds(10, 337, 209, 20);
		frmNuovaPrenotazione.getContentPane().add(parkingDaysField);
	}

}
