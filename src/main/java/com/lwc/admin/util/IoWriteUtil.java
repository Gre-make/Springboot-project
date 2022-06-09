package com.lwc.admin.util;

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析excel并且将结果写入一个新的excel
 */
public class IoWriteUtil {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\supply_diag.xls");
        Workbook workbook = new HSSFWorkbook(new POIFSFileSystem(fis));
        int numberOfSheets = workbook.getNumberOfSheets();
        Sheet sheet = workbook.getSheetAt(0);
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
//        获取每行
        for (int i = 0; i <= sheet.getLastRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                for (String s : list) {
                    map.put(s, sb.toString().substring(0,sb.length()-1));
                    if (StringUtils.isNotEmpty(s.trim())) {
                        mapList.add(map);
                    }
                    map = new HashMap<>();
                }
                list = new ArrayList<>();
                sb = new StringBuilder();
                continue;
            }
            String row1 = "";
            String row2 = "";
            String row3 = "";
            for (int k = 0; k <= sheet.getRow(0).getPhysicalNumberOfCells(); k++) {
                Cell cell = row.getCell(k);
                if (ObjectUtils.isNotEmpty(cell) && k == 0) {
                    row1 = cell.toString();
                }
                if (ObjectUtils.isNotEmpty(cell) && k == 1) {
                    row2 = cell.toString();
                }
                if (ObjectUtils.isNotEmpty(cell) && k == 2) {
                    row3 = cell.toString();
                }
            }

            if (StringUtils.isNotEmpty(row1) && StringUtils.isNotEmpty(row2)) {
                list.add(row1 + row2);
            }
            if (StringUtils.isNotEmpty(row1) && StringUtils.isEmptyOrNull(row2)) {
                list.add(row1);
            }
            if (StringUtils.isNotEmpty(row3)) {
                sb.append(row3 + ",");
            }
        }
        fis.close();
        //写入文件
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("表1");
        HSSFRow row = sheet1.createRow(0);
        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("name1");
        cell = row.createCell((short) 1);
        cell.setCellValue("name2");
        for (int i = 0; i < mapList.size(); i++) {
            row = sheet1.createRow(i + 1);
            row.createCell(0).setCellValue(mapList.get(i).keySet().iterator().next());
            row.createCell(1).setCellValue(mapList.get(i).get(mapList.get(i).keySet().iterator().next()));
        }
        FileOutputStream fout = new FileOutputStream("D:\\myexcel2.xls");
        wb.write(fout);
        fout.close();
    }
}
