package com.gwh;

import cn.hutool.core.lang.Validator;

public class HutoolTest {

    public static void main(String[] args) {
        // System.out.println(Validator.isMobile("15013680429"));
        System.out.println(HutoolTest.MAX_SHEDULE_PEROID);
    }

    public static long MAX_SHEDULE_PEROID = 3600 * 1000 * 24 *20;
}
