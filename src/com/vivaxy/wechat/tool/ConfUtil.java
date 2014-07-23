package com.vivaxy.wechat.tool;

import com.thoughtworks.xstream.XStream;
import com.vivaxy.wechat.object.Conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 9:07
 * Project: wechat
 * Package: com.vivaxy.wechat.tool
 */
public class ConfUtil {

    private String confPath;

    public ConfUtil() {
        String classesPath = this.getClass().getClassLoader().getResource(File.separator).getPath();
        this.confPath = classesPath + "conf.xml";
    }

    public String getConfPath() {
        return confPath;
    }

    public String getWechatToken() {
        String WechatToken = null;
        try {
            File file = new File(confPath);
            XStream xstream = new XStream();
            xstream.alias("xml", Conf.class);
            FileInputStream fis = new FileInputStream(file);
            Conf conf = (Conf) xstream.fromXML(fis);
            WechatToken = conf.getWechatToken();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return WechatToken;
    }

}