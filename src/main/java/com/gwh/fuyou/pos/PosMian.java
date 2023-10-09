package com.gwh.fuyou.pos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gwh.fuyou.utils.HttpUtil;
import com.gwh.fuyou.utils.RsaUtil;
import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PosMian {
	
	public static void main(String[] args) {
		order();
	}
	
	//订单支付请求接口
	public static void order() {
		//测试环境富友公钥
		String pub_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKPD4f/3xMjPuHcQSGxPIYZNgF2i0sJhzmKpN3dmzhbKH/1nG+aXUJDhswyitzrI+U0ic/GL/IWB1wQ3noWuLFr8jDSGafenTFiY9c0H9ZAEfqW/oywx95G5JWu5y/ffp4yCmlt8k5kHO/4kE1qnJcGaQlb6/+7t3MPSV5ybmBZwIDAQAB";
		//测试环境商户私钥
		String pri_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJMr8NnRV7ve7Y5FEBium/TsU0fK5NvzvFpsYxPAQhBXY+EN0Bi2JEg790C1njk9Q3U36u2JBDHAiDIomlgh6wWkJsFn7dghV/fCWSX1VVJ+dRINZy1432fRaJ8GqspvMneBpeLjBe94IwlWKpN+AOR+BNX8QL/uHmfCPlVQXos9AgMBAAECgYAzqbMs434m50UBMmFKKNF6kxNRGnpodBFktLO7FTybu/HF6TFp21a1PMe5IYhfk5AAsBZ6OCUOygWFhhdYZN+5W+dweF3kp1rLE4y5CjwqNlk/g22TAndf9znh/ltHFLvITToqu/eh/34tE1gyNxRbsi1olw/1wv8ZRjM3vtM9QQJBANvNwFq+CJHUyFzkXQB7+ycQFnY8wDq8Uw2Hv9ZMjgIntH7FSlJtdu5mAYPPo6f74slO5tFUMNP7EVppqsjYaNkCQQCraD6iKHo+OIlvvYIKiMXatJGD7N1GNhq5CrhUNPWLHwv/Ih2D3JJdF8IUZOPIJfUxTfM2fZYI+EVdsv6s4RcFAkAGjNYbnighOGcUJZYD6q3sVxVkRqEv3ubWs2HrH/Lna4l8caKqXCq8JfwLkod8/QugFiLYwBqIZqX4vMdjHtfZAkBsAl9dbWZCaPvpxp/4JWGPxDLhz9NLV/KU4bVvkoObq++yUHwKyGYOdVcd5MlIKOsNq5Hzp0Vw14lWVuF2bMxFAkBuNrZksvUULNIaWDKd4rQ6GVzUxXuIZW0ZE6atHYDiXPB4jVAjKRtLxZAV1qH9cr1zNJlcg+RbGYUdF9t4A9n5";
		String url = "https://aggpc-test.fuioupay.com/aggpos/order.fuiou";//测试环境接口地址
		String mchnt_cd = "0001000F0040992";//商户号
		String order_date = new SimpleDateFormat("yyyyMMdd").format(new Date());//订单日期
		String order_id = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//订单号唯一。30位内。只能数字和字母。
		String order_amt = "1";//金额是整数。单位是分。1就是1分钱。
		String order_pay_type = "ALIPAY";
		String back_notify_url= "http://www-2.wg.fuioupay.com:13195/pay_test/callback.jsp";   //后台通知地址。商家后台接收订单支付成功的地址。
		String goods_name = "衣服";
		String goods_detail = "小孩子衣服";
		String appid = ""; //公众号或者小程序的appid
		String openid = "";//公众号或者小程序 用户的appid
		String bill_params = "";//不用传
		String ver = "1.0.0";

		Map<String, String> param = new HashMap<String, String>();
		param.put("mchnt_cd",mchnt_cd);
		param.put("order_date",order_date);
		param.put("order_id",order_id);
		param.put("order_amt",order_amt);
		param.put("order_pay_type",order_pay_type);
		param.put("back_notify_url",back_notify_url);
		param.put("goods_name",goods_name);
		param.put("goods_detail",goods_detail);
		param.put("appid",appid);
		param.put("openid",openid);
		param.put("bill_params",bill_params);
		param.put("ver",ver);

		Map<String, String> req = new HashMap<String, String>();
		req.put("mchnt_cd",mchnt_cd);
		//富友公钥加密
		req.put("message", RsaUtil.encryptByRsaPub(JSON.toJSONString(param),pub_key,"GBK"));
		String resp = HttpUtil.postJson(url, JSON.toJSONString(req));
		System.out.println(resp);
		JSONObject json = JSON.parseObject(resp);
		String resp_code = json.getString("resp_code");
		if (resp_code.equals("0000")) {
			//商户私钥解密
			String msg = RsaUtil.decryptByRsaPri(json.getString("message"), pri_key, "GBK");
			System.out.println(msg);
		}
	}
	
	
	//订单后台回调通知
	public void backNotify(HttpServletRequest request) {
		try {
			String msg = IOUtils.toString(request.getInputStream(), "UTF-8");
			System.out.println(msg);
			//解密message同上
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
