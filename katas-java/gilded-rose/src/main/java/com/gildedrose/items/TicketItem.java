package com.gildedrose.items;

import com.gildedrose.Helpers;
import com.gildedrose.Item;

public class TicketItem implements UpdatableItem {
    private Item item;
    public TicketItem(Item item) {

        this.item = item;
    }

    @Override
    public void update() {
        Helpers.increaseQuality(item);
        this.item.sellIn--;
        if (this.item.sellIn <= 10) {
            Helpers.increaseQuality(item);
            if(this.item.sellIn <= 5) {
               Helpers.increaseQuality(item);
            }
        }
        if (this.item.sellIn < 0) {
            this.item.quality = 0;
        }
    }
}
