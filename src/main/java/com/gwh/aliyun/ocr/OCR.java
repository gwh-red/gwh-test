package com.gwh.aliyun.ocr;

import cn.hutool.json.JSONUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class OCR {
    public static void main(String[] args) {
        String host = "https://foodshop.market.alicloudapi.com";
        String path = "/ai_market/intelligent_food_business_license_identification/v1";
        String method = "POST";
        String appcode = "70118048691549cabc7c31a719c85b5a";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        //bodys.put("IMAGE", "https://icredit-api-market.oss-cn-hangzhou.aliyuncs.com/%E8%89%BE%E7%A7%91%E7%91%9E%E7%89%B9_%E5%8D%B0%E5%88%B7%E6%96%87%E5%AD%97%E8%AF%86%E5%88%AB_%E9%A3%9F%E5%93%81%E7%BB%8F%E8%90%A5%E8%AE%B8%E5%8F%AF%E8%AF%81%E8%AF%86%E5%88%AB/%E9%A3%9F%E5%93%81%E7%BB%8F%E8%90%A5%E8%AE%B8%E5%8F%AF%E8%AF%81.jpg");
        bodys.put("IMAGE", "https://image.gxptkc.com/upload/business168551736307425876.png");
        bodys.put("IMAGE_TYPE", "1");


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse httpResponse = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //System.out.println(httpResponse.toString());
            //获取response的body
            String body = EntityUtils.toString(httpResponse.getEntity());

            cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(body);
            cn.hutool.json.JSONObject jsonObject1 = JSONUtil.parseObj(jsonObject.getStr("食品经营许可证实体信息"));

            System.out.println(jsonObject1);
            jsonObject1.getStr("经营者名称");
        } catch (Exception e) {
            e.printStackTrace();
        }

/*
        String body = HttpRequest.post("https://foodshop.market.alicloudapi.com/ai_market/intelligent_food_business_license_identification/v1")
                .header(Header.AUTHORIZATION, "APPCODE " + "70118048691549cabc7c31a719c85b5a")
                .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8")//头信息，多个头信息多次调用此方法即可
                //.timeout(20000)//超时，毫秒
                .body("IMAGE", "https://image.gxptkc.com/upload/business168551576067067600.jpg")
                .body("IMAGE_TYPE", "1")
                .execute().body();

        System.out.println(body);
*/

/*        HttpHeaders headers = new HttpHeaders();
        // 设置通用的请求属性
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set(HttpHeaders.AUTHORIZATION, "APPCODE " + "70118048691549cabc7c31a719c85b5a");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("IMAGE_TYPE", "1");
        params.add("IMAGE", "https://image.gxptkc.com/upload/business168551576067067600.jpg");
//        params.add("image", imageUrl);
        HttpEntity<MultiValueMap<String, String>> restRequest = new HttpEntity<>(params, headers);
        //log.info("营业执照识别请求参数：{}", JSON.toJSONString(restRequest));
        ResponseEntity<String> responseEntity = null;
        *//*LicenseResponse licenseResponse = new LicenseResponse();
        licenseResponse.setIfCreditValid(false);*//*
        try {
            responseEntity = restTemplate.postForEntity(url, restRequest, String.class);
        } catch (Exception e) {
 *//*           log.error("调用营业执照识别失败：" + e.getMessage(), e.getStackTrace());
            licenseResponse.setCreditMsg("营业执照识别失败！");*//*
            //return licenseResponse;
        }
        String body = responseEntity.getBody();
    }*/
    }
}