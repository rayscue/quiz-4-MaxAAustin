package quiz4;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleLinkedListTest {
	
	private static final int LIST_SIZE = 100000;
	private static final int NUM_ITERATIONS = 100;
	private static final int GET_POSITION = LIST_SIZE / 2 + LIST_SIZE / 3;
	
	
	@Test
	public void testGet() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.add(1);
		assertEquals(1, (int) list.get(0));
		list.add(2);
		assertEquals(2, (int) list.get(1));
	}
	
	@Test
	public void timeGet() {
		OriginalDoubleLinkedList<Integer> originalList = new OriginalDoubleLinkedList<Integer>();
		DoubleLinkedList<Integer> newList = new DoubleLinkedList<Integer>();
		for (int i = 0; i < LIST_SIZE; i++) {
			originalList.add(1);
			newList.add(1);
		}
		
		double averageOriginalListDuration = 0;
		double averageNewListDuration = 0;
		
		for (int i = 0; i < NUM_ITERATIONS; i++) {
			int slowListStart = (int) System.nanoTime();
			originalList.get(GET_POSITION);
			int slowListStop = (int) System.nanoTime();
			
			int improvedListStart = (int) System.nanoTime();
			newList.get(GET_POSITION);
			int improvedListStop = (int) System.nanoTime();
			
			averageOriginalListDuration += (slowListStop - slowListStart) / (double) NUM_ITERATIONS;
			averageNewListDuration += (improvedListStop - improvedListStart) / (double) NUM_ITERATIONS;
		}
		
		double timeDifference = averageNewListDuration - averageOriginalListDuration;
		
		System.out.println("Improvement: " + timeDifference + " nanoseconds.");
	}

	@Test
	public void testFind() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		assertEquals(-1, list.find(1));
		
		list.add(1);
		assertEquals(0, list.find(1));
		
		list.add(1);
		/*
		 * Should find first occurrence.
		 * List is now [1, 1]
		 */
		assertEquals(0, list.find(1));
		
		list.add(2);
		// List is now [1, 1, 2]
		assertEquals(2, list.find(2));
		
		assertEquals(-1, list.find(3));
	}

	@Test
	public void testFindEInt() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		assertEquals(-1, list.find(1));
		
		list.add(1);
		assertEquals(0, list.find(1));
		
		list.add(1);
		/*
		 * Should find first occurrence.
		 * List is now [1, 1]
		 */
		assertEquals(1, list.find(1, 1));
	}

}
