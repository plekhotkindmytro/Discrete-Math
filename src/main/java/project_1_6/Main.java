package project_1_6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		FiniteSet a = new FiniteSet('A', new HashSet<Character>());
		FiniteSet b = new FiniteSet('B', new HashSet<Character>(Arrays.asList('a', 'b', 'c')));
		FiniteSet c = new FiniteSet('C', new HashSet<Character>(Arrays.asList('b', 'c', 'a', 'd', 'e', 'f')));
		FiniteSet d = new FiniteSet('D', new HashSet<Character>(Arrays.asList('d', 'e', 'f')));

		List<FiniteSet> setList = new ArrayList<FiniteSet>(Arrays.asList(a, b, c, d));

		for (FiniteSet set1 : setList) {
			for (FiniteSet set2 : setList) {
				if (set1 != set2 && set1.isSubsetOf(set2)) {
					System.out.println(set1 + " ⊂ " + set2);
				}
			}
		}
	}

}
