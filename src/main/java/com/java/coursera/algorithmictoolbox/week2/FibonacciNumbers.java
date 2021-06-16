package com.java.coursera.algorithmictoolbox.week2;

import java.io.*;
import java.util.*;

// get nth fibanocci number
public class FibonacciNumbers {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner(System.in);
		long n = sc.nextLong();
		long ansNav;
		long ansOpt;
		// Naive method
		long startTime = System.currentTimeMillis();
		System.out.println(ansNav = computeNthFibNaive(n));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Naive method = " + elapsedTime);

		// optimized method
		startTime = System.currentTimeMillis();
		System.out.println(ansOpt = computeNthFibOpt(n));
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Optimized method = " + elapsedTime);
		System.out.println("Result match = " + (ansNav == ansOpt ? "Passed": "failed") );

	}

	private static long computeNthFibNaive(long n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return computeNthFibNaive(n - 1) + computeNthFibNaive(n - 2);
	}

	private static long computeNthFibOpt(long n) {
		if (n == 0 || n == 1)
			return n;
		long first = 1;
		long second = 0;
		long total = 0;
		for (int i = 0; i < n; i++) {
			total = first + second;
			first = second;
			second = total;
		}
		return total;
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
