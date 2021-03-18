package ch.hslu.ownDatastructures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class OwnStack implements StackInterface {

	
	static private final Logger LOG = LogManager.getLogger(OwnStack.class);
	private Object[] stack;
	private int current = 0;
	private final int maxSize;

	public OwnStack(int size) {
		stack = new Object[size];
		maxSize = size;
	}

	@Override
	public void push(Object o) {
		if(current+1== maxSize) {
			LOG.error("Max size of the StackInterface reached. Value was not safed!");
		} else {
		if (stack[0] != null) {
			current++;
		}
		stack[current] = o;
		}
	}

	@Override
	public Object pop() {
//		stack[current] = null;
		--current;
		return stack[current + 1];
	}

	@Override
	public void clear() {
		for (int l = 0; l != stack.length; l++) {
			stack[l] = null;
		}
		current = 0;
	}

	@Override
	public int size() {
		if (stack[0] == null) {
			return 0;
		} else {
			return current + 1;
		}
	}

}
