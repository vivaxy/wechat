package com.vivaxy.wechat.bean;

/**
 * Author : vivaxy
 * Date   : 2014/7/24 8:15
 * Project: wechat
 * Package: com.vivaxy.wechat.bean
 */
public class MysqlData {

    private Integer id;
    private Long created;
    private Long updated;
    private Long lastused;
    private Integer used;
    private Integer teached;
    private String ask;
    private String answer;
    private Integer isValid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Long getLastused() {
        return lastused;
    }

    public void setLastused(Long lastused) {
        this.lastused = lastused;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getTeached() {
        return teached;
    }

    public void setTeached(Integer teached) {
        this.teached = teached;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
