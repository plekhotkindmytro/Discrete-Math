package project_1_5;

import java.util.ArrayList;
import java.util.List;

public class BitLists {

	/**
	 * A ⋂ B
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Bit> intersection(List<Bit> a, List<Bit> b) {
		if (a.size() != b.size()) {
			throw new IllegalArgumentException("Two lists must have the same size!");
		}

		List<Bit> result = new ArrayList<Bit>();
		for (int i = 0; i < a.size(); i++) {
			Bit bitA = a.get(i);
			Bit bitB = b.get(i);
			result.add(bitA.and(bitB));
		}

		return result;

	}

	/**
	 * A ⋃ B
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Bit> union(List<Bit> a, List<Bit> b) {
		if (a.size() != b.size()) {
			throw new IllegalArgumentException("Two lists must have the same size!");
		}

		List<Bit> result = new ArrayList<Bit>();
		for (int i = 0; i < a.size(); i++) {
			Bit bitA = a.get(i);
			Bit bitB = b.get(i);
			result.add(bitA.or(bitB));
		}

		return result;
	}

	/**
	 * A ⨁ B
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Bit> exclusiveDisjunction(List<Bit> a, List<Bit> b) {
		if (a.size() != b.size()) {
			throw new IllegalArgumentException("Two lists must have the same size!");
		}

		List<Bit> result = new ArrayList<Bit>();
		for (int i = 0; i < a.size(); i++) {
			Bit bitA = a.get(i);
			Bit bitB = b.get(i);
			result.add(bitA.xor(bitB));
		}

		return result;
	}

	/**
	 * ¬A
	 * 
	 * @param a
	 * @return
	 */
	public static List<Bit> negation(List<Bit> a) {
		List<Bit> result = new ArrayList<Bit>();
		for (int i = 0; i < a.size(); i++) {
			Bit bitA = a.get(i);
			result.add(bitA.not());
		}

		return result;
	}

	/**
	 * A \\ B
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Bit> relativeComplement(List<Bit> a, List<Bit> b) {
		if (a.size() != b.size()) {
			throw new IllegalArgumentException("Two lists must have the same size!");
		}

		List<Bit> result = new ArrayList<Bit>();
		for (int i = 0; i < a.size(); i++) {
			Bit bitA = a.get(i);
			Bit bitB = b.get(i);
			Bit newBit = bitA == bitB ? Bit.ZERO : Bit.ONE;
			result.add(newBit);

		}

		return result;
	}
}
