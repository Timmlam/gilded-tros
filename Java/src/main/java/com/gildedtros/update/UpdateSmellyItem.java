package com.gildedtros.update;

import com.gildedtros.Item;

public class UpdateSmellyItem implements UpdateItemInterface{
    @Override
    public void updateItem(Item item) {
        if (item.sellIn > 0){
            item.quality -= 2;
        } else {
            item.quality -= 4;
        }
        if(item.quality < 0) {
            item.quality = 0;
        }
        item.sellIn--;
    }
}
