package com.vivaxy.wechat.bean.message.out;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 11:11
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.out
 */
public class Text extends Message {//回复文本消息
    private String Content;//回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）

    public Text() {
        super();
        super.setMsgType("text");
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
