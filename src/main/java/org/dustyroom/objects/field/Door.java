package org.dustyroom.objects.field;

import org.dustyroom.objects.items.KeyItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;


public class Door extends FieldObject {

    private final KeyItem key = new KeyItem("DoorKey", "TestKey");

    public Door(int x, int y) {
        super(x, y, Color.YELLOW, true);
    }

    public boolean checkKey(List<KeyItem> keys) {
        KeyItem keyFound = keys.stream()
                .filter(Objects::nonNull)
                .filter(k -> k.getSecret().equals(key.getSecret()))
                .findFirst()
                .orElse(null);

        if (keyFound != null) {
            JOptionPane.showMessageDialog(null, "Door Opened!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(null, "You need key!", "Info", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }
}
