package ch.hslu.trees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Knoten implements Tree, Comparable<Knoten> {

	static private final Logger LOG = LogManager.getLogger(Knoten.class);

	private Knoten leftChild;
	private Knoten rightChild;
	private int currentValue;
	private int haschCode;

	
	public Knoten(int value) {
		this.currentValue = value;
		this.haschCode = this.hashCode();
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
			LOG.error("Value " + o.getCurrentValue() + " already exists! Value was not safed!");
			return;

			// Knoten gets leftChild of this Knoten
		} else if ((this.compareTo(o)) == 1 && this.getLeftChild() == null) {
			LOG.debug(1);
			this.leftChild = o;
			LOG.debug("Value " + o.getCurrentValue() + " has been added.");
			return;

			// Knoten gets rightChild of this Knoten
		} else if ((this.compareTo(o)) == -1 && this.getRightChild() == null) {
			LOG.debug(2);
			this.rightChild = o;
			LOG.debug("Value " + o.getCurrentValue() + " has been added.");
			return;

			// Knoten gets passed to the leftChild of this Knoten
		} else if ((this.compareTo(o)) == 1 && this.getLeftChild() != null) {
			LOG.debug(3);
			LOG.debug("Value " + o.getCurrentValue() + " has been passed to LeftChild.");
			this.getLeftChild().add(o);
			return;

			// Knoten gets passed to the rightChild of this Knoten
		} else if ((this.compareTo(o)) == -1 && this.getRightChild() != null) {
			LOG.debug(4);
			LOG.debug("Value " + o.getCurrentValue() + " has been passed to right child.");
			this.getRightChild().add(o);
			return;
		} else {
			LOG.error("A Problem has occured! whil adding the Object on " + this);
			return;
		}
	}

	@Override
	public boolean search(Knoten o) {

		// Knoten already exists
		if ((this.compareTo(o)) == 0) {
			LOG.debug("Value " + o.getCurrentValue() + " has been found in: " + this.toString());
			return true;

			// Knoten gets leftChild of this Knoten
		} else if (this.getLeftChild() == null && this.getRightChild() == null) {
			return false;

			// Knoten gets passed to the leftChild of this Knoten
		} else if ((this.compareTo(o)) == 1 && this.getLeftChild() != null) {

			LOG.debug("Searching in: " + this.toString());
			return this.getLeftChild().search(o);

			// Knoten gets passed to the rightChild of this Knoten
		} else if ((this.compareTo(o)) == -1 && this.getRightChild() != null) {
			LOG.debug("Searching in: " + this.toString());
			return this.getRightChild().search(o);

		}
		LOG.error("Knoten: " + o + " doesnt exist.");
		return false;
	}

	@Override
	public void deleteWithoutChildren(Knoten o) {

		if (this.getLeftChild() != null) {
			if (this.getLeftChild().equals(o) && this.getLeftChild().hasChildren() == false) {
				LOG.debug("Value " + this.getLeftChild().getCurrentValue() + " has been deleted: "
						+ this.getLeftChild().toString());
				this.leftChild = null;
				return;
			}

		} else if (this.getRightChild() != null) {
			if (this.getRightChild().equals(o) && this.getRightChild().hasChildren() == false) {
				LOG.debug("Value " + this.getLeftChild().getCurrentValue() + " has been deleted: "
						+ this.getLeftChild().toString());
				this.rightChild = null;
				return;
			}

		}
		if (this.getLeftChild() != null) {
			this.getLeftChild().deleteWithoutChildren(o);
		}
		if (this.getRightChild() != null) {
			this.getRightChild().deleteWithoutChildren(o);
		}
//			LOG.debug("No Item was deleted. Either it has children or it didnt exist");

	}

	@Override
	public void inOrder() {
		if (this.getLeftChild() != null) {
//			LOG.debug("1");	
			this.getLeftChild().inOrder();
		}

		LOG.info("Current Value: " + this.getCurrentValue());
		if (this.getRightChild() != null) {
//			LOG.debug("2");	
			this.getRightChild().inOrder();
		}
	}

	@Override
	public void preOrder() {
		LOG.info("Current Value: " + this.getCurrentValue());
		if (this.getLeftChild() != null) {
//			LOG.debug("1");	
			this.getLeftChild().preOrder();
		}

		if (this.getRightChild() != null) {
//			LOG.debug("2");	
			this.getRightChild().preOrder();
		}
	}

	@Override
	public void postOrder() {
		if (this.getLeftChild() != null) {
//			LOG.debug("1");	
			this.getLeftChild().postOrder();
		}

		if (this.getRightChild() != null) {
//			LOG.debug("2");	
			this.getRightChild().postOrder();
		}
		LOG.info("Current Value: " + this.getCurrentValue());

	}

	public boolean hasChildren() {
		if (this.getLeftChild() == null && this.getRightChild() == null) {
			return false;
		} else
			return true;
	}

	@Override
	public String toString() {
		return "Knoten [leftchild=" + leftChild + ", rightChild=" + rightChild + ", currentValue=" + currentValue + "]";
	}

}
