package com.cdk.dap.kata;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsKata {

    @Test
    public void givenOneShouldReturnEmpty(){
        Assert.assertThat(getPrime(1), Matchers.empty());
    }

    @Test
    public void givenTwoShouldReturn2(){
        verifyPrimeFactors(2);
    }

    @Test
    public void givenThreeShouldReturnThree(){
        verifyPrimeFactors(3);
    }

    @Test
    public void given4ShouldReturn2and2() {
        verifyPrimeFactors(2, 2);
    }

    @Test
    public void given5ShouldReturn5(){
        verifyPrimeFactors(5);
    }

    @Test
    public void given6ShouldReturn2and3(){
        verifyPrimeFactors(2,3);
    }

    @Test
    public void given7ShouldReturn7(){
        verifyPrimeFactors(7);
    }

    @Test
    public void given8ShouldReturn2And2And2(){
        verifyPrimeFactors(2,2,2);
    }

    @Test
    public void given9ShouldReturn3And3(){
        verifyPrimeFactors(3,3);
    }

    @Test
    public void given10ShouldReturn2And5(){
        verifyPrimeFactors(2,5);
    }

    @Test
    public void given150ShouldReturn2355(){
        verifyPrimeFactors(2,3,5,5);
    }

    @Test
    public void given150ShouldReturn23557And13And19(){
        verifyPrimeFactors(2,3,5,5,13,7,19);
    }

    private void verifyPrimeFactors(final Integer... input) {
        int number = 1;
        for (int i : input) {
            number*=i;
        }
        Assert.assertThat(getPrime(number), Matchers.containsInAnyOrder(input));
    }

    private List<Integer> getPrime(int input) {
        final List<Integer> myList = new ArrayList<>();

        if (input == 1) {
            return myList;
        }

        int divisor = 2;
        while(input > 1){
            while((input % divisor) == 0){
                myList.add(divisor);
                input = input / divisor;
            }
            divisor++;
        }
        return myList;
    }
}
