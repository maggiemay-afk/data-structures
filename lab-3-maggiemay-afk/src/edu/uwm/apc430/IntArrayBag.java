package edu.uwm.apc430;


public class IntArrayBag implements Cloneable {
	private Integer[] data;
	private int manyItems;

	public IntArrayBag() {
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = new Integer[INITIAL_CAPACITY];
	}

	public IntArrayBag(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("initialCapacity is negative: "
					+ initialCapacity);
		}
		manyItems = 0;
		data = new Integer[initialCapacity];
	}

	public void add(Integer element) {
		if (element == null) throw new IllegalArgumentException();
		
		assert wellFormed() : "Failed at the start of add";
		ensureCapacity(manyItems + 1);		
		data[manyItems] = element;
		manyItems++;
		
		assert wellFormed() : "Failed at the end of add";
	}

	private boolean _report(String message) {
		System.out.println(message);
		return false;
	}

	private boolean wellFormed() {
		// Make assertions about the invariant, returning false
		// if the invariant false. Taken from pg 123 (3rd ed.)

		// #1. manyItems should never be greater than data.length
		if (manyItems > data.length)
			return _report("manyItems is greater than data.length");

		// #2. When the bag isn't empty, then items data[0] to data[manyItems-1]
		// should contain data and therefore not be null
		// (this is because null data are not allowed in this bag)
		// TODO Implement the 2nd Invariant
		// NB: This part of the invariant is different in the homework!
		if (manyItems > 0) {
			for (int i=0; i < manyItems; i++) {
				if (data[i] == null) return _report("data contains null items");
			}
		}

		// All invariant assertions passed so return true
		return true;
	}

	public boolean remove(Integer target) {
		if (target == null) throw new IllegalArgumentException();
		
		assert wellFormed() : "Failed at the start of remove";

		int index = 0;
		while ((index < manyItems) && (target != data[index])) {
			index++;
		}

		if (index == manyItems) {
			return false;
		} else {
			data[index] = null;
			--manyItems;
			assert wellFormed() : "Failed at the end of remove";
			return true;
		}
	}

	public int size() {
		return manyItems;
	}

	public int getCapacity() {
		return data.length;
	}

	public int countOccurrences(Integer target) {
		if (target == null) throw new IllegalArgumentException();
		
		assert wellFormed() : "Failed at the start of countOccurrences";
		
		int answer = 0;
		int index = 0;

		for (index = 0; index < manyItems; index++) {
			if (target == data[index]) {
				answer++;
			}
		}
		return answer;
	}

	public void ensureCapacity(int minimumCapacity) {
		// Do nothing if the current capacity is at least minimumCapacity
		// Otherwise make a bigger array of the larger of 
		// minimumCapacity and one more than twice the current capacity then copy elements over
		// This code will be useful for the Homework too,
		// with minor adjustments.
		
		if (minimumCapacity <= data.length) return;
		
		int newSize = (data.length * 2);
		if (newSize < minimumCapacity) {
			newSize = minimumCapacity;
		}
		
		Integer[] tempArray = new Integer[newSize];
		for (int i=0; i < manyItems; i++) {
			tempArray[i] = data[i];
		}
		
		data = tempArray;
		
	}
}

