package puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConwaySequence
{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt();
		int L = in.nextInt();
		in.close();

		List<Integer> current = new ArrayList<>();
		current.add(R);

		for (int i = 1; i < L; i++) {
			List<Integer> next = new ArrayList<>();
			int count = 1;
			for (int j = 1; j < current.size(); j++) {
				if (current.get(j).equals(current.get(j - 1))) {
					count++;
				} else {
					next.add(count);
					next.add(current.get(j - 1));
					count = 1;
				}
			}
			next.add(count);
			next.add(current.get(current.size() - 1));
			current = next;
		}

		for(int i = 0; i < current.size(); i++){
			if(i < current.size() -1){
				System.out.print( current.get(i) + " ");
			}else{
				System.out.print( current.get(i));
			}
		}
	}
}

