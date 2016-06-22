package project_1_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Table {

	private List<Row> rows;

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	public static Table fromFile(String filePath) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filePath));
		Table table = new Table();
		for (String line : lines) {
			String[] atomsAndInterpretations = line.split("\\s*\\|\\s*");
			if (atomsAndInterpretations.length != 2) {
				throw new IllegalArgumentException("Truth table has wrong format");
			}

			String[] atomStrings = atomsAndInterpretations[0].split("\\s*,\\s*");
			List<Boolean> atoms = new ArrayList<Boolean>();
			for (String atomString : atomStrings) {
				if (atomString.equals("true") || atomString.equals("false")) {
					atoms.add(Boolean.valueOf(atomString));
				} else {
					throw new IllegalArgumentException("Truth table has non boolean values");
				}
			}

			String[] interpretationsStrings = atomsAndInterpretations[1].split("\\s*,\\s*");
			List<Boolean> interpretations = new ArrayList<Boolean>();
			for (String interpretationsString : interpretationsStrings) {
				if (interpretationsString.equals("true") || interpretationsString.equals("false")) {
					interpretations.add(Boolean.valueOf(interpretationsString));
				} else {
					throw new IllegalArgumentException("Truth table has non boolean values");
				}
			}

			table.addRow(new Row(atoms, interpretations));
		}

		return table;
	}

	private void addRow(Row row) {
		if (rows == null) {
			rows = new ArrayList<Row>();
		}
		rows.add(row);
	}

	// TODO Fix bugs in toString method 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (rows != null && !rows.isEmpty()) {
			List<Character> atomNames = rows.get(0).getAtomNames();
			for (Character atomName : atomNames) {
				builder.append(atomName).append("       ");
			}
			builder.append("|");
			List<String> clauseNames = rows.get(0).getClauseNames();
			for (String clauseName : clauseNames) {
				builder.append(clauseName).append("      ");
			}
			builder.append(System.lineSeparator());
			int currentTableLength = builder.length();
			for (int i = 0; i < currentTableLength; i++) {
				builder.append("-");
			}
			builder.append(System.lineSeparator());
			for (Row row : rows) {
				builder.append(row).append(System.lineSeparator());
			}
		}
		return builder.toString();
	}
}
