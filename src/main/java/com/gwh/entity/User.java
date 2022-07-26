package com.gwh.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    public User() {

    }

    public User(Integer id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
