package ch.hslu.a2;

public interface IntegerHeap {

	/**
	 * 
	 * @param The int-value to be entered. 
	 */
	public void insert(final int e);


	/**
	 * 
	 * @return the biggest int-value in the heap.
	 */
	public int getMax();
	
	/**
	 * Ist eine Hilfmethode für insert(), welche den grössten int-value 
	 * wieder auf die Rootposition bringt.
	 */
	public void reorganiseAfterInsert(int index);
	
	/**
	 * Ist eine Hilfmethode für getMax(), welche das neue RootValue mit seinen Kindern
	 * und Kindeskindern vergleicht. 
	 */
	public void reorganiseAfterGetMax(int index);
	
	
	/**
	 * 
	 * @return true if the heap is full.
	 */
	public boolean isFull();
	
	
	/**
	 * 
	 * @return true if the heap is empty.
	 */
	public boolean isEmpty();
	
	
}
