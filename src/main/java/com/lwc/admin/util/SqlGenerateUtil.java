package com.lwc.admin.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * sql生成器（mysql）
 */
@Slf4j
public class SqlGenerateUtil {


    public String sqlGenerateMethod(String entityName, String tableName) {
        try {
            Class<?> clName = Class.forName(entityName);
            Field[] fields = clName.getDeclaredFields();
            Map<String, String> map = new HashMap<>();
            map.put("java.lang.String", "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL");
            map.put("java.lang.Double", "decimal(10, 2) NULL DEFAULT NULL");
            map.put("java.lang.Integer", "int(10)");
            map.put("java.lang.Date", "datetime(0) NULL DEFAULT NULL");
            File file=new File(tableName+".sql");
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.append("SET NAMES utf8mb4;\n");
            ps.append("SET FOREIGN_KEY_CHECKS = 0;\n");
            ps.append("DROP TABLE IF EXISTS `" + tableName + "`;\n");
            ps.append("create table `" + tableName + "`(\n");
            for (int i = 0; i < fields.length; i++) {
                String type = map.containsKey(fields[i].getType().getName()) ? map.get(fields[i].getType().getName()) : map.get("java.lang.String");
                String name = fields[i].getName();
                if (i == fields.length - 1) {
                    ps.append("`" + name + "` " + type + "\n");
                } else {
                    ps.append("`" + name + "` " + type + ",\n");
                }
            }
            ps.append(") ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;");
            ps.append("SET FOREIGN_KEY_CHECKS = 1;");
            ps.close();
        } catch (ClassNotFoundException e) {
            log.error("类名不存在或路径不正确");
            e.printStackTrace();

        } catch (IOException e) {
            log.error("创建文件异常");
            e.printStackTrace();
        }
        return "处理完成";

    }

    public static void main(String[] args) {
        new SqlGenerateUtil().sqlGenerateMethod("com.lwc.admin.bean.Admin","admin");
    }

}
