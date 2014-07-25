package com.vivaxy.wechat.tool;

import com.vivaxy.wechat.bean.RobotSays;

import java.util.List;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 15:35
 * Project: wechat
 * Package: com.vivaxy.wechat.tool
 */
public class RobotUtil {
    public String Reply(String input) {
        input = input.trim();
        if (input.startsWith("--ask")) {// teach
            String[] list = input.split("--");
            if (list[1].startsWith("ask") && list[2].startsWith("answer")) {
                String ask = list[1].substring(3, list[1].length());
                String answer = list[2].substring(6, list[2].length());
                Teach(ask, answer);
                return "哦，懂了！";
            }
        }
        if (input.equals("--help")) {// help
            return "输入--help获得帮助。\n输入--ask问题--answer答案，教我怎么回答你的问题。";
        }
        // answer
        MysqlUtil mu = new MysqlUtil();
        mu.start();
        List<RobotSays> robotList = mu.select();
        for (RobotSays rs : robotList) {
            if (rs.getAsk().equals(input)) {
                mu.updateUse(rs.getUsed(), rs.getId());
                return rs.getAnswer();
            }
        }
        mu.end();
        return null;
    }

    private void Teach(String ask, String answer) {
        int count = 0;
        MysqlUtil mu = new MysqlUtil();
        LogUtil log = new LogUtil();
        mu.start();
        List<RobotSays> robotList = mu.select();
        for (RobotSays rs : robotList) {
            if (rs.getAsk().equals(ask) && rs.getAnswer().equals(answer)) {
                mu.updateTaught(rs.getTaught(), rs.getId());
                count = count + 1;
            }
        }
        if (count == 0) mu.insert(ask, answer);
        if (count > 1) log.put("ERROR", "SAME ASK - ANSWER EXISTS.");
        mu.end();
    }
}
