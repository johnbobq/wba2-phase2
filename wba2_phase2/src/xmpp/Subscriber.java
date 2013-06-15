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
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;


public class Subscriber extends User {

	public Subscriber(String name, String pass) throws XMPPException {
		super(name, pass);
	}
	
	public void subscribe(String titel) throws XMPPException {
		
		PubSubManager mgr = new PubSubManager(con);
		LeafNode node = mgr.getNode(titel);
		
//		 node.addItemEventListener(new ItemEventCoordinator<Item>());
		node.subscribe(jid);
		
	}
	

}
