package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class usergui {

	private JFrame frame;
	private JTextField txtNeuenUrlaub;
	private JTextField txtTitel;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usergui window = new usergui();
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
	public usergui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblUrlaubFloats = new JLabel("Urlaub Float");
		lblUrlaubFloats.setBounds(6, 6, 265, 16);
		frame.getContentPane().add(lblUrlaubFloats);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("Neuer Beitrag");
		tabbedPane.setBounds(0, 27, 534, 548);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Neuer Beitrag");
		tabbedPane.addTab("Neuer Beitrag", null, panel, null);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(52, 34, 126, 27);
		panel.add(comboBox);
		
		JLabel lblSchreibeEinenNeun = new JLabel("Schreibe einen neun Beitrag \u00FCber deinen Urlaub!");
		lblSchreibeEinenNeun.setBounds(6, 6, 306, 16);
		panel.add(lblSchreibeEinenNeun);
		
		JLabel lblUrlaub = new JLabel("Urlaub");
		lblUrlaub.setBounds(6, 38, 61, 16);
		panel.add(lblUrlaub);
		
		txtNeuenUrlaub = new JTextField();
		txtNeuenUrlaub.setText("Neuen Urlaub");
		txtNeuenUrlaub.setBounds(178, 32, 134, 28);
		panel.add(txtNeuenUrlaub);
		txtNeuenUrlaub.setColumns(10);
		
		txtTitel = new JTextField();
		txtTitel.setText("Titel");
		txtTitel.setBounds(6, 66, 134, 28);
		panel.add(txtTitel);
		txtTitel.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(6, 108, 412, 188);
		panel.add(textPane);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(0, 308, 117, 29);
		panel.add(btnSpeichern);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Channels", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblKanalTitel = new JLabel("Kanal Titel");
		lblKanalTitel.setBounds(16, 19, 165, 16);
		panel_1.add(lblKanalTitel);
		
		JButton btnLesen = new JButton("Lesen");
		btnLesen.setAction(action);
		//btnLesen.addActionListener(ActionEvent e)
		btnLesen.setBounds(225, 14, 117, 29);
		panel_1.add(btnLesen);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblUrlaubFloats}));
		frame.setBounds(100, 100, 665, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
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


