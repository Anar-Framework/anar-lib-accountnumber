package af.gov.anar.lib.accountnumber;


import af.gov.anar.lib.accountnumber.type.BbanStructure;
import af.gov.anar.lib.accountnumber.type.BbanStructureEntry;
import af.gov.anar.lib.accountnumber.type.CountryCode;
import af.gov.anar.lib.accountnumber.type.IbanFormat;
import af.gov.anar.lib.accountnumber.exception.IbanFormatException;
import af.gov.anar.lib.accountnumber.exception.InvalidCheckDigitException;
import af.gov.anar.lib.accountnumber.exception.UnsupportedCountryException;
import af.gov.anar.lib.accountnumber.utils.IbanUtil;

import java.util.List;
import java.util.Random;

import static af.gov.anar.lib.accountnumber.exception.IbanFormatException.IbanFormatViolation.*;


/**
 * International Bank Account Number
 *
 * <a href="http://en.wikipedia.org/wiki/ISO_13616">ISO_13616</a>.
 */
public final class BIN {

    public static final String DEFAULT_CHECK_DIGIT = "00";

    // Cache string value of the iban
    private final String value;

    /**
     * Creates iban instance.
     *
     * @param value String
     */
    private BIN(final String value) {
        this.value = value;
    }

    /**
     * Returns iban's country code.
     *
     * @return countryCode CountryCode
     */
    public CountryCode getCountryCode() {
        return CountryCode.getByCode(IbanUtil.getCountryCode(value));
    }

    /**
     * Returns iban's check digit.
     *
     * @return checkDigit String
     */
    public String getCheckDigit() {
        return IbanUtil.getCheckDigit(value);
    }

    /**
     * Returns iban's account number.
     *
     * @return accountNumber String
     */
    public String getAccountNumber() {
        return IbanUtil.getAccountNumber(value);
    }

    /**
     * Returns iban's bank code.
     *
     * @return bankCode String
     */
    public String getBankCode() {
        return IbanUtil.getBankCode(value);
    }

    /**
     * Returns iban's branch code.
     *
     * @return branchCode String
     */
    public String getBranchCode() {
        return IbanUtil.getBranchCode(value);
    }

    /**
     * Returns iban's national check digit.
     *
     * @return nationalCheckDigit String
     */
    public String getNationalCheckDigit() {
        return IbanUtil.getNationalCheckDigit(value);
    }

    /**
     * Returns iban's account type.
     *
     * @return accountType String
     */
    public String getAccountType() {
        return IbanUtil.getAccountType(value);
    }

    /**
     * Returns iban's owner account type.
     *
     * @return ownerAccountType String
     */
    public String getOwnerAccountType() {
        return IbanUtil.getOwnerAccountType(value);
    }

    /**
     * Returns iban's identification number.
     *
     * @return identificationNumber String
     */
    public String getIdentificationNumber() {
        return IbanUtil.getIdentificationNumber(value);
    }

    /**
     * Returns iban's bban (Basic Bank Account Number).
     *
     * @return bban String
     */
    public String getBban() {
        return IbanUtil.getBban(value);
    }

    /**
     * Returns an Iban object holding the value of the specified String.
     *
     * @param iban the String to be parsed.
     * @return an Iban object holding the value represented by the string argument.
     * @throws IbanFormatException if the String doesn't contain parsable Iban
     *         InvalidCheckDigitException if Iban has invalid check digit
     *         UnsupportedCountryException if Iban's Country is not supported.
     *
     */
    public static BIN valueOf(final String iban) throws IbanFormatException,
            InvalidCheckDigitException, UnsupportedCountryException {
        IbanUtil.validate(iban);
        return new BIN(iban);
    }

