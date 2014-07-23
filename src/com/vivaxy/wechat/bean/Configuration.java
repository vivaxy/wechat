package com.vivaxy.wechat.bean;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 9:06
 * Project: wechat
 * Package: com.vivaxy.wechat.bean
 */
public class Configuration {

    private String WechatToken;
    private String MysqlHost;
    private String MysqlPort;
    private String MysqlUsername;
    private String MysqlPassword;
    private String MysqlDatabaseName;

    public String getWechatToken() {
        return WechatToken;
    }

    public void setWechatToken(String weinxintoken) {
        this.WechatToken = weinxintoken;
    }

    public String getMysqlHost() {
        return MysqlHost;
    }

    public void setMysqlHost(String mysqlHost) {
        MysqlHost = mysqlHost;
    }

    public String getMysqlPort() {
        return MysqlPort;
    }

    public void setMysqlPort(String mysqlPort) {
        MysqlPort = mysqlPort;
    }

    public String getMysqlUsername() {
        return MysqlUsername;
    }

    public void setMysqlUsername(String mysqlUsername) {
        MysqlUsername = mysqlUsername;
    }

    public String getMysqlPassword() {
        return MysqlPassword;
    }

    public void setMysqlPassword(String mysqlPassword) {
        MysqlPassword = mysqlPassword;
    }

    public String getMysqlDatabaseName() {
        return MysqlDatabaseName;
    }

    public void setMysqlDatabaseName(String mysqlDatabaseName) {
        MysqlDatabaseName = mysqlDatabaseName;
    }
}
