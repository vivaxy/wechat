package com.vivaxy.wechat.servlet;

import com.vivaxy.wechat.tool.ConfUtil;
import com.vivaxy.wechat.tool.LogUtil;
import com.vivaxy.wechat.tool.RobotUtil;
import com.vivaxy.wechat.tool.Signature;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 8:51
 * Project: wechat
 * Package: com.vivaxy.wechat.servlet
 */
public class WechatApi extends HttpServlet {

    //    当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");//设置返回值编码
        response.setContentType("text/xml;charset=UTF-8");//设置返回格式为xml

//        接受消息
        StringBuilder xmlMsg = new StringBuilder();
        try {
            ServletInputStream inputStream = request.getInputStream();
//            将流转换为字符串
            byte[] b = new byte[4096];
            for (int n; (n = inputStream.read(b)) != -1; ) {
                xmlMsg.append(new String(b, 0, n, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        RobotUtil ru = new RobotUtil();
        LogUtil log = new LogUtil();
        log.put("PostMessage", "\n" + xmlMsg);
        String outputMsg = ru.replyMsg(xmlMsg.toString());
        log.put("outputMsg", "\n" + outputMsg);
//        输出返回值
        try {
            PrintWriter out = response.getWriter();
            out.write(outputMsg);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    开发者提交信息后，微信服务器将发送GET请求到填写的URL上
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        LogUtil log = new LogUtil();
        log.put("GetQueryString", request.getQueryString());
        response.setCharacterEncoding("UTF-8");//设置返回值编码
        Boolean result = false;//结果
//        获取参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
//        获取微信公众号的token
        String Token = new ConfUtil().getConf().getWechatToken();
//        传参为不为空
        if (signature != null && timestamp != null && nonce != null && echostr != null) {
//            1. 将token、timestamp、nonce三个参数进行字典序排序
            List<String> params = new ArrayList<String>();
            params.add(Token);
            params.add(timestamp);
            params.add(nonce);
            Collections.sort(params, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
//            2. 将三个参数字符串拼接成一个字符串进行sha1加密
            String sha1 = Signature.encode(params.get(0) + params.get(1) + params.get(2));
//            3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
            if (sha1.equals(signature)) result = true;
        }
//        输出返回值
        try {
            PrintWriter out = response.getWriter();
            if (result) out.write(echostr);
            else out.write("Got ya!");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}