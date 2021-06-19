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
public class FibonacciPartialSum2 {

	private static long fibonacci_mod10(long n) {
		long previous = 0;
		long current = 1;
		long sum = 1;

		for (long i = n; i <= n-1; i++) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
		}
		return current % 10;
	}

	private static long getFibonacciSumNaive(long from, long to) {
		from = from % 60;
		to = from + (to - from) % 60;
		System.out.println("from = "+ from+" , to = "+ to);
		int sum = 0;
		for (long i = from; i <= to; i++) {
			long z = fibonacci_mod10(i);
//			System.out.println(z);
			sum += z;
		}
		return sum % 10;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long from = scanner.nextLong();
		long to = scanner.nextLong();
		System.out.println(getFibonacciSumNaive(from, to));
	}
}
