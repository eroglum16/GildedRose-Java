package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void givenSellDatePassed_qualityShouldDegradeTwiceAsFast(){
        Item[] items = new Item[] { new Item("anything", 1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(app.items[0], 0, 2);

        app.updateQuality();
        assertItem(app.items[0], -1, 0);
    }

    @Test
    void qualityIsNeverNegative(){
        Item[] items = new Item[] {
            new Item("anything", 5, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(app.items[0], 4, 0);
        assertItem(app.items[1], -1, 0);
    }

    @Test
    void agedBrieShouldIncreaseInQualityOnUpdate(){
        Item[] items = new Item[] { new Item("Aged Brie", 3, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(app.items[0], 2, 4);
    }

    @Test
    void givenSellDatePassed_agedBrieQualityShouldIncreaseTwiceAsFast(){
        Item[] items = new Item[] { new Item("Aged Brie", 1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(app.items[0], 0, 4);

        app.updateQuality();
        assertItem(app.items[0], -1, 6);
    }

    @Test
    void qualityIsNeverOver50(){
        Item[] items = new Item[] { new Item("Aged Brie", 2, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(app.items[0], 1, 50);

        app.updateQuality();
        assertItem(app.items[0], 0, 50);

        app.updateQuality();
        assertItem(app.items[0], -1, 50);
    }

    @Test
    void sulfurasSellInAndQualityNeverChange(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(app.items[0], 0, 80);

        app.updateQuality();
        assertItem(app.items[0], 0, 80);
    }

    @Test
    void givenSellInOver10_backstagePassesIncreaseInValueBy1(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 15) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertItem(app.items[0], 11, 16);

        app.updateQuality();
        assertItem(app.items[0], 10, 17);
    }

    @Test
    void givenSellInLessThanOrEqualTo10AndGreaterThan5_backstagePassesIncreaseInValueBy2(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertItem(app.items[0], 9, 14);

        app.updateQuality();
        assertItem(app.items[0], 8, 16);
    }

    @Test
    void givenSellInLessThanOrEqualTo5_backstagePassesIncreaseInValueBy3(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertItem(app.items[0], 4, 8);

        app.updateQuality();
        assertItem(app.items[0], 3, 11);

        app.updateQuality();
        assertItem(app.items[0], 2, 14);

        app.updateQuality();
        assertItem(app.items[0], 1, 17);

        app.updateQuality();
        assertItem(app.items[0], 0, 20);
    }

    @Test
    void givenConcertDatePassed_backstagePassesQualityDropsTo0(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(app.items[0], -1, 0);
    }

    private void assertItem(Item item, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }

}

