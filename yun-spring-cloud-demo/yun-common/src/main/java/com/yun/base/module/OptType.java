package com.yun.base.module;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author: yun
 * @createdOn: 2019-03-01 10:03.
 */

public enum OptType {
    NoChange(0, "无改变"),
    Add(1, "新增"),
    Update(2, "修改"),
    Delete(3, "删除"),
    MaxValue(4, "最大值");


    public static final String des = "操作类型：0-无改变、1-新增、2-修改、3-删除";

    private final Integer type;

    private final String name;

    private OptType(Integer type, String name) {
        this.type = type;

        this.name = name;
    }

    /**
     * Is valid itemType boolean.
     * @param type the itemType
     * @return the boolean
     */
    public static boolean isValidItem(OptType type) {
        if (type == null) {
            return false;
        }
        if (type.getType() < MaxValue.getType() && type.getType() >= NoChange.getType()) {
            return true;
        }

        return false;
    }

    public static boolean isValidType(Integer type) {
        if (type == null) {
            return false;
        }

        if (type < MaxValue.getType() && type >= NoChange.getType()) {
            return true;
        }

        return false;
    }

    public static OptType getByCode(Integer code) {
        for (OptType item : values()) {
            if (item.getType().equals(code)) {
                return item;
            }
        }

        return null;
    }

    public boolean isEqualType(Integer type) {
        if (type == null) {
            return false;
        }

        return getType().equals(type);
    }

    /**
     * Gets itemType.
     * @return the itemType
     */
    @JsonValue
    public Integer getType() {
        return type;
    }
}
