package com.java.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 12, 6, 123, 3213, 412, 12312, 4214, 1, 4, 0, 123 };
		System.out.println(new RadixSort().getClass().getSimpleName());
		System.out.println("Start = " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Final = " + Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		int numberOfRuns = getLargestNumber(arr);
		for (int i = 0; i < numberOfRuns; i++) {
			int[] tempCountArray = new int[10];
			int[] tempFinalArray = new int[arr.length];
			for (int val : arr) {
				int count = i + 1;
				int rem = -1;
				while (count-- > 0) {
					rem = val % 10;
					val = val / 10;
				}
				tempCountArray[rem]++;
			}
			System.out.println(i + Arrays.toString(tempCountArray));
			for (int j = 1; j < tempCountArray.length; j++) {
				tempCountArray[j] = tempCountArray[j - 1] + tempCountArray[j];
			}
			System.out.println("i = " + i + " >>" + Arrays.toString(tempCountArray));

			for (int k = arr.length - 1; k >= 0; k--) {
				int val = arr[k];
				int count = i + 1;
				int rem = -1;
				while (count-- > 0) {
					rem = val % 10;
					val = val / 10;
				}
				tempFinalArray[--tempCountArray[rem]] = arr[k];
			}
			for (int m = 0; m < arr.length; m++)
				arr[m] = tempFinalArray[m];
			System.out.println("temp = " + Arrays.toString(arr));
		}
	}

	private static int getLargestNumber(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return Integer.toString(max).length();
	}

}
