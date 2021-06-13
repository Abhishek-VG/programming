package com.java.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 2,4,2,4,5,2 };
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	
	private static void merge(int[] arr, int start, int mid	,int end) {
		int[] tempArr = new int[end - start + 1];
		int k=0,m=start,n=mid + 1;
		while(m <= mid && n <= end) {
			if(arr[m] <= arr[n]) {
				tempArr[k++] = arr[m++];
			} else if(arr[m] > arr[n]) {
				tempArr[k++] = arr[n++];
			} 
		}
		while(m<=mid) {
			tempArr[k++] = arr[m++];
		}
		while(n<=end) {
			tempArr[k++] = arr[n++];			
		}
		for(int i=0;i<tempArr.length;i++) {
			arr[i+start] = tempArr[i];
		}
	}

}
