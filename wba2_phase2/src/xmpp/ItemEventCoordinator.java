package xmpp;

import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;


public class ItemEventCoordinator implements ItemEventListener {
	public void handlePublishedItems(ItemPublishEvent items) {
		System.out.println("HALLO NEUES ITEM GEPUBLISHED");
		System.out.println("Item count: " + items.getItems().size());
		System.out.println(items);
	}
}