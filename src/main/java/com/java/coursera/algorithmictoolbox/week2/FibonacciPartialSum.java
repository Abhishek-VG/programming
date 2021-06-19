package com.java.coursera.algorithmictoolbox.week2;

import java.util.Scanner;

/* 
 * PISANO method
 * 
 * For modulus 10,
 * the last digit will be output
 * 
 * PISANO method used to find the pattern of fibanocci servies for the reminder or modules
 * 
 * example f2015 last digit can be found as in last problem
 * 
 * similarly for this problem, summiung will also work
 * 
 * "0,  1,  1,  2,  3,  5,  8,  3,  1,  4,  5,  9,  4,  3,  7,  0,  7,  7,  4,  1,  5,  6,  1,  7,  8,  5,  3,  8,  1,  9,  0,  9,  9,  8,  7,  5,  2,  7,  9,  6,  5,  1,  6,  7,  3,  0,  3,  3,  6,  9,  5,  4,  9,  3,  2,  5,  7,  2,  9,  1"
 * SUM = 280
 */

/*
 * index  1 2 3 4 5   6   7   8   9   10
 * fib    1 1 2 3 5   8  13  21  34   55
 * fibsum 1 2 4 7 12 20  33  54  88   143
 * 
 * 12 143
 */
public class FibonacciPartialSum {

	private static long getFibonacciSumNaive(long n) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;
		long sum = 1;

		for (long i = 0; i < n - 1; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
			sum += current;
		}
		return sum;
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

		long sum = prev + curr;
		for (int i = 0; i < n - 1; i++) {
			long temp = curr;
			curr = (curr + prev) % m;
			prev = temp;
			sum += curr;
		}
		return sum % 10;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long from = scanner.nextLong();
		long to = from + (scanner.nextLong() - from);
		long sum1 = Math.abs(from == 0 ? 0 : (getFibonacciHugeOptimized(from - 1, 10)));
		long sum2 = Math.abs(getFibonacciHugeOptimized(to, 10));
		if(sum1 >= sum2) {
			System.out.println(Math.abs(sum1 - (sum2 + 10)) % 10); 
		} else {
			System.out.println(Math.abs(sum1 - sum2));			
		}
	}
}
