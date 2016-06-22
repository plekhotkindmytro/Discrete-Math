package project_1_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		final String tablePath;
		if (args.length == 1) {
			tablePath = args[0];
		} else {
			tablePath = Main.class.getResource("/project_1_2/truth_table.csv").getFile();
			System.out.println("Using default table.");
		}

		Table table = Table.fromFile(tablePath);
		System.out.println(table);
		System.out.println("Perfect conjunctive normal forms for every interpretation: ");
		buildPerfectConjunctiveNormalForm(table);

	}

	private static void buildPerfectConjunctiveNormalForm(Table table) {
		List<StringBuilder> builders = new ArrayList<StringBuilder>();

		for (Row row : table.getRows()) {
			List<Boolean> clauses = row.getClauses();
			for (int i = 0; i < clauses.size(); i++) {
				if (builders.size() <= i) {
					builders.add(new StringBuilder());
				}

				if (!clauses.get(i)) {
					if (builders.get(i).length() > 0) {
						builders.get(i).append(" ∧ ");
					}
					List<Boolean> atoms = row.getAtoms();
					builders.get(i).append("(");
					StringBuilder internalBuilder = new StringBuilder();
					for (int j = 0; j < atoms.size(); j++) {

						Boolean atom = atoms.get(j);
						if (internalBuilder.length() > 0) {
							internalBuilder.append(" ∨ ");
						}
						internalBuilder.append(atom ? "¬" : "").append(row.getAtomNames().get(j));

					}
					builders.get(i).append(internalBuilder.toString());
					builders.get(i).append(")");
				}
			}
		}

		for (int i = 0; i < builders.size(); i++) {
			StringBuilder builder = builders.get(i);
			System.out.println("Perfect CNF for clause f" + (i + 1) + ": " + builder.toString());

		}
	}
}
