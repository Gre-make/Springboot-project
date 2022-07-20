package com.lwc.admin.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.WorkbookUtil;
import com.alibaba.excel.util.WorkBookUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;

/**
 * 读取excel文件并且处理（根据不同想要的结果）
 */
public class IoTest {

    public static void main(String[] args) throws IOException {

//        for (int i=0;i<11;i++) {
            long time=System.currentTimeMillis();
            HttpRequest post = HttpRequest.post("http://localhost:9180/qc/api/uploadSaveAndHandle")
                    .header("content-type", "application/json;charset=UTF-8")
                    .body("");
            HttpResponse httpResponse = post.execute();
            System.out.println(httpResponse.body());
            long time2 = System.currentTimeMillis();
            System.out.println(time2-time);
//        }

//        }
//
//        FileInputStream fis = new FileInputStream("D:\\supply_diag_2.xls");
//        Workbook workbook = new HSSFWorkbook(new POIFSFileSystem(fis));
//        int numberOfSheets = workbook.getNumberOfSheets();
//        Sheet sheet = workbook.getSheetAt(0);
//        List<Map<String, String>> mapList = new ArrayList<>();
//        Map<String, String> map = new HashMap<>();
//        List<String> list = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
////        获取每行
//        String row4 = "";
//        String row5 = "";
//        String row6 = "";
//        for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
//            Row row = sheet.getRow(i);
//            if ("1.0".equals(row4) && "1.0".equals(row5) && "1.0".equals(row6) || row == null) {
//                for (String s : list) {
//                    map.put(s, sb.toString().substring(0, sb.length() - 1));
//                    if (StringUtils.isNotEmpty(s.trim())) {
//                        mapList.add(map);
//                    }
//                    map = new HashMap<>();
//                }
//                list = new ArrayList<>();
//                sb = new StringBuilder();
//            }
//            String row1 = "";
//            String row2 = "";
//            String row3 = "";
//            row4 = "";
//            row5 = "";
//            row6 = "";
//            for (int k = 0; k <= sheet.getRow(0).getPhysicalNumberOfCells(); k++) {
//                Cell cell = row.getCell(k);
//                if (ObjectUtils.isNotEmpty(cell) && k == 0) {
//                    row1 = cell.toString();
//                }
//                if (ObjectUtils.isNotEmpty(cell) && k == 1) {
//                    row2 = cell.toString();
//                }
//                if (ObjectUtils.isNotEmpty(cell) && k == 2) {
//                    row3 = cell.toString();
//                }
//                if (ObjectUtils.isNotEmpty(cell) && k == 3) {
//                    row4 = cell.toString();
//                }
//                if (ObjectUtils.isNotEmpty(cell) && k == 4) {
//                    row5 = cell.toString();
//                }
//                if (ObjectUtils.isNotEmpty(cell) && k == 5) {
//                    row6 = cell.toString();
//                }
//            }
//
//            if (StringUtils.isNotEmpty(row1) && StringUtils.isNotEmpty(row2)) {
//                list.add(row1 + row2);
//            }
//            if (StringUtils.isNotEmpty(row1) && StringUtils.isEmptyOrNull(row2)) {
//                list.add(row1);
//            }
//            if (StringUtils.isNotEmpty(row3)) {
//                sb.append(row3 + ",");
//            }
//        }
////        for (int i = 0; i < mapList.size(); i++) {
////            System.out.println(mapList.get(i).get(mapList.get(i).keySet().iterator().next()));
////
////        }
//        fis.close();
//        //写入文件
//        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFSheet sheet1 = wb.createSheet("表1");
//        HSSFRow row = sheet1.createRow(0);
//        HSSFCell cell = row.createCell((short) 0);
//        cell.setCellValue("name1");
//        cell = row.createCell((short) 1);
//        cell.setCellValue("name2");
//        for (int i = 0; i < mapList.size(); i++) {
//            row = sheet1.createRow(i + 1);
//            row.createCell(0).setCellValue(mapList.get(i).keySet().iterator().next());
//            row.createCell(1).setCellValue(mapList.get(i).get(mapList.get(i).keySet().iterator().next()));
//        }
//        FileOutputStream fout = new FileOutputStream("D:\\myexcel4.xls");
//        wb.write(fout);
//        fout.close();
//


    }
}




