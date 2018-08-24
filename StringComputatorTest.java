package com.cdk.dap.kata;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class StringComputatorTest {
    /*
        input = "1+7*3"
        output = "22"
     */

    @Test
    public void shouldReturnNullWhenGivenANullString(){
        assertComputation(null, compute(null));
    }



    @Test
    public void shouldReturnEmptyStringWhenGivenAnEmptyString(){
        assertComputation("", compute(""));

    }

    @Test
    public void shouldReturnStringNumberWhenGivenStringNumber(){
        assertComputation("8", compute("8"));
    }

    @Test
    public void shouldReturnStringAnswerWhenGivenStringAdditionProblemWithTwoNumbers(){
        assertComputation("6", compute("3+3"));
        assertComputation("7", compute("4+3"));
        assertComputation("7", compute("4+3"));
        assertComputation("445", compute("442+3"));
    }

    @Test
    public void shouldReturnStringAnswerWhenGivenStringSubtractionProblemWithTwoNumbers(){
        assertComputation("6", compute("9-3"));
        assertComputation("95", compute("98-3"));
        assertComputation("97", compute("100-3"));
    }


    @Test
    public void shouldHaveAdditionOperatorTest(){
        String input = "3+3";
        Assert.assertThat(shouldHaveArithmeticOperator(input), Matchers.equalTo(true));
    }

    @Test
    public void shouldNotHaveArithmeticOperatorTest(){
        String input = "8";
        Assert.assertThat(shouldHaveArithmeticOperator(input),Matchers.equalTo(false));
    }

    @Test
    public void shouldHaveSubtractionOperatorTest(){
        String input = "9-3";
        Assert.assertThat(shouldHaveArithmeticOperator(input), Matchers.equalTo(true));
    }

    private boolean shouldHaveArithmeticOperator(String input) {
        if((input.indexOf('+') == -1) && (input.indexOf('-') == -1) && (input.indexOf('*') == -1)){
            return false;
        }else{
            return true;
        }
    }

    private void assertComputation(String expected, String compute) {
        Assert.assertThat(compute, Matchers.equalTo(expected));
    }


    private String compute(String input) {
        String[] digits;
        int answer;
        if(input != null && shouldHaveArithmeticOperator(input)){
            if(input.indexOf('+') != -1){
                digits = input.split("\\+");
                answer = Integer.parseInt(digits[0]) + Integer.parseInt(digits[1]);
                return String.valueOf(answer);
            }else{
                digits = input.split("\\-");
                answer = Integer.parseInt(digits[0]) - Integer.parseInt(digits[1]);
                return String.valueOf(answer);
            }
        }else{
            return input;
        }
    }


}
