package com.gildedrose;

import com.gildedrose.strategy.AgedProductDailyUpdateStrategy;
import com.gildedrose.strategy.DailyUpdateStrategy;
import com.gildedrose.strategy.LegendaryItemUpdateStrategy;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    private final List<String> agedProducts = Arrays.asList("Aged Brie");
    private final List<String> legendaryItems = Arrays.asList("Sulfuras, Hand of Ragnaros");

    private final DailyUpdateStrategy agedProductDailyUpdateStrategy;
    private final DailyUpdateStrategy legendaryItemUpdateStrategy;
    public GildedRose(Item[] items) {
        this.items = items;
        this.agedProductDailyUpdateStrategy = new AgedProductDailyUpdateStrategy();
        this.legendaryItemUpdateStrategy = new LegendaryItemUpdateStrategy();
    }

    public void updateQuality() {
        for (Item item : items) {
            if (this.agedProducts.contains(item.name)){
                this.agedProductDailyUpdateStrategy.update(item);
                return;
            } else if (this.legendaryItems.contains(item.name)){
                this.legendaryItemUpdateStrategy.update(item);
                return;
            }
            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
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

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                } else {
                    item.quality = 0;
                }
            }
        }
    }
}
