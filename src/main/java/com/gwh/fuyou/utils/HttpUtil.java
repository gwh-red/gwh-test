package com.gwh.fuyou.utils;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author 123
 */
public class HttpUtil {

    public static String postForm(String url, Map<String, String> paramMap) {
        try {
            System.out.println("HttpUtil.postForm调用开始,url==" + url + ",参数==" + paramMap);
            Request request = Request.Post(url);
            request.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            Form form = Form.form();
            for (String key : paramMap.keySet()) {
                form.add(key, paramMap.get(key));
            }
            Response response = request.bodyForm(form.build(), Charset.forName("UTF-8")).execute();
            if (response != null) {
                Content content = response.returnContent();
                System.out.println("HttpUtil.postForm调用返回结果==" + content.asString());
                return content.asString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String postJson(String url, String json) {
        try {
            System.out.println("HttpUtil.postJson调用开始,url==" + url + ",参数==" + json);
            Request request = Request.Post(url);
            request.addHeader("Content-Type", "application/json");
            Response response = request.bodyString(json, ContentType.APPLICATION_JSON).execute();
            if (response != null) {
                Content content = response.returnContent();
                System.out.println("HttpUtil.postJson调用返回结果==" + content.asString());
                return content.asString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}