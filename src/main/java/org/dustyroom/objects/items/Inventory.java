package org.dustyroom.objects.items;

import java.util.List;

public interface Inventory {

    List<KeyItem> getKeys();

    void add(InventoryItem inventoryItem);

    void add(List<InventoryItem> inventoryItems);
}
