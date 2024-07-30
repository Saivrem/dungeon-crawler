package org.dustyroom.objects.field;

import org.dustyroom.objects.items.InventoryItem;
import org.dustyroom.objects.items.KeyItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Loot extends FieldObject {

    public Loot(int x, int y) {
        super(x, y, Color.WHITE, false);
    }

    public List<InventoryItem> pickup() {
        JOptionPane.showMessageDialog(null, "You picked an item!", "Info", JOptionPane.INFORMATION_MESSAGE);
        return List.of(new KeyItem("DoorKey", "TestKey"));
    }
}
