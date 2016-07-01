package project_1_4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {

	private static final String DEFAULT_FILE_PATH = Main.class.getResource("/project_1_4/disjunction_set.txt").getFile();

	public static void main(String[] args) throws IOException {
		final String filePath;
		if (args.length != 1) {
			System.out.println("Using default disjunction set file: " + DEFAULT_FILE_PATH);
			filePath = DEFAULT_FILE_PATH;
		} else {
			filePath = args[0];
		}

		final byte[] disjunctionSetBytes = Files.readAllBytes(Paths.get(filePath));
		final String disjunctionSetString = new String(disjunctionSetBytes, StandardCharsets.UTF_8);

		String disjunctionSetValues = disjunctionSetString.replace("S={", "").replace("}", "");
		List<String> disjunctionStrings = new ArrayList<String>(Arrays.asList(disjunctionSetValues.split("\\s*,\\s*")));

		List<Disjunction> disjunctions = new ArrayList<Disjunction>();
		for (String disjunctionString : disjunctionStrings) {
			disjunctions.add(new Disjunction(disjunctionString));
		}

		System.out.println("Set " + disjunctionSetString + " is " + (isContradictory(disjunctions) ? "" : "not ") + "contradictory.");

	}

	private static boolean isContradictory(List<Disjunction> disjunctions) {

		for (Disjunction d1 : disjunctions) {
			for (Disjunction d2 : disjunctions) {
				Set<Literal> set1 = d1.getLiterals();
				Set<Literal> set2 = d2.getLiterals();

				for (Iterator<Literal> iterator1 = set1.iterator(); iterator1.hasNext();) {
					Literal literal1 = iterator1.next();
					for (Iterator<Literal> iterator2 = set2.iterator(); iterator2.hasNext();) {
						Literal literal2 = iterator2.next();
						if (literal1.complements(literal2)) {
							iterator1.remove();
							iterator2.remove();
						}
					}

				}

				if (set1.size() == 0 || set2.size() == 0) {
					return true;
				}
			}
		}

		return false;
	}

}
