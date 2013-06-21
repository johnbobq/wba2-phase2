package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.Popup;
import javax.swing.PopupFactory;

public class Pswd
{
   JFrame frame;
   Popup popup;

   public Pswd()
   {
      frame = new JFrame("Passwort");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 300);

      JPanel panel = new JPanel();
      panel.add(new JButton("Login"));
   

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