package com.vivaxy.wechat.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 15:12
 * Project: wechat
 * Package: com.vivaxy.wechat.tool
 */
public class Mysql {
    Connection conn;
    PreparedStatement pst;
    String host;
    String port;
    String username;
    String password;
    String databaseName;

    public void start() {
        Conf conf = new Conf();
        this.host = conf.getConf().getMysqlHost();
        this.port = conf.getConf().getMysqlPort();
        this.username = conf.getConf().getMysqlUsername();
        this.password = conf.getConf().getMysqlPassword();
        this.databaseName = conf.getConf().getMysqlDatabaseName();
        String driverName = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://";
        String serverName = host + ":" + port + "/";
        String connName = dbUrl + serverName + databaseName;

        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(connName, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String ask, String answer) {
        try {
            String sql = "insert into test(ask, answer) VALUES(?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ask);
            pst.setString(2, answer);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void end() {
        try {
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
