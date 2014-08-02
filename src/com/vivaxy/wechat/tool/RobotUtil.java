package com.vivaxy.wechat.tool;

import com.vivaxy.wechat.bean.RobotSays;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 15:35
 * Project: wechat
 * Package: com.vivaxy.wechat.tool
 */
public class RobotUtil {
    public String reply(String input) {
        input = input.trim();
        if (input.startsWith("问 ") && input.contains(" 答 ")) {
            String[] list = input.split(" 答 ");
            if (list.length == 2) {//teach
                String ask = list[0].substring(2, list[0].length()).trim();
                String answer = list[1].trim();
                if (!ask.equals("") && !answer.equals("")) {
                    teach(ask, answer);
                    return "学会了，现在问我" + ask + "试试看~";
                }
            }
            return "回复帮助查看帮助。";
        } else {//answer
            MysqlUtil mu = new MysqlUtil();
            mu.start();
            List<RobotSays> robotList = mu.select();
            List<RobotSays> answerList = new ArrayList<RobotSays>();
            for (RobotSays rs : robotList) {
                if (rs.getAsk().equals(input)) {
                    answerList.add(rs);
                }
            }
            if (answerList.size() != 0) {
                int random = (int) Math.floor(Math.random() * answerList.size());
                RobotSays answer = answerList.get(random);
                mu.updateUse(answer.getUsed(), answer.getId());
                mu.end();
                return answer.getAnswer();
            }
            mu.end();
            return "没有人教过我怎么回答这个问题TAT~\n回复帮助查看帮助。";
        }
    }

    private void teach(String ask, String answer) {
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
