package com.gwh;

public class pageTest {

    public static void main(String[] args) {
        int total = 50;//数据总量
        int row = 10;//一页显示条数
        System.out.println((total-1)/row+1);//此方法使用较多
        System.out.println((total+row-1)/row);

    }
}
