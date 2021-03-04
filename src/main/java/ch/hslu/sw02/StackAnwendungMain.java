package ch.hslu.sw02;

public class StackAnwendungMain {

	public static void main(final String[] args) {
		OwnStack stack = new OwnStack(100);
		stack.push("toll!");
		stack.push("sind ");
		stack.push("Datenstrukturen ");
		
		System.out.print(stack.pop());
		System.out.print(stack.pop());
		System.out.print(stack.pop());
		
	}
	
	
}
