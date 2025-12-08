package medium.war;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Let's go back to basics with this simple card game: war!
 * 
 * Your goal is to write a program which finds out which player is the winner
 * for a given card distribution of the "war" game.
 * 
 * Rules War is a card game played between two players. Each player gets a
 * variable number of cards of the beginning of the game: that's the player's
 * deck. Cards are placed face down on top of each deck.
 * 
 * Step 1 : the fight At each game round, in unison, each player reveals the top
 * card of their deck – this is a "battle" – and the player with the higher card
 * takes both the cards played and moves them to the bottom of their stack. The
 * cards are ordered by value as follows, from weakest to strongest: 2, 3, 4, 5,
 * 6, 7, 8, 9, 10, J, Q, K, A.
 * 
 * Step 2 : war If the two cards played are of equal value, then there is a
 * "war". First, both players place the three next cards of their pile face
 * down. Then they go back to step 1 to decide who is going to win the war
 * (several "wars" can be chained). As soon as a player wins a "war", the winner
 * adds all the cards from the "war" to their deck.
 * 
 * Special cases: If a player runs out of cards during a "war" (when giving up
 * the three cards or when doing the battle), then the game ends and both
 * players are placed equally first. The test cases provided in this puzzle are
 * built in such a way that a game always ends (you do not have to deal with
 * infinite games) Each card is represented by its value followed by its suit:
 * D, H, C, S. For example: 4H, 8C, AS.
 * 
 * When a player wins a battle, they put back the cards at the bottom of their
 * deck in a precise order. First the cards from the first player, then the one
 * from the second player (for a "war", all the cards from the first player then
 * all the cards from the second player).
 * 
 * For example, if the card distribution is the following: Player 1 : 10D 9S 8D
 * KH 7D 5H 6S Player 2 : 10H 7H 5C QC 2C 4H 6D Then after one game turn, it
 * will be: Player 1 : 5H 6S 10D 9S 8D KH 7D 10H 7H 5C QC 2C Player 2 : 4H 6D
 * 
 * Victory Conditions A player wins when the other player no longer has cards in
 * their deck. Game Input Input Line 1: the number N of cards for player one.
 * 
 * N next lines: the cards of player one.
 * 
 * Next line: the number M of cards for player two.
 * 
 * M next lines: the cards of player two.
 * 
 * Output If players are equally first: PAT Otherwise, the player number (1 or
 * 2) followed by the number of game rounds separated by a space character. A
 * war or a succession of wars count as one game round. Constraints 0 < N, M <
 * 1000
 */

class Solution {

	static Queue<Integer> pileone;
	static Queue<Integer> piletwo;
	static Queue<Integer> one;
	static Queue<Integer> two;
	static boolean twoisout = false;
	static boolean oneisout = false;
	static boolean gameon = true;
	static int rounds;
	static int warrounds = 0;

	// static method for when players have 'war'
	public static int war(int c1, int c2) {
		int orig1 = c1;
		int orig2 = c2;
		int card1 = -1;
		int card2 = -1;
		pileone.offer(orig1);
		piletwo.offer(orig2);
		int[] down = new int[3];

		for (int i = 0; i < 4; i++) {
			if (!one.isEmpty()) {
				card1 = one.poll();

				if (i < 3) {
					pileone.offer(card1);
					down[i] = card1;
				}

			} else {
				oneisout = true;
				gameon = false;
			}

			if (!two.isEmpty()) {
				card2 = two.poll();

				if (i < 3) {

					piletwo.offer(card2);
					down[i] = card2;
				}
			} else {
				twoisout = true;
				gameon = false;
			}
		}

		if (oneisout || twoisout) {
			return 0;
		} else if (card1 > card2) {
			int pone = pileone.size();
			int ptwo = piletwo.size();
			for (int i = 0; i < pone; i++) {
				one.offer(pileone.poll());
			}
			one.offer(card1);
			for (int j = 0; j < ptwo; j++) {
				one.offer(piletwo.poll());
			}
			one.offer(card2);

			return 1;
		} else if (card2 > card1) {
			int pone = pileone.size();
			int ptwo = piletwo.size();
			for (int i = 0; i < pone; i++) {
				two.offer(pileone.poll());
			}
			two.offer(card1);
			for (int j = 0; j < ptwo; j++) {
				two.offer(piletwo.poll());
			}
			two.offer(card2);
			return 2;
		} else {
			return war(card1, card2);
		}

	}

	@SuppressWarnings("boxing")
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		rounds = 0;
		one = new LinkedList<>();
		two = new LinkedList<>();

		String result = "PAT";

		for (int i = 0; i < n; i++) {
			String card = in.next();
			String value = card.substring(0, card.length() - 1);

			if (value.equals("A")) {
				one.offer(14);
			} else if (value.equals("K")) {
				one.offer(13);
			} else if (value.equals("Q")) {
				one.offer(12);
			} else if (value.equals("J")) {
				one.offer(11);
			} else {
				one.offer(Integer.parseInt(value));
			}
		}

		n = (in.nextInt());
		for (int i = 0; i < n; i++) {
			String card = in.next();
			String value = card.substring(0, card.length() - 1);

			if (value.equals("A")) {
				two.offer(14);
			} else if (value.equals("K")) {
				two.offer(13);
			} else if (value.equals("Q")) {
				two.offer(12);
			} else if (value.equals("J")) {
				two.offer(11);
			} else {
				two.offer(Integer.parseInt(value));
			}
		}

		pileone = new LinkedList<Integer>();
		piletwo = new LinkedList<Integer>();
		int winner = 0;
		while (!one.isEmpty() && !two.isEmpty()) {
			int c1 = -1;
			int c2 = -1;

			if (one.size() > 0) {
				c1 = one.poll();
			}
			if (two.size() > 0) {
				c2 = two.poll();
			}
			if (c1 > c2) {
				one.offer(c1);
				one.offer(c2);
				rounds++;
				winner = 1;
				result = String.valueOf(winner) + " " + String.valueOf(rounds);
			} else if (c2 > c1) {
				two.offer(c1);
				two.offer(c2);
				rounds++;
				winner = 2;
				result = String.valueOf(winner) + " " + String.valueOf(rounds);
			} else if (c1 == c2 && c1 > 0 && c2 > 0) {
				rounds++;
				winner = war(c1, c2);
				if (winner == 0) {
					result = "PAT";
				} else {
					result = String.valueOf(winner) + " "
							+ String.valueOf(rounds);
				}
			}
		}
		System.out.println(result);
	}
}
