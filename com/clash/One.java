package com.clash;

public class One
{

	public static long fact(int n) {
		if(n==0 || n == 1) {
			return 1;
		}long f = 1;
		for(int i = 2; i <= n; i++) {
			f *= i;
		}return f;
	}
	public static void main(String[] args) {
		int number = 5;
		System.out.println( fact(number) );
	}
}
