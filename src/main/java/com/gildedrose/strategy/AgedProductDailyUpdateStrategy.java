package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedProductDailyUpdateStrategy extends IncreasingQualityItemUpdate implements DailyUpdateStrategy {
    @Override
    public void update(Item item) {
        if (item.sellIn > 0){
            item.quality++;
        } else {
            item.quality += 2;
        }
        checkAndSetUpperBound(item);
        item.sellIn--;
    }
}
