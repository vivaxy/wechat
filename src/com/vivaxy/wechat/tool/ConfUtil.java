package com.vivaxy.wechat.tool;

import com.thoughtworks.xstream.XStream;
import com.vivaxy.wechat.bean.Configuration;

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

    private Configuration conf;

    private String confPath;

    public ConfUtil() {
        this.confPath = this.getClass().getClassLoader().getResource("conf.xml").getPath();
        try {
            File file = new File(this.confPath);
            XStream xstream = new XStream();
            xstream.alias("xml", Configuration.class);
            FileInputStream fis = new FileInputStream(file);
            this.conf = (Configuration) xstream.fromXML(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getConfPath() {
        return confPath;
    }

    public Configuration getConf() {
        return conf;
    }
}