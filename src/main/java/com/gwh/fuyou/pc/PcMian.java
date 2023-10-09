package com.gwh.fuyou.pc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gwh.fuyou.utils.HttpUtil;
import com.gwh.fuyou.utils.RsaUtil;


public class PcMian {
	
	public static void main(String[] args) {
		order();
		query();
	}
	
	//订单支付请求接口
	public static void order() {
		//测试环境商户私钥
		String pri_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJMr8NnRV7ve7Y5FEBium/TsU0fK5NvzvFpsYxPAQhBXY+EN0Bi2JEg790C1njk9Q3U36u2JBDHAiDIomlgh6wWkJsFn7dghV/fCWSX1VVJ+dRINZy1432fRaJ8GqspvMneBpeLjBe94IwlWKpN+AOR+BNX8QL/uHmfCPlVQXos9AgMBAAECgYAzqbMs434m50UBMmFKKNF6kxNRGnpodBFktLO7FTybu/HF6TFp21a1PMe5IYhfk5AAsBZ6OCUOygWFhhdYZN+5W+dweF3kp1rLE4y5CjwqNlk/g22TAndf9znh/ltHFLvITToqu/eh/34tE1gyNxRbsi1olw/1wv8ZRjM3vtM9QQJBANvNwFq+CJHUyFzkXQB7+ycQFnY8wDq8Uw2Hv9ZMjgIntH7FSlJtdu5mAYPPo6f74slO5tFUMNP7EVppqsjYaNkCQQCraD6iKHo+OIlvvYIKiMXatJGD7N1GNhq5CrhUNPWLHwv/Ih2D3JJdF8IUZOPIJfUxTfM2fZYI+EVdsv6s4RcFAkAGjNYbnighOGcUJZYD6q3sVxVkRqEv3ubWs2HrH/Lna4l8caKqXCq8JfwLkod8/QugFiLYwBqIZqX4vMdjHtfZAkBsAl9dbWZCaPvpxp/4JWGPxDLhz9NLV/KU4bVvkoObq++yUHwKyGYOdVcd5MlIKOsNq5Hzp0Vw14lWVuF2bMxFAkBuNrZksvUULNIaWDKd4rQ6GVzUxXuIZW0ZE6atHYDiXPB4jVAjKRtLxZAV1qH9cr1zNJlcg+RbGYUdF9t4A9n5";
		String url = "https://aggpc-test.fuioupay.com/inteGate.fuiou";//测试环境接口地址
		String mchnt_cd = "0001000F0040992";//商户号
		String order_date = new SimpleDateFormat("yyyyMMdd").format(new Date());//订单日期
		String order_id = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//订单号唯一。30位内。只能数字和字母。
		String pay_type = "";
		String order_amt = "1";//金额是整数。单位是分。1就是1分钱。
		String page_notify_url = "http://www-2.wg.fuioupay.com:13195/pay_test/callback.jsp";  //页面通知地址。商家页面显示订单支付成功的页面。
		String back_notify_url= "http://www-2.wg.fuioupay.com:13195/pay_test/callback.jsp";   //后台通知地址。商家后台接收订单支付成功的地址。
		String goods_name = "衣服";
		String rem = "";
		//拼接参数用于签名
		String	inputStr = back_notify_url + "|" + goods_name+ "|" +mchnt_cd+ "|" +order_amt+ "|" +order_date+ "|" + order_id+ "|" +page_notify_url+ "|"  +pay_type + "|" +     rem;		
		//得到签名。
		String sign = RsaUtil.sign2Base64ByMd5Rsa(pri_key, inputStr, "GBK");
		System.out.println(url);
		System.out.println(inputStr);
		System.out.println(sign);
		//将上面的参数给前端。用html表单提交。即可跳转到收银台。
		 /*
		  * <form name="form" method="post" action="url_test">
			 <input type="hidden" value = 'mchnt_cd' name="mchnt_cd"/>
			 <input type="hidden" value = 'pay_type' name="pay_type"/>
			 <input type="hidden" value = 'order_id' name="order_id"/>
			 <input type="hidden" value = 'order_date' name="order_date"/>
			 <input type="hidden" value = 'order_amt' name="order_amt"/>
			 <input type="hidden" value = 'goods_name' name="goods_name"/>
			 <input type="hidden" value = 'rem' name="rem"/>
			 <input type="hidden" value = 'page_notify_url' name="page_notify_url"/>
			 <input type="hidden" value = 'back_notify_url' name="back_notify_url"/>
			 <input type="hidden" value = 'sign' name="sign"/>
		 </form>
		 */
	}
	
