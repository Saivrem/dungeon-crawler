package org.dustyroom.objects.items;

import lombok.Getter;

@Getter
public class KeyItem extends InventoryItem {

    private final String secret;

    public KeyItem(String name, String secret) {
        super(name);
        this.secret = secret;
    }
}
