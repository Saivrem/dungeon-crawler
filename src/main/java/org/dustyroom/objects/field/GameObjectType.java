package org.dustyroom.objects.field;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum GameObjectType {

    FIELD(0),
    WALL(1),
    PLAYER(2),
    DOOR(3),
    LOOT(4);

    private final int objectId;

    public static GameObjectType getByCode(int code) {
        return Arrays.stream(values())
                .filter(v -> v.objectId == code)
                .findFirst()
                .orElse(null);
    }
}
