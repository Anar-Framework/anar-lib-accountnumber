package af.gov.anar.lib.accountnumber.exception;


/**
 * Thrown to indicate that Iban's check digit is invalid
 */
public class InvalidCheckDigitException extends Iban4jException {

    private static final long serialVersionUID = -9222165415290480187L;

    private String actual;
    private String expected;

    /**
     * Constructs a <code>InvalidCheckDigitException</code> with no detail message.
     */
    public InvalidCheckDigitException() {
        super();
    }

    /**
     * Constructs a <code>InvalidCheckDigitException</code> with the
     * specified detail message.
     *
     * @param s the detail message.
     */
    public InvalidCheckDigitException(final String s) {
        super(s);
    }

    /**
     * Constructs a <code>InvalidCheckDigitException</code> with the
     * specified actual, expected and detail message.
     *
     * @param actual the actual check digit.
     * @param expected the expected check digit.
     * @param s the detail message.
     */
    public InvalidCheckDigitException(final String actual, final String expected, final String s) {
        super(s);
        this.actual = actual;
        this.expected = expected;
    }

    /**
     * Constructs a <code>InvalidCheckDigitException</code> with the
     * specified detail message and cause.
     *
     * @param s the detail message.
     * @param t the cause.
     */
    public InvalidCheckDigitException(final String s, final Throwable t) {
        super(s, t);
    }

    /**
     * Constructs a <code>InvalidCheckDigitException</code> with the
     * specified cause.
     *
     * @param t the cause.
     */
    public InvalidCheckDigitException(final Throwable t) {
        super(t);
    }

    public String getActual() {
        return actual;
    }

    public String getExpected() {
        return expected;
    }
}