package xmpp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.CollectionNode;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.NodeType;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.PublishModel;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.Subscription;

public class Xmppclient {
	

	protected PubSubManager mgr;
	protected Connection con;
	protected String username;
	protected String pass;
	protected String jid;
	private String server;
	private int port;
	private AccountManager acm;
	protected String ROOT = "Dienst";
	
	public Xmppclient(String name, String pass) throws XMPPException {
		this.username = name;
		this.pass = pass;
	}
	
	
	
	
	
	/** Verbindung zum LocalHost erstellen erstellen */
	public boolean setConnectionFile() {
		if(server == null || port == 0) {
			System.out.println("Entweder Server oder Port, ist falsch eingegeben worden");
			return false;
		}
		else {
			ConnectionConfiguration config = new ConnectionConfiguration(server ,port);
			SASLAuthentication.supportSASLMechanism("PLAIN", 0);
			con = new XMPPConnection(config);
			return true;
		}
	}
	
	/** PubSubManager und Acm erstellen mit Verbindung zum localhost */
	public boolean login() throws XMPPException, InterruptedException {
		try {
			setConnectionFile();
		}
		catch (Exception e){
			return false;
		}
		this.mgr = new PubSubManager(con);
		this.acm = new AccountManager(con);
		try {
			con.connect();
			con.login(username, pass);
			jid = con.getUser();
			return true;
		}
		catch (XMPPException e) {
			System.out.println("Benutzer: " + username + "konnte nicht eingeloggt werden");
			return false;
		}
	}
	
	public boolean logout() {
		if(con.isConnected()) {
			con.disconnect();
			return true;
		}
		else {
			return false;
		}
	}
	
	public String identification() {
		return jid;
	}
	
	public void regist(String name, String password) throws XMPPException {
		try {
			con.connect();
			mgr = new PubSubManager(con);
			acm = new AccountManager(con);
			acm.createAccount(name, password);
		}
		catch (XMPPException e) {
			System.out.println("Registration fehlgeschlagen, Name doppelt?");
		}
	}
	
	/** Jeder Benutzer kann ein Kommentar zu einem Beitrag machen */
	public void comment(String node, String kommentar) {
		
	}
	
	public String getRootNode() {
		return ROOT;
	}


	public boolean subscribe(String node, String jid) throws XMPPException {
	    
		LeafNode beitrag = null;
		try {
			beitrag = mgr.getNode(node);
		}
		catch (XMPPException e) {
			System.out.println("Node konnte nicht abonniert werden, falscher Name?");
			return false;
		}
		beitrag.addItemEventListener(new ItemEventCoordinator());

	    beitrag.subscribe(jid);
	    System.out.println("User mit der Jid `" + jid + "` hat Kanal "+ "`"+beitrag.getId()+"`" + " abonniert");
	    return true;
	}
	
	public void listNodes() throws XMPPException {
		
		// Obtain the ServiceDiscoveryManager associated with my Connection
		DiscoverItems tmp = mgr.discoverNodes(ROOT);
		System.out.println("Hier alle nodes von wujrzel:" + tmp.getItems().next().getName());
		
		
	}
	
	

	public boolean createRootNode() throws XMPPException {  
		// A decorator for a Form to easily enable reading and updating of node configuration.
		// MERKEN:  	setCollection(java.lang.String collection) 
		ConfigureForm form = new ConfigureForm(FormType.submit);
	    form.setAccessModel(AccessModel.open);
	    form.setDeliverPayloads(false);
	    form.setNotifyRetract(true);
	    form.setPersistentItems(true);
	    form.setPublishModel(PublishModel.open);
	    form.setNodeType(NodeType.collection);
	    
	    // Schaue ob Wurzelknoten ("Dienst") bereits vorhanden, wenn ja löschen und neuen anlegen
	    CollectionNode wurzel = null;
		try {
			try {
				CollectionNode existingNode = (CollectionNode) mgr.getNode(ROOT);
				mgr.deleteNode(ROOT);
			} 
			catch (XMPPException e) {
				System.out.println("Der Wurzelknoten existierte noch nicht");
			}
			wurzel = (CollectionNode) mgr.createNode(ROOT, form);
		} 
		catch (XMPPException e) {
			System.err.println(e);
		}
		System.out.println("Der Wurzelknoten wurde nun erstellt: " + mgr.getNode(ROOT).getId());
		return true;
	}
	
