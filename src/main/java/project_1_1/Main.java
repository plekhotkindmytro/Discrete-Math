package project_1_1;

import static project_1_1.Algorithms.*;

public class Main {

	public static void main(String[] args) {
		if (args.length == 2 && isArgsBoolean(args)) {

			boolean p = Boolean.valueOf(args[0]);
			boolean q = Boolean.valueOf(args[1]);

			print("Conjunction: " + conjunction(p, q));
			print("Disjunction: " + disjunction(p, q));
			print("Alternative disjunction: " + alternativeDisjunction(p, q));
			print("Implication: " + implication(p, q));
			print("Equivalence: " + equivalence(p, q));
		} else {
			error("Please enter two boolean values(true/false) as parameters");
		}

	}

	private static boolean isArgsBoolean(String[] args) {
		for (String s : args) {
			if (!s.equals("true") && !s.equals("false")) {
				return false;
			}
		}
		return true;
	}

	private static void print(String s) {
		System.out.println(s);
	}

	private static void error(String s) {
		System.err.println(s);
	}

}
