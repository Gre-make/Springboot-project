package com.lwc.admin.util;

import java.io.*;

/**
 * 序列化工具
 */
public class SerializeUtil {
    /**
     * 将java对象转换为byte数组 序列化过程
     */

    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将byte数组转化为java对象
     * @param bytes
     * @return
     */

    public static Object unserialize(byte[] bytes){
        if (bytes==null) return null;

        ByteArrayInputStream bais=null;
        try{
            bais =new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            return objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象转数组
     * @param obj
     * @return
     */
    public static byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

}
