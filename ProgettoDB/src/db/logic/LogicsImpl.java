package db.logic;

import javax.swing.JOptionPane;

import db.pages.LoginPages;
import db.pages.ManagerPages;
import db.pages.ReceptionPages;

public class LogicsImpl implements Logic {
	private String code;
	private String password;
	static LoginPages mainPage;

	/**
	 * Constructor.
	 */
	public LogicsImpl(LoginPages mainPage) {
		this.mainPage = mainPage;

	}

	@Override
	public void login(final String code, final String password) {
		this.code = code;
		this.password = password;

		if (this.code.equals("Receptionist1") && this.password.equals("Receptionist1")) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			ReceptionPages rec = new ReceptionPages();
			rec.frmHotelMalenia.setVisible(true);
		} else if (this.code.equals("Dirigente1") && this.password.equals("Dirigente1")) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			ManagerPages man = new ManagerPages();
			man.frmHotelMalenia.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Errore in fase di login");
		}
	}

	@Override
	public void logout() {
		this.mainPage.frame.setVisible(true);
	}

}
