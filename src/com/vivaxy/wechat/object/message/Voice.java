package com.vivaxy.wechat.object.message;

import com.vivaxy.wechat.object.msg.Message;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 9:05
 * Project: wechat
 * Package: com.vivaxy.wechat.object.message
 */
public class Voice extends Message {

    private String MediaId;//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String Format;//语音格式，如amr，speex等

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

}
