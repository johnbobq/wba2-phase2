package xmpp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.ServiceDiscoveryManager;
import org.jivesoftware.smackx.packet.DiscoverInfo;
import org.jivesoftware.smackx.packet.DiscoverItems;
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

	    beitrag.subscribe(this.jid);
	    System.out.println("User mit der Jid `" + this.jid + "` hat Kanal "+ "`"+beitrag.getId()+"`" + " abonniert");
	    return true;
	}
	
	public void listNodes() throws XMPPException {
		
		// Obtain the ServiceDiscoveryManager associated with my Connection
		DiscoverItems tmp = mgr.discoverNodes(ROOT);
		System.out.println("Hier alle nodes von wujrzel:" + tmp.getItems().next().getName());
		
		
	}
	
	/* HIlfsunktion */
	public void subPub(String node) throws XMPPException {
		// Create a pubsub manager using an existing Connection
	      PubSubManager mgr = new PubSubManager(con);

	      // Get the node
	      LeafNode nodee = mgr.getNode(node);

	      // Publish an Item with payload
	      nodee.publish(new PayloadItem("test" + System.currentTimeMillis(), 
	          new SimplePayload("book", "pubsub:test:book", "payload")));
	}
	

}
