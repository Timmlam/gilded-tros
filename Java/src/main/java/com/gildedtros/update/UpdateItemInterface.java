package com.gildedtros.update;

import com.gildedtros.Item;

public interface UpdateItemInterface {
    int MAX_QUALITY_VALUE = 50;
    int MIN_QUALITY_VALUE = 0;
    void updateItem(Item item);
}
