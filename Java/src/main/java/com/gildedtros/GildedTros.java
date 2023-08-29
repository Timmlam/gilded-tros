package com.gildedtros;

import com.gildedtros.update.UpdateItemFactory;

class GildedTros {
    Item[] items;
    private final UpdateItemFactory updateItemFactory = new UpdateItemFactory();

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemFactory.getUpdater(item).updateItem(item);
        }
    }
}