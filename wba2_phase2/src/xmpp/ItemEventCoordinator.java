package xmpp;

import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

class ItemEventCoordinator implements ItemEventListener {
	
	public void handlePublishedItems(ItemPublishEvent items) {
		System.out.println("Item count: " + items.getItems().size());
		System.out.println(items);
	}

}