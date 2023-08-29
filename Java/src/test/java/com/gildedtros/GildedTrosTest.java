package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    static final String normalItemName = "Ring of Cleansening Code";
    static final String wineItemName = "Good Wine";
    static final String legendaryItemName = "B-DAWG Keychain";
    static final String backstagePassesItemName = "Backstage passes for Re:Factor";
    static final String smellyitemName = "Duplicate Code";

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void Update_Normal_Item_No_Edge_Case(){
        Item[] items = new Item[] {new Item(normalItemName, 10, 20)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
        assertEquals(9,app.items[0].sellIn);
    }

    @Test
    void Update_Normal_Item_Sell_Date_Passed(){
        Item[] items = new Item[] {new Item(normalItemName, 0, 20)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
        assertEquals(-1,app.items[0].sellIn);
    }

    @Test
    void Update_Normal_Item_Quality_Never_Negative(){
        Item[] items = new Item[] {new Item(normalItemName, 10, 0)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(9,app.items[0].sellIn);
    }

    @Test
    void Update_Good_Wine_Item_Quality_Increases(){
        Item[] items = new Item[] { new Item(wineItemName, 2, 0)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(1,app.items[0].sellIn);
    }

    @Test
    void Update_Good_Wine_Item_Quality_Not_Above_50(){
        Item[] items = new Item[] { new Item(wineItemName, 2, 50)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(1,app.items[0].sellIn);
    }

    @Test
    void Update_Legendary_Item_No_Change(){
        Item[] items = new Item[] { new Item(legendaryItemName, 0, 80)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(0,app.items[0].sellIn);
    }

    @Test
    void Update_Backstage_Passes_Item_Increase_Quality_Simple(){
        Item[] items = new Item[] { new Item(backstagePassesItemName, 15, 20)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(14,app.items[0].sellIn);
    }

    @Test
    void Update_Backstage_Passes_Item_Increase_Quality_By_2_When_10_Days_Or_Closer(){
        Item[] items = new Item[] { new Item(backstagePassesItemName, 8, 20)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
        assertEquals(7,app.items[0].sellIn);
    }

    @Test
    void Update_Backstage_Passes_Item_Increase_Quality_By_2_When_10_Days_Or_Closer_Edge_Case(){
        Item[] items = new Item[] { new Item(backstagePassesItemName, 11, 20)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(10,app.items[0].sellIn);
    }

    @Test
    void Update_Backstage_Passes_Item_Increase_Quality_By_3_When_5_Days_Or_Closer(){
        Item[] items = new Item[] { new Item(backstagePassesItemName, 4, 20)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
        assertEquals(3,app.items[0].sellIn);
    }

    @Test
    void Update_Backstage_Passes_Item_Increase_Quality_By_3_When_5_Days_Or_Closer_Edge_Case(){
        Item[] items = new Item[] { new Item(backstagePassesItemName, 6, 20)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
        assertEquals(5,app.items[0].sellIn);
    }

    @Test
    void Update_Backstage_Passes_Item_Quality_Drops_To_0_After_Conference(){
        Item[] items = new Item[] { new Item(backstagePassesItemName, 0, 20)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1,app.items[0].sellIn);
    }

    @Test
    void Update_Backstage_Passes_Item_Increase_Quality_Not_Above_50(){
        Item[] items = new Item[] { new Item(backstagePassesItemName, 20, 50)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(19,app.items[0].sellIn);
    }

    @Test
    void Update_Backstage_Passes_Item_Increase_Quality_Not_Above_50_When_10_Days_Or_Closer(){
        Item[] items = new Item[] { new Item(backstagePassesItemName, 8, 49)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(7,app.items[0].sellIn);
    }

    @Test
    void Update_Backstage_Passes_Item_Increase_Quality_Not_Above_50_When_5_Days_Or_Closer(){
        Item[] items = new Item[] { new Item(backstagePassesItemName, 4, 48)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(3,app.items[0].sellIn);
    }

    /**
     * Tests for Smelly items
     */

    @Test
    void Update_Smelly_Item_Decrease_Quality_By_2(){
        Item[] items = new Item[] { new Item(smellyitemName, 3, 6)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
        assertEquals(2,app.items[0].sellIn);
    }

    @Test
    void Update_Smelly_Item_Decrease_Quality_Not_Negative(){
        Item[] items = new Item[] { new Item(smellyitemName, 3, 1)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(2,app.items[0].sellIn);
    }

    @Test
    void Update_Smelly_Item_Decrease_Quality_By_4_Sell_Date_Passed(){
        Item[] items = new Item[] { new Item(smellyitemName, 0, 6)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        assertEquals(-1,app.items[0].sellIn);
    }







}
