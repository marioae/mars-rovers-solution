package type;

public enum InstructionType {
	L, R, M;

	public String value() {
		return name();
	}

	public static InstructionType value(String v) {
		try {
			return valueOf(v);
		} catch (Exception e) {
			return null;
		}
	}

}
