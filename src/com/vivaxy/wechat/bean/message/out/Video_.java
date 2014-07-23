package com.vivaxy.wechat.bean.message.out;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 14:19
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.out
 */
public class Video_ {
    private String MediaId;//通过上传多媒体文件，得到的id
    private String Title;//视频消息的标题
    private String Description;//视频消息的描述

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
