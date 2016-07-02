package project_1_5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {

		Set<Character> universe = new LinkedHashSet<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'm', 'n', 'p', 'q'));
		Set<Character> a = new LinkedHashSet<Character>(Arrays.asList('b', 'm', 'n', 'q'));
		Set<Character> b = new LinkedHashSet<Character>(Arrays.asList('a', 'b', 'f', 'm', 'q'));

		List<Bit> aBitList = convertToBitList(a, universe);
		List<Bit> bBitList = convertToBitList(b, universe);

		System.out.println("U: " + universe);
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println("A ⋂ B: " + convertToSet(BitLists.intersection(aBitList, bBitList), universe));
		System.out.println("A ⋃ B: " + convertToSet(BitLists.union(aBitList, bBitList), universe));
		System.out.println("A ⨁ B: " + convertToSet(BitLists.exclusiveDisjunction(aBitList, bBitList), universe));
		System.out.println("A \\ B: " + convertToSet(BitLists.relativeComplement(aBitList, bBitList), universe));
		System.out.println("¬A: " + convertToSet(BitLists.negation(aBitList), universe));

	}

	public static List<Bit> convertToBitList(Set<Character> setToConvert, Set<Character> universe) {
		List<Bit> bitList = new ArrayList<Bit>();
		for (Character universeElement : universe) {
			Bit bit = setToConvert.contains(universeElement) ? Bit.ONE : Bit.ZERO;
			bitList.add(bit);
		}
		return bitList;
	}

	public static Set<Character> convertToSet(List<Bit> bitList, Set<Character> universe) {
		if (bitList.size() != universe.size()) {
			throw new IllegalArgumentException("Bit list must have the same size as universe set");
		}
		Set<Character> set = new LinkedHashSet<Character>();
		List<Character> universeList = new ArrayList<Character>(universe);
		for (int i = 0; i < universeList.size(); i++) {
			if (bitList.get(i) == Bit.ONE) {
				set.add(universeList.get(i));
			}
		}

		return set;
	}
}
