package xmpp;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.PubSubManager;

public class User {

	private PubSubManager mgr;
	private Connection con;
	private String username, pass, jid;
	
	public boolean connect() throws XMPPException {
		
		if(con.isConnected())
			return true;
		
		ConnectionConfiguration config = new ConnectionConfiguration("localhost",5222);
		// Verbindung zu localhost erstellen
		con = new XMPPConnection(config);
		// PubSubManager erstellen mit Verbindung zum localhost
		mgr = new PubSubManager(con);
		
		con.connect();
		return true;		
	}
	
	public boolean login(String username, String pass) throws XMPPException {
		
		con.login(username, pass);
		this.username = username;
		this.pass = pass;
		
		return true;
	}
	
	public boolean logout() {
		
		if(con.isConnected()) {
			con.disconnect();
			return true;
		}
		return false;
	}
	
	public void identification() {
		jid = con.getUser();
	}

}
