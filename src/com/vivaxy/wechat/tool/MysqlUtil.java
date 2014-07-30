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
            String sql = "select * from robot";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                RobotSays robotSays = new RobotSays();
                robotSays = bu.set(robotSays, rs);
                list.add(robotSays);
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
            String sql = "insert into robot(created, used, taught, ask, answer, isValid) VALUES(NOW(), 0, 1, ?, ?, 1)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ask);
            pst.setString(2, answer);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUse(int used, int id) {
        try {
            String sql = "update robot set lastUsed = NOW(), used = ? where id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, used + 1);
            pst.setInt(2, id);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTaught(int taught, int id) {
        try {
            String sql = "update robot set taught = ? where id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, taught + 1);
            pst.setInt(2, id);
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
