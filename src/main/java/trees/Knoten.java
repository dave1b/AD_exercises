package trees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Knoten implements Tree, Comparable<Knoten> {

	static private final Logger LOG = LogManager.getLogger(Knoten.class);

	private Knoten leftChild;
	private Knoten rightChild;
	private int currentValue;

	public Knoten(int value) {
		this.currentValue = value;
	}

	@Override
	public Knoten getLeftChild() {
		return leftChild;
	}

	@Override
	public Knoten getRightChild() {
		return rightChild;
	}

	@Override
	public int getCurrentValue() {
		return currentValue;
	}

	@Override
	public int compareTo(Knoten o) {
		if (this == o) {
			return 0;
		} else {
//			return this.getCurrentValue().compareTo(o.getCurrentValue());
			return Integer.compare(this.getCurrentValue(), o.getCurrentValue());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knoten other = (Knoten) obj;
		if (currentValue != other.currentValue)
			return false;
		return true;
	}

	@Override
	public void add(Knoten o) {
		
		// Knoten already exists
		if ((this.compareTo(o)) == 0) {
			LOG.error("Value " +  o.getCurrentValue() + " already exists! Value was not safed!");
			return;
			
		// Knoten gets leftChild of this Knoten 
		} else if ((this.compareTo(o)) == 1 && this.getLeftChild() == null) {
			LOG.info(1);
			this.leftChild = o;
			
		// Knoten gets rightChild of this Knoten 
		} else if ((this.compareTo(o)) == -1 && this.getRightChild() == null) {
			LOG.info(2);
			this.rightChild = o;
			
		// Knoten gets passed to the leftChild of this Knoten 
		} else if ((this.compareTo(o)) == 1 && this.getLeftChild() != null) {
			LOG.info(3);
			this.getLeftChild().add(o);

		// Knoten gets passed to the rightChild of this Knoten 
		} else if ((this.compareTo(o)) == -1 && this.getRightChild() != null) {
			LOG.info(4);
			this.getRightChild().add(o);
		} else {
			LOG.error("A Problem has occured! whil adding the Object on " + this);
		}
	}

	@Override
	public String toString() {
		return "Knoten [leftchild=" + leftChild + ", rightChild=" + rightChild + ", currentValue=" + currentValue + "]";
	}
	
	
	
	
}
