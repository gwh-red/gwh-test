package com.gwh.fuyou.app;

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


public class AppMian {

    public static void main(String[] args) {
        token();
    }

    //获取token
    public static void token() {
        //商户私钥解密
        String pri_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDIQi1d74mvJr9nMWgZbqT6A35L3rRfp2trpxR/zmh4lMoMLDFCSwoKt/oEZrQeNIIVXf8W/gVUCq6MUs63pvTVF90f1CDJUmdOOZYuJrUcMwa534qna+OhV4ikP6bV74OMpeR/yZ2Azu3PB+k/qkn5jeeIwPghqqtfD5bWCCxYmNLkajJPQu67vHxJKFOiGSO/8b1nSgGR9MXXTR+IYWIWNL+HshPPdZ9GtKsajuatscVc35d7CFSFCa09FSJnf3/O95ztAk768W82o8JF5lGdFiCKmmFKaQh/J4TEtLnvzFkOa+Ezqy/UlHhB/QIX1A1X5js6TovXWNXsxFB3mKLPAgMBAAECggEAP8PytiqD6OWppK4yu4ZjuchK+tWbEao5pjm5aUjMMzkNbPrVZIqIVAlo7uXVDJkjorIfe66++5e7JKtpb0kWRJQosO3W0sQOaPYlP+TLXoNQ7PalK9JK1SEOPV6XPR/a/3oDXD1SjaVWS8n1F3SdwXzR8NWhLPcvQkGwgc5wcHUIzViofLw4TO8LR+U5tjoEK4v3HEG242Q36QB+LTNKrv974RN1niFiDDhoryzIGvEJuD/XQUzZUdLXiTegTeOszyS0wH4RTMQA/MPU60rjOpH1tRsqmmwOHF64tioElCz6FSO8FV/M7myxx8DViHD4wf2OJoddaez1F471hKB2IQKBgQDpz2ajHrXA9UXkPVKMXRtewmpnY93zjtYrdGvQlSR8qgAAFNMJTYWGhsfMyW632NGu5PVB3AOSLw6z0JHNBUFOWfndoWco++Uq7rP2XtGfjsW1Y9KZY9eYqg59tW5XVf+b9fLX+mHyyt6dnUyZ0/8reol9SSC7HigE3bJQtZnrRQKBgQDbQ5zhtXlwmEvNTPH5YIXpCbJJ/QhnQfDHqcglODZ4KfvKe5CX9TdkygDtVmhGruGAsJ8dni7g37gGkvIEf0r3qqfTi/OmOz3B17Po9opV1biwjGT07YDkwweYJlqE+OEGrNbX8YvyIRjTklqRRapfZj17f/SAekDf670xOcztAwKBgA+Tf5TyYM1gCa3w3+T19vLTJN+KaajmJSJz+RLGPM4JTUK0IHMINRMHO5xK9xNMYHu0SRqAG8TLWcFk7bGo3fboS5sWO5chYN0BVf/dxT1J96Xj5o3Ndvl2qsx5H8a1tfef5PO6fHf+R+JcLlQ5KVCuMyajjoios6XPVyfFUWG5AoGAFkg0tStAABU5/s8G+BS7BweZOrOgGv40fdXfJQklX+jEUbtk4kxlKLTuiy/wwN4cxHsucFAW63tQtDpSpepZr/mDvJfIVuhGSmClQ9NqE3b4odhimhFYu+al6uxa3pB8LbV6z88YLa73WujQk1rFCZTWQqqqKjRCS38lZs886AkCgYEAsDS2JwC2XCMpXGGt/dOksFgfFTqJPRjtryMICHlYnJyEVe46ZDfXIS8XXrNIEg6OikScIwJWXvcSIxXcUOCjuNlCHVoJanp5b/p+5Y4g5Ljzy0FtfFC8JBd3VhC6grwuNOGQuSgx8dQGJIFfshFIkeXC7IjiDfQxPsoCCOmigWo=";
        //富友公钥加密
        String pub_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDWbeSPxvfbpY2uWHbX2YXcrHXa88NITHajSmjTWdY0wqS9WqF8OyMT3ucIEuumP20/5D5+OaSETSBxrD7+1HA87TdTcCLn/FUuzVWiu4cD7Oln2/FJDwPxC/5/u14APBU30aLRWJbPVu0W8ZPmCF8718fAiYjP0RjvXU0gSnA/wwIDAQAB";

        String url = "https://aggapp-test.fuioupay.com/token.fuiou";//测试环境接口地址
        String mchnt_cd = "0002900F0096235";//商户号
        String order_date = new SimpleDateFormat("yyyyMMdd").format(new Date());//订单日期
        String order_id = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//订单号唯一。30位内。只能数字和字母。
        String ver = "1.0.0";
        Map<String, String> param = new HashMap<String, String>();
        param.put("mchnt_cd", mchnt_cd);
        param.put("order_date", order_date);
        param.put("order_id", order_id);
        param.put("ver", ver);

        Map<String, String> req = new HashMap<String, String>();
        req.put("mchnt_cd", mchnt_cd);
        //富友公钥加密
        req.put("message", RsaUtil.encryptByRsaPub(JSON.toJSONString(param), pub_key, "GBK"));
        String resp = HttpUtil.postJson(url, JSON.toJSONString(req));
        System.out.println(resp);
        JSONObject json = JSON.parseObject(resp);
        String resp_code = json.getString("resp_code");
        if (resp_code.equals("0000")) {
            //商户私钥解密
            String msg = RsaUtil.decryptByRsaPri(json.getString("message"), pri_key, "GBK");
            System.out.println(msg);
            //把token给前端sdk。前端sdk即可下单支付。
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