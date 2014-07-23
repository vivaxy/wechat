package com.vivaxy.wechat.bean.message.out;

import java.util.Date;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 11:14
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.out.main
 */
public class Message {
    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;

    public Message() {
        this.CreateTime = new Date().getTime();
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
