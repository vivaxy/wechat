package com.vivaxy.wechat.bean.message.in;

import com.vivaxy.wechat.bean.message.out.Message;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 13:15
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.in
 */
public class Event extends Message {
    private String Event;//事件类型，subscribe(订阅)、unsubscribe(取消订阅)

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
