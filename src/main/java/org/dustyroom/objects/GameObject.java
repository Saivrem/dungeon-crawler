package org.dustyroom.objects;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public abstract class GameObject extends JPanel {

    private Point point;
    private Color color;
    private boolean isObstacle;

    public GameObject(int x, int y, Color color, boolean isObstacle) {
        this.point = new Point(x, y);
        this.color = color;
        this.isObstacle = isObstacle;
        setBackground(color);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
