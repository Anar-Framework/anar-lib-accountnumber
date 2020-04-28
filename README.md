#### Account Number Generator Library of Anar Framework

Bank Identifier Number (Bin) and Business Identifier Code (BIC) Generation and Validation based on ISO 13616 and ISO 9262.


```
        <dependency>
			<groupId>af.gov.anar.lib</groupId>
			<artifactId>anar-lib-accountnumber</artifactId>
			<version>${project.version}</version>
		</dependency>



```

#### Documentation 

for more information refer to : https://github.com/Anar-Framework/anar-lib-accountnumber/wiki



##### Generate Bin 

```java

// How to generate Bin
 Bin Bin = new Bin.Builder()
                .countryCode(CountryCode.AFG)
                .bankCode("19043")
                .accountNumber("00234573201")
                .build();


 // How to create Bin object from String
 Bin Bin = Bin.valueOf("DE89370400440532013000");

 // How to create Bin object from formatted String
 Bin Bin = Bin.valueOf("DE89 3704 0044 0532 0130 00", BinFormat.Default);

 // How to generate random Bin
 Bin Bin = Bin.random(CountryCode.AFG);
 Bin Bin = Bin.random();
 Bin Bin = new Bin.Builder()
                 .countryCode(CountryCode.AFG)
                 .bankCode("19043")
                 .buildRandom();

 // How to validate Bin 
 try {
     BinUtil.validate("AT611904300234573201");
     BinUtil.validate("DE89 3704 0044 0532 0130 00", BinFormat.Default);
     // valid
 } catch (BinFormatException |
          InvalidCheckDigitException |
          UnsupportedCountryException e) {
     // invalid
 }

```


##### Extract BIC

```java

//How to create Bic object from String
 Bic bic = Bic.valueOf("DEUTDEFF");


 //How to validate Bic
 try {
     BicUtil.validate("DEUTDEFF500");
     // valid
 } catch (BicFormatException e) {
     // invalid
 }

```