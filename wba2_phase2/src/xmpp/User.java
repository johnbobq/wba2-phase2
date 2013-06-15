package xmpp;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.PubSubManager;

public class User {

	private PubSubManager mgr;
	protected Connection con;
	protected String username;
	protected String pass;
	protected String jid;
	private String server;
	private int port;
	private AccountManager acm;
	private String wurzel_knoten = "Dienst";
	
	public User(String name, String pass) throws XMPPException {
		this.username = name;
		this.pass = pass;
	}
	
	
	
	/* Verbindung zum LocalHost erstellen erstellen */
	public boolean setConnectionFile() {
		if(server == null || port == 0) {
			System.out.println("Entweder Server oder Port, ist falsch eingegeben worden");
			return false;
		}
		else {
			ConnectionConfiguration config = new ConnectionConfiguration(server ,port);
			con = new XMPPConnection(config);
			return true;
		}
	}
	
	/* PubSubManager und Acm erstellen mit Verbindung zum localhost */
	public void login() throws XMPPException, InterruptedException {
		mgr = new PubSubManager(con);
		acm = new AccountManager(con);
		con.connect();	
		con.login(username, pass);
		jid = con.getUser();
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
	
	/* Jeder Benutzer kann ein Kommentar zu einem Beitrag machen */
	public void comment(String node, String kommentar) {
		
	}
	
	public String getRootNode() {
		return wurzel_knoten;
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
	
	public String getUser2() {
		return con.getUser();
	}
	
	public String getPass() {
		return pass;
	}
	
}
