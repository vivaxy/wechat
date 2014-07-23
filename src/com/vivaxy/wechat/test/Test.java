package com.vivaxy.wechat.test;

import com.thoughtworks.xstream.XStream;
import com.vivaxy.wechat.object.Conf;
import com.vivaxy.wechat.tool.LogUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 9:10
 * Project: wechat
 * Package: com.vivaxy.wechat.test
 */
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        LogUtil log = new LogUtil();
        response.setCharacterEncoding("UTF-8");//设置返回值编码
        String path = this.getClass().getClassLoader().getResource(File.separator).getPath();
        log.put("", path);
        File file = new File(path + "conf.xml");
        try {
            XStream xstream = new XStream();
            xstream.alias("xml", Conf.class);
            FileInputStream fis = new FileInputStream(file);
            Conf conf = (Conf) xstream.fromXML(fis);
            String WechatToken = conf.getWechatToken();
            log.put("", WechatToken);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.put("ERROR", "获取微信公众号的token");
            return;
        }
    }
}