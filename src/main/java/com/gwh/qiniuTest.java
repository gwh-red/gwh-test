package com.gwh;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.gwh.entity.RunfastGoodsSellVO;
import com.qiniu.util.Auth;
import com.qiniu.util.UrlUtils;
import com.sun.deploy.net.URLEncoder;
import org.apache.poi.ss.formula.functions.T;

import javax.crypto.Mac;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.NoSuchElementException;


public class qiniuTest {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    private final String ACCESS_KEY = "Bku4MNJHn2m-qHPxZ4jDTkkV-tIw6U-u6Ex2mUrW";
    private final String SECRET_KEY = "eMSL04-fhF-IggfUsa_v87IcX_ehREMA0gVj3iCL";
    //要上传的空间
    String bucketname = "runfast";
    //上传到七牛后保存的文件名
    //密钥配置
    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //private Configuration cfg = new Configuration(Zone.zone2());
    //Zone z = Zone.zone1();
    //Configuration c = new Configuration(z);
    //创建上传对象
    //private UploadManager uploadManager = new UploadManager(cfg);

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    private String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        /*qiniuTest qiniuTest = new qiniuTest();
        System.out.println(qiniuTest.getUpToken());*/


        // domain   下载 domain, eg: qiniu.com【必须】
        // useHttps 是否使用 https【必须】
        // key      下载资源在七牛云存储的 key【必须】
        //List<T> list = null;
        ImportParams params = new ImportParams();
        //表头在第几行
        params.setTitleRows(1);
        //是否需要通过key-value导入方法，获取特定字段
        params.setReadSingleCell(true);
        // List<Object> listAll = new ArrayList<>();
        //for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
        //第几个sheet页
        params.setStartSheetIndex(0);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File("https://image.gxptkc.com/goods/1654573012638测试文件.xls"), RunfastGoodsSellVO.class, params);
            System.out.println(list);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
