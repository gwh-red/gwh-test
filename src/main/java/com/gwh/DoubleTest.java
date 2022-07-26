package com.gwh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class DoubleTest {

    public static void main(String[] args) {

        //我知道这可以在Java中轻松完成使用 list.indexOf（Collections.min（list））。
        // 但是，我正在寻找类似Scala的解决方案，我们可以简单地说 List（34,11,98,56,43）.zipWithIndex.min._2 来获取索引最小值。

        List<Integer> integers = new ArrayList<Integer>();
        integers.add(2);
        integers.add(11);
        integers.add(1);
        integers.add(7);
        integers.add(10);
        int i = integers.indexOf(Collections.min(integers));
        System.out.println(i);


    }

}
