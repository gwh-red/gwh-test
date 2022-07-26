package com.gwh;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 123
 */
public class ExcelDome {

    public void ordergeneratexml() throws Exception {
        //根据file得到Workbook,主要是要根据这个对象获取,传过来的excel有几个sheet页
        File file1 = new File("");
        InputStream is = new FileInputStream(file1);
        Workbook hssfWorkbook = new HSSFWorkbook(is);
        //获取sheet数量
        int sheetNum = hssfWorkbook.getNumberOfSheets();
        ImportParams params = new ImportParams();
        //表头在第几行
        params.setTitleRows(3);
        //是否需要通过key-value导入方法，获取特定字段
        params.setReadSingleCell(true);
        //判断一个cell是key的规则,可以自定义,默认就是 “:”
        params.setKeyMark("：");

       /* List<ExcelVo> listAll = new ArrayList<>();
        for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
            //第几个sheet页
            params.setStartSheetIndex(sheetIndex);
            //获取表头下的数据
            ExcelImportResult<ExcelVo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), ExcelVo.class, params);
            List<ExcelVo> list = result.getList();
            //获取特定字段的map
            Map<String, Object> map = result.getMap();
            list.forEach(entity -> {
                entity.setRukuriqi(map.get("日期：").toString());
                entity.setDianpumingchen(map.get("店铺名：").toString());
            });
            listAll.addAll(list);
        }*/
    }


    public static Workbook getWorkBook(File file) throws IOException {
        //这样写excel能兼容03和07
        //InputStream is = file.getInputStream();
        InputStream is = new FileInputStream(file);
        Workbook hssfWorkbook = null;
        try {
            hssfWorkbook = new HSSFWorkbook(is);
        } catch (Exception ex) {
            hssfWorkbook = new XSSFWorkbook(is);
        }
        return hssfWorkbook;
    }

/*    public static void main(String[] args) {
        //功能描述：把同一个表格多个sheet测试结果重新输出，
        Workbook workBook = null;
        try {
            // 创建参数对象（用来设定excel的sheet1内容等信息）
            ExportParams userExportParams = new ExportParams();
            // 设置sheet得名称
            userExportParams.setSheetName("用户表");
            // 设置sheet表头名称
            userExportParams.setTitle("用户列表");
            // 创建sheet1使用得map
            Map<String, Object> userExportMap = new HashMap<>();
            // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
            userExportMap.put("title", userExportParams);
            // 模版导出对应得实体类型
            userExportMap.put("entity", ExportExcelUser.class);
            //转成导出vo类型
            List<ExportExcelUser> users = this.changeType(this.list());
            // sheet1中要填充得数据
            userExportMap.put("data", users);


            // 创建参数对象（用来设定excel的sheet2内容等信息）
            ExportParams logInfoExportParams = new ExportParams();
            logInfoExportParams.setTitle("日志列表");
            logInfoExportParams.setSheetName("日志表");
            // 创建sheet2使用的map
            Map<String, Object> logInfoExportMap = new HashMap<>();
            logInfoExportMap.put("title", logInfoExportParams);
            logInfoExportMap.put("entity", ExportExcelLog.class);
            //查询log数据
            List<LogInfo> logInfoEntitys = logInfoMapper.selectList(new QueryWrapper<>());
            //转成导出vo类型
            List<ExportExcelLog> logInfos = this.changeInfoType(logInfoEntitys);
            // sheet2中要填充得数据
            logInfoExportMap.put("data", logInfos);


            // 将sheet1、sheet2使用得map进行包装
            List<Map<String, Object>> sheetsList = new ArrayList<>();
            //后续增加sheet组，则后面继续追加即可;
            sheetsList.add(userExportMap);
            sheetsList.add(logInfoExportMap);
            // 执行方法
            workBook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
            //设置编码格式
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            //设置内容类型
            response.setContentType("application/octet-stream");
            //设置头及文件命名。
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("用户及操作日志导出.xls", StandardCharsets.UTF_8.name()));
            //写出流
            workBook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workBook != null) {
                try {
                    //强行关流
                    workBook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}
