package com.gildedtros.update;

import com.gildedtros.Item;

public class UpdateBackstagePassesItem implements UpdateItemInterface {
    @Override
    public void updateItem(Item item) {
        int newQuality;
        if (item.sellIn <= EXPIRATION_DATE){
            newQuality = 0;
        } else {
            if (item.sellIn <= 5){
                newQuality = item.quality + 3;
            } else if (item.sellIn <= 10) {
                newQuality = item.quality + 2;
            } else {
                newQuality = item.quality + 1;
            }
        }
        if (newQuality > MAX_QUALITY_VALUE){
            newQuality = 50;
        }
        item.quality = newQuality;
        item.sellIn--;

    }
}
