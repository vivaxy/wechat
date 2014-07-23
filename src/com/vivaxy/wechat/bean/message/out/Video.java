package com.vivaxy.wechat.bean.message.out;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 14:18
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.out
 */
public class Video extends Message {//回复视频消息
    private Video_ Video;

    public Video() {
        super();
        super.setMsgType("video");
    }

    public Video_ getVideo() {
        return Video;
    }

    public void setVideo(Video_ video) {
        Video = video;
    }
}
