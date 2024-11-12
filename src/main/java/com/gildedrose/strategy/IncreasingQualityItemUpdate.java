package com.gildedrose.strategy;

import com.gildedrose.Item;

public class IncreasingQualityItemUpdate {
    private final Integer qualityUpperBound = 50;

    protected void checkAndSetQualityUpperBound(Item item){
        if (item.quality > qualityUpperBound){
            item.quality = qualityUpperBound;
        }
    }
}
