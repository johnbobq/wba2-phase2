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
	
	public boolean subscribe(String node) throws XMPPException {
	      // Get the node
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
	    System.out.println("User mit der Jid `" + jid + "` hat Kanal "+ "`"+node+"`" + " abonniert");
	    return true;
	}
	

}
