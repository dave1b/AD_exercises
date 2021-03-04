package ch.hslu.einfuehrung;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class FibonacciRekursion {

	static List<Long> fibonacciReihe = new ArrayList<>(); 
	static private final Logger LOG = LogManager.getLogger(FibonacciRekursion.class);
// MAIN	
	public static void main(final String[] args) {
		
		
		System.out.println(fib(8));
		System.out.println(formelFib(8));
		fibonacciReihe.stream()
		.forEach(t -> System.out.println(t));		
//		LOG.info(isFibonacci(200));
		LOG.info(nextFibonacci(3));
	}
	
// Rekursiv
	public static long fib(int a) {
		if (a <= 1)
			return a;
		else {
			return fib(a - 1) + fib(a - 2);
		}
	}

	public static double formelFib(double a) {
		return (1/Math.sqrt(5d))*(Math.pow((0.5*(1+Math.sqrt(5))),a));
	}
	
// Liste mit Fibonacci befüllen
	public static void fibForList(int a) {
		for(int i = 0; i <= a; i++) {
			fibonacciReihe.add(fib(i));
		}
	}
	
// Ist x eine Fibonacci Zahl
	public static boolean isFibonacci(long x) {
		if(fibonacciReihe.size()>=0) {
			fibForList(20);
		}		
		if(fibonacciReihe.contains(x)) {
			return true;
		} else return false;
	}
// Nächste Fibonacci Zahl
	private static long nextFibonacci(long x) {
		return fibonacciReihe.get(fibonacciReihe.indexOf(x)+1);
	}
	
	
	
// Iterative Lösung
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


