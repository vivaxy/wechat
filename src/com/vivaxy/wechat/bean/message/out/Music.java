package com.vivaxy.wechat.bean.message.out;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 14:21
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.out
 */
public class Music extends Message {//回复音乐消息
    private Music_ Music;

    public Music() {
        super();
        super.setMsgType("music");
    }

    public Music_ getMusic() {
        return Music;
    }

    public void setMusic(Music_ music) {
        Music = music;
    }
}
