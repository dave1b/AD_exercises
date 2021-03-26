package ch.hslu.ownDatastructures;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class PerformanceIntGenerator{

	
	
	static private final Logger LOG = LogManager.getLogger(PerformanceIntGenerator.class);
	
	
	static int[] returnData(int size) {
		long startTime = System.currentTimeMillis();
		
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = i;
		}
		long endTime = System.currentTimeMillis();
		LOG.info("Array-Duration in ms: " + (endTime-startTime));
		return array;
	}
	
	static Stack<Integer> returnDataStack(int size) {
		
		long startTime = System.currentTimeMillis();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < size; i++) {
			stack.push(i);
		}
		long endTime = System.currentTimeMillis();
		LOG.info("Stack-Duration in ms: " + (endTime-startTime));	
		return stack;
	}
	static OwnStack returnDataOwnStack(int size) {
		long startTime = System.currentTimeMillis();
		OwnStack ownStack = new OwnStack(size);
		for(int i = 0; i < size; i++) {
			ownStack.push(i);
		}
		long endTime = System.currentTimeMillis();
		LOG.info("OwnStack-Duration in ms: " + (endTime-startTime));	
		return ownStack;
		
	}
	static Deque<Integer> returnDataDeque(int size) {
		long startTime = System.currentTimeMillis();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i = 0; i < size; i++) {
			deque.add(i);
		}
		long endTime = System.currentTimeMillis();
		LOG.info("Deque-Duration in ms: " + (endTime-startTime));		
		return deque;
	}
	
	
	
	
	public static void main(final String[] args) {
		int iterationen = 100000000;
		PerformanceIntGenerator.returnData(iterationen);
		PerformanceIntGenerator.returnDataStack(iterationen);
		PerformanceIntGenerator.returnDataOwnStack(iterationen);
		PerformanceIntGenerator.returnDataDeque(iterationen);	
	}
	
	
}
