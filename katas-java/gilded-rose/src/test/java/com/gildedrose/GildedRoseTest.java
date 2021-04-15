package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {
  private final String ticketName = "Backstage passes to a TAFKAL80ETC concert";
  private final String agedBrieName = "Aged Brie";
  private final String sulfurasName = "Sulfuras, Hand of Ragnaros";
  private Item[] items;
  private Item normalItem;
  private Item sulfuras;
  private Item agedBrie;
  private Item ticket;

  @BeforeEach
  public void setUp(){
    sulfuras = new Item(sulfurasName, 4, 25);
    agedBrie = new Item(agedBrieName, 1, 10);
    ticket = new Item(ticketName, 11, 10);
    normalItem = new Item("foo", 1, 10);
  }

  @Test
  public void reduce_normal_items_values_when_update() {
    items = new Item[]{normalItem};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, normalItem.sellIn);
    assertEquals(9, normalItem.quality);
  }

  @Test
  public void reduce_normal_item_quality_twice_fast_when_date_has_passed() {
    items = new Item[]{normalItem};
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    app.updateQuality();

    assertEquals(-1, normalItem.sellIn);
    assertEquals(7, normalItem.quality);
  }

  @Test
  public void item_quality_can_not_be_lower_than_zero() {
    normalItem.quality=0;
    items = new Item[]{normalItem};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, normalItem.sellIn);
    assertEquals(0, normalItem.quality);
  }

  @Test
  public void item_quality_can_not_be_greater_than_fifty() {
    agedBrie.quality=50;
    items = new Item[]{agedBrie};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, agedBrie.sellIn);
    assertEquals(50, agedBrie.quality);
  }

  @Test
  public void do_not_reduce_sulfuras_item_values_when_update() {
    items = new Item[]{sulfuras};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, sulfuras.sellIn);
    assertEquals(25, sulfuras.quality);
  }

  @Test
  public void increase_aged_brie_quality_when_update() {
    items = new Item[]{agedBrie};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, agedBrie.sellIn);
    assertEquals(11, agedBrie.quality);
  }

  @Test
  public void increase_aged_brie_quality_twice_when_date_has_passed() {
    agedBrie.sellIn=0;
    items = new Item[]{agedBrie};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(-1, agedBrie.sellIn);
    assertEquals(12, agedBrie.quality);
  }

  @Test
  public void ticket_quality_drops_to_zero_when_sell_in_expired(){
    ticket.sellIn=0;
    items = new Item[]{ticket};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(-1, ticket.sellIn);
    assertEquals(0, ticket.quality);
  }

  @Test
  public void increase_ticket_quality_when_update() {
    items = new Item[]{ticket};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(10, ticket.sellIn);
    assertEquals(11, ticket.quality);
  }

  @Test
  public void increase_ticket_quality_twice_when_date_lower_than_ten() {
    ticket.sellIn = 10;
    items = new Item[]{ticket};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(9, ticket.sellIn);
    assertEquals(12, ticket.quality);
  }

  @Test
  public void increase_ticket_quality_triple_when_date_lower_than_five() {
    ticket.sellIn = 5;
    items = new Item[]{ticket};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, ticket.sellIn);
    assertEquals(13, ticket.quality);
  }
}

