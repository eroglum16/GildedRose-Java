package com.gildedrose;

import com.gildedrose.strategy.*;

class GildedRose {
    Item[] items;

    private final DailyUpdateStrategyContext dailyUpdateStrategyContext;
    public GildedRose(Item[] items) {
        this.items = items;
        this.dailyUpdateStrategyContext = new DailyUpdateStrategyContext();
    }

    public void updateQuality() {
        for (Item item : items) {
            dailyUpdateStrategyContext.execute(item);
        }
    }
}
