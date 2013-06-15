package xmpp;

import java.util.List;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.PublishModel;
import org.jivesoftware.smackx.pubsub.Subscription;

public class Publisher extends User {
	
	public Publisher(String name, String pass) throws XMPPException {
		super(name, pass);
	}

	public void createNode(String titel) throws XMPPException {
		PubSubManager mgr = new PubSubManager(con);
		// Neuen Node (Kanal) erstellen
		LeafNode kanal = mgr.createNode(titel);
	}
	
	public void publishNode(String titel) throws XMPPException {
		
		PubSubManager mgr = new PubSubManager(con);
		LeafNode node = mgr.getNode(titel);
		
		node.send(new Item(titel));
		node.publish();
	}
	
	public List<Subscription> getSubscriber(String titel) throws XMPPException {
		
		PubSubManager mgr = new PubSubManager(con);
		LeafNode node = mgr.getNode(titel);
		
		return node.getSubscriptions();
	}

}
