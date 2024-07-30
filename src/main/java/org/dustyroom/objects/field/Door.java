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
        repaint();
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        int fontSize = Math.min(getHeight(), getWidth()) / 2;
        g2d.setFont(new Font("Serif", Font.PLAIN, fontSize));
        g2d.setColor(Color.LIGHT_GRAY);

        String unicodeChar = "\uD83D\uDEAA";
        g2d.drawString(unicodeChar, getWidth() / 3, getHeight() / 2);
    }
}
