package com.gwh;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.gwh.entity.GaodeVO;
import lombok.extern.log4j.Log4j2;

import java.util.*;

@Log4j2
public class GaoDe {

    private static String path = "https://restapi.amap.com/v3/assistant/inputtips?parameters";
    private static String path1 = "https://restapi.amap.com/v5/place/text?parameters";

    private static String key1 = "14d183f119d9a5ec0136f35009d7a65b";

    private static String key2 = "06ea6b7a5821b4365355a6fd8c13e999";

    private static String key3 = "https://restapi.amap.com/v5/place/text?parameters";

    public static void main(String[] args) {


        //c3cf2919-66cf-3d11-80f7-cd2efd935364
        //c3cf2919-66cf-3d11-80f7-cd2efd935364
        Map<String, String> headers = new HashMap<>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        // headers.put("Authorization", "APPCODE " + appcode);
        Map<String, Object> querys = new HashMap<>();

        querys.put("key", key1);
        querys.put("keywords", "西边园");
        //querys.put("city", "440113");
       //querys.put("location", "113.083138,30.502178");
        querys.put("city", "469005");
        //querys.put("region", "429006");
        //querys.put("offset", 20);
        //querys.put("page", 1);
        //querys.put("key", key1);
        //querys.put("keyword", key);
        //querys.put("page", "1");
        //querys.put("province", province.getName());

        //querys.put("citylimit", "true");


        log.info("请求参数{},{},{}", path, JSONObject.toJSONString(headers), JSONObject.toJSONString(querys));

        String result = HttpUtil.createGet(path).headerMap(headers, true).method(Method.GET).form(querys).execute().body();
        log.info("返回信息={}", result);

        System.out.println(result);
        cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(result);
        System.out.println(jsonObject.getStr("count"));

        String pois = jsonObject.getStr("pois");

        JSONArray array = JSONUtil.parseArray(pois);

        List<GaodeVO> list = JSONUtil.toList(array, GaodeVO.class);

        list.forEach(System.out::println);
    }
}
