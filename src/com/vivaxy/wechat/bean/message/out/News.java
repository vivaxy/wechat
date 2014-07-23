package com.vivaxy.wechat.bean.message.out;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 14:24
 * Project: wechat
 * Package: com.vivaxy.wechat.bean.message.out
 */
public class News extends Message {//回复图文消息
    private Long ArticleCount;//图文消息个数，限制为10条以内
    private List Articles = new ArrayList();//多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应

    public News() {
        super();
        super.setMsgType("news");
    }

    public Long getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Long articleCount) {
        ArticleCount = articleCount;
    }

    public void add(Item item) {
        this.Articles.add(item);
    }

    public List getContent() {
        return this.Articles;
    }
}
