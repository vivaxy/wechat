package com.vivaxy.wechat.object.message;

import com.vivaxy.wechat.object.msg.Message;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 8:54
 * Project: wechat
 * Package: com.vivaxy.wechat.object.message
 */
public class Text extends Message {

    private String Content;//文本消息内容

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
