package puzzles;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class IslandEscapeWithQueue
{

	static int n;
	static int[][] grid;
	static boolean[][] visited;
	static int[] directionRow =
				{ -1, 1, 0, 0 };
	static int[] directionCol =
				{ 0, 0, -1, 1 };

	static boolean dfs( int row, int col )
		{
			if ( row < 0 || col < 0 || row >= n || col >= n || visited[row][col] )
				{ return false; }

			visited[row][col] = true;

			if ( row == 0 || col == 0 || row == n - 1 || col == n - 1 )
				{ return true; }

			for ( int i = 0; i < 4; i++ )
				{
					int nextRow = row + directionRow[i], nextCol = col + directionCol[i];
					if ( nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n && Math.abs(
							grid[nextRow][nextCol] - grid[row][col] ) <= 1 && !visited[nextRow][nextCol] )
						{
							if ( dfs( nextRow, nextCol ) )
								{ return true; }
						}
				}

			return false;
		}

	public static void main( String[] arowgs )
		{
			Scanner in = new Scanner( System.in );
			int n = in.nextInt();
			int[][] grid = new int[n][n];
			for ( int i = 0; i < n; i++ )
				{
					for ( int j = 0; j < n; j++ )
						{
							grid[i][j] = in.nextInt();
						}
				}
			in.close();
			boolean[][] visited = new boolean[n][n];
			int[] directionRow =
						{ -1, 1, 0, 0 };
			int[] directionCol =
						{ 0, 0, -1, 1 };

					Queue<int[]> queue = new ArrayDeque<>();
					int mid = n / 2;
					queue.add( new int[]
						{ mid, mid } );
			visited[mid][mid] = true;

			while ( !queue.isEmpty() )
				{
					int[] cur = queue.poll();
					int row = cur[0], col = cur[1];

					if ( row == 0 || col == 0 || row == n - 1 || col == n - 1 )
						{
							System.out.println( "yes" );
							return;
						}

					for ( int i = 0; i < 4; i++ )
						{
							int nextRow = row + directionRow[i], nextCol = col + directionCol[i];
							if ( nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n
									&& !visited[nextRow][nextCol] && Math.abs( grid[nextRow][nextCol]
											- grid[row][col] ) <= 1 )
								{
									visited[nextRow][nextCol] = true;
									queue.add( new int[]
												{ nextRow, nextCol } );
								}
						}
				}

			System.out.println( "no" );

		}
}
