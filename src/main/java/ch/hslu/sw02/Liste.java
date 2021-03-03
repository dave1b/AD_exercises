package ch.hslu.sw02;

public class Liste {

	private Node first;
	
	public Liste() {
		
	}
	
	
	public void setFirst(Node first) {
		this.first = first;
	}
	public Node getFirst() {
		return this.first;
	}
	
	public void addNode(String data) {
		setFirst(new Node(getFirst(), data));
	}
	
	public void deleteFirst() {
		first = first.getNext();
	}
	
	public void delet(Node node) {
		if(first != null) {
			Node before;
			Node current = first;
			if(first.equals(node)) {
				setFirst(first.getNext());
			}
			while(current.hasNext()) {
				before = current;
				current = current.getNext();
				if(current.equals(node)) {
					before.setNext(current.getNext());
				}
			}
		}
	}
	
	public int size() {
		int i = 0;
		if(first != null) {
			Node current = first;
			i++;
			while(current.hasNext()) {
				i++;
				current = current.getNext();
			}
			return i;	
		}
		return 0;
	}
	
	public boolean isExisting(Node node) {
		if(first != null) {
			Node current = first;
			if(first.equals(node)) {
				return true;
			}
			while(current.hasNext()) {
				current = current.getNext();
				if(current.equals(node)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
