package ch.hslu.a2;

public class FixedSizeHeap implements IntegerHeap {

	int[] heap;
	int addIndex;

	public FixedSizeHeap(int size) {
		heap = new int[size];
		addIndex = 0;
	}

	@Override
	public void insert(final int e) {
		if (this.isFull()) {
			throw new IllegalStateException("The Heap is Full");
		} else {
			heap[addIndex] = e;
			if (!(this.isEmpty())) {
				this.reorganiseAfterInsert(addIndex);
			}
			addIndex++;
		}
	}

	@Override
	public void reorganiseAfterInsert(int index) {
		if (index > 2) {
			if (index % 2 == 1) {
				if (heap[index] > heap[(index - 1) / 2]) {
					this.swap(index, (index - 1) / 2);
					this.reorganiseAfterInsert((index - 1) / 2);
				}
			} else {
				if (heap[index] > heap[(index / 2) - 1]) {
					this.swap(index, (index / 2) - 1);
					this.reorganiseAfterInsert((index / 2) - 1);
				}
			}
		} else {
			if (index % 2 == 1) {
				if (heap[index] > heap[(index - 1)]) {
					this.swap(index, (index - 1));
				}
			} else {
				if (heap[index] > heap[(index - 2)]) {
					this.swap(index, (index - 2));
				}
			}

		}
	}

	@Override
	public int getMax() {
		int tmpReturn = heap[0];
		heap[0] = heap[addIndex - 1];
		heap[addIndex - 1] = 0;
		
		this.reorganiseAfterGetMax(0);
		--addIndex;
		return tmpReturn;
	}

	@Override
	public void reorganiseAfterGetMax(int index) {
		boolean leftChildBigger = false;
		if (heap[(2 * index) + 1] > heap[2 * (index + 1)]) {
			leftChildBigger = true;
		}
		if (leftChildBigger) {
			if (heap[index] < heap[2 * index + 1]) {
				this.swap(2 * index + 1, index);		
			} else {
			}
			if (addIndex > 2 * index + 1) {
				this.reorganiseAfterGetMax(2 * index + 1);
			}

		} else if (!(leftChildBigger)) {
			if (heap[index] < heap[2 * (index + 1)]) {
				this.swap(2 * (index + 1), index);
			} else {
			}
			if (addIndex > 2 * (index + 1)) {
				this.reorganiseAfterGetMax(2 * (index + 1));
			}
		}
	}

	private void swap(int index1, int index2) {
		int tmp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = tmp;
	}

	@Override
	public boolean isFull() {
		if (heap.length == addIndex) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isEmpty() {
		if (addIndex == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void printHeap() {
		System.out.println();
		for (int i : heap) {
			System.out.print(i + ", ");
		}
	}
}
