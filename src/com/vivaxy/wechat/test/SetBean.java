package com.vivaxy.wechat.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈罗志
 * @author 修改人:陈亮
 * @创建日期: 2011-8-1
 * @修改日期: 2012-6-28
 * @功能说明1: 利用反射机制从ResultSet自动绑定到JavaBean, bean属性名称必须跟数据库字段名称相同
 * 1.修改了Oracle获取的字段名称大小写不匹配问题
 * 2.处理了日期类型绑定出现类型不匹配异常
 * 3.处理了int类型绑定出现类型不匹配异常
 * 4.处理了double类型绑定出现类型不匹配异常
 * 5.处理了查询出来的字段结果为null时的空指针异常
 * 遗留问题：oracle 的long型不能读取，报流已被关闭错误
 */
public class SetBean<T> {
    // 首写字母变大写
    public static String firstUpperCase(String old) {
        return old.substring(0, 1).toUpperCase() + old.substring(1);
    }

    /**
     * @param clazz 所要封装的javaBean
     * @param rs    记录集
     * @return ArrayList 数组里边装有 多个javaBean
     * @throws Exception
     * @说明：利用反射机制从ResultSet自动绑定到JavaBean；根据记录集自动调用javaBean里边的对应方法。
     */
    public List<T> getList(Class<T> clazz, ResultSet rs) {

        Field field = null;
        List<T> lists = new ArrayList<T>();

        try {
            // 取得ResultSet列名
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取记录集中的列数
            int counts = rsmd.getColumnCount();
            // 定义counts个String 变量
            String[] columnNames = new String[counts];
            // 给每个变量赋值(字段名称全部转换成小写)
            for (int i = 0; i < counts; i++) {
                columnNames[i] = rsmd.getColumnLabel(i + 1).toLowerCase();
            }
            // 变量ResultSet
            while (rs.next()) {
                T t = clazz.newInstance();
                // 反射, 从ResultSet绑定到JavaBean
                for (int i = 0; i < counts; i++) {

                    // 设置参数类型，此类型应该跟javaBean 里边的类型一样，而不是取数据库里边的类型
                    field = clazz.getDeclaredField(columnNames[i]);

                    // 这里是获取bean属性的类型
                    Class<?> beanType = field.getType();

                    // 根据 rs 列名 ，组装javaBean里边的其中一个set方法，object 就是数据库第一行第一列的数据了
                    Object value = rs.getObject(columnNames[i]);

                    if (value != null) {

                        // 这里是获取数据库字段的类型
                        Class<?> dbType = value.getClass();

                        // 处理日期类型不匹配问题
                        if (dbType == java.sql.Timestamp.class && beanType == java.util.Date.class) {
                            // value = new
                            // java.util.Date(rs.getTimestamp(columnNames[i]).getTime());
                            value = new java.util.Date(((java.sql.Timestamp) value).getTime());
                        }
                        // 处理double类型不匹配问题
                        if (dbType == java.math.BigDecimal.class && beanType == double.class) {
                            // value = rs.getDouble(columnNames[i]);
                            value = new Double(value.toString());
                        }
                        // 处理int类型不匹配问题
                        if (dbType == java.math.BigDecimal.class && beanType == int.class) {
                            // value = rs.getInt(columnNames[i]);
                            value = new Integer(value.toString());
                        }
                    }

                    String setMethodName = "set" + firstUpperCase(columnNames[i]);
                    // 第一个参数是传进去的方法名称，第二个参数是 传进去的类型；
                    Method m = t.getClass().getMethod(setMethodName, beanType);

                    // 第二个参数是传给set方法数据；如果是get方法可以不写
                    m.invoke(t, value);
                }
                lists.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lists;
    }

    /**
     * @param clazz bean类
     * @param rs    结果集 (只有封装第一条结果)
     * @return 封装了查询结果的bean对象
     */
    public T getObj(Class<T> clazz, ResultSet rs) {
        Field field = null;
        T obj = null;
        try {
            // 取得ResultSet列名
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取记录集中的列数
            int counts = rsmd.getColumnCount();
            // 定义counts个String 变量
            String[] columnNames = new String[counts];
            // 给每个变量赋值(字段名称全部转换成小写)
            for (int i = 0; i < counts; i++) {
                columnNames[i] = rsmd.getColumnLabel(i + 1).toLowerCase();
            }
            // 变量ResultSet
            if (rs.next()) {
                T t = clazz.newInstance();
                // 反射, 从ResultSet绑定到JavaBean
                for (int i = 0; i < counts; i++) {

                    // 设置参数类型，此类型应该跟javaBean 里边的类型一样，而不是取数据库里边的类型
                    field = clazz.getDeclaredField(columnNames[i]);

                    // 这里是获取bean属性的类型
                    Class<?> beanType = field.getType();

                    // 根据 rs 列名 ，组装javaBean里边的其中一个set方法，object 就是数据库第一行第一列的数据了
                    Object value = rs.getObject(columnNames[i]);

                    if (value != null) {

                        // 这里是获取数据库字段的类型
                        Class<?> dbType = value.getClass();

                        // 处理日期类型不匹配问题
                        if (dbType == java.sql.Timestamp.class && beanType == java.util.Date.class) {
                            // value = new
                            // java.util.Date(rs.getTimestamp(columnNames[i]).getTime());
                            value = new java.util.Date(((java.sql.Timestamp) value).getTime());
                        }
                        // 处理double类型不匹配问题
                        if (dbType == java.math.BigDecimal.class && beanType == double.class) {
                            // value = rs.getDouble(columnNames[i]);
                            value = new Double(value.toString());
                        }
                        // 处理int类型不匹配问题
                        if (dbType == java.math.BigDecimal.class && beanType == int.class) {
                            // value = rs.getInt(columnNames[i]);
                            value = new Integer(value.toString());
                        }
                    }

                    String setMethodName = "set" + firstUpperCase(columnNames[i]);
                    // 第一个参数是传进去的方法名称，第二个参数是 传进去的类型；
                    Method m = t.getClass().getMethod(setMethodName, beanType);

                    // 第二个参数是传给set方法数据；如果是get方法可以不写
                    m.invoke(t, value);
                }
                obj = t;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return obj;
    }
}