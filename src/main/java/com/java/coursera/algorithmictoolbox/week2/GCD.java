package com.java.coursera.algorithmictoolbox.week2;

import java.util.Scanner;

public class GCD {
	private static int gcd_naive(int a, int b) {
		int current_gcd = 1;
		for (int d = 2; d <= a && d <= b; ++d) {
			if (a % d == 0 && b % d == 0) {
				if (d > current_gcd) {
					current_gcd = d;
				}
			}
		}

		return current_gcd;
	}
	
	private static int gcd_optimized(int a, int b) {
		if(b == 0) {
			return a;
		}
		int temp = a % b;
		a = b;
		b = temp;
		return gcd_optimized(a, b);
	}
	
	
//821487621 821368713

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int ansNav;
		int ansOpt;
		long startTime = System.currentTimeMillis();
		System.out.println(ansNav = gcd_naive(a, b));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Naive method = " + elapsedTime);
		
		startTime = System.currentTimeMillis();
		System.out.println(ansOpt = gcd_optimized(a, b));
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Optimized method = " + elapsedTime);
		System.out.println("Result match = " + (ansNav == ansOpt ? "Passed": "failed") );

	}
}
