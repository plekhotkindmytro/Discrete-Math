package project_1_5;

public enum Bit {
	ZERO(0, false), ONE(1, true);

	private final int value;
	private final boolean booleanValue;

	private Bit(final int value, final boolean booleanValue) {
		this.value = value;
		this.booleanValue = booleanValue;
	}

	public Bit and(Bit bit) {
		return valueOf(this.booleanValue && bit.booleanValue);
	}

	public Bit or(Bit bit) {
		return valueOf(this.booleanValue || bit.booleanValue);
	}

	public Bit xor(Bit bit) {
		return valueOf((this != bit) && (this.booleanValue || bit.booleanValue));
	};

	public Bit not() {
		return valueOf(!this.booleanValue);
	}

	private Bit valueOf(boolean isOne) {
		return isOne ? ONE : ZERO;
	}

	public String toString() {
		return String.valueOf(value);
	}

}
