package com.gildedrose.items;

import com.gildedrose.Item;
//DONE
public class SulfurasItem implements UpdatableItem {
    private Item item;
    public SulfurasItem(Item item) {

        this.item = item;
        this.item.quality = 80;
    }

    @Override
    public void update() {

    }
}
