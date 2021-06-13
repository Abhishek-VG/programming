package com.java.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 6, 3, 4, 1, 10 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(arr[j] <= arr[j -1]) {
					swap(arr, j, j-1);
				} else {
					break;
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		System.out.println(Arrays.toString(arr));
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
