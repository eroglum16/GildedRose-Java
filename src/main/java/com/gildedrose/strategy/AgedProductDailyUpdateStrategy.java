package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedProductDailyUpdateStrategy implements DailyUpdateStrategy {
    @Override
    public void update(Item item) {
        if (item.quality < 50){
            if (item.sellIn > 0){
                item.quality++;
            } else {
                item.quality += 2;
            }
        }
        item.sellIn--;
    }
}
