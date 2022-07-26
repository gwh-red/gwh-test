package com.gwh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student2Test {
    public static void main(String[] args) {
        List<Student2> list2 = new ArrayList<Student2>();
        list2.add(new Student2("风清扬", 30));
        list2.add(new Student2("刘晓曲", 28));
        list2.add(new Student2("武鑫", 29));
        list2.add(new Student2("林青霞", 27));

        String name = list2.stream()
                .distinct()
                .peek(Student2::getAge)
                .min(Comparator.comparing(Student2::getAge))
                .get()
                .getName();
        System.out.println(name);
    }
}

class MyComparator implements Comparator<Student2> {
    @Override
    public int compare(Student2 s1, Student2 s2) {
        int num = s1.getAge() - s2.getAge();
        int num1 = (num == 0 ? s1.getName().compareTo(s2.getName()) : num);
        return num1;
    }
}