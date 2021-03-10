package ch.hslu.ownDatastructures;

public interface Stack  {

	/**
	 * Add an Element to the Stack.
	 * @param The Object you want to add to the Stack.
	 * @return void.
	 * 
	 */
	public  void push(Object o);
	
	/**
	 * Remove an Element from the Stack.
	 * @param The Element which you want to be removed.
	 * @return void.
	 */
	public Object pop();
	/**
	 * Returns and deletes last element from this Stack.
	 * @return last added Object.
	 */
	public void clear();
	/**
	 * Returns the number of elements in this Stack.
	 * @return the number of elements in this collection.
	 */
	public int size();
	
	
	
	
}
