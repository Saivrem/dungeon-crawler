package org.dustyroom.levels;

import org.dustyroom.objects.field.*;

public class LevelBuilder {

    public static FieldObject[][] buildLevel(int[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new RuntimeException("Null grid");
        }
        FieldObject[][] objects = new FieldObject[grid.length][grid.length];

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                objects[y][x] = getObject(grid[y][x], x, y);
            }
        }
        return objects;
    }

    private static FieldObject getObject(int code, int x, int y) {
        GameObjectType TYPE = GameObjectType.getByCode(code);
        if (TYPE == null) {
            throw new RuntimeException("No Object for code");
        }
        return switch (TYPE) {
            case FIELD -> new Field(x, y);
            case WALL -> new Wall(x, y);
            case PLAYER -> new Player(x, y);
            case DOOR -> new Door(x, y);
            case LOOT -> new Loot(x, y);
        };
    }
}
