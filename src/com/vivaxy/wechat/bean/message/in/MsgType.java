package com.vivaxy.wechat.bean.message.in;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 8:53
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.msg
 */
public enum MsgType {

    Text("text"),
    Image("image"),
    Music("music"),
    Video("video"),
    Voice("voice"),
    Location("location"),
    Link("link"),
    Event("event");
    private String msgType;

    MsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return msgType;
    }
}
