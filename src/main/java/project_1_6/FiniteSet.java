package project_1_6;

import java.util.Set;

public class FiniteSet {

	private char name;
	private Set<Character> elements;

	public FiniteSet(char name, Set<Character> elements) {
		this.name = name;
		this.elements = elements;
	}

	public boolean isSubsetOf(FiniteSet finiteSet) {
		return finiteSet.elements.containsAll(this.elements);
	}

	public String toString() {
		return String.valueOf(name).toUpperCase();
	};
}
