package com.vivaxy.wechat.object.message;

import com.vivaxy.wechat.object.msg.Message;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 8:54
 * Project: wechat
 * Package: com.vivaxy.wechat.object.message
 */
public class Image extends Message {

    private String PicUrl;//图片链接
    private String MediaId;//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

}
