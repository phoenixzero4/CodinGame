package puzzles;



import java.util.Scanner;

public class IslandEscape {

	public static String testRoute(int[][] map, int r, int c, int n) {
		String answer = "yes";
		int cur =  map[r][c];
		int up = map[r-1][c];
		int down = map[r+1][c];
		int left = map[r][c+1];
		int right = map[r][c-1];

		if( r -1 >= 0 && up - cur < 2) {
			testRoute(map, r - 1, c, n);
		}else if( r + 1 <= n && down - cur < 2){
			testRoute(map, r + 1, c, n);
		}else if( c - 1 >= 0 && left - cur < 2){
			testRoute(map, r, c - 1, n );
		}else if( c + 1<= n && right - cur < 2){
			testRoute(map, r, c - 1, n );
		}else{
			answer = "no";

		}
		return answer;

	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int n  = in.nextInt();
		int[][] map = new int[n][n];
		int count = 0;

		for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++) {
					map[i][j] = in.nextInt();

					if( j % n < n)
						{
							System.out.print( map[i][j] + " ");
						}
				}
				System.out.println(  );
			}

		in.close();
		System.out.println( testRoute(map, n/2, n/2, n) );

	}

}