	/** Eine neuen CollectionNode mit Name an den Wurzelknoten hängen, entspricht einem Kanal */
	public boolean createLeafNode(String titel) throws XMPPException {
		
		ConfigureForm form = new ConfigureForm(FormType.submit);
	    form.setAccessModel(AccessModel.open);
	    form.setDeliverPayloads(true);
	    form.setNotifyRetract(true);
	    form.setPersistentItems(true);
	    form.setSubscribe(true);
	    form.setDeliverPayloads(true);
	    form.setPublishModel(PublishModel.open);
	    form.setNodeType(NodeType.leaf);
	    form.setCollection(ROOT);
	    
	    LeafNode kanal = null;
	    try {
	    	kanal = (LeafNode) mgr.createNode(titel, form);
	    	System.out.println("Der LeafNode(Kanal) wurde erstellt: " + kanal.getId());
	    	return true;
	    }
	    catch (XMPPException e) {
	    	System.out.println("Gleicher Kanalname ist bereits vorhanden: " + titel);
	    	return false;
	    }
	}
	
	public boolean publishNode(String node) throws XMPPException {
		LeafNode beitrag = null;
		try {
			beitrag = mgr.getNode(node);
		}
		catch (XMPPException e) {
			System.out.println("Falscher Node(Kanal) zum Publishen angegeben");
		}
		// Fehlt hier etwas?
		beitrag.publish(new Item());
		System.out.println("Item wurde auf Node /" + beitrag.getId() + "/ gepublished");
		return true;
	}
	
	public boolean publishNodePayload(String node, String content) throws XMPPException {
		String itemId = node + System.currentTimeMillis();
		LeafNode beitrag = null;
		try {
			beitrag = mgr.getNode(node);
		}
		catch (XMPPException e) {
			System.out.println("Falscher Node(Kanal) angegeben");
			return false;
		}
		SimplePayload payload = new SimplePayload("Beitrag", beitrag.getId()+":Kommentar" , content);
		PayloadItem payloadItem = new PayloadItem(itemId, payload);
//		beitrag.send(payloadItem);
		beitrag.publish(payloadItem);
		System.out.println("Item mit Payload wurde gepublished an  " + beitrag.getId() + " und hat " + beitrag.getSubscriptions().size()+ " Subscriber ");
		return true;
	}
	
	/** Hilfsmethode */
	public void getPublishedItem(String node) throws XMPPException {
		
		LeafNode beitrag = mgr.getNode(node);
		Collection<? extends Item> items = beitrag.getItems();
		if(items.isEmpty())
			System.out.println(node + " getItems ist leer.");
		
	}
	
	
	/** Hilfsmethode */
	public void loescheNode(String node) throws XMPPException {
		try {
			mgr.deleteNode(node);
			System.out.println("Loeschen geklappt");
		}
		catch (XMPPException e) {
			System.out.println("loeschen nicht geklappt");
		}
	}
	

	/** Hilfsmethode */
	public ArrayList<String> getSubscriber(String leaf) throws XMPPException {
		
		LeafNode node = mgr.getNode(leaf);
		List<Subscription> list = node.getSubscriptions();
		ArrayList<String> list2 = new ArrayList<String>();
		int i = 0;
		while(!(list.isEmpty())) {
			list2.add(list.get(i).getJid());
			i++;
		}
		return list2;
	}
	
	public String getSubscriber2(String leaf) throws XMPPException {
		LeafNode node = mgr.getNode(leaf);
		String tmp = node.getSubscriptions().get(0).getJid();
		return tmp;
	}

	/** Hilfsmethode */
	public void subPub(String node) throws XMPPException {
		// Create a pubsub manager using an existing Connection
	      PubSubManager mgr = new PubSubManager(con);

	      // Get the node
	      LeafNode nodee = mgr.getNode(node);

	      // Publish an Item with payload
	      nodee.publish(new PayloadItem("test" + System.currentTimeMillis(), 
	          new SimplePayload("book", "pubsub:test:book", "payload")));
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setServer(String server) {
		this.server = server;
	}
	
	public String getServer() {
		return server;
	}
	
	public String getUser() {
		return username;
	}

	public String getJid() {
		return jid;
	}
	
	public String getPass() {
		return pass;
	}

}
