package ch.hslu.ownDatastructures;

public interface StackInterface  {

	/**
	 * Add an Element to the StackInterface.
	 * @param The Object you want to add to the StackInterface.
	 * @return void.
	 * 
	 */
	public  void push(Object o);
	
	/**
	 * Remove an Element from the StackInterface.
	 * @param The Element which you want to be removed.
	 * @return void.
	 */
	public Object pop();
	/**
	 * Returns and deletes last element from this StackInterface.
	 * @return last added Object.
	 */
	public void clear();
	/**
	 * Returns the number of elements in this StackInterface.
	 * @return the number of elements in this collection.
	 */
	public int size();
	
	
	
	
}
