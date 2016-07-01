package project_1_4;

import java.util.HashSet;
import java.util.Set;

public class Disjunction {

	private Set<Literal> literals = new HashSet<Literal>();

	public Disjunction(String disjunctionString) {

		if (disjunctionString.contains("∨")) {
			String[] literalStrings = disjunctionString.split("\\s*∨\\s*");
			for (int i = 0; i < literalStrings.length; i++) {
				Literal literal = Literal.valueOf(literalStrings[i]);
				this.literals.add(literal);
			}
		} else {
			Literal literal = Literal.valueOf(disjunctionString);
			this.literals.add(literal);
		}

	}

	public Set<Literal> getLiterals() {
		return literals;
	}

}
