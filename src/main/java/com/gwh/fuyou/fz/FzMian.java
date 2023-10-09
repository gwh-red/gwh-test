package com.gwh.fuyou.fz;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gwh.fuyou.utils.HttpUtil;
import com.gwh.fuyou.utils.RsaUtil;

public class FzMian {
    //测试环境商户私钥
    static String pri_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJMr8NnRV7ve7Y5FEBium/TsU0fK5NvzvFpsYxPAQhBXY+EN0Bi2JEg790C1njk9Q3U36u2JBDHAiDIomlgh6wWkJsFn7dghV/fCWSX1VVJ+dRINZy1432fRaJ8GqspvMneBpeLjBe94IwlWKpN+AOR+BNX8QL/uHmfCPlVQXos9AgMBAAECgYAzqbMs434m50UBMmFKKNF6kxNRGnpodBFktLO7FTybu/HF6TFp21a1PMe5IYhfk5AAsBZ6OCUOygWFhhdYZN+5W+dweF3kp1rLE4y5CjwqNlk/g22TAndf9znh/ltHFLvITToqu/eh/34tE1gyNxRbsi1olw/1wv8ZRjM3vtM9QQJBANvNwFq+CJHUyFzkXQB7+ycQFnY8wDq8Uw2Hv9ZMjgIntH7FSlJtdu5mAYPPo6f74slO5tFUMNP7EVppqsjYaNkCQQCraD6iKHo+OIlvvYIKiMXatJGD7N1GNhq5CrhUNPWLHwv/Ih2D3JJdF8IUZOPIJfUxTfM2fZYI+EVdsv6s4RcFAkAGjNYbnighOGcUJZYD6q3sVxVkRqEv3ubWs2HrH/Lna4l8caKqXCq8JfwLkod8/QugFiLYwBqIZqX4vMdjHtfZAkBsAl9dbWZCaPvpxp/4JWGPxDLhz9NLV/KU4bVvkoObq++yUHwKyGYOdVcd5MlIKOsNq5Hzp0Vw14lWVuF2bMxFAkBuNrZksvUULNIaWDKd4rQ6GVzUxXuIZW0ZE6atHYDiXPB4jVAjKRtLxZAV1qH9cr1zNJlcg+RbGYUdF9t4A9n5";
    //测试环境富友公钥
    static String pub_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdTXpOEbMNokE555vL6o4ES7+c2V9J7EiTxaWuT3yTVvlTngDGhIVPMrOZkvGJOBknwKS3eRCgAUCeDFmBzdRyKKAUSYrBFLfLMuLy0ZYLfI5+na7wN0nAivkqLf5K44JqwfnvYi79wGQO8aibGNhHY+abSTA2qtxivfcTIzI+swIDAQAB";


    public static void main(String[] args) throws Exception {
        // one();
        tow();
    }

    //开记账户
    public static void one() throws Exception {

        String url = "https://ordupz-test.fuioupay.com/fatspOpenAccount.fuiou";//测试环境接口地址

        OpenFatspAccountIn in = new OpenFatspAccountIn();
        in.setTraceNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));//流水号唯一。30位内。只能数字和字母。
        in.setMchntCd("0001000F8020759");//商户号
        in.setApplyDate("20220125");//申请日期
        in.setIsIndividualMchnt("8");
        in.setInsNameCn("入账户名称唯一" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

        in.setArtifNm("张三");
        in.setCertifId("330127198605192593");
        in.setValidDt("20290125");
        in.setContactPhone("15871417894");
        in.setCertifIdPic1("16224864739.jpg");

        in.setSettleTp("02");
        in.setOutAcntNm("张三");
        in.setOutAcntIdNo("330127198605192593");
        in.setOutAcntNo("6228480059586300000");
        in.setYhkzmPic("16224864739.jpg");

        List<String> excludeFieldList = new ArrayList<>();
        excludeFieldList.add("signature");
        excludeFieldList.add("revenueTp");
        //生成待签名的字符串
        String inputStr = ClearTextUtil.generateClearText(in, excludeFieldList);
        System.out.println(inputStr);

        String sign = RsaUtil.sign2Base64ByMd5Rsa(pri_key, inputStr, "GBK");
        in.setSignature(sign);

        String xml = XmlUtil.bean2Xml(in);
        System.out.println(xml);

        Map<String, String> param = new HashMap<String, String>();
        param.put("req", URLEncoder.encode(xml, "GBK"));
        //请求
        String resp = HttpUtil.postForm(url, param);
        System.out.println(resp);

        OpenFatspAccountOut out = XmlUtil.xml2Bean(URLDecoder.decode(resp, "GBK"), OpenFatspAccountOut.class);
        //生成待验签的字符串
        System.out.println(out);
        String clearText = ClearTextUtil.generateClearText(out, excludeFieldList);
        System.out.println(clearText);
        boolean verify = RsaUtil.verifySignByMd5Rsa(pub_key, clearText, out.getSignature(), "GBK");
        System.out.println(verify);
    }

    //开通分账协议合同
    public static void tow() throws Exception {

        String url = "https://ordupz-test.fuioupay.com/openContract.fuiou";
        //测试环境接口地址


        OpenContractIn openContractIn = new OpenContractIn();
        //商户号
        openContractIn.setMchntCd("0001000F8020759");
        //流水号唯一。30位内。只能数字和字母。
        openContractIn.setTraceNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));//流水号唯一。30位内。只能数字和字母。

        openContractIn.setAccountIn("0001007F8032032");
        openContractIn.setContractName("20220527合同名称001");
        openContractIn.setContractUrl("002REWR.jpg");

        openContractIn.setStartDate("20220529");
        openContractIn.setEndDate("20250528");


        List<String> excludeFieldList = new ArrayList<>();
        excludeFieldList.add("signature");
        excludeFieldList.add("revenueTp");
        //生成待签名的字符串
        String inputStr = ClearTextUtil.generateClearText(openContractIn, excludeFieldList);
        System.out.println(inputStr);

        String sign = RsaUtil.sign2Base64ByMd5Rsa(pri_key, inputStr, "GBK");
        openContractIn.setSignature(sign);

        String xml = XmlUtil.bean2Xml(openContractIn);
        System.out.println(xml);

        Map<String, String> param = new HashMap<String, String>();
        param.put("req", URLEncoder.encode(xml, "GBK"));
        //请求
        String resp = HttpUtil.postForm(url, param);
        System.out.println(resp);

        OpenContractOut out = XmlUtil.xml2Bean(URLDecoder.decode(resp, "GBK"), OpenContractOut.class);
        //生成待验签的字符串
        System.out.println(out);
        String clearText = ClearTextUtil.generateClearText(out, excludeFieldList);
        System.out.println(clearText);
        boolean verify = RsaUtil.verifySignByMd5Rsa(pub_key, clearText, out.getSignature(), "GBK");
        System.out.println(verify);
    }
}
