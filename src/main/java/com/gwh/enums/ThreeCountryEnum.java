package com.gwh.enums;

import lombok.Getter;

/**
 * @author 123
 */

public enum ThreeCountryEnum {
    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "小日子"), SIX(6, "韩");

    @Getter
    private Integer index;
    @Getter
    private String code;

    ThreeCountryEnum(Integer index, String code) {
        this.index = index;
        this.code = code;
    }

    public static ThreeCountryEnum getThreeCountryEnum(int index) {
        for (ThreeCountryEnum countryEnum : values()) {
            if (countryEnum.getIndex() == index) {
                return countryEnum;
            }
        }
        return null;

    }
}
