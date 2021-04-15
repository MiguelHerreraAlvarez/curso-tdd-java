package com.gildedrose.items;

import com.gildedrose.Helpers;
import com.gildedrose.Item;

public class AgedBrieItem implements UpdatableItem {
    private Item item;
    public AgedBrieItem(Item item) {

        this.item = item;
    }

    @Override
    public void update() {
        Helpers.increaseQuality(item);
        this.item.sellIn--;
        if (this.item.sellIn < 0) {
            Helpers.increaseQuality(item);
        }
    }
}
