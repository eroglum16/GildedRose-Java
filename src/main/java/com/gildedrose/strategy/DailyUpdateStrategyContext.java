package com.gildedrose.strategy;

import com.gildedrose.Item;

import java.util.Arrays;
import java.util.List;

public class DailyUpdateStrategyContext {
    private final List<String> agedProductNames = Arrays.asList("Aged Brie");
    private final List<String> legendaryItemNames = Arrays.asList("Sulfuras, Hand of Ragnaros");
    private final List<String> backstagePassNames = Arrays.asList("Backstage passes to a TAFKAL80ETC concert");
    private final List<String> conjuredItemNames = Arrays.asList("Conjured Mana Cake");

    private final DailyUpdateStrategy agedProductDailyUpdateStrategy;
    private final DailyUpdateStrategy legendaryItemUpdateStrategy;
    private final DailyUpdateStrategy backstagePassUpdateStrategy;
    private final DailyUpdateStrategy regularItemUpdateStrategy;
    private final DailyUpdateStrategy conjuredItemUpdateStrategy;
    public DailyUpdateStrategyContext() {
        this.agedProductDailyUpdateStrategy = new AgedProductDailyUpdateStrategy();
        this.legendaryItemUpdateStrategy = new LegendaryItemUpdateStrategy();
        this.backstagePassUpdateStrategy = new BackstagePassUpdateStrategy();
        this.regularItemUpdateStrategy = new RegularItemUpdateStrategy();
        this.conjuredItemUpdateStrategy = new ConjuredItemUpdateStrategy();
    }

    public void execute(Item item){
        if (this.agedProductNames.contains(item.name)){
            this.agedProductDailyUpdateStrategy.update(item);
        } else if (this.legendaryItemNames.contains(item.name)){
            this.legendaryItemUpdateStrategy.update(item);
        } else if (this.backstagePassNames.contains(item.name)){
            this.backstagePassUpdateStrategy.update(item);
        } else if (this.conjuredItemNames.contains(item.name)){
          this.conjuredItemUpdateStrategy.update(item);
        } else {
            this.regularItemUpdateStrategy.update(item);
        }
    }
}
