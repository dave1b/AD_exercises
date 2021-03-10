package ch.hslu.ownDatastructures;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OwnQueue implements Queue {

	static private final Logger LOG = LogManager.getLogger(OwnQueue.class);
	private int addIndex = 0;
	private int pollIndex = 0;
	private Object[] queue;
	private final int maxSize;

	public OwnQueue(int size) {
		queue = new Object[size];
		this.maxSize = size;
	}

	@Override
	public void add(Object o) {
		if (this.size() == maxSize) {
			LOG.error("Max size of the queue is reached Value wasn't safed!");
			return;
		} else if (addIndex == maxSize) {
			addIndex = 0;
			queue[addIndex] = o;
			addIndex++;
		} else {
			queue[addIndex] = o;
		addIndex++;
		}
	}

	@Override
	public Object poll() {
		if (pollIndex == maxSize) {
			pollIndex = 0;
			Object o = queue[maxSize];
			queue[maxSize] = null;
			return o;

		} else
			pollIndex++;
		Object o = queue[pollIndex - 1];
		queue[pollIndex - 1] = null;
		return o;
	}

	@Override
	public int size() {
		if (pollIndex > addIndex) {
			return maxSize - pollIndex + addIndex;
		}
		return addIndex - pollIndex;
	}

	@Override
	public String toString() {
		return "OwnQueue [addIndex=" + addIndex + ", pollIndex=" + pollIndex + ", queue=" + Arrays.toString(queue)
				+ ", maxSize=" + maxSize + "]";
	}

}
