package org.dustyroom;

import org.dustyroom.levels.LevelMap;
import org.dustyroom.levels.LevelMaps;
import org.dustyroom.objects.field.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {

    private LevelMap levelMap;

    public GameWindow() {
        setTitle("Grid Game");
        setSize(new Dimension(800, 800));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        levelMap = LevelMaps.mapSet.get("first-floor");
        add(levelMap);

        levelMap.updateGrid();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                movePlayer(e);
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    private void movePlayer(KeyEvent e) {
        int key = e.getKeyCode();
        Player player = levelMap.getPlayer();

        Point playerPoint = player.getPoint();
        int oldX = playerPoint.x;
        int oldY = playerPoint.y;
        int newX = oldX;
        int newY = oldY;

        switch (key) {
            case KeyEvent.VK_UP:
                newY--;
                break;
            case KeyEvent.VK_DOWN:
                newY++;
                break;
            case KeyEvent.VK_LEFT:
                newX--;
                break;
            case KeyEvent.VK_RIGHT:
                newX++;
                break;
        }

        if (isValidMove(newY, newX, player)) {
            FieldObject object = levelMap.getByCoordinate(newY, newX);
            if (object instanceof Door || object instanceof Loot) {
                object = new Field(newX, newY);
            }
            object.getPoint().move(oldX, oldY);
            playerPoint.move(newX, newY);
            levelMap.swap(object, player);
            levelMap.upd();
        }
    }

    private boolean isValidMove(int row, int col, Player player) {
        FieldObject mapObject = levelMap.getByCoordinate(row, col);
        if (mapObject == null) return false;
        if (mapObject instanceof Door d) {
            return d.checkKey(player.getKeys());
        }
        if (mapObject instanceof Loot l) {
            player.add(l.pickup());
        }
        return !mapObject.isObstacle();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameWindow::new);
    }
}

