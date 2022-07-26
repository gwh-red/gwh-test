package com.gwh;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class jsonTest {
    private static final String[] audits = {"pulp", "terror", "politician", "ads", "behavior"};

    public static void main(String[] args) {
        String html = "{\"data\":[{\"id\":\"1197323960015847790\",\"order_record_id\":\"21463446\",\"operation_code\":\"op202204081621003259914129\",\"status\":\"-14\",\"status_str\":\"商家超时未接单，系统自动取消\",\"create_time\":\"2022-04-08 16:21:02\",\"operator_type\":\"5\",\"operator_id\":\"-1\",\"operator_name\":\"系统\"}],\"database\":\"runfast_trade\",\"es\":1649928120000,\"id\":1270223,\"isDdl\":false,\"mysqlType\":{\"id\":\"bigint(20)\",\"order_record_id\":\"bigint(20)\",\"operation_code\":\"varchar(30)\",\"status\":\"int(11)\",\"status_str\":\"varchar(100)\",\"create_time\":\"datetime\",\"operator_type\":\"int(11)\",\"operator_id\":\"bigint(20)\",\"operator_name\":\"varchar(255)\"},\"old\":[{\"create_time\":\"2022-04-08 16:21:01\"}],\"pkNames\":[\"id\"],\"sql\":\"\",\"sqlType\":{\"id\":-5,\"order_record_id\":-5,\"operation_code\":12,\"status\":4,\"status_str\":12,\"create_time\":93,\"operator_type\":4,\"operator_id\":-5,\"operator_name\":12},\"table\":\"order_operation_record\",\"ts\":1649928120228,\"type\":\"UPDATE\"}" ;
        JSONObject jsonObject = JSONUtil.parseObj(html);


        System.out.println(jsonObject.getStr("data"));


    }
}
