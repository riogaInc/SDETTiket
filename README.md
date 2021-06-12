##**tiket.com SDET Assessment**

This repo contains test automation source code for fulfilling the requirement for tiket.com technical assessment for SDET position. The script was build by using **Java Cucumber Framework** for testing web https://www.tiket.com/.

The Gerkhin file contain scenarios that will be execute Automaticly which are on /src/test/resources/

The implementation of the gerkhin syntax was put on java file at /src/test/java/StepDefinitions/

---
## Assumption

1. for login step in every each scenario, email and password have to be replaced with valid user's email and password that will be used to login. Because for the security reason and because the repository can be accesed publicly, I put random email address and random password
2. for entering OTP when user logs in, it has tobe done manually and have chance to entering it for 20 seconds. For real life scenario, the OTP can be got from specific end point, querying to database, etc
3. Scenarios that crated are scenario for Product Flight and Product Train
4. For Scenario Product Train cannot be continued to finish because some trouble in tiket.com website when trying to simulate the user action for choosing seat by clicking "PILIH KURSI" button

![Alt text](https://github.com/riogaInc/SDETTiket/blob/master/docs/problem_pilihkursi.png?png=true)



---

## Prerequisite
To run the project, you need to install to your environment.

1. Java JDK ver. 1.8.
2. Apache Maven
3. MacOS version 10.14.4 Mojave
4. Chrome Browser Version 91.0.4472.77
5. Chrome Driver for Chrome Browser Version 91.0.4472.77

---

## Running The Script
You can run scrip by using maven command "mvn clean verify"

---

## Author

1. Satrio Ajie Wijaya

