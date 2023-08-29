package com.gildedtros;

class GildedTros {

    private static final int MAX_QUALITY_VALUE = 50;
    private static final int MIN_QUALITY_VALUE = 0;
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item:items) {
            updateSellIn(item);
            if (!item.name.equals("Good Wine")
                    && !item.name.equals("Backstage passes for Re:Factor")
                    && !item.name.equals("Backstage passes for HAXX"))
            {
                if (item.quality > MIN_QUALITY_VALUE) {
                    if (!item.name.equals("B-DAWG Keychain")) {
                        downgradeQuality(item);
                    }
                }
            } else {
                if (item.quality < MAX_QUALITY_VALUE) {
                    upgradeQuality(item);

                    if (item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX") ) {
                        if (item.sellIn < 11) {
                            if (item.quality < MAX_QUALITY_VALUE) {
                                upgradeQuality(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < MAX_QUALITY_VALUE) {
                                upgradeQuality(item);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("B-DAWG Keychain")) {
                downgradeQuality(item);
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Good Wine")) {
                    if (!item.name.equals("Backstage passes for Re:Factor") && !item.name.equals("Backstage passes for HAXX")) {
                        if (item.quality > MIN_QUALITY_VALUE) {
                            if (!item.name.equals("B-DAWG Keychain")) {
                                downgradeQuality(item);
                            }
                        }
                    } else {
                        zeroQuality(item);
                    }
                } else {
                    if (item.quality < MAX_QUALITY_VALUE) {
                        upgradeQuality(item);
                    }
                }
            }
        }
    }

    private void zeroQuality(Item item) {
        item.quality = 0;
    }

    private void downgradeQuality(Item item){
        item.quality--;
    }
    private void upgradeQuality(Item item){
        item.quality++;
    }
    private void updateSellIn(Item item){
        item.sellIn--;
    }
}