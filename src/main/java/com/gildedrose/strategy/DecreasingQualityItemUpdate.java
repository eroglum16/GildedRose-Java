package com.gildedrose.strategy;

import com.gildedrose.Item;

public class DecreasingQualityItemUpdate {
    private final Integer qualityLowerBound = 0;

    protected void checkAndSetQualityLowerBound(Item item){
        if (item.quality < qualityLowerBound){
            item.quality = qualityLowerBound;
        }
    }
}
