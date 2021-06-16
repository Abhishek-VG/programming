package com.java.coursera.algorithmictoolbox.week2;

import java.util.Scanner;

public class FibonacciModulusOfANumber {
	private static long getFibonacciHugeNaive(long n, long m) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;

		for (long i = 0; i < n; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = (tmp_previous + current);
		}
		System.out.println(current);
		return current % m;
	}

	private static long pisanoPeriodlength(long m) {
		long previous = 0;
		long current = 1;
		long res = 0;
		for (long i = 0; i < m * m; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = (tmp_previous + current) % m;

			if (previous == 0 && current == 1) {
				res = i + 1;
			}

		}
		return res;
	}

	// refer pdf
	private static long getFibonacciHugeOptimized(long n, long m) {
		long l = pisanoPeriodlength(m);
		n = n % l;

		long prev = 0;
		long curr = 1;

		if (n == 0 || n == 1)
			return n;

		for (int i = 0; i < n - 1 ; i++) {
			long temp = curr;
			curr = (curr + prev) % m;
			prev = temp;
		}
		return curr;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();

			long ansNav;
		long ansOpt;
			long startTime = System.currentTimeMillis();
			System.out.println(ansNav = getFibonacciHugeNaive(n, m));
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("Naive method = " + elapsedTime);

			startTime = System.currentTimeMillis();
		System.out.println(ansOpt = getFibonacciHugeOptimized(n, m));
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Optimized method = " + elapsedTime);
		System.out.println("Result match = " + (ansNav == ansOpt ? "Passed" : "failed"));

	}
}
