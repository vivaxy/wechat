package com.vivaxy.wechat.object.message;

import com.vivaxy.wechat.object.msg.Message;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 9:05
 * Project: wechat
 * Package: com.vivaxy.wechat.object.message
 */
public class Location extends Message {
    private String Location_X;//地理位置纬度
    private String Location_Y;//地理位置经度
    private Long Scale;//地图缩放大小
    private String Label;//地理位置信息

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public Long getScale() {
        return Scale;
    }

    public void setScale(Long scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

}
