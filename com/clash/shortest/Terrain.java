package com.clash.shortest;

import java.util.Scanner;


/** find the largest terrain with the shortest code
 *  Java never wins these clashes
 *  
 *  n = number of terrains
 *  c = current
 *  m = max
 *  w = width
 *  h = height
 *  a = answer
 */

public class Terrain
{


	class Solution {
		public static void main(String args[]) {
			Scanner in=new Scanner(System.in);
			int n=in.nextInt();
			int m=0;
			int a=0;
			for (int i = 0; i < n; i++) {
				int c=0;
				int w=in.nextInt();
				int h=in.nextInt();
				int t=in.nextInt();
				c=w*h;
				if(c>m){
					m=c;
					a=t;
				}
			}
			System.out.print(a);
		}
	}
}
