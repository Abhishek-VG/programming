package com.java.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 3,1,2,8,99,6776,34};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		sort(arr, start, mid);
		sort(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int[] tempArr = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;
		while (mid >= i && end >= j) {
			if (arr[i] > arr[j]) {
				tempArr[k++] = arr[j++];
			} else if (arr[i] < arr[j]) {
				tempArr[k++] = arr[i++];
			}

		}
		while (mid >= i) {
			tempArr[k++] = arr[i++];
		}
		
		while (end >= j) {
			tempArr[k++] = arr[j++];
		}
		for (int m = 0; m < tempArr.length; m++) {
			arr[m + start] = tempArr[m];
		}
	}

}
