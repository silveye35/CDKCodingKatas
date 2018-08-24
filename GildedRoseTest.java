package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void updateQualityOnADogFoodShouldDecreaseQualityByOne() {
        final int anyQualityGreaterThanZero = 3;
        final int anySellInGreaterThanZero = 27;
        final int expectedQuality = anyQualityGreaterThanZero - 1;
        final int expectedSellIn = anySellInGreaterThanZero - 1;
        final String itemName = "Dog Food";
        final String expectedItemName = itemName;
        verifyResults(itemName, anySellInGreaterThanZero, anyQualityGreaterThanZero, expectedItemName, expectedSellIn, expectedQuality);
    }

    @Test
    public void updateQualityOnAgedBrieWillIncreaseQualityByOneIfLessThanFifty() {
        final String itemName = "Aged Brie";
        final int anyQualityLessThanFifty = 20;
        final int anySellIn = 48;

        verifyResults(itemName, anySellIn, anyQualityLessThanFifty, itemName, anySellIn - 1, anyQualityLessThanFifty + 1);
    }

    @Test
    public void updateQualityOnAgedBrieWillIncreaseQualityByOneIfGreaterThanFifty() {
        final String itemName = "Aged Brie";
        final int anyQualityLessThanFifty = 55;
        final int anySellIn = 48;

        verifyResults(itemName, anySellIn, anyQualityLessThanFifty, itemName, anySellIn - 1, anyQualityLessThanFifty);
    }

    @Test
    public void updateQualityOnConcertTicketsWillIncreaseQualityByOneIfSellInIsBetweenSixAndElevenAndQualityIsLessThanFifty() {
        final String itemName = "Backstage passes to a TAFKAL80ETC concert";

        final int anyQualityLessThanFifty = 23;
        final int anySellInGreaterThanSixAndLessThanEleven = 10;

        verifyResults(itemName, anySellInGreaterThanSixAndLessThanEleven, anyQualityLessThanFifty, itemName, anySellInGreaterThanSixAndLessThanEleven - 1, anyQualityLessThanFifty+2);
    }

    @Test
    public void updateQualityOnConcertTicketsWillIncreaseQualityByTwoIfSellInIsBetweenSixAndElevenAndQualityIsLessThanFifty() {
        final String itemName = "Backstage passes to a TAFKAL80ETC concert";

        final int anyQualityLessThanFifty = 23;
        final int anySellInGreaterThanSixAndLessThanEleven = 10;

        verifyResults(itemName, anySellInGreaterThanSixAndLessThanEleven, anyQualityLessThanFifty, itemName, anySellInGreaterThanSixAndLessThanEleven - 1, anyQualityLessThanFifty+2);
    }

    private void verifyResults(final String initialItemName,
                               final int initialSellIn,
                               final int initialQuality,
                               final String expectedItemName,
                               final int expectedSellIn,
                               final int expectedQuality) {
        // arrange
        Item[] items = new Item[] { new Item(initialItemName, initialSellIn, initialQuality) };
        // act
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        // assert
        assertEquals("Wrong name",expectedItemName,  items[0].name);
        assertEquals("Wrong sellin", expectedSellIn, items[0].sellIn);
        assertEquals("Wrong quality",expectedQuality, items[0].quality);
    }

}
