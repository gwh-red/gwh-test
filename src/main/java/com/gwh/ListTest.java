package com.gwh;

import com.gwh.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {


    public static void main(String[] args) {




      /*  ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            integers.add(i);
        }
        integers.add(123);
        integers.add(1111);

        List<Integer> collect = integers.stream().filter(integer -> {
            if (integer < 10) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        System.out.println(collect);*/

        //HashMap<Integer, String> stringHashMap = new HashMap<Integer, String>();

        //stringHashMap.put(1,"");
        /*ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "aa"));
        users.add(new User(2, "bb"));
        users.add(new User(3, "cc"));
        users.add(new User(4, "dd"));
        users.add(new User(5, "ee"));
        //List<User> collect = users.stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());
        AtomicInteger a = new AtomicInteger(0);

        System.out.println(a.getAndIncrement());
        users.forEach(u -> {
            if (!"bb".equals(u.getName())) {
                a.getAndIncrement();
            }

        });
        System.out.println(a);*/
        /*  List<User> collect = users.stream().filter(user -> {
            if (user.getName().equals("bb")) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
                //.sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());

        collect.forEach(e -> {
            System.out.println(e);
        });*/
    }

    //数据转map判断是否有一致的数据
    public void test1() {


        List<User> users = new ArrayList<>();
        users.add(new User(1, "aa"));
        users.add(new User(2, "bb"));
        users.add(new User(3, "cc"));
        users.add(new User(4, "dd"));
        users.add(new User(5, "ee"));

        List<User> users1 = new ArrayList<>();
        users1.add(new User(1, "aa"));
        users1.add(new User(2, "bb"));
        users1.add(new User(3, "cc"));
        users1.add(new User(4, "dd"));
        users1.add(new User(5, "ee"));
        users1.add(new User(6, "ff"));

        List<User> users2 = new ArrayList<>();

        for (int i = 0; i < users2.size(); i++) {
        }

        Map<Integer, String> maps = users1.stream().collect(Collectors.toMap(User::getId, User::getName));

        users.forEach(e -> {
            if (maps.get(e.getId()) == null) {
                users2.add(e);
            }
        });
        System.out.println(users1);
        System.out.println(users2);
        System.out.println(maps);


    }

}
