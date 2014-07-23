package com.vivaxy.wechat.bean.message.out;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 14:14
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.out
 */
public class Voice extends Message {//回复语音消息

    private Voice_ Voice;

    public Voice() {
        super();
        super.setMsgType("voice");
    }

    public Voice_ getVoice() {
        return Voice;
    }

    public void setVoice(Voice_ voice) {
        Voice = voice;
    }
}
