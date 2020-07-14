package com.automationpractice.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomValues {

    public static String generateRandomEmailAddress() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;

        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        String emailAddress = generatedString + "@test.com";

        return emailAddress;
    }

    public static String generateRandomPhoneNumber() {
        Random generator = new Random();

        int num1, num2, num3;
        int set2, set3;

        // Area code number; Will not print 8 or 9
        num1 = generator.nextInt(7) + 1; // add 1 so there is no 0 to begin
        num2 = generator.nextInt(8); // randomize to 8 becuase 0 counts as a number in the generator
        num3 = generator.nextInt(8);

        // Sequence two of phone number
        // the plus 100 is so there will always be a 3 digit number
        // randomize to 643 because 0 starts the first placement so if i randomized up
        // to 642 it would only go up yo 641 plus 100
        // and i used 643 so when it adds 100 it will not succeed 742
        set2 = generator.nextInt(643) + 100;

        // Sequence 3 of numebr
        // add 1000 so there will always be 4 numbers
        // 8999 so it wont succed 9999 when the 1000 is added
        set3 = generator.nextInt(8999) + 1000;

        String PhoneNumber = (num1 + "" + num2 + "" + num3 + "" + set2 + "" + set3).toString();

        return PhoneNumber;
    }

    public static int generateRandomZipcode(){
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

}
