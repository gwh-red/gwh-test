package com.gwh;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BucketManagerDemo {
    public static void main(String args[]) throws IOException {


        URL realUrl = new URL("https://image.gxptkc.com/upload/164975789973027.png?imageView2%2F1%2Fw%2F600%2Fh%2F500%2Fq%2F75%7Cwatermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWFnZS5neHB0a2MuY29tL3VwbG9hZC9sb2dvbWFyazMucG5n%2Fdissolve%2F30%2Fgravity%2FSouthEast%2Fdx%2F40%2Fdy%2F40");
        HttpURLConnection urlCon = (HttpURLConnection) realUrl.openConnection();
        urlCon.setConnectTimeout(6000);
        urlCon.setReadTimeout(6000);
        int code = urlCon.getResponseCode();
      /*  //设置需要操作的账号的AK和SK
        String ACCESS_KEY = "Bku4MNJHn2m-qHPxZ4jDTkkV-tIw6U-u6Ex2mUrW";
        String SECRET_KEY = "eMSL04-fhF-IggfUsa_v87IcX_ehREMA0gVj3iCL";
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        Zone z = Zone.zone0();
        Configuration c = new Configuration(z);

        //实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth, c);
        //要测试的空间和key，并且这个key在你空间中存在
        String bucket = "runfast";
        String key = "upload/164975789973027.png";
        try {
            //调用stat()方法获取文件的信息
            FileInfo info = bucketManager.stat(bucket, key);
            System.out.println(info.hash);
            System.out.println(info.key);
            System.out.println(info.mimeType);

        } catch (QiniuException e) {
            //捕获异常信息
            Response r = e.response;
            System.out.println(r.toString());
        }*/
    }
}
