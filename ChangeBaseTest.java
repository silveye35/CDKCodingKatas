package com.cobalt.dap.creatives;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ChangeBaseTest {

    @Test
    public void shouldReturn0Given0Base3() {
        verifyConvertBase("0", 0);
    }

    @Test
    public void shouldReturn1Given1Base3() {
        verifyConvertBase("1", 1);
    }

    @Test
    public void shouldReturn2Given2Base3() {
        verifyConvertBase("2", 2);
    }

    @Test
    public void shouldReturn10Given3Base3() {
        verifyConvertBase("10", 3);
    }

    @Test
    public void shouldReturn11Given4Base3() {
        verifyConvertBase("11", 4);
    }

    @Test
    public void shouldReturn12Given5Base3() {
        verifyConvertBase("12", 5);
    }

    @Test
    public void shouldReturn20Given6Base3() {
        verifyConvertBase("20", 6);
    }

    @Test
    public void shouldReturn222Given26Base3() {
        verifyConvertBase("222", 26);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativeNumbers() {
        convertBase(-2);
    }

    private void verifyConvertBase(String expected, int number) {
        String actual = convertBase(number);
        Assert.assertThat(expected, Matchers.equalTo(actual));
    }


    private String convertBase(int number) {

        if(number < 0){
            throw new IllegalArgumentException();
        }

        if (number < 3) {
            return Integer.toString(number);

        }

        if(number % 3 == 0){
            return convertBase(number/3) + '0';
        }

        if(number % 3 == 1){
            return convertBase((number-1)/3) + '1';
        }

        return convertBase((number-2)/3) + '2';

    }
}
