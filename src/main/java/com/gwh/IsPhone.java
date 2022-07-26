package com.gwh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsPhone {

    /**
     * 验证是否是手机号码
     *
     * @param str
     * @return
     */
    public static boolean isPhone(String str) {

        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(16[5,6])|(17[0-8])|(18[0-9])|(19[1、5、8、9]))\\d{8}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void main(String[] args) {

      /*  String format = String.format("%s_%s.zip", 1, 2);
        System.out.println(format);*/

        boolean phone = IsPhone.isPhone("19172587706");
        System.out.println(phone);

    }

}
