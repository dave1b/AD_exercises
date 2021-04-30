/*
 * Copymax 2021 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.n4.quicksort;

import ch.hslu.a1.Sort;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public class QuicksortRecursive {

	/**
	 * public method exposed to client, sorts given array using QuickSort Algorithm
	 * in Java.
	 *
	 * @param array input array.
	 */
	public static void quicksort(int[] array) {
		QuicksortRecursive.quickSort(array, 0, array.length - 1);
	}

	/**
	 * Recursive quicksort logic.
	 *
	 * @param array    input array.
	 * @param startIdx start index of the array.
	 * @param endIdx   end index of the array.
	 */
	public static void quickSort(int[] array, int startIdx, int endIdx) {
		
		Sort.quickSort(array, startIdx, endIdx);
		
		
//		int up = startIdx; // linke Grenze
//		int down = endIdx - 1; // rechte Grenze (ohne Trennelement)
//		int t = array[endIdx]; // rechtes Element als Trennelement
//		boolean allChecked = false;
//		do {
//			while (array[up] < t) {
//				up++; // suche grösseres (>=) Element von links an
//			}
//			while ((array[down] >= t) && (down > up)) {
//				down--; // suche echt kleineres (<) Element von rechts an
//			}
//			if (down > up) { // solange keine Überschneidung
//				exchange(array, up, down);
//				up++;
//				down--; // linke und rechte Grenze verschieben
//			} else {
//				allChecked = true; // Austauschen beendet
//			}
//		} while (!allChecked);
//		exchange(array, up, endIdx); // Trennelement an endgültige Position (a[up])
//
//          // Left subproblem as separate thread
//		
//		// hier tasks starten
//		if (startIdx < (up - 1)) {
//			QuicksortTask left = new QuicksortTask(array, startIdx,(up - 1));
//			left.fork();
//			
//		}
//		if ((up + 1) < endIdx) {
//			QuicksortTask right = new QuicksortTask(array, (up + 1),endIdx);
//			right.invoke();
//		}

	}



//	private static void exchange(final int[] array, final int i, final int j) {
//		int temp = array[i];
//		array[i] = array[j];
//		array[j] = temp;
//	}
}
