package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstagePassUpdateStrategy extends IncreasingQualityItemUpdate implements DailyUpdateStrategy{
    private final Integer tripleIncreaseUpperBound = 5;
    private final Integer doubleIncreaseUpperBound = 10;

    @Override
    public void update(Item item) {
        if (item.sellIn <= 0){
            item.quality = 0;
            item.sellIn--;
            return;
        }
        if (item.sellIn <= tripleIncreaseUpperBound){
            item.quality += 3;
        } else if (item.sellIn <= doubleIncreaseUpperBound){
            item.quality += 2;
        } else {
            item.quality++;
        }

        checkAndSetUpperBound(item);

        item.sellIn--;
    }
}
