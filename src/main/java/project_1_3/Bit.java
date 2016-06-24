package project_1_3;

public enum Bit {
	ZERO(0), ONE(1);

	private final int value;

	private Bit(int value) {
		this.value = value;
	}

	public static Bit or(Bit a, Bit b) {
		int result = a.value | b.value;
		switch (result) {
		case 0:
			return ZERO;
		case 1:
			return ONE;
		}
		return null;
	}

	public static Bit and(Bit a, Bit b) {
		int result = a.value & b.value;
		switch (result) {
		case 0:
			return ZERO;
		case 1:
			return ONE;
		}
		return null;
	}

	public static Bit xor(Bit a, Bit b) {
		int result = a.value ^ b.value;
		switch (result) {
		case 0:
			return ZERO;
		case 1:
			return ONE;
		}
		return null;
	}

	public static Bit valueOf(char c) {
		switch (c) {
		case '0':
			return ZERO;
		case '1':
			return ONE;
		}
		return null;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
