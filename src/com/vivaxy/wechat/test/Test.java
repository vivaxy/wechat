package com.vivaxy.wechat.test;

import com.thoughtworks.xstream.XStream;
import com.vivaxy.wechat.bean.message.out.Item;
import com.vivaxy.wechat.bean.message.out.News;
import com.vivaxy.wechat.tool.LogUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 9:10
 * Project: wechat
 * Package: com.vivaxy.wechat.test
 */
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");//设置返回值编码
        TestNews();
    }

    public void TestNews() {
        LogUtil log = new LogUtil();
        News news = new News();
        Item item0 = new Item();
        item0.setPicUrl("setPicUrl0");
        item0.setDescription("setDescription0");
        item0.setTitle("setTitle0");
        item0.setUrl("setUrl0");
        Item item1 = new Item();
        item1.setPicUrl("setPicUrl1");
        item1.setDescription("setDescription1");
        item1.setTitle("setTitle1");
        item1.setUrl("setUrl1");
        news.add(item0);
        news.add(item1);
        news.setFromUserName("setFromUserName");
        news.setToUserName("setToUserName");
        news.setArticleCount(2L);
        XStream xstream = new XStream();
        xstream.alias("xml", News.class);
        xstream.alias("item", Item.class);
        log.put("", "\n" + xstream.toXML(news));
    }
}