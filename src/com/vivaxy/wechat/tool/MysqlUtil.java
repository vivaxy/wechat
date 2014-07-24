package com.vivaxy.wechat.tool;

import com.vivaxy.wechat.bean.MysqlData;

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

    public List<MysqlData> select() {
        List<String[]> returnValue = new ArrayList<String[]>();
        try {
            String sql = "";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            rs.getObject(1);

            ResultSetMetaData rsmd = rs.getMetaData();
            rsmd.getColumnName(1);

            int columnCount = rsmd.getColumnCount();
            String listHead[] = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                listHead[i] = rsmd.getColumnLabel(i + 1);
            }
            returnValue.add(listHead);
            while (rs.next()) {
                String listItem[] = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    listItem[i] = rs.getString(i + 1);
                }
                returnValue.add(listItem);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
