package com.gildedrose;

import com.gildedrose.strategy.AgedProductDailyUpdateStrategy;
import com.gildedrose.strategy.BackstagePassUpdateStrategy;
import com.gildedrose.strategy.DailyUpdateStrategy;
import com.gildedrose.strategy.LegendaryItemUpdateStrategy;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    private final List<String> agedProductNames = Arrays.asList("Aged Brie");
    private final List<String> legendaryItemNames = Arrays.asList("Sulfuras, Hand of Ragnaros");
    private final List<String> backstagePassNames = Arrays.asList("Backstage passes to a TAFKAL80ETC concert");

    private final DailyUpdateStrategy agedProductDailyUpdateStrategy;
    private final DailyUpdateStrategy legendaryItemUpdateStrategy;
    private final DailyUpdateStrategy backstagePassUpdateStrategy;
    public GildedRose(Item[] items) {
        this.items = items;
        this.agedProductDailyUpdateStrategy = new AgedProductDailyUpdateStrategy();
        this.legendaryItemUpdateStrategy = new LegendaryItemUpdateStrategy();
        this.backstagePassUpdateStrategy = new BackstagePassUpdateStrategy();
    }

    public void updateQuality() {
        for (Item item : items) {
            if (this.agedProductNames.contains(item.name)){
                this.agedProductDailyUpdateStrategy.update(item);
                continue;
            } else if (this.legendaryItemNames.contains(item.name)){
                this.legendaryItemUpdateStrategy.update(item);
                continue;
            } else if (this.backstagePassNames.contains(item.name)){
                this.backstagePassUpdateStrategy.update(item);
                continue;
            }

            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }
        }
    }
}
