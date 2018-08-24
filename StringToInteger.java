package com.cdk.dap.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToInteger {
    @Test
    public void givenEmptyShouldReturnNull() {

        check("", null);
    }

    @Test(expected = NullPointerException.class)
    public void GivenNullShouldThrowNewException(){

        check(null, -1.0);
    }

    @Test
    public void givenStringNumberZeroShouldReturnIntegerZero() {
        check("0", 0.0);
    }

    @Test
    public void givenStringNumnberOneShouldReturnIntegerOne() {
        check("1", 1.0);
    }

    @Test
    public void givenDoubleDigitStringNumberShouldReturnDoubleDigitNumber() {
        check("12", 12.0);
    }

    @Test
    public void givenNegativeStringNumberShouldReturnNegativeIntegerNumber() {
        check("-7", -7.0);
    }

    @Test
    public void givenFloatNumberStringShouldReturnFloatNumber() {
        check("12.2222222", 12.2222222);
    }

    @Test
    public void givenTwoStringNumbersShouldReturnIntegerNumberMultiplied(){ //to-do
        check("12*3", 36.0);
    }



    private void check(String input, Double expected) {
        assertEquals(expected, convertStringToInteger(input));
    }

    private Double convertStringToInteger(String input) {

        if (null == input){
            throw new NullPointerException();
        } if (input.length() > 0) {
            double value = 0;
            int multiplier = 1;
            int roundingFactor = 1;
            if (input.charAt(0) == '-') {
                multiplier = -1;
                input = input.substring(1);
            }
            int power = input.length();
            if (input.contains(".")) {
                power = input.indexOf('.');
                roundingFactor = input.substring(power).length();
            }
            for (char ch : input.toCharArray()) {
                if (ch == '.')
                    continue;
                    power--;
                    value += ((int) (ch - 48) * Math.pow(10, power));
                }
                double val = Math.pow(10, roundingFactor);
                return Math.round((value * multiplier)*val)/val;
        }


        return null;
    }





}
