package com.vivaxy.wechat.test;

import com.vivaxy.wechat.tool.RobotUtil;

/**
 * Author : vivaxy
 * Date   : 2014/7/25 14:42
 * Project: wechat
 * Package: com.vivaxy.wechat.test
 */
public class Application {

    public static void main(String[] args) throws Exception {
        System.out.print(new RobotUtil().replyNews("1", "2"));
    }
}
