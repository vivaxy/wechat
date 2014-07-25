package com.vivaxy.wechat.tool;

import com.vivaxy.wechat.bean.RobotSays;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : vivaxy
 * Date   : 2014/7/23 15:12
 * Project: wechat
 * Package: com.vivaxy.wechat.tool
 */
public class MysqlUtil {
    Connection conn;

    String host;
    String port;
    String username;
    String password;
    String databaseName;

    public void start() {
        ConfUtil conf = new ConfUtil();
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

    public List<RobotSays> select() {
        List<RobotSays> list = new ArrayList<RobotSays>();
        BeanUtil<RobotSays> bu = new BeanUtil<RobotSays>();
        try {
            String sql = "select * from test";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                RobotSays robotSays = new RobotSays();
                bu.set(robotSays, rs);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(String ask, String answer) {
        try {
            String sql = "insert into test(ask, answer) VALUES(?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ask);
            pst.setString(2, answer);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void end() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
