package com.gildedtros;

import com.gildedtros.update.UpdateItemFactory;

/**
 * Class representing the GildedTros for updating the items inventory.
 */
class GildedTros {
    /** Variable holding the items for this class. */
    Item[] items;

    /** Variable holding the updateItemFactory to get the right updater. */
    private static final UpdateItemFactory updateItemFactory = new UpdateItemFactory();

    /**
     * Class constructor with the items for the inventory.
     * @param items the items for the inventory.
     */
    public GildedTros(Item[] items) {
        this.items = items;
    }

    /**
     * Function that updates all the items of the class. Updates both sellIn and quality of each item.
     */
    public void updateItems() {
        for (Item item : items) {
            updateItemFactory.getUpdater(item).updateItem(item);
        }
    }
}