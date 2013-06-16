package xmpp;

import org.jivesoftware.smack.XMPPException;


public class Testklasse {

	Publisher b1;
	User b2;
	
	public void benutzerErstellen() throws XMPPException {
		this.b1 = new Publisher("user3", "abcd");
		System.out.println(b1.getUser());
		System.out.println(b1.getPass());
		b1.setPort(5222);
		b1.setServer("localhost");
	    if(b1.setConnectionFile())
	    	System.out.println("Verbindung erstellt");
	    System.out.println("Serveradresse mit getServer(): " + b1.getServer());
	    System.out.println("Port mit getPort(): " + b1.getPort());
	    
		this.b2 = new Publisher("user4", "abcd");
		b2.setPort(5222);
		b2.setServer("localhost");
		b2.setConnectionFile();
	}
	
	public void benutzerConnect() throws XMPPException, InterruptedException {
	    b1.login();	
	    b2.login();
	}
	
	public void nodesErstellen() throws XMPPException, InterruptedException {
		b1.createRootNode();
		b1.createCollectionNode("Kanal1");
		b1.createLeafeNode("beitrag1", "Kanal1");
	}
	
	public void benutzRegist() throws XMPPException, InterruptedException {
	
		System.out.println("HIER USER 2 NAME: " + b2.getUser());
		System.out.println("HIER USER 2 PASS: " + b2.getPass());
		String n2 = b2.getUser();
		String p2 = b2.getPass();
		b2.regist(n2, p2);
		b2.login();
	}
	
	public void benutzerAusloggen() {
		if(b1.logout())
			System.out.println("Benutzer war eingeloggt: ist jetzt ausgeloggt");
		else 
			System.out.println("Benutzer war nicht eingeloggt");
	}
		
	public void b2ausloggen() {
		if(b2.logout()) {
			System.out.println("Benutzer war eingeloggt: ist jetzt ausgeloggt");
		}
			else 
				System.out.println("Benutzer war nicht eingeloggt");
		}
}
