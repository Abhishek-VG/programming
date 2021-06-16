package com.java.coursera.algorithmictoolbox.week2;

import java.util.Scanner;

public class LCM {
	private static long lcm_naive(int a, int b) {
		for (long l = 1; l <= (long) a * b; ++l) {
//			System.out.println("Hi");
			if (l % a == 0 && l % b == 0)
				return l;
		}
		return (long) a * b;
	}
	
	private static long lcm_optimied(long a, long b) {
		int gcd = gcd_optimized((int)a, (int)b);
		return  (a * b) / gcd;
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

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		long ansNav;
		long ansOpt;
		
//		// Naive
		long startTime = System.currentTimeMillis();
		System.out.println(ansNav = lcm_naive(a, b));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Naive method = " + elapsedTime);
		
		// Optimized
		 startTime = System.currentTimeMillis();
		System.out.println(ansOpt = lcm_optimied(a, b));
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Optimized method = " + elapsedTime);
		System.out.println("Result match = " + (ansNav == ansOpt ? "Passed": "failed") );
	}
}
