package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextArea;

public class sub {

	private JFrame frame;

	/**
	 * Launch the application!
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sub window = new sub();
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
	public sub() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(238, 238, 238));
		frame.setBounds(100, 100, 674, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 667, 444);
		tabbedPane.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Kan\u00E4le", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.setBackground(UIManager.getColor("Button.background"));
		
		JLabel label_2 = new JLabel("\u00DCbersicht aller Urlaubs Kan\u00E4le");
		label_2.setBounds(6, 6, 248, 16);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Kanal 1");
		label_3.setBounds(6, 34, 223, 16);
		panel_1.add(label_3);
		
		JButton button_1 = new JButton("Anzeigen");
		button_1.setBounds(241, 29, 117, 29);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("User", null, panel_2, null);
		panel_2.setLayout(null);
		panel_2.setToolTipText("User");
		
		JTextPane textPane = new JTextPane();
		textPane.setText("User");
		textPane.setBounds(24, 7, 416, 170);
		panel_2.add(textPane);
		
		JButton btnAlleUserAnzeigen = new JButton("Alle User Anzeigen");
		btnAlleUserAnzeigen.setBounds(27, 202, 246, 29);
		panel_2.add(btnAlleUserAnzeigen);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Beitrag", null, panel, null);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(456, 46, -432, 198);
		panel.add(textArea);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(6, 275, 451, 61);
		panel.add(formattedTextField);
		
		JButton btnKommentieren = new JButton("Kommentieren");
		btnKommentieren.setBounds(6, 348, 117, 29);
		panel.add(btnKommentieren);
		
		JLabel lblBeitragTitel = new JLabel("Beitrag Titel");
		lblBeitragTitel.setBounds(6, 6, 98, 16);
		panel.add(lblBeitragTitel);
		
		JLabel lblKommentar = new JLabel("Kommentar");
		lblKommentar.setBounds(6, 254, 154, 16);
		panel.add(lblKommentar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(panel_3);
		
		JButton btnAusloggen = new JButton("Ausloggen");
		btnAusloggen.setBounds(276, 450, 117, 29);
		frame.getContentPane().add(btnAusloggen);
	}
}
