package com.gwh;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("userId", 0);
        if (true) {
            stringObjectHashMap.put("userId", 1);
        }
        System.out.println(stringObjectHashMap);


    }
}
