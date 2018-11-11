package com.forum.entity.dto.enums;

/**
 * 状态枚举类
 */
public enum State {
    VALID("10A"),//有效
    INVALID("10X");//失效

    private final String value;

    State(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
