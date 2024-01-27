package edu.uwm.apc430.util;

import java.lang.reflect.Array;

public class MergeSort {
	
	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> E[] sort(E[] original) {
		
		if (original.length < 2) {
			return original;
		}	
		
		E[] left = (E[]) Array.newInstance(original.getClass().getComponentType(), original.length/2);
		for (int i = 0; i < left.length; i++) {
			left[i] = original[i];
		}	
		
		E[] right = (E[]) Array.newInstance(original.getClass().getComponentType(), original.length - left.length);
		for (int i = 0; i < right.length; i++) {
			right[i] = original[left.length + i];
		}
			
		// TODO: complete the mergesort
		return merge(sort(left), sort(right));
	}
	
	@SuppressWarnings("unchecked")
	static <E extends Comparable<E>> E[] merge(E[] left, E[] right) {
		E[] out = (E[]) Array.newInstance(left.getClass().getComponentType(), left.length + right.length);
		
		int leftIndex = 0;
		int rightIndex = 0;
		
		for(int i = 0; i < out.length; i++) {
			// TODO:
			// The arrays named left and right should already be sorted.
			// Your task is to merge both arrays into the array called out
			// so that out is also sorted.
			//checks if left or right array ends before the other 
			//then add remaining indexes from that array
			
			if (leftIndex == left.length) {
				out[i] = right[rightIndex];
				rightIndex++;
				
			} else if (rightIndex == right.length) {
				out[i] = left[leftIndex];
				leftIndex++;
				
			} else if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
				out[i] = left[leftIndex];
				leftIndex++;
				
			} else {
				out[i] = right[rightIndex];
				rightIndex++;
			}
		}
		
		return out;
	
	}
}
