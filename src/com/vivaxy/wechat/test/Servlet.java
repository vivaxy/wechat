package com.vivaxy.wechat.test;

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
public class Servlet extends HttpServlet {
    LogUtil log = new LogUtil();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");//设置返回值编码

    }
}