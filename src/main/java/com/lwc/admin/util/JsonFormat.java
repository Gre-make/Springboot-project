package com.lwc.admin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonFormat {

    /**
     * json数据格式化
     * @param str
     * @return
     */
    public String jsonFormat(String str){
        String jsonStr=str;
        try {
            JSONObject object = JSONObject.parseObject(str);
            jsonStr = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteDateUseDateFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public static void main(String[] args) {
    }

}
