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
    void qualityIsNeverOver50AgedBrie(){
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 49),
            new Item("Aged Brie", 0, 49),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(app.items[0], 1, 50);
        assertItem(app.items[1], -1, 50);

        app.updateQuality();
        assertItem(app.items[0], 0, 50);
        assertItem(app.items[1], -2, 50);

        app.updateQuality();
        assertItem(app.items[0], -1, 50);
        assertItem(app.items[1], -3, 50);
    }
    @Test
    void qualityIsNeverOver50BackstagePasses(){
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 45),
            new Item("Backstage passes to a TAFKAL80ETC concert", 8, 47),
            new Item("Backstage passes to a TAFKAL80ETC concert", 13, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItem(app.items[0], 3, 48);
        assertItem(app.items[1], 7, 49);
        assertItem(app.items[2], 12, 50);
        assertItem(app.items[3], 10, 50);

        app.updateQuality();
        assertItem(app.items[0], 2, 50);
        assertItem(app.items[1], 6, 50);
        assertItem(app.items[2], 11, 50);
        assertItem(app.items[3], 9, 50);

        app.updateQuality();
        assertItem(app.items[0], 1, 50);
        assertItem(app.items[1], 5, 50);
        assertItem(app.items[2], 10, 50);
        assertItem(app.items[3], 8, 50);
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

    @Test
    void conjuredItemsShouldDegradeTwiceAsFast(){
        Item[] items = new Item[] {
            new Item("Conjured Mana Cake", 3, 5),
            new Item("Conjured Mana Cake", 10, 10),
            new Item("Conjured Mana Cake", 1, 7),
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItem(items[0], 2, 3);
        assertItem(items[1], 9, 8);
        assertItem(items[2], 0, 5);
    }

    @Test
    void givenSellDatePassed_conjuredItemsShouldDegradeFourTimesAsFast(){
        Item[] items = new Item[] {
            new Item("Conjured Mana Cake", 1, 12),
            new Item("Conjured Mana Cake", 0, 10),
            new Item("Conjured Mana Cake", -1, 8),
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertItem(items[0], 0, 10);
        assertItem(items[1], -1, 6);
        assertItem(items[2], -2, 4);

        app.updateQuality();
        assertItem(items[0], -1, 6);
        assertItem(items[1], -2, 2);
        assertItem(items[2], -3, 0);
    }

    @Test
    void qualityOfAConjuredItemIsNeverNegative(){
        Item[] items = new Item[] {
            new Item("Conjured Mana Cake", 4, 2),
            new Item("Conjured Mana Cake", 4, 1),
            new Item("Conjured Mana Cake", 4, 0),

            new Item("Conjured Mana Cake", 1, 0),
            new Item("Conjured Mana Cake", 0, 1),
            new Item("Conjured Mana Cake", -1, 3),
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItem(items[0], 3, 0);
        assertItem(items[1], 3, 0);
        assertItem(items[2], 3, 0);

        assertItem(items[3], 0, 0);
        assertItem(items[4], -1, 0);
        assertItem(items[5], -2, 0);
    }

    private void assertItem(Item item, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }

}

