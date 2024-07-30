package org.dustyroom.objects.field;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public abstract class FieldObject extends JPanel {

    private Point point;
    private Color color;
    private boolean obstacle;

    public FieldObject(int x, int y, Color color, boolean obstacle) {
        this.point = new Point(x, y);
        this.color = color;
        this.obstacle = obstacle;
        setBackground(color);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
