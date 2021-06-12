package com.java.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

//		int[] arr = new int[] { 3, 2, 1 };
		int[] arr = new int[] { 6, 4, 13, 1, 10 };
//		int[] arr = new int[] { 9, 7, 8, 3, 2, 1 };
//		sortMethod1(arr, 0, arr.length - 1);
		sortMethod2(arr, 0, arr.length - 1);
		System.out.println(new QuickSort().getClass().getSimpleName());
		System.out.println(Arrays.toString(arr));
	}

	private static void sortMethod1(int[] arr, int start, int end) {
		int i = start;
		int j = end;
		int pivot = arr[start];
		if (start < end) {
			while (i < j) {
				while (i < end && arr[i] <= pivot) {
					i++;
				}
				while (j > start && arr[j] > pivot) {
					j--;
				}
				if (i < j) {
					swap(arr, i, j);
				}
			}
			swap(arr, start, j);
			sortMethod1(arr, start, j - 1);
			sortMethod1(arr, j + 1, end);
		}
	}

	private static void sortMethod2(int[] arr, int start, int end) {
		if (start < end) {
			int pivIndex = partition(arr, start, end);
			sortMethod2(arr, start, pivIndex - 1);
			sortMethod2(arr, pivIndex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int i = start - 1;
		int pivotElem = arr[end];
		for (int j = start; j <= end; j++) {
			if (arr[j] < pivotElem) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, end);
		return i + 1;
	}

//	private static void sort(int[] arr, int start, int end) {
//		int i = start;
//		int j = end;
//		if (start < end) {
//			int pivotIndex = start;
//			while (i < j) {
//				int pivot = arr[pivotIndex];
//				while (i < end && arr[i] < pivot) {
//					i++;
//				}
//				while (j > start && arr[j] >= pivot) {
//					j--;
//				}
//				swap(arr, pivotIndex, j);
//			}
//			sort(arr, start, j - 1);
//			sort(arr, j + 1, end);
//		}
//	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
