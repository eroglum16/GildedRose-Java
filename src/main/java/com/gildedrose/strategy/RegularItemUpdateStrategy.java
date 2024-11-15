package com.gildedrose.strategy;

import com.gildedrose.Item;

public class RegularItemUpdateStrategy extends DecreasingQualityItemUpdate implements DailyUpdateStrategy{
    @Override
    public void update(Item item) {
        if (item.sellIn > 0) {
            item.quality--;
        } else {
            item.quality -= 2;
        }

        checkAndSetQualityLowerBound(item);

        item.sellIn--;
    }

}
