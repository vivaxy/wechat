package com.vivaxy.wechat.tool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;

/**
 * Author : vivaxy
 * Date   : 2014/7/24 11:00
 * Project: wechat
 * Package: com.vivaxy.wechat.tool
 */
public class BeanUtil<T> {
    LogUtil log = new LogUtil();

    public T set(T t, ResultSet rs) {
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 获取属性
            String property = field.getName();
            // 获取方法名
            String prefix = property.substring(0, 1).toUpperCase();
            String getMethodName = "get" + prefix + property.substring(1);
            String setMethodName = "set" + prefix + property.substring(1);
            try {
                // 获取对应的方法
                Method methodSet = clazz.getMethod(setMethodName, new Class[]{field.getType()});
                Method methodGet = clazz.getMethod(getMethodName, new Class[]{});
                // 调用set方法
                if (field.getType() == Integer.class) methodSet.invoke(t, rs.getInt(property));
                if (field.getType() == Long.class) methodSet.invoke(t, rs.getLong(property));
                if (field.getType() == String.class) methodSet.invoke(t, rs.getString(property));
                // 调用get方法
//                Object objValue = methodGet.invoke(t);
//                String methodGetValue = objValue == null ? "" : objValue.toString();
                // 输出
//                log.put(property, methodGetValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}
