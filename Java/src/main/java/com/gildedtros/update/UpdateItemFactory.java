package com.gildedtros.update;

import com.gildedtros.Item;

public class UpdateItemFactory {

    public UpdateItemInterface getUpdater(Item item){
        if (item.name.equals("Good Wine")){
            return new UpdateWineItem();
        } else if (item.name.equals("B-DAWG Keychain")) {
            return new UpdateLegendaryItem();
        } else if (item.name.startsWith("Backstage passes for")) {
            return new UpdateBackstagePassesItem();
        } else if (item.name.equals("Duplicate Code") || item.name.equals("Long Methods") || item.name.equals("Ugly Variable Names") ) {
            return new UpdateSmellyItem();
        } else {
            return new UpdateNormalItem();
        }
    }
}
