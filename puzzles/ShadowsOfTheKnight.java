package puzzles;

import java.util.Scanner;

public class ShadowsOfTheKnight
{


		class Player
			{
				public static void main( String args[] )
					{
						Scanner in = new Scanner( System.in );

						int W = in.nextInt(); // width of the building
						int H = in.nextInt(); // height of the building
						int N = in.nextInt(); // maximum number of turns before game over
						int X0 = in.nextInt(); // Batman's starting X position
						int Y0 = in.nextInt(); // Batman's starting Y position

						int xMin = 0, xMax = W - 1;
						int yMin = 0, yMax = H - 1;
						int batX = X0, batY = Y0;

						while ( true )
							{
								String bombDir = in.next(); // direction of the bomb (e.g., U, UR, R, DR, D, DL, L, UL)

								if ( bombDir.contains( "U" ) )
									{
										yMax = batY - 1;
									} else if ( bombDir.contains( "D" ) )
									{
										yMin = batY + 1;
									}

								if ( bombDir.contains( "L" ) )
									{
										xMax = batX - 1;
									} else if ( bombDir.contains( "R" ) )
									{
										xMin = batX + 1;
									}

								batX = ( xMin + xMax ) / 2;
								batY = ( yMin + yMax ) / 2;

								System.out.println( batX + " " + batY );
							}
					}
			}
}
