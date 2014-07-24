package com.vivaxy.wechat.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 9:08
 * Project: wechat
 * Package: com.vivaxy.wechat.tool
 */
public class LogUtil {
    public <T> void put(String tag, T message) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String time = df.format(new Date());
        String project = "wechat";
        if (message == null) {
            System.out.println(time + " [" + project + "] [" + tag + "] ");
        } else {
            System.out.println(time + " [" + project + "] [" + tag + "] " + message.toString());
        }
    }
}