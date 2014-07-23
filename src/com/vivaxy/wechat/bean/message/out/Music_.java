package com.vivaxy.wechat.bean.message.out;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 14:23
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.out
 */
public class Music_ {
    private String Title;//音乐标题
    private String Description;//音乐描述
    private String MusicUrl;//音乐链接
    private String HQMusicUrl;//高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String ThumbMediaId;//缩略图的媒体id，通过上传多媒体文件，得到的id

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

    public String getMusicUrl() {
        return MusicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        MusicUrl = musicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
