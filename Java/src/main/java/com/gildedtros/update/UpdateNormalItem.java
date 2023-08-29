package com.gildedtros.update;

import com.gildedtros.Item;

public class UpdateNormalItem implements UpdateItemInterface{
    @Override
    public void updateItem(Item item) {
        if (item.quality > MIN_QUALITY_VALUE){
            item.quality--;
            if (item.sellIn <= EXPIRATION_DATE ){
                item.quality--;
            }
        }
        item.sellIn--;

    }
}
