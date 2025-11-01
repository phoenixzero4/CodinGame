package puzzles;

/**
 * Phoenix 11/1/2025
 * 
 */
import java.util.Scanner;

public class IslandEscape
{

	/**
	 * You're dropped onto an island, starting at the very middle of an N by N terrain. Luckily you have
	 * a raft and a map showing the elevation of each square plot of land. The ocean at elevation 0
	 * surrounds the island and lies all along the borders of the map.
	 * 
	 * You can move directly north, south, east, or west to an adjacent plot, provided the difference in
	 * elevation is at most one. Larger differences indicate steep terrain which cannot be traversed
	 * carrying your raft. Determine yes or no if it's possible to reach the ocean and get away.
	 */

	/**
	 * Solution: Use depth first search to recursively check the terrain around the center of the
	 * island, attempting to reach the sea. O(n2)
	 * 
	 * 
	 */

	public static boolean dfs( int[][] grid, boolean[][] visited, int row, int col, int n )
		{

			if ( row < 0 || col < 0 || row >= n || col >= n )
				{ return false; }
			if ( visited[row][col] )
				{ return false; }
			visited[row][col] = true;

			if ( row == 0 || col == 0 || row == n - 1 || col == n - 1 )
				{
					if ( grid[row][col] == 0 )
						{ return true; }
				}

			int[][] directions =
						{
									{ 1, 0 },
									{ -1, 0 },
									{ 0, 1 },
									{ 0, -1 } };

			for ( int[] d : directions )
				{
					int nextRow = row + d[0], nextCol = col + d[1];
					if ( nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n )
						{
							if ( Math.abs( grid[row][col] - grid[nextRow][nextCol] ) <= 1 )
								{
									if ( dfs( grid, visited, nextRow, nextCol, n ) )
										{ return true; }
								}
						}
				}
			return false;
		}

	public static void main( String[] args )
		{

			Scanner in = new Scanner( System.in );
			int n = in.nextInt();

			int start = n / 2;
			boolean[][] visited = new boolean[n][n];
			int[][] grid = new int[n][n];

			for ( int i = 0; i < grid.length; i++ )
				{
					for ( int j = 0; j < grid.length; j++ )
						{
							grid[i][j] = in.nextInt();
						}
				}
			boolean reachable = dfs( grid, visited, start, start, n );
			System.out.println( reachable ? "yes" : "no" );
			in.close();
		}
}
