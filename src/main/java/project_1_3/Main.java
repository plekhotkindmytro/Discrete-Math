package project_1_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			throw new IllegalArgumentException("Please enter two bit strings");
		}
		final String bitString1 = args[0];
		final String bitString2 = args[1];
		final int length = bitString1.length();
		List<Bit> or = new ArrayList<Bit>();
		List<Bit> and = new ArrayList<Bit>();
		List<Bit> xor = new ArrayList<Bit>();
		for (int i = 0; i < length; i++) {
			Bit a = Bit.valueOf(bitString1.charAt(i));
			Bit b = Bit.valueOf(bitString2.charAt(i));
			or.add(Bit.or(a, b));
			and.add(Bit.and(a, b));
			xor.add(Bit.xor(a, b));
		}

		System.out.println(bitString1 + " - first bit string.");
		System.out.println(bitString2 + " - second bit string.");
		System.out.println(buildHorisontalLine(length));
		System.out.println(buildBitString(or) + " - or.");
		System.out.println(buildBitString(and) + " - and.");
		System.out.println(buildBitString(xor) + " - xor.");

		if (bitString1.length() != bitString2.length()) {
			throw new IllegalArgumentException("Bit strings must have the same length");
		}

	}

	private static String buildHorisontalLine(int length) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			builder.append("-");
		}
		return builder.toString();
	}

	private static String buildBitString(List<Bit> bitList) {
		StringBuilder builder = new StringBuilder();
		for (Bit bit : bitList) {
			builder.append(bit);
		}
		return builder.toString();
	}

}
