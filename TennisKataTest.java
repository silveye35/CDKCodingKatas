package com.cdk.dap.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class TennisKataTest {


    @Test
    public void ShouldReturnLoveLoveForInitialScores() {
        assertEquals("Love - Love", TennisKata.getScore(0, 0));
    }

    @Test
    public void shouldReturnFifteenLoveIfPlayerOneScores() {
        assertEquals("Fifteen - Love", TennisKata.getScore(1, 0));
    }

    @Test
    public void shouldReturnLoveFifteenIfPlayerTwoScores() {
        assertEquals("Love - Fifteen", TennisKata.getScore(0, 1));
    }

    @Test
    public void shouldReturnThirtyLoveIfPlayerOneScoresTwice() {
        assertEquals("Thirty - Love", TennisKata.getScore(2, 0));
    }

    @Test
    public void shouldReturnFifteenFifteenIfPlayerTwoAndPlayerOneScoreOnce() {
        assertEquals("Fifteen - Fifteen", TennisKata.getScore(1, 1));
    }

    @Test
    public void shouldReturnThirtyThirtyIfPlayerOneAndPlayerTwoScoresTwice() {
        assertEquals("Thirty - Thirty", TennisKata.getScore(2, 2));
    }


}