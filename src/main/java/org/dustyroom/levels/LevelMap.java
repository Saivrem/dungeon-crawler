package org.dustyroom.levels;

import org.dustyroom.objects.GameObject;
import org.dustyroom.objects.Player;

import javax.swing.*;
import java.awt.*;

public class LevelMap extends JPanel {
    public GameObject[][] mapObjects;
    public Player player;
    public final int gridSize;

    public LevelMap(GameObject[][] mapObjects) {
        this.mapObjects = mapObjects;
        for (GameObject[] mapObject : mapObjects) {
            for (GameObject gameObject : mapObject) {
                if (gameObject instanceof Player p) player = p;
            }
        }
        gridSize = mapObjects.length;
        setLayout(new GridLayout(gridSize, gridSize));
    }

    public GameObject getByCoordinate(int row, int col) {
        return withinBorders(row, col) ? mapObjects[row][col] : null;
    }

    public GameObject getPlayer() {
        return player;
    }

    public void updateGrid() {
        for (GameObject[] mapObject : mapObjects) {
            for (GameObject gameObject : mapObject) {
                add(gameObject);
            }
        }
        revalidate();
    }

    private boolean withinBorders(int row, int col) {
        return (row >= 0 && row < gridSize) && (col >= 0 && col < gridSize);
    }

    public void swap(GameObject o1, GameObject o2) {
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