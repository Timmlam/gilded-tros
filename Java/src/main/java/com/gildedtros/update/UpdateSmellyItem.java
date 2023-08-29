package com.gildedtros.update;

import com.gildedtros.Item;

public class UpdateSmellyItem implements UpdateItemInterface{
    @Override
    public void updateItem(Item item) {
        if (item.sellIn > EXPIRATION_DATE){
            item.quality -= 2;
        } else {
            item.quality -= 4;
        }
        if(item.quality < MIN_QUALITY_VALUE) {
            item.quality = 0;
        }
        item.sellIn--;
    }
}
