package xmpp;

import org.jivesoftware.smack.XMPPException;


public class Testklasse {

	Publisher b1;
	Subscriber b2;
	
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
	    
		this.b2 = new Subscriber("user4", "abcd");
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
		b1.createLeafNode("Kanal1");
	}
	
	public void publish() throws XMPPException {
		b1.publishNode("Kanal1");
	}
	
	public void publishPayload() throws XMPPException {
		b1.publishNodePayload("Kanal1", "ErsterBeitrag");
	}
	
	public void subscribe() throws XMPPException {
		b2.subscribe("Kanal1");
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
