package project_1_1;

public final class Algorithms {

	public static boolean conjunction(boolean p, boolean q) {
		return p && q;
	}

	public static boolean disjunction(boolean p, boolean q) {
		return p || q;
	}

	public static boolean alternativeDisjunction(boolean p, boolean q) {
		return (p || q) && (p != q);
	}

	public static boolean implication(boolean p, boolean q) {
		return !p || q;
	}

	public static boolean equivalence(boolean p, boolean q) {
		return p == q;
	}
}
