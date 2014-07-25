package com.vivaxy.wechat.bean;

/**
 * Author : vivaxy
 * Date   : 2014/7/24 8:15
 * Project: wechat
 * Package: com.vivaxy.wechat.bean
 */
public class RobotSays {

    private Integer id;
    private Long created;
    private Long updated;
    private Long lastUsed;
    private Integer used;
    private Integer taught;
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

    public Long getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Long lastUsed) {
        this.lastUsed = lastUsed;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getTaught() {
        return taught;
    }

    public void setTaught(Integer taught) {
        this.taught = taught;
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
