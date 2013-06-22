package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

import javax.swing.Popup;
import javax.swing.PopupFactory;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jivesoftware.smack.XMPPException;

import xmpp.*;

import javax.swing.JTable;
import javax.swing.JTextPane;

class Usergui {

	private JFrame framemain, frameLog, frameCon;
	private JButton btnSpeichern,  btnOk, btnServer;
	private JTextField textField, beitragTextField, userTextField, serverTxtField, portTxtField;
	private JPanel panelLog, panelCon;
	private JLabel benutzernametxt, passworttxt, servertxt, porttxt;
	private Popup popup;
	private JPasswordField passwordField;
	private String rolle, server;
	private int port;
	private static int connectionVisible, loginVisible;
	private JComboBox listeRolle;
	private Publisher pub1;
	private Subscriber sub1;
	

	// private final Action action = new SwingAction();

	/**
	 * Create the application.
	 */
	public Usergui() {
		connection();
		login();
		mainframe();
	}
	
	/**
	 * Launch the application.
	 * 
	 * @return
	 */
	public static void main(String[] args) {
		Usergui window = new Usergui();
		
		try {
			window.frameCon.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/** WHILE SCHLEIFEN SIND PERFROMANCELASTIG SCHEISSE?! */
		/* Schaue ob Server und Port korrekt eingegeben wurden */
		while(connectionVisible == 1) {
			if(connectionVisible == 0) {
				window.frameCon.setVisible(false);
				window.frameLog.setVisible(true);
				loginVisible = 1;
			}
		}
		while(loginVisible == 1) {
			if(loginVisible == 0) {
				window.frameLog.setVisible(false);
				window.framemain.setVisible(true);
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void mainframe() {
		framemain = new JFrame();
		framemain.setBounds(100, 100, 630, 520);
		framemain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framemain.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 25, 620, 435);
		tabbedPane.setBackground(new Color(238, 238, 238));
		framemain.getContentPane().add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Neuer Beitrag", null, panel_1, null);
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"Schreibe einen neuen Beitrag \u00FCber deinen urlaub!");
		lblNewLabel.setBounds(6, 6, 355, 16);
		panel_1.add(lblNewLabel);

		JLabel lblUrlaub = new JLabel("Urlaub");
		lblUrlaub.setBounds(6, 34, 61, 16);
		panel_1.add(lblUrlaub);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(50, 30, 155, 27);
		panel_1.add(comboBox);

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(211, 28, 134, 28);
		panel_1.add(textField);
		textField.setColumns(10);

		beitragTextField = new JFormattedTextField();
		beitragTextField.setBounds(6, 62, 587, 233);
		panel_1.add(beitragTextField);

		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {

			// Action wenn Button Speichern gedrŸckt wird
			public void actionPerformed(ActionEvent e) {
				// †berprŸfen ob Textfelder leer sind -> muss noch dran
				// geschraubt werden
				if (beitragTextField.getText().isEmpty()
						|| textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Eins der fehlenden Felder ist leer!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				else {
					// Felder ausgeben --> Eigenlichte Funktion hier rein!
					System.out.println("Kanal: " + textField.getText());
					System.out.println("Beitrag: " + beitragTextField.getText());

					;
				}

			}
		});

		btnSpeichern.setBounds(6, 295, 117, 29);
		panel_1.add(btnSpeichern);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { lblNewLabel, lblUrlaub, comboBox, textField,
						beitragTextField, btnSpeichern }));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 238, 238));
		tabbedPane.addTab("Urlaubs Kan\u00E4le", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel(
				"\u00DCbersicht aller Urlaubs Kan\u00E4le");
		lblNewLabel_1.setBounds(6, 6, 248, 16);
		panel.add(lblNewLabel_1);

		JLabel lblKanal = new JLabel("Kanal 1");
		lblKanal.setBounds(6, 34, 223, 16);
		panel.add(lblKanal);

		JButton btnAnzeigen = new JButton("Anzeigen");
		btnAnzeigen.setBounds(241, 29, 117, 29);
		panel.add(btnAnzeigen);

		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("User");
		tabbedPane.addTab("User", null, panel_2, null);
		panel_2.setLayout(null);

		JTextPane txtpnUser = new JTextPane();
		txtpnUser.setText("User");
		txtpnUser.setBounds(95, 6, 416, 170);
		panel_2.add(txtpnUser);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Kanal", null, panel_3, null);

		JLabel lblUrlaub_1 = new JLabel("Urlaub");
		lblUrlaub_1.setBounds(6, 6, 61, 16);
		framemain.getContentPane().add(lblUrlaub_1);

		// btn_publish.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// boolean errorFound = false;
		//
		// if(ta_publishMessage.getText().isEmpty()) {
		// errorFound = true;
		// throwError(window, "Fehler: Bitte Nachricht eingeben!");
		// }
		//
		// if(errorFound == false) {
		// String cb_allTopicsSelected =
		// stripFormat(cb_allTopics.getSelectedItem().toString());
		// String ta_publishMessageText = ta_publishMessage.getText();
		// String tf_nodeTitleText = tf_nodeTitle.getText();
		//
		// smack.publishMsg(cb_allTopicsSelected, tf_nodeTitleText,
		// ta_publishMessageText);
		// //throwMessage(window,"Success!\n" + cb_allTopicsSelected + "\n" +
		// ta_publishMessageText);
		// }
		// }
		//
		// public void actionPerformed(ActionEvent arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		// window.add(btn_publish);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	public void connection() {

		connectionVisible = 1;
		frameCon = new JFrame("Verbindung");
		frameCon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCon.setSize(500, 300);
		frameCon.setLocationRelativeTo(null);
		
		panelCon = new JPanel();
		panelCon.setBounds(0, 0, 400, 250);
		frameCon.getContentPane().add(panelCon);
		panelCon.setLayout(null);
		
		/* Server Textfeld */
		serverTxtField = new JTextField();
		serverTxtField.setBounds(165, 50, 130, 30);
		panelCon.add(serverTxtField);
		
		servertxt = new JLabel("Server (localhost)");
		servertxt.setBounds(60, 55, 130, 15);
		panelCon.add(servertxt);
		
		/* Port IntFeld */
		portTxtField = new JTextField();
		portTxtField.setBounds(165, 100, 130, 30);
		panelCon.add(portTxtField);
		
		porttxt = new JLabel("Port (5222)");
		porttxt.setBounds(100, 105, 130, 15);
		panelCon.add(porttxt);		
		
		/* Bestätigen Button */
		btnServer = new JButton("Bestätigen");
		btnServer.setBounds(165, 150, 115, 30);
		btnServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnServer()) {
					System.out.println("Server: " + server + " Port: " + port);
					connectionVisible = 0;
				}
			}
		});
		panelCon.add(btnServer);
	
	}
	
	public void login() {
		
		loginVisible = 0;
		frameLog = new JFrame("Passwort");
		frameLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLog.setSize(500, 300);
		frameLog.setLocationRelativeTo(null);

		// Panel an Frame kleben
		panelLog = new JPanel();
		panelLog.setBounds(0, 0, 400, 250);
		frameLog.getContentPane().add(panelLog);
		panelLog.setLayout(null);

		/* Benutzername */
		userTextField = new JTextField();
		userTextField.setBounds(100, 5, 130, 30);
		panelLog.add(userTextField);
		userTextField.setColumns(10);
		// Benutzername Txt
		benutzernametxt = new JLabel("Benutzername");
		benutzernametxt.setBounds(10, 10, 130, 15);
		panelLog.add(benutzernametxt);

		/* Passwortfeld */
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 50 , 130, 30);
		panelLog.add(passwordField);
		// Passwort Txt Feld
		passworttxt = new JLabel("Passwort");
		passworttxt.setBounds(40, 55, 130, 15);
		panelLog.add(passworttxt);
		
		/* Der Bestätigungsknopf */
		btnOk = new JButton("Einloggen");
		btnOk.setBounds(100, 100, 117, 29);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(btnOk()) {
						loginVisible = 0;
						System.out.println("Benutzer eingeloggt");
					}
				} catch (XMPPException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		});
		panelLog.add(btnOk);
		
		/* Rolle aus Dropdownmenu auswählen */
		String[] rollenString = { "Publisher", "Subscriber" };
		// Text
		JLabel rolletxt = new JLabel("Rolle auswählen");
		rolletxt.setBounds(290, 10, 130, 15);
		panelLog.add(rolletxt);
		// Dropdownmenu
		listeRolle = new JComboBox(rollenString);
		listeRolle.setBounds(290, 30, 100, 20);
		panelLog.add(listeRolle);
	

//		PopupFactory factory = PopupFactory.getSharedInstance();
//		popup = factory.getPopup(frameLog, panelLog, 50, 50);
//		popup.show();

	}
	
	private boolean btnServer() {	
		try {
			this.server = serverTxtField.getText();
			this.port = Integer.parseInt(portTxtField.getText());
			return true;
		}
		catch (NumberFormatException e) {
			System.out.println("Server und/oder Port falschb");
			return false;
		}
	}
	
	/* Der EventListener für den Einlogge Button */
	@SuppressWarnings("deprecation")
	private boolean btnOk() throws XMPPException, InterruptedException {
		String name, pw;
		try {
			name = userTextField.getText();
			pw = passwordField.getText();
			rolle = listeRolle.getSelectedItem().toString();
			System.out.println("Rolle: " + rolle +" Name: " + name+ " Pass: " + pw);
		}
		catch (StringIndexOutOfBoundsException e){
			System.out.println("Benutzername ausfüllen");
			return false;
		}
		try {
			pub1 = new Publisher(name, pw);
			pub1.setPort(port);
			pub1.setServer(server);
			System.out.println(port+server);
			if(pub1.login()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (XMPPException e) {
			System.out.println("Falscher Benutzername");
			return false;
		}
		
		
	}

}
