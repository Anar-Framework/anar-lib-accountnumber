package af.gov.anar.lib.accountnumber.exception;

/**
 * Thrown to indicate that requested country is not supported.
 */
public class UnsupportedCountryException extends Iban4jException {

    private static final long serialVersionUID = -3733353745417164234L;

    private String countryCode;

    /**
     * Constructs a <code>UnsupportedCountryException</code> with no detail message and cause.
     */
    public UnsupportedCountryException() {
        super();
    }

    /**
     * Constructs a <code>UnsupportedCountryException</code> with the
     * specified detail message.
     *
     * @param s the detail message.
     */
    public UnsupportedCountryException(final String s) {
        super(s);
    }

    /**
     * Constructs a <code>UnsupportedCountryException</code> with the
     * specified country code and detail message.
     *
     * @param countryCode the country code.
     * @param s the detail message.
     */
    public UnsupportedCountryException(String countryCode, final String s) {
        super(s);
        this.countryCode = countryCode;
    }

    /**
     * Constructs a <code>UnsupportedCountryException</code> with the
     * specified detail message and cause.
     *
     * @param s the detail message.
     * @param t the cause.
     */
    public UnsupportedCountryException(final String s, final Throwable t) {
        super(s, t);
    }

    /**
     * Constructs a <code>UnsupportedCountryException</code> with the
     * specified cause.
     *
     * @param t the cause.
     */
    public UnsupportedCountryException(final Throwable t) {
        super(t);
    }

    public String getCountryCode() {
        return countryCode;
    }
}