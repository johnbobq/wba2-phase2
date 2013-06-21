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

import org.eclipse.wb.swing.FocusTraversalOnArray;

class Usergui {

	private JFrame frame;
	private JButton btnSpeichern;
	private JTextField textField;
	private JTextField beitragTextField;

	// private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Usergui window = new Usergui();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Usergui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(238, 238, 238));
		tabbedPane.setBounds(6, 25, 620, 435);
		frame.getContentPane().add(tabbedPane);

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

			//Action wenn Button Speichern gedrŸckt wird
			public void actionPerformed(ActionEvent e) {
				//†berprŸfen ob Textfelder leer sind -> muss noch dran geschraubt werden
				if(beitragTextField.getText().isEmpty() || textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Eins der fehlenden Felder ist leer!", "Error", JOptionPane.ERROR_MESSAGE);
				 }
				
				else {
					//Felder ausgeben --> Eigenlichte Funktion hier rein!
					System.out.println("Kanal: "+textField.getText());
					System.out.println("Beitrag: "+beitragTextField.getText());

;				}

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

		JLabel lblUrlaub_1 = new JLabel("Urlaub");
		lblUrlaub_1.setBounds(6, 6, 61, 16);
		frame.getContentPane().add(lblUrlaub_1);

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
}
