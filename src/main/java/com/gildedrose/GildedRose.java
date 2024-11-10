package com.gildedrose;

import com.gildedrose.strategy.AgedProductDailyUpdateStrategy;
import com.gildedrose.strategy.DailyUpdateStrategy;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    private final List<String> agedProducts = Arrays.asList("Aged Brie");

    private final DailyUpdateStrategy agedProductDailyUpdateStrategy;
    public GildedRose(Item[] items) {
        this.items = items;
        this.agedProductDailyUpdateStrategy = new AgedProductDailyUpdateStrategy();
    }

    public void updateQuality() {
        for (Item item : items) {
            if (this.agedProducts.contains(item.name)){
                this.agedProductDailyUpdateStrategy.update(item);
                return;
            }
            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            }
        }
    }
}
