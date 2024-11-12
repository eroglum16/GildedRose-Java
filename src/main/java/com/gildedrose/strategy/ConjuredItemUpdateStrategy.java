package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConjuredItemUpdateStrategy extends DecreasingQualityItemUpdate implements DailyUpdateStrategy{
    @Override
    public void update(Item item) {
        if (item.sellIn > 0) {
            item.quality -= 2;
        } else {
            item.quality -= 4;
        }

        checkAndSetQualityLowerBound(item);

        item.sellIn--;
    }
}
