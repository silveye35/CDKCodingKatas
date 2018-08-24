package com.cdk.dap.kata;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void shouldReturnNullForNoInput(){
        assertValidity(null, null);
    }

    @Test
    public void shouldReturnEmptyStringForEmptyString(){
        assertValidity("", "");
    }

    @Test
    public void shouldReturnStringNumberForGivenStringNumber(){
        assertValidity("129", "129");
    }

    @Test
    public void shouldReturnStringAnswerForGivenStringAdditionProblem(){
        assertValidity("6", "2+4");
        assertValidity("8", "6+2");
        assertValidity("25", "12+13");
    }

    @Test
    public void shouldReturnStringAnswerForGivenSingleStringArithmeticProblem(){
        assertValidity("15", "12+3");
        assertValidity("12", "15-3");
        assertValidity("6", "2*3");
        assertValidity("8", "24/3");
    }

    @Test
    public void shouldReturnStringAnswerForThreeDigitSingleArithmeticOperationProblem(){
        assertValidity("15", "7+4+4");
        assertValidity("24", "28-2-2");
        assertValidity("27", "3*3*3");
        assertValidity("10", "40/2/2");
    }

//    @Test
//    public void shouldReturnStringAnswerForMultipleDigitMultipleArithmeticOperationProblem(){
//        assertValidity("7", "1+2*3");
//    }


    public void assertValidity(String expected, String computation){
        Assert.assertThat(compute(computation), Matchers.equalTo(expected));
    }

    private String compute(String input) {
        String[] digits;
        int answer;
        if(input == null){
            return null;
        }else{
            if(!hasMultipleMathOperations(input)){
                if(input.indexOf('+') != -1){
                    return add(input);
                }else if(input.indexOf('-') != -1){
                    return subtract(input);
                }else if(input.indexOf('/') != -1){
                    return divide(input);
                }else{
                    return multiply(input);
                }

            }else{
                return input;
            }
        }
    }

    @Test
    public void shouldReturnFalseWhenHaveMixMathOperation() {
        Assert.assertThat(hasMultipleMathOperations("++"), Matchers.equalTo(false));
    }

    public boolean hasSameMathOperation(String input){
        for(char c : input.toCharArray()){
            if(c == '*' || c == '/' || c == '+' || c == '-'){
                return true;
            }
        }
        return false;
    }

    public boolean hasMultipleMathOperations(String input){
        int count = 0;
        if(input.indexOf('+') != -1){
            count++;
        }
        if(input.indexOf('-') != -1){
            count++;
        }
        if(input.indexOf('/') != -1){
            count++;
        }
        if(input.indexOf('*') != -1){
            count++;
        }
        if(count > 1){
            return true;
        }else{
            return false;
        }
    }



    public String add(String input){
        String[] digits;
        int answer;
        digits = input.split("\\+");
        answer = Integer.parseInt(digits[0]);
        for(int i = 1; i < digits.length; i++){
            answer += Integer.parseInt(digits[i]);
        }
        return String.valueOf(answer);
    }

    public String subtract(String input){
        String[] digits;
        int answer;
        digits = input.split("\\-");
        answer = Integer.parseInt(digits[0]);
        for(int i = 1; i < digits.length; i++){
            answer = answer - Integer.parseInt(digits[i]);
        }
        return String.valueOf(answer);
    }

    public String divide(String input){
        String[] digits;
        int answer;
        digits = input.split("/");
        answer = Integer.parseInt(digits[0]);
        for(int i = 1; i < digits.length; i++){
            answer = answer / Integer.parseInt(digits[i]);
        }
        return String.valueOf(answer);
    }

    public String multiply(String input){
        String[] digits;
        int answer;
        digits = input.split("\\*");
        answer = Integer.parseInt(digits[0]);
        for(int i = 1; i < digits.length; i++){
            answer = answer * Integer.parseInt(digits[i]);
        }
        return String.valueOf(answer);
    }
}
