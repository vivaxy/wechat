package com.vivaxy.wechat.test;

import com.vivaxy.wechat.bean.RobotSays;
import com.vivaxy.wechat.tool.LogUtil;
import com.vivaxy.wechat.tool.MysqlUtil;

import java.util.List;

/**
 * Author : vivaxy
 * Date   : 2014/7/25 14:42
 * Project: wechat
 * Package: com.vivaxy.wechat.test
 */
public class Application {

    public static void main(String[] args) throws Exception {
        LogUtil log = new LogUtil();
        MysqlUtil mu = new MysqlUtil();
        mu.start();
        List<RobotSays> list = mu.select();
        mu.end();
    }
}
