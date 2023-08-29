package com.gildedtros.update;

import com.gildedtros.Item;

/**
 * Interface for the update function of the items.
 */
public interface UpdateItemInterface {
    /** Constant for the maximum value of the quality of an item. */
    int MAX_QUALITY_VALUE = 50;

    /** Constant for the minimum value of the quality of an item. */
    int MIN_QUALITY_VALUE = 0;

    /** Constant that holds the number for the day of the sell by date. */
    int EXPIRATION_DATE = 0;

    /**
     * Function that updates the quality and sellin of an Item.
     * @param item the item to update
     */
    void updateItem(Item item);
}