	//订单查询接口
	public static void query() {
		//测试环境商户私钥
		String pri_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJMr8NnRV7ve7Y5FEBium/TsU0fK5NvzvFpsYxPAQhBXY+EN0Bi2JEg790C1njk9Q3U36u2JBDHAiDIomlgh6wWkJsFn7dghV/fCWSX1VVJ+dRINZy1432fRaJ8GqspvMneBpeLjBe94IwlWKpN+AOR+BNX8QL/uHmfCPlVQXos9AgMBAAECgYAzqbMs434m50UBMmFKKNF6kxNRGnpodBFktLO7FTybu/HF6TFp21a1PMe5IYhfk5AAsBZ6OCUOygWFhhdYZN+5W+dweF3kp1rLE4y5CjwqNlk/g22TAndf9znh/ltHFLvITToqu/eh/34tE1gyNxRbsi1olw/1wv8ZRjM3vtM9QQJBANvNwFq+CJHUyFzkXQB7+ycQFnY8wDq8Uw2Hv9ZMjgIntH7FSlJtdu5mAYPPo6f74slO5tFUMNP7EVppqsjYaNkCQQCraD6iKHo+OIlvvYIKiMXatJGD7N1GNhq5CrhUNPWLHwv/Ih2D3JJdF8IUZOPIJfUxTfM2fZYI+EVdsv6s4RcFAkAGjNYbnighOGcUJZYD6q3sVxVkRqEv3ubWs2HrH/Lna4l8caKqXCq8JfwLkod8/QugFiLYwBqIZqX4vMdjHtfZAkBsAl9dbWZCaPvpxp/4JWGPxDLhz9NLV/KU4bVvkoObq++yUHwKyGYOdVcd5MlIKOsNq5Hzp0Vw14lWVuF2bMxFAkBuNrZksvUULNIaWDKd4rQ6GVzUxXuIZW0ZE6atHYDiXPB4jVAjKRtLxZAV1qH9cr1zNJlcg+RbGYUdF9t4A9n5";
		//测试环境富友公钥
		String pub_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTK/DZ0Ve73u2ORRAYrpv07FNHyuTb87xabGMTwEIQV2PhDdAYtiRIO/dAtZ45PUN1N+rtiQQxwIgyKJpYIesFpCbBZ+3YIVf3wlkl9VVSfnUSDWcteN9n0WifBqrKbzJ3gaXi4wXveCMJViqTfgDkfgTV/EC/7h5nwj5VUF6LPQIDAQAB";
		//测试环境接口地址
		String url = "https://aggpc-test.fuioupay.com/aggpaySynQry.do";
		String mchnt_cd = "0001000F0040992";
		String order_id = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String order_type = "PAY";
		String order_date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		//拼接参数用于签名
		String	inputStr = mchnt_cd + "|" + order_date+ "|" +order_id+ "|" +order_type ;		
		//得到签名。
		String sign = RsaUtil.sign2Base64ByMd5Rsa(pri_key, inputStr, "GBK"); 
		System.out.println(inputStr);
		System.out.println(sign);
		//查询参数
		Map<String,String> parm = new HashMap<String, String>();
		parm.put("mchnt_cd", mchnt_cd);
		parm.put("order_id", order_id);
		parm.put("order_type", order_type);
		parm.put("order_date", order_date);
		parm.put("sign", sign);
		String resp = HttpUtil.postJson(url, JSON.toJSONString(parm));
		//查询结果
		System.out.println(resp);
		JSONObject json = JSON.parseObject(resp);
		String resp_code = json.getString("resp_code");
		if (resp_code.equals("0000")) {
			//拼接参数用于验签
			String src =json.getString("mchnt_cd")+"|"+json.getString("order_amt")+"|"+json.getString("order_date")+"|"+json.getString("order_id")+"|"+json.getString("order_st")+"|"+json.getString("resp_code")+"|"+json.getString("resp_desc");
			//富友公钥验签
			boolean b = RsaUtil.verifySignByMd5Rsa(pub_key, src, json.getString("sign"), "GBK");
			System.out.println(b);
		}
	}
	
	//订单后台回调通知
	public void backNotify(HttpServletRequest request) {
		Map<String,String[]> map = request.getParameterMap();
		Iterator<Entry<String, String[]>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String[]> p =  it.next();
			String key = (String) p.getKey();
			String[] value = (String[]) p.getValue();
			System.out.println(key + " " + value);
			//此处的拼接验签规则和上面的查询一样。商户自行幂等处理。
		}
	}
	
	//订单页面跳转通知
	public void pageNotify(HttpServletRequest request) {
		Map<String,String[]> map = request.getParameterMap();
		Iterator<Entry<String, String[]>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String[]> p =  it.next();
			String key = (String) p.getKey();
			String[] value = (String[]) p.getValue();
			System.out.println(key + " " + value);
			//此处的拼接验签规则和上面的查询一样。商户自行幂等处理。
		}
	}

}
