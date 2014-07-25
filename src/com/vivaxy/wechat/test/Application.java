package com.vivaxy.wechat.test;

import com.vivaxy.wechat.tool.MysqlUtil;

/**
 * Author : vivaxy
 * Date   : 2014/7/25 14:42
 * Project: wechat
 * Package: com.vivaxy.wechat.test
 */
public class Application {

    public static void main(String[] args) throws Exception {
        MysqlUtil mu = new MysqlUtil();
        mu.start();
        mu.insert("我觉得舒服", "肯定很高");
        mu.end();
    }
}
