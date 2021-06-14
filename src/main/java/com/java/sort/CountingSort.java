package com.java.sort;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 12, 6, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(new CountingSort().getClass().getSimpleName());
		System.out.println("Start = " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Final = " + Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		int highestRange = getLargestNumber(arr) + 1;
		int[] tempCountArray = new int[highestRange];

		int[] tempFinalArray = new int[arr.length];
		for (int val : arr) {
			tempCountArray[val]++;
		}
		for (int j = 1; j < tempCountArray.length; j++) {
			tempCountArray[j] = tempCountArray[j - 1] + tempCountArray[j];
		}

		for (int k = arr.length - 1; k >= 0; k--) {
			int val = arr[k];
			tempFinalArray[--tempCountArray[val]] = arr[k];
		}
		for (int m = 0; m < arr.length; m++)
			arr[m] = tempFinalArray[m];
		System.out.println("temp = " + Arrays.toString(arr));
	}

	private static int getLargestNumber(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
