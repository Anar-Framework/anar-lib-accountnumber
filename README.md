#### Account Number Generator Library of Anar Framework

Bank Identifier Number (BIN) and Business Identifier Code (BIC) Generation and Validation based on ISO 13616 and ISO 9262.


```
        <dependency>
			<groupId>af.gov.anar.lib</groupId>
			<artifactId>anar-lib-accountnumber</artifactId>
			<version>${project.version}</version>
		</dependency>



```

#### Documentation 

for more information refer to : https://github.com/Anar-Framework/anar-lib-accountnumber/wiki



##### Generate BIN 

```java

// How to generate BIN
 BIN BIN = new BIN.Builder()
                .countryCode(CountryCode.AFG)
                .bankCode("19043")
                .accountNumber("00234573201")
                .build();


 // How to create BIN object from String
 BIN BIN = BIN.valueOf("DE89370400440532013000");

 // How to create BIN object from formatted String
 BIN BIN = BIN.valueOf("DE89 3704 0044 0532 0130 00", BINFormat.Default);

 // How to generate random BIN
 BIN BIN = BIN.random(CountryCode.AFG);
 BIN BIN = BIN.random();
 BIN BIN = new BIN.Builder()
                 .countryCode(CountryCode.AFG)
                 .bankCode("19043")
                 .buildRandom();

 // How to validate BIN 
 try {
     BINUtil.validate("AT611904300234573201");
     BINUtil.validate("DE89 3704 0044 0532 0130 00", BINFormat.Default);
     // valid
 } catch (BINFormatException |
          InvalidCheckDigitException |
          UnsupportedCountryException e) {
     // invalid
 }

```