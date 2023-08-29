package com.gildedtros.update;

import com.gildedtros.Item;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UpdateItemFactory {

    private static final Map<String, List<String>> itemsTypeMap = Stream.of(
                    new AbstractMap.SimpleEntry<>("Good Wine Items", Arrays.asList("Good Wine")),
                    new AbstractMap.SimpleEntry<>("Legendary Items", Arrays.asList("B-DAWG Keychain")),
                    new AbstractMap.SimpleEntry<>("Backstage Passes Items", Arrays.asList(
                            "Backstage passes for Re:Factor","Backstage passes for HAXX")),
                    new AbstractMap.SimpleEntry<>("Smelly Items", Arrays.asList(
                            "Duplicate Code","Long Methods", "Ugly Variable Names")))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

    public UpdateItemInterface getUpdater(Item item){
        if (itemsTypeMap.get("Good Wine Items").contains(item.name)){
            return new UpdateWineItem();
        } else if (itemsTypeMap.get("Legendary Items").contains(item.name)) {
            return new UpdateLegendaryItem();
        } else if (itemsTypeMap.get("Backstage Passes Items").contains(item.name)) {
            return new UpdateBackstagePassesItem();
        } else if (itemsTypeMap.get("Smelly Items").contains(item.name)) {
            return new UpdateSmellyItem();
        } else {
            return new UpdateNormalItem();
        }
    }
}
