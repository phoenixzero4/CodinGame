package com.clash;

public class Factorial
{

	public static long factorial(int n) {
		if(n<=1) {
			return 1;
		}long f = 1;
		for(int i = 2; i <= n; i++) {
			f *= i;
		}return f;
	}

	public static void main( String[] args )
		{
			int num = 5;
			System.out.println( factorial(num) );
		}

}
