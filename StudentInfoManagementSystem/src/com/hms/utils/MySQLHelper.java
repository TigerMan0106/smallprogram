package com.hms.utils;

import java.sql.*;

public class MySQLHelper {
    private static final String DRIVER_CON = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/StudentInfoManagementSystem?useUnicode=true&useSSL=false&characterEncoding=utf8&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    static {
        try {
            Class.forName(DRIVER_CON);
        } catch (ClassNotFoundException e) {
            System.out.println("加载MySql驱动类失败!");
        }
    }
    /**
     * 	获得数据库的链接
     * @return
     */
    private Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接MySql数据库失败!");
        }
        return null;
    }

    /**
     * 	查询数据库
     * @param sql
     * @param param
     * @return
     */
    public ResultSet doQuery(String sql , Object ... param){
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null){
                pstat = conn.prepareStatement(sql);
                if (param != null){
                    for (int i = 0; i < param.length;i++){
                        pstat.setObject(i+1,param[i]);
                    }
                }
                rs = pstat.executeQuery();
                return rs;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 	更新数据库
     * @param sql
     * @param param
     * @return
     */
    public boolean doUpdate(String sql , Object ... param){
        Connection conn = null;
        PreparedStatement pstat = null;
        int result=0;
        try {
            conn = getConnection();
            if (conn != null){
                pstat = conn.prepareStatement(sql);
                if (param != null){
                    for (int i = 0; i < param.length;i++){
                        pstat.setObject(i+1,param[i]);
                    }
                }
                result=pstat.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (pstat != null){
                try {
                    pstat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result!=0;
    }
}
