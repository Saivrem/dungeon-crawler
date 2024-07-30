package org.dustyroom.objects.field;

import org.dustyroom.objects.items.Inventory;
import org.dustyroom.objects.items.InventoryItem;
import org.dustyroom.objects.items.KeyItem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player extends FieldObject implements Inventory {

    List<InventoryItem> inventory = new ArrayList<>();

    public Player(int x, int y) {
        super(x, y, Color.RED, true);
    }

    @Override
    public List<KeyItem> getKeys() {
        return inventory.stream()
                .filter(i -> i instanceof KeyItem)
                .map(i -> (KeyItem) i)
                .toList();
    }

    @Override
    public void add(InventoryItem inventoryItem) {
        inventory.add(inventoryItem);
    }

    @Override
    public void add(List<InventoryItem> inventoryItems) {
        inventory.addAll(inventoryItems);
    }
}
