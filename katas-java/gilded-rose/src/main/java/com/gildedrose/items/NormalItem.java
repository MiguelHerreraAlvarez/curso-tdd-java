package com.gildedrose.items;

import com.gildedrose.Helpers;
import com.gildedrose.Item;

public class NormalItem implements UpdatableItem {
    private Item item;
    public NormalItem(Item item) {

        this.item = item;
    }

    @Override
    public void update() {
        Helpers.decreaseQuality(item);
        this.item.sellIn--;
        if (this.item.sellIn < 0) {
            Helpers.decreaseQuality(item);
        }

    }
}
