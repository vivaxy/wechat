package com.vivaxy.wechat.object.msg;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 8:53
 * Project: wechat
 * Package: com.vivaxy.wechat.object.msg
 */
public enum MsgType {

    Text("text"),
    Image("image"),
    Music("music"),
    Video("video"),
    Voice("voice"),
    Location("location"),
    Link("link");
    private String msgType;

    MsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * @return the msgType
     */
    @Override
    public String toString() {
        return msgType;
    }
}
