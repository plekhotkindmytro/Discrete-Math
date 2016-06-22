package project_1_2;

import java.util.ArrayList;
import java.util.List;

public class Row {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private List<Boolean> atoms;
	private List<Boolean> clauses;

	public Row(List<Boolean> atoms, List<Boolean> clause) {
		this.atoms = atoms;
		this.clauses = clause;
	}

	public List<Boolean> getAtoms() {
		return atoms;
	}

	public void setAtoms(List<Boolean> atoms) {
		this.atoms = atoms;
	}

	public List<Boolean> getClauses() {
		return clauses;
	}

	public void setClauses(List<Boolean> clause) {
		this.clauses = clause;
	}

	public List<Character> getAtomNames() {
		List<Character> atomNames = new ArrayList<Character>();
		if (atoms != null && !atoms.isEmpty()) {
			// TODO fix bug when atoms.size() is bigger than alphabet.
			char[] chars = ALPHABET.substring(0, atoms.size()).toCharArray();
			for (char c : chars) {
				atomNames.add(c);
			}
		}

		return atomNames;
	}

	public List<String> getClauseNames() {
		List<String> clauseNames = new ArrayList<String>();
		if (clauses != null && !clauses.isEmpty()) {
			for (int i = 0; i < clauses.size(); i++) {
				clauseNames.add("f" + (i + 1));
			}
		}

		return clauseNames;
	}

	// TODO Fix bugs in toString method
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Boolean atom : atoms) {
			builder.append(atom);

			if (atom) {
				builder.append("    ");
			} else {
				builder.append("   ");
			}
		}
		builder.append("|");

		for (Boolean clause : clauses) {
			builder.append(clause);
			if (clause) {
				builder.append("    ");
			} else {
				builder.append("   ");
			}
		}
		return builder.toString();
	}
}