    /**
     * Returns an Iban object holding the value of the specified String.
     *
     * @param iban the String to be parsed.
     * @param format the format of the Iban.
     * @return an Iban object holding the value represented by the string argument.
     * @throws IbanFormatException if the String doesn't contain parsable Iban
     *         InvalidCheckDigitException if Iban has invalid check digit
     *         UnsupportedCountryException if Iban's Country is not supported.
     *
     */
    public static BIN valueOf(final String iban, final IbanFormat format) throws IbanFormatException,
            InvalidCheckDigitException, UnsupportedCountryException {
        switch (format) {
            case Default:
                final String ibanWithoutSpaces = iban.replace(" ", "");
                final BIN ibanObj = valueOf(ibanWithoutSpaces);
                if(ibanObj.toFormattedString().equals(iban)) {
                    return ibanObj;
                }
                throw new IbanFormatException(IBAN_FORMATTING,
                        String.format("Iban must be formatted using 4 characters and space combination. " +
                                "Instead of [%s]", iban));
            default:
                return valueOf(iban);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Returns formatted version of Iban.
     *
     * @return A string representing formatted Iban for printing.
     */
    public String toFormattedString() {
        return IbanUtil.toFormattedString(value);
    }

    public static BIN random() {
        return new BIN.Builder().buildRandom();
    }

    public static BIN random(CountryCode cc) {
        return new BIN.Builder().countryCode(cc).buildRandom();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof BIN) {
            return value.equals(((BIN)obj).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Iban Builder Class
     */
    public final static class Builder {

        private CountryCode countryCode;
        private String bankCode;
        private String branchCode;
        private String nationalCheckDigit;
        private String accountType;
        private String accountNumber;
        private String ownerAccountType;
        private String identificationNumber;

        private final Random random = new Random();

        /**
         * Creates an Iban Builder instance.
         */
        public Builder() {
        }

        /**
         * Sets iban's country code.
         *
         * @param countryCode CountryCode
         * @return builder Builder
         */
        public Builder countryCode(final CountryCode countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        /**
         * Sets iban's bank code.
         *
         * @param bankCode String
         * @return builder Builder
         */
        public Builder bankCode(final String bankCode) {
            this.bankCode = bankCode;
            return this;
        }

        /**
         * Sets iban's branch code.
         *
         * @param branchCode String
         * @return builder Builder
         */
        public Builder branchCode(final String branchCode) {
            this.branchCode = branchCode;
            return this;
        }

        /**
         * Sets iban's account number.
         *
         * @param accountNumber String
         * @return builder Builder
         */
        public Builder accountNumber(final String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        /**
         * Sets iban's national check digit.
         *
         * @param nationalCheckDigit String
         * @return builder Builder
         */
        public Builder nationalCheckDigit(final String nationalCheckDigit) {
            this.nationalCheckDigit = nationalCheckDigit;
            return this;
        }

        /**
         * Sets iban's account type.
         *
         * @param accountType String
         * @return builder Builder
         */
        public Builder accountType(final String accountType) {
            this.accountType = accountType;
            return this;
        }

        /**
         * Sets iban's owner account type.
         *
         * @param ownerAccountType String
         * @return builder Builder
         */
        public Builder ownerAccountType(final String ownerAccountType) {
            this.ownerAccountType = ownerAccountType;
            return this;
        }

        /**
         * Sets iban's identification number.
         *
         * @param identificationNumber String
         * @return builder Builder
         */
        public Builder identificationNumber(final String identificationNumber) {
            this.identificationNumber = identificationNumber;
            return this;
        }

        /**
         * Builds new iban instance. This methods validates the generated IBAN.
         *
         * @return new iban instance.
         * @exception IbanFormatException if values are not parsable by Iban Specification
         *  <a href="http://en.wikipedia.org/wiki/ISO_13616">ISO_13616</a>
         * @exception UnsupportedCountryException if country is not supported
         */
        public BIN build() throws IbanFormatException,
                IllegalArgumentException, UnsupportedCountryException {
            return build(true);
        }

        /**
         * Builds new iban instance.
         *
         * @param validate boolean indicates if the generated IBAN needs to be
         *  validated after generation
         * @return new iban instance.
         * @exception IbanFormatException if values are not parsable by Iban Specification
         *  <a href="http://en.wikipedia.org/wiki/ISO_13616">ISO_13616</a>
         * @exception UnsupportedCountryException if country is not supported
         */
        public BIN build(boolean validate) throws IbanFormatException,
                IllegalArgumentException, UnsupportedCountryException {

            // null checks
            require(countryCode, bankCode, accountNumber);

            // iban is formatted with default check digit.
            final String formattedIban = formatIban();

            final String checkDigit = IbanUtil.calculateCheckDigit(formattedIban);

            // replace default check digit with calculated check digit
            final String ibanValue = IbanUtil.replaceCheckDigit(formattedIban, checkDigit);

            if (validate) {
                IbanUtil.validate(ibanValue);
            }
            return new BIN(ibanValue);
        }

        /**
         * Builds random iban instance.
         *
         * @return random iban instance.
         * @exception IbanFormatException if values are not parsable by Iban Specification
         *  <a href="http://en.wikipedia.org/wiki/ISO_13616">ISO_13616</a>
         * @exception UnsupportedCountryException if country is not supported
         *
         */
        public BIN buildRandom() throws IbanFormatException,
                IllegalArgumentException, UnsupportedCountryException {
            if (countryCode == null) {
                List<CountryCode> countryCodes = BbanStructure.supportedCountries();
                this.countryCode(countryCodes.get(random.nextInt(countryCodes.size())));
            }
            fillMissingFieldsRandomly();
            return build();
        }

        /**
         * Returns formatted bban string.
         */
        private String formatBban() {
            final StringBuilder sb = new StringBuilder();
            final BbanStructure structure = BbanStructure.forCountry(countryCode);

            if (structure == null) {
                throw new UnsupportedCountryException(countryCode.toString(),
                        "Country code is not supported.");
            }

            for(final BbanStructureEntry entry : structure.getEntries()) {
                switch (entry.getEntryType()) {
                    case bank_code:
                        sb.append(bankCode);
                        break;
                    case branch_code:
                        sb.append(branchCode);
                        break;
                    case account_number:
                        sb.append(accountNumber);
                        break;
                    case national_check_digit:
                        sb.append(nationalCheckDigit);
                        break;
                    case account_type:
                        sb.append(accountType);
                        break;
                    case owner_account_number:
                        sb.append(ownerAccountType);
                        break;
                    case identification_number:
                        sb.append(identificationNumber);
                        break;
                }
            }
            return sb.toString();
        }

        /**
         * Returns formatted iban string with default check digit.
         */
        private String formatIban() {
            final StringBuilder sb = new StringBuilder();
            sb.append(countryCode.getAlpha2());
            sb.append(DEFAULT_CHECK_DIGIT);
            sb.append(formatBban());
            return sb.toString();
        }

        private void require(final CountryCode countryCode,
                             final String bankCode,
                             final String accountNumber)
                throws IbanFormatException {
            if(countryCode == null) {
                throw new IbanFormatException(COUNTRY_CODE_NOT_NULL,
                        "countryCode is required; it cannot be null");
            }

            if(bankCode == null) {
                throw new IbanFormatException(BANK_CODE_NOT_NULL,
                        "bankCode is required; it cannot be null");
            }

            if(accountNumber == null) {
                throw new IbanFormatException(ACCOUNT_NUMBER_NOT_NULL,
                        "accountNumber is required; it cannot be null");
            }
        }

        private void fillMissingFieldsRandomly() {
            final BbanStructure structure = BbanStructure.forCountry(countryCode);

            if (structure == null) {
                throw new UnsupportedCountryException(countryCode.toString(),
                        "Country code is not supported.");
            }

            for(final BbanStructureEntry entry : structure.getEntries()) {
                switch (entry.getEntryType()) {
                    case bank_code:
                        if (bankCode == null) {
                            bankCode = entry.getRandom();
                        }
                        break;
                    case branch_code:
                        if (branchCode == null) {
                            branchCode = entry.getRandom();
                        }
                        break;
                    case account_number:
                        if (accountNumber == null) {
                            accountNumber = entry.getRandom();
                        }
                        break;
                    case national_check_digit:
                        if (nationalCheckDigit == null) {
                            nationalCheckDigit = entry.getRandom();
                        }
                        break;
                    case account_type:
                        if (accountType == null) {
                            accountType = entry.getRandom();
                        }
                        break;
                    case owner_account_number:
                        if (ownerAccountType == null) {
                            ownerAccountType = entry.getRandom();
                        }
                        break;
                    case identification_number:
                        if (identificationNumber == null) {
                            identificationNumber = entry.getRandom();
                        }
                        break;
                }
            }
        }

    }

}