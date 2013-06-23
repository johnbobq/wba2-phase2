package xmpp;

import java.util.ArrayList;

import org.jivesoftware.smack.XMPPException;

public class Xmpptest {

	Xmppclient client;
	String name = "user3";
	String pass = "abcd";
	String server = "localhost";
	String leaf = "kanal1";
	String content = "Hallo das ist der tolle Payload";
	int port = 5222;
	
	public void startTest() throws XMPPException, InterruptedException {
		erstellen();
		loeschen(leaf);
		makeRootNode();
		makeLeafNode(leaf);
		subscribe(leaf);
		publish(leaf, content);
//		getSubscriber(leaf);
		getItems(leaf);
		Thread.sleep(10000);
		ausloggen();
	}
	
	public void erstellen() throws XMPPException, InterruptedException {
		
		client = new Xmppclient(name, pass);
		client.setPort(port);
		client.setServer(server);
		if(client.login())
	    	System.out.println("Verbindung erstellt");
	}
	
	public void makeRootNode() throws XMPPException {
		client.createRootNode();
	}
	
	public void ausloggen() {
		if(client.logout())
			System.out.println("Benutzer wurde wieder ausgeloggt");
	}
	
	public void makeLeafNode(String node) throws XMPPException {
		client.createLeafNode(node);
	}
	
	public void subscribe(String node) throws XMPPException {
		client.subscribe(node, client.getJid());
	}

	public void publish(String node, String content) throws XMPPException {
		client.publishNodePayload(node, content);
	}
	
	public void loeschen(String node) throws XMPPException {
		client.loescheNode(node);
	}
	
	public void getItems(String node) throws XMPPException {
		client.getPublishedItem(node);
	}
	
	public void getSubscriber(String node) throws XMPPException {
		System.out.println(client.getSubscriber2(node));
		
	}
}


