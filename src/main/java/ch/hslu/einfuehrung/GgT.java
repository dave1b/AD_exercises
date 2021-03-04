package ch.hslu.einfuehrung;

public class GgT {

	public static int ggtIterativ1(int a, int b) {
		int i = 0;
		while (a != b) {
			if (a > b) {
				a = a - b;
				i++;
			} else {
				b = b - a;
				i++;
			}
		}
		System.out.println("ggtIterativ1 - Durchläufe: " + i);
		return a;
	}

	public static int ggtIterativ2(int a, int b) {
		int i = 0;
		while ((a != 0) && (b != 0)) {
			if (a > b) {
				a = a % b;
				i++;
			} else {
				b = b % a;
				i++;
			}
		}
		System.out.println("ggtIterativ2 - Durchläufe: " + i);
		return (a + b); // Entweder a oder b ist 0!
	}

	
	public static int ggtRekursiv(final int a, final int b) {
		int i = 0;
		if(a > b) {
			i++;
		return ggtRekursiv(a -b, b);
		} else{ 
			i++;
		if(a < b) {
			i++;
		return ggtRekursiv(a, b -a);
		} else{
			System.out.println("ggtRekursiv1 - Durchläufe: " + i);
		return a;
		}
		}
		}
	
	
	 public static void main(final String[] args) {
		 final int a = 22;
		 final int b = 68;
		 
		 ggtIterativ1(a, b);
		 ggtIterativ2(a, b);
		 ggtRekursiv(a, b);
		 
		 
		 
		 
	 }
	
}



