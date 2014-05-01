package type;

/**
 * 
 */

/**
 * @author mario
 * 
 */
public enum CardinalPointType {
	E, N, O, S;

	public String value() {
		return name();
	}

	public static CardinalPointType value(String v) {
		try {
			return valueOf(v);
		} catch (Exception e) {
			return null;
		}
	}

}
