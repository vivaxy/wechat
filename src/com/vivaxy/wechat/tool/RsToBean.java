package com.vivaxy.wechat.tool;

import com.vivaxy.wechat.bean.MysqlData;

/**
 * Author : vivaxy
 * Date   : 2014/7/24 8:49
 * Project: wechat
 * Package: com.vivaxy.wechat.tool
 */
public class RsToBean {
    LogUtil log = new LogUtil();

    public static void main(String[] args) throws Exception {
        MysqlData md = new MysqlData();
        BeanUtil<MysqlData> bu = new BeanUtil<MysqlData>();
        bu.set(md);
    }
}
