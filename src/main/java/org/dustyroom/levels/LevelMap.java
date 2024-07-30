package org.dustyroom.levels;

import lombok.Getter;
import org.dustyroom.objects.field.FieldObject;
import org.dustyroom.objects.field.Player;

import javax.swing.*;
import java.awt.*;

@Getter
public class LevelMap extends JPanel {
    public FieldObject[][] mapObjects;
    public Player player;
    public final int gridSize;

    public LevelMap(FieldObject[][] mapObjects) {
        this.mapObjects = mapObjects;
        for (FieldObject[] mapObject : mapObjects) {
            for (FieldObject fieldObject : mapObject) {
                if (fieldObject instanceof Player p) player = p;
            }
        }
        gridSize = mapObjects.length;
        setLayout(new GridLayout(gridSize, gridSize));
    }

    public FieldObject getByCoordinate(int row, int col) {
        return withinBorders(row, col) ? mapObjects[row][col] : null;
    }

    public void updateGrid() {
        for (FieldObject[] mapObject : mapObjects) {
            for (FieldObject fieldObject : mapObject) {
                add(fieldObject);
            }
        }
        revalidate();
    }

    private boolean withinBorders(int row, int col) {
        return (row >= 0 && row < gridSize) && (col >= 0 && col < gridSize);
    }

    public void swap(FieldObject o1, FieldObject o2) {
        Point o1p = o1.getPoint();
        Point o2p = o2.getPoint();

        mapObjects[o1p.y][o1p.x] = o1;
        mapObjects[o2p.y][o2p.x] = o2;
    }

    public void upd() {
        removeAll();
        updateGrid();
    }
}