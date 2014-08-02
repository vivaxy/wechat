package com.vivaxy.wechat.tool;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.vivaxy.wechat.bean.RobotSays;
import com.vivaxy.wechat.bean.message.in.Message;
import com.vivaxy.wechat.bean.message.in.MsgType;
import com.vivaxy.wechat.bean.message.out.Item;
import com.vivaxy.wechat.bean.message.out.News;
import com.vivaxy.wechat.bean.message.out.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 15:35
 * Project: wechat
 * Package: com.vivaxy.wechat.tool
 */
public class RobotUtil {
    public String replyMsg(String xml) {
        LogUtil log = new LogUtil();
//        将xml内容转换为InputMessage对象
        XStream xs = new XStream(new DomDriver());
        //一定要alias啊
        xs.alias("xml", Message.class);
        Message inputMsg = (Message) xs.fromXML(xml);
//        取得消息类型
        String msgType = inputMsg.getMsgType();
        //根据消息类型获取对应的消息内容
        if (msgType.equals(MsgType.Text.toString())) {
            String inputContent = inputMsg.getContent();
            log.put("inputContent", inputContent);
            if (inputContent.equals("游戏")) {
                return replyNews(inputMsg.getFromUserName(), inputMsg.getToUserName());
            }
            return replyText(robotReply(inputContent), inputMsg.getFromUserName(), inputMsg.getToUserName());
        }
        if (msgType.equals(MsgType.Event.toString())) {
            if (inputMsg.getEvent().equals("subscribe"))
                return replyText("欢迎关注维瓦克西微信公众号。\n回复帮助查看帮助。", inputMsg.getFromUserName(), inputMsg.getToUserName());
        }
        return " ";
    }

    public String replyNews(String ToUserName, String FromUserName) {
        News replyMsg = new News();
        replyMsg.setToUserName(ToUserName);
        replyMsg.setFromUserName(FromUserName);
        replyMsg.setArticleCount(1L);
        Item item = new Item();
        item.setPicUrl("http://himg.bdimg.com/sys/portrait/item/c618766976617879a706.jpg");
        item.setDescription("点击进入游戏");
        item.setTitle("弱智游戏");
        item.setUrl("http://vivaxy.github.io/wechat/web/index.html?openid=" + ToUserName);
        replyMsg.add(item);
        XStream xstream = new XStream();
        xstream.alias("xml", News.class);
        xstream.alias("item", Item.class);
        return xstream.toXML(replyMsg);
    }

    private String replyText(String replyContent, String ToUserName, String FromUserName) {
        Text replyMsg = new Text();
        replyMsg.setContent(replyContent);
        replyMsg.setToUserName(ToUserName);
        replyMsg.setFromUserName(FromUserName);
        XStream xstream = new XStream();
        xstream.alias("xml", Text.class);
        return xstream.toXML(replyMsg);
    }

    private String robotReply(String input) {
        input = input.trim();
        if (input.startsWith("问 ") && input.contains(" 答 ")) {
            String[] list = input.split(" 答 ");
            if (list.length == 2) {//teach
                String ask = list[0].substring(2, list[0].length()).trim();
                String answer = list[1].trim();
                if (!ask.equals("") && !answer.equals("")) {
                    teachRobot(ask, answer);
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

    private void teachRobot(String ask, String answer) {
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
