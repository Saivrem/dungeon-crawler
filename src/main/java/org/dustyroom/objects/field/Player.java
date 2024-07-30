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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        int fontSize = Math.min(getHeight(), getWidth()) / 2;
        g2d.setFont(new Font("Serif", Font.PLAIN, fontSize));
        g2d.setColor(Color.LIGHT_GRAY);

        String unicodeChar = " \uD83E\uDDCD";
        g2d.drawString(unicodeChar, getWidth() / 3, getHeight() / 2);
    }
}
