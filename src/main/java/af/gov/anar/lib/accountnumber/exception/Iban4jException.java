package af.gov.anar.lib.accountnumber.exception;

import af.asr.accountnumber.exception.BicFormatException;
import af.asr.accountnumber.exception.IbanFormatException;
import af.asr.accountnumber.exception.InvalidCheckDigitException;
import af.asr.accountnumber.exception.UnsupportedCountryException;

/**
 * Base Runtime Exception Class for the library exceptions.
 * @see IbanFormatException
 * @see InvalidCheckDigitException
 * @see UnsupportedCountryException
 * @see BicFormatException
 */
public abstract class Iban4jException extends RuntimeException {

    public Iban4jException() {
        super();
    }

    public Iban4jException(final String message) {
        super(message);
    }

    public Iban4jException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public Iban4jException(final Throwable cause) {
        super(cause);
    }
}