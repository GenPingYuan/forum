package com.forum.entity.dto.enums;

public enum Display {
    SHOW(1),HIDDEN(0);

    private final int value;


    Display(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
