package com.gwh;

import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class atlabText {

    static final String accessKey = "Bku4MNJHn2m-qHPxZ4jDTkkV-tIw6U-u6Ex2mUrW";
    static final String secretKey = "eMSL04-fhF-IggfUsa_v87IcX_ehREMA0gVj3iCL";
    static final String url = "http://ai.qiniuapi.com/v3/text/censor";

    public static void main(String[] args) {
        /*String s = qiniuToken();
        System.out.println(s);*/


        StringMap headers = new StringMap();
        headers.put("Authorization", qiniuToken());
        try {
            Client client = new Client();
            System.out.println(json().getBytes());
            Response resp = client.post(url, json().getBytes(), headers, Client.JsonMime);
            System.out.println(resp.toString());
            System.out.println(resp.bodyString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String qiniuToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String authorization = (String) auth.authorizationV2(url, "POST", json().getBytes(), Client.JsonMime).get("Authorization");
        return authorization;
    }

    static String json() {
        return "{\"data\": {\"text\": \"111\"},\"params\": {\"scenes\":[\"antispam\"]}}";
    }
}