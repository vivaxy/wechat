package com.vivaxy.wechat.bean.message.out;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 13:29
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.out
 */
public class Image extends Message {//回复图片消息
    private Image_ Image;

    public Image() {
        super();
        super.setMsgType("image");
    }

    public Image_ getImage() {
        return Image;
    }

    public void setImage(Image_ image_) {
        this.Image = image_;
    }
}

