package com.gildedtros.update;

import com.gildedtros.Item;

public class UpdateNormalItem implements UpdateItemInterface{
    @Override
    public void updateItem(Item item) {
        if (item.quality > 0){
            item.quality--;
            if (item.sellIn <= 0 ){
                item.quality--;
            }
        }
        item.sellIn--;

    }
}
