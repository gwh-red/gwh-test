package com.gwh;

import lombok.Data;

@Data
public class Student2 {
    private String name;
    private int age;
    public Student2() {
    }

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
