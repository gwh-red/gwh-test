package com.gwh.operator;

/**
 * 有符号左移运算符的使用
 *
 * @author tony 18601767221@163.com
 * @version 2021/3/16 12:23
 * @since JDK11
 */
public class SignedLeftMoveOperator {

    public static void main(String[] args) {
        // 有符号左移(<<) 内存中的操作过程: 二进制补码向左移动,左边的符号位会丢弃,右边补0
        //有符号左移(<<) 运算规律:左移N位,就是乘以2的N次方

        /*
            正整数 左移的内存操作过程
            1. 10是占据4个字节,因为默认是int类型, 计算二进制补码   0000 0000 0000 0000 0000 0000  0000 1010
            2. 位运算符操作的是二进制补码  0000 0000 0000 0000 0000 0000  0000 1010 << 2
            3. 向左移动的结果 00 0000 0000 0000 0000 0000  0000 101000
            4. 打印输出需要转换成十进制的原码 结果是40
         */

        // 10 << 2 等于 40
        System.out.println("10 << 2 = "+(10 << 2 ));


        /*
           负整数 左移的内存操作过程
           1. -10是占据4个字节,因为默认是int类型, 计算二进制原码   1000 0000 0000 0000 0000 0000  0000 1010
           2. 根据原码求补码
           原码 1000 0000 0000 0000 0000 0000  0000 1010
           反码 1111 1111 1111 1111 1111 1111  1111 0101
           补码 1111 1111 1111 1111 1111 1111  1111 0110
           3. 补码左移2位
           1111 1111 1111 1111 1111 1111  1111 0110 << 2
左移两位的结果11 1111 1111 1111 1111 1111  1111 011000
           4. 补码转换成十进制的原码输出
          补码  11 1111 1111 1111 1111 1111  1111 011000
          反码  11 1111 1111 1111 1111 1111  1111 010111
          原码  10 0000 0000 0000 0000 0000  0000 101000  转换成十进制的结果是-40
         */


        //  -10 << 2 等于-40
        System.out.println("-10 << 2 = "+(-10 << 2 ));


    }
}