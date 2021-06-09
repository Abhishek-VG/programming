package com.java.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = new int[]{6,3,4,1,10};
		sort(arr);
	}
	
	private static void sort(int[] arr) {
		for(int i=0; i<arr.length - 1; i++) {
			for(int j =0; j< arr.length - i - 1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
