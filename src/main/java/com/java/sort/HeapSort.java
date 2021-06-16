package com.java.sort;

import java.util.Arrays;

public class HeapSort {
	static public void sort(int arr[]) {
		int n = arr.length;
		for (int i = (n / 2 - 1); i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = 0; i < n - 1; i++) {
			swap(arr, 0, n - 1 - i);
			heapify(arr, n - 1- i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	static void heapify(int arr[], int n, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(arr, largest, i);
			heapify(arr, n , largest);
		}
	}

	private static void swap(int[] arr, int largest, int i) {
		int temp = arr[largest];
		arr[largest] = arr[i];
		arr[i] = temp;
	}

	// Driver code
	public static void main(String args[]) {
//		int arr[] = { 12, 11, 13 };
//        int arr[] = { 12, 11, 13, 5, 6, 7 };
      int arr[] = { 15, 5, 20, 1, 17, 10, 30 };
		sort(arr);
	}
}
