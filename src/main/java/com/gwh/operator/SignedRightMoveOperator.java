package com.gwh.operator;

/**
 * 有符号右移的使用
 *
 * @author tony 18601767221@163.com
 * @version 2021/3/16 12:39
 * @since JDK11
 */
public class SignedRightMoveOperator {

    public static void main(String[] args) {
        //有符号右移(>>) 内存的操作过程: 二进制补码向右移动,左边使用符号位来补齐,符号位是1,那么就补1,如果符号位是0,那么就补0

        //有符号右移(>>)运算的规律:右移N位,就是除以2的N次方


        /*
            正整数的右移内存操作过程
            1. 整数32默认占据4个字节,因为是int类型,二进制的补码表示方式为  0000 0000 0000 0000 0000 0000 0010 0000
            2.  0000 0000 0000 0000 0000 0000 0010 0000 >> 2
  32右移两位的结果 000000 0000 0000 0000 0000 0000 0010 00
            3. 转换成十进制的原码输出
            10 00 转换成十进制的结果是8
         */

        // 32 >> 2 等于8
        System.out.println("32 >> 2 = "+(32 >> 2));



        /*
            负整数的右移内存操作过程
             1. 负整数-32默认占据4个字节,因为是int类型,二进制的原码表示方式为  1000 0000 0000 0000 0000 0000 0010 0000
             2. 根据原码求补码
             原码 1000 0000 0000 0000 0000 0000 0010 0000
             反码 1111 1111 1111 1111 1111 1111 1101 1111
             补码 1111 1111 1111 1111 1111 1111 1110 0000
             3. 将1111 1111 1111 1111 1111 1111 1110 0000 >>2
 右边移动两位的结果  111111 1111 1111 1111 1111 1111 1110 00
             4. 根据补码求原码
           补码  111111 1111 1111 1111 1111 1111 1110 00
           反码  111111 1111 1111 1111 1111 1111 1101 11
           原码  100000 0000 0000 0000 0000 0000 0010 00  转换成十进制 -8
         */

        System.out.println("-32 >> 2 = "+(-32 >> 2));

    }
}
