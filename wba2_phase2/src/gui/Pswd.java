package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;

import javax.swing.Popup;
import javax.swing.PopupFactory;

public class Pswd
{
   JFrame frame;
   Popup popup;
   JPasswordField passwordField;
   JTextField userTextField;

   public Pswd()
   {
      frame = new JFrame("Passwort");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 300);


      JPanel panel = new JPanel();
		panel.setBounds(99, 65, 158, 89);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(14, 5, 134, 28);
		panel.add(passwordField);
		
		userTextField = new JTextField();
		userTextField.setBounds(14, 45, 134, 28);
		panel.add(userTextField);
		userTextField.setColumns(10);
		
		
      PopupFactory factory = PopupFactory.getSharedInstance();
      popup = factory.getPopup(frame, panel, 50, 50);
      popup.show();

      frame.setVisible(true);
   }

   public static void main(String[] args)
   {
     Pswd pswd = new Pswd();
   }
}