package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;

import javax.swing.Popup;
import javax.swing.PopupFactory;

public class Pswd {
	JFrame frame;
	Popup popup;
	JPasswordField passwordField;
	JTextField userTextField;
	JButton btnOk;


	public static void main(String[] args) {
		Pswd pswd = new Pswd();
	}
	
	public Pswd() {
		frame = new JFrame("Passwort");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);

		// Panel an Frame kleben
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		/* Benutzername */
		userTextField = new JTextField();
		userTextField.setBounds(100, 5, 130, 30);
		panel.add(userTextField);
		userTextField.setColumns(10);
		// Benutzername Txt
		JLabel benutzernametxt = new JLabel("Benutzername");
		benutzernametxt.setBounds(10, 10, 130, 15);
		panel.add(benutzernametxt);

		/* Passwortfeld */
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 50 , 130, 30);
		panel.add(passwordField);
		// Passwort Txt Feld
		JLabel passworttxt = new JLabel("Passwort");
		passworttxt.setBounds(40, 55, 130, 15);
		panel.add(passworttxt);
		
		/* Der Bestätigungsknopf */
		btnOk = new JButton("Einloggen");
		btnOk.setBounds(100, 100, 117, 29);
//		btnOk.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if(btnOk()) {
//					
//				}
//			}	
//		});
		panel.add(btnOk);
		
		/* Rolle aus Dropdownmenu auswählen */
		String[] rollenString = { "Publisher", "Subscriber" };
		// Text
		JLabel rolletxt = new JLabel("Rolle auswählen");
		rolletxt.setBounds(290, 10, 130, 15);
		panel.add(rolletxt);
		// Dropdownmenu
		JComboBox listeRolle = new JComboBox(rollenString);
		listeRolle.setBounds(290, 30, 100, 20);
		panel.add(listeRolle);
	

		PopupFactory factory = PopupFactory.getSharedInstance();
		popup = factory.getPopup(frame, panel, 50, 50);
		popup.show();

		frame.setVisible(true);
	}
	
//	@SuppressWarnings("deprecation")
//	private boolean btnOk() {
//		String name, pw;
//		try {
//			name = userTextField.getText();
//			pw = passwordField.getText();
//		}
//		catch (StringIndexOutOfBoundsException e){
//			System.out.println("Benutzername ausfüllen");
//			return false;
//		}
//		
//		
//	}

}