package com.gildedtros.update;

import com.gildedtros.Item;

public class UpdateWineItem implements UpdateItemInterface {
    @Override
    public void updateItem(Item item) {
        if(item.quality < MAX_QUALITY_VALUE) {
            item.quality++;
        }
        item.sellIn--;
    }
}
