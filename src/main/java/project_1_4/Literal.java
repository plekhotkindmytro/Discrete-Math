package project_1_4;

public class Literal {

	public final char atom;
	public final boolean isNegation;

	public Literal(char atom, boolean isNegation) {
		this.atom = atom;
		this.isNegation = isNegation;
	}

	@Override
	public String toString() {
		return isNegation ? "¬" : "" + atom;
	}

	public boolean complements(Literal literal) {
		return this.atom == literal.atom && this.isNegation == !literal.isNegation;
	}

	public static Literal valueOf(String literalString) {
		Literal literal;
		if (literalString.length() == 2) {
			char firstChar = literalString.charAt(0);
			char secondChar = literalString.charAt(1);
			if (firstChar == '¬') {
				literal = new Literal(secondChar, true);
			} else {
				throw new IllegalArgumentException("Literal is not valid: " + literalString);
			}
		} else if (literalString.length() == 1) {
			char firstChar = literalString.charAt(0);
			literal = new Literal(firstChar, false);
		} else {
			throw new IllegalArgumentException("Literal is not valid: " + literalString);
		}
		return literal;
	}

	public char getAtom() {
		return atom;
	}

	public boolean isNegation() {
		return isNegation;
	}

}
