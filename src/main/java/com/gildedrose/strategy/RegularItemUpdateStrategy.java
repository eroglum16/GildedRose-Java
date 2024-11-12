package com.gildedrose.strategy;

import com.gildedrose.Item;

public class RegularItemUpdateStrategy implements DailyUpdateStrategy{
    private final Integer qualityLowerBound = 0;
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

    private void checkAndSetQualityLowerBound(Item item){
        if (item.quality < qualityLowerBound){
            item.quality = qualityLowerBound;
        }
    }
}
