package af.gov.anar.lib.accountnumber.exception;

/**
 * Thrown to indicate that the application has attempted to convert
 * a string to Bic or to validate Bic's string representation, but the string does not
 * have the appropriate format.
 */
public class BicFormatException extends Iban4jException {

    private static final long serialVersionUID = 1764207967955765664L;

    private BicFormatViolation formatViolation;

    private Object expected;
    private Object actual;

    /**
     * Constructs a <code>BicFormatException</code> with no detail message.
     */
    public BicFormatException() {
        super();
    }

    /**
     * Constructs a <code>BicFormatException</code> with the
     * specified detail message.
     *
     * @param s the detail message.
     */
    public BicFormatException(final String s) {
        super(s);
    }

    /**
     * Constructs a <code>BicFormatException</code> with the
     * specified detail message and cause.
     *
     * @param s the detail message.
     * @param t the cause.
     */
    public BicFormatException(final String s, final Throwable t) {
        super(s, t);
    }

    /**
     * Constructs a <code>BicFormatException</code> with the
     * specified violation, actual value, expected value and detail message.
     *
     * @param violation the violation.
     * @param actual the actual value.
     * @param expected the expected value.
     * @param s the detail message.
     */
    public BicFormatException(BicFormatViolation violation,
                              Object actual, Object expected, final String s) {
        super(s);
        this.actual = actual;
        this.expected = expected;
        this.formatViolation = violation;
    }

    /**
     * Constructs a <code>BicFormatException</code> with the
     * specified violation and detail message.
     *
     * @param violation the violation.
     * @param s the detail message.
     */
    public BicFormatException(BicFormatViolation violation, final String s) {
        super(s);
        this.formatViolation = violation;
    }

    /**
     * Constructs a <code>BicFormatException</code> with the
     * specified violation, actual value and detail message.
     *
     * @param violation the violation.
     * @param actual the actual value.
     * @param s the detail message.
     */
    public BicFormatException(BicFormatViolation violation, Object actual,
                              final String s) {
        super(s);
        this.actual = actual;
        this.formatViolation = violation;
    }

    /**
     * Constructs a <code>BicFormatException</code> with the
     * specified cause.
     *
     * @param t the cause.
     */
    public BicFormatException(final Throwable t) {
        super(t);
    }

    public BicFormatViolation getFormatViolation() {
        return formatViolation;
    }

    public Object getExpected() {
        return expected;
    }

    public Object getActual() {
        return actual;
    }

    public static enum BicFormatViolation {
        UNKNOWN,

        BIC_NOT_NULL,
        BIC_NOT_EMPTY,
        BIC_LENGTH_8_OR_11,
        BIC_ONLY_UPPER_CASE_LETTERS,

        BRANCH_CODE_ONLY_LETTERS_OR_DIGITS,
        LOCATION_CODE_ONLY_LETTERS_OR_DIGITS,
        BANK_CODE_ONLY_LETTERS,
        COUNTRY_CODE_ONLY_UPPER_CASE_LETTERS
    }
}