package ch.hslu.trees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TreeApplication {
	static private final Logger LOG = LogManager.getLogger(TreeApplication.class);
	
	
	public static void main(final String[] args) {
		Knoten root = new Knoten(5);
		LOG.debug("---");
		root.add(new Knoten(2));
		LOG.debug("---");
		root.add(new Knoten(2));
		LOG.debug("---");
		root.add(new Knoten(1));
		LOG.debug("---");
		root.add(new Knoten(3));
		LOG.debug("---");
		root.add(new Knoten(25));
		LOG.debug("---");
		root.add(new Knoten(7));
		LOG.debug("---");
		root.add(new Knoten(8));
		LOG.debug("---");
		root.add(new Knoten(0));
		LOG.debug("---");
		root.add(new Knoten(11));
		LOG.debug("---");
		root.add(new Knoten(200));
		LOG.debug("---");
		
		
//		root.inOrder();
//		root.preOrder();
		root.postOrder();
		root.deleteWithoutChildren(new Knoten(0));
		root.postOrder();
//		System.out.println(root.hasChildren());
		
		
	}
 	
	
	
	
	
	
	
}
