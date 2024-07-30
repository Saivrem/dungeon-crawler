package org.dustyroom.objects.items;

import lombok.Getter;

@Getter
public abstract class InventoryItem {
    public final String name;

    public InventoryItem(String name) {
        this.name = name;
    }
}
