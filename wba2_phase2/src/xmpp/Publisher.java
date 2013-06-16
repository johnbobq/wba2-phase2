package xmpp;

import java.util.List;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.CollectionNode;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.Node;
import org.jivesoftware.smackx.pubsub.NodeType;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.PublishModel;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.Subscription;

public class Publisher extends User {
	
	public Publisher(String name, String pass) throws XMPPException {
		super(name, pass);
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
	
	/* Eine neuen CollectionNode mit Name an den Wurzelknoten hängen, entspricht einem Kanal */
	public boolean createLeafNode(String titel) throws XMPPException {
		
		ConfigureForm form = new ConfigureForm(FormType.submit);
	    form.setAccessModel(AccessModel.open);
	    form.setDeliverPayloads(true);
	    form.setNotifyRetract(true);
	    form.setPersistentItems(true);
	    form.setSubscribe(true);
	    form.setPublishModel(PublishModel.open);
	    form.setNodeType(NodeType.leaf);
	    form.setCollection(ROOT);
	    
	    LeafNode kanal = null;
	    try {
	    	kanal = (LeafNode) mgr.createNode(titel, form);
	    	System.out.println("Der CollectionNode(Kanal) wurde erstellt: " + kanal.getId());
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
			System.out.println("Falscher Node(Kanal) angegeben");
		}
		// Fehlt hier etwas?
		beitrag.publish(new Item());
		System.out.println("Item wurde auf Node /" + beitrag.getId() + "/ gepublished");
		return true;
	}
	
	public boolean publishNodePayload(String node, String titelBeitrag) throws XMPPException {
		String itemId = node + System.currentTimeMillis();
		LeafNode beitrag = null;
		try {
			beitrag = mgr.getNode(node);
		}
		catch (XMPPException e) {
			System.out.println("Falscher Node(Kanal) angegeben");
			return false;
		}
		SimplePayload payload = new SimplePayload(node, beitrag.getId()+":Kommentar" , "Hier XML?!");
		PayloadItem payloadItem = new PayloadItem(itemId, payload);
		beitrag.publish(payloadItem);
		// beitrag.send(payloadItem);
		System.out.println("Item mit Payload wurde an gepublished" + beitrag.getId());
		return true;
	}
	

	
	public List<Subscription> getSubscriber(String titel) throws XMPPException {
		
		PubSubManager mgr = new PubSubManager(con);
		LeafNode node = mgr.getNode(titel);
		
		return node.getSubscriptions();
	}
	
//	public boolean createLeafeNode(String titel, String parent) throws XMPPException {
//	
//	ConfigureForm form = new ConfigureForm(FormType.submit);
//    form.setAccessModel(AccessModel.open);
//    form.setDeliverPayloads(true);
//    form.setNotifyRetract(true);
//    form.setPersistentItems(true);
//    form.setPublishModel(PublishModel.open);
//    form.setNodeType(NodeType.leaf);
//    form.setCollection("Kanal:" + parent);
//    form.setSubscribe(false);
//	
//    // Schaue ob es den CollectionNode(Kanal) gibt
//    CollectionNode tmp = null;
//    try {
//    	tmp = (CollectionNode) mgr.getNode("Kanal:" + parent);
//    }
//    catch (XMPPException e) {
//    	System.out.println("Falscher CollectionNode(Kanal) wurde eingegeben");
//    	return false;
//    }
//    
//    LeafNode beitrag = null;
//    try {
//    	beitrag = (LeafNode) mgr.createNode(tmp.getId() + "/" + titel, form);
//    	System.out.println("Der LeafNode(Beitrag wurde erstellt: " + beitrag.getId());
//    	return true;
//    }
//    catch (XMPPException e) {
//    	System.out.println("Dieser LeafNode(Beitrag)-Name ist bereits vorhanden: " + titel);
//    	return false;
//    }
//    
//}
//


}
