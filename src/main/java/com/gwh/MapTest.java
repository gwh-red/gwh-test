package com.gwh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
