package restservice;

import org.jivesoftware.smack.XMPPException;

import xmpp.Publisher;
import xmpp.User;

public class Testklasse {

	User b1;
	User b2;
	
	public void benutzerErstellen() throws XMPPException {
		this.b1 = new Publisher("user3", "abcd");
		System.out.println(b1.getUser());
		System.out.println(b1.getPass());
		b1.setPort(5222);
		b1.setServer("localhost");
	    if(b1.setConnection())
	    	System.out.println("Verbindung hergestellt");
	    System.out.println(b1.getUser2());
	    System.out.println(b1.getServer());
	    System.out.println(b1.getPort());
	    
//		User b2 = new Publisher("user4", "abcd");
//		b2.setPort(5222);
//		b2.setServer("localhost");
//		b2.setConnection();
	}
	
	public void benutzerConnect() throws XMPPException {

	    b1.login();
	    System.out.println(b1.identification());
	    System.out.println(b1.getUser2());
		
	}
	public void benutzRegist() throws XMPPException {
	
		b2.regist(b2.getUser(), b2.getPass());
		
		b2.login();
		System.out.println(b2.identification());
	}
	
	public void benutzerAusloggen() {
		if(b1.logout())
			System.out.println("Ist eingeloggt");
		else 
			System.out.println("Nicht");
//		b2.logout();
		
	}
		

}
