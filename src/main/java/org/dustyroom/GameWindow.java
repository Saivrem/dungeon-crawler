package org.dustyroom;

import org.dustyroom.levels.LevelMap;
import org.dustyroom.levels.LevelMaps;
import org.dustyroom.objects.GameObject;

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
        GameObject player = levelMap.getPlayer();

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

        if (isValidMove(newY, newX)) {
            GameObject object = levelMap.getByCoordinate(newY, newX);
            object.getPoint().move(oldX, oldY);
            playerPoint.move(newX, newY);
            levelMap.swap(object, player);
            levelMap.upd();
        }
    }

    private boolean isValidMove(int row, int col) {
        GameObject mapObject = levelMap.getByCoordinate(row, col);
        if (mapObject == null) return false;
        return !mapObject.isObstacle();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameWindow::new);
    }
}

