package xmpp;

import java.util.List;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.PublishModel;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;


public class Subscriber extends User {

	public Subscriber(String name, String pass) throws XMPPException {
		super(name, pass);
	}
	
	public boolean subscribe(String node) throws XMPPException {
	    
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
	    System.out.println("User mit der Jid `" + this.jid + "` hat Kanal "+ "`"+node+"`" + " abonniert");
	    return true;
	}
	
	public void subPub() throws XMPPException {
		// Create a pubsub manager using an existing Connection
	      PubSubManager mgr = new PubSubManager(con);

	      // Get the node
	      LeafNode node = mgr.getNode("Kanal1");

	      // Publish an Item with payload
	      node.publish(new PayloadItem("test" + System.currentTimeMillis(), 
	          new SimplePayload("book", "pubsub:test:book", "")));
	}
	

}
