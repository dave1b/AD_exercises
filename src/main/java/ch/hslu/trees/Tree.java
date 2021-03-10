package ch.hslu.trees;

public interface Tree {

	public Object getLeftChild();
	public Object getRightChild();
	public int getCurrentValue();
	void add(Knoten o);
}
