package ch.hslu.hashTabelle;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HashTable<E> implements HashArrayInterface<Integer> {

	static private final Logger LOG = LogManager.getLogger(HashTable.class);

	Integer[] hashArray = new Integer[10];
	private int size;
	final private int maxSize = 10;

	@Override
	public void add(Integer e) {
		if (this.isFull() == true) {
			LOG.error("This HashTable is full. Value has NOT been saved!");
			return;
		}
		int i = 0;
		while ((hashArray[this.hash(e) + i]) != null) {
			if (this.hash(e) + i + 1 == this.maxSize) {
				i = -this.hash(e);
			} else {
				i++;
				if (this.hash(e) + i == this.hash(e)) {
					return;
				}
			}
		}
		hashArray[this.hash(e) + i] = e;
		size++;
	}

	@Override
	public Integer search(Integer e) {
		
		int i = 0;
		while ((hashArray[this.hash(e) + i]) != e) {
			if (this.hash(e) + i + 1 == this.maxSize) {
				i = -this.hash(e);
			} else {
				i++;
				if (this.hash(e) + i == this.hash(e)) {
					return null;
				}
			}
		}
		return hashArray[this.hash(e)+i];
		
	}

	@Override
	public void remove(Integer e) {
		
		int i = 0;
		while ((hashArray[this.hash(e) + i]) != e) {
			if (this.hash(e) + i + 1 == this.maxSize) {
				i = -this.hash(e);
			} else {
				i++;
				if (this.hash(e) + i == this.hash(e)) {
					return;
				}
			}
		}
		hashArray[this.hash(e) + i] = null;
		--size;
		

	}

	@Override
	public String toString() {
		return "HashTable [hashArray=" + Arrays.toString(hashArray) + ", size=" + size + ", maxSize=" + maxSize + "]";
	}

	private boolean exists(Integer e) {	
		int i = 0;
		while ((hashArray[this.hash(e) + i]) != e) {
			if (this.hash(e) + i + 1 == this.maxSize) {
				i = -this.hash(e);
			} else {
				i++;
				if (this.hash(e) + i == this.hash(e)) {
					return false;
				}
			}
		}
	return true;
	}

	public boolean isFull() {
		if (size != maxSize) {
			return false;
		} else
			return true;
	}

	public int size() {
		return this.size;
	}

	private int hash(Integer e) {
		return e % 10;
	}

}
