package org.pms.util;

import java.sql.*;

/**
 * 连接数据库的工具类
 *
 * @author zqx
 * @date 2022-12-02
 */
public class DbUtil4MsSql {
    /**
     * 连接驱动程序
     */
    private static final String DRIVER = "net.sourceforge.jtds.jdbc.Driver";
    /**
     * 连接URL
     */
    private static final String URL = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=layui_admin";
    /**
     * 帐号
     */
    private static final String USER = "sa";
    /**
     * 密码
     */
    private static final String PASS = "123";

    static {
        /*
         * 加载驱动程序
         */
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动程序失败...");
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象 -- Java程序 与 数据库之间的桥梁
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("获取连接对象失败...");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭相关的 JDBC 对象
     *
     * DriverManager：驱动管理对象，获取连接对象
     *
     * DriverManager.getConnection(URL, USER, PASS);
     *
     * ResultSet：结果集对象 用于接收查询数据时，返回的结果
     *
     * Statement：语句对象 用于执行SQL语句（PreparedStatement、CallableStatement）
     * 增、删、改：executeUpdate() 查询：executeQuery()
     *
     *
     * Connection：连接对象 建立JAVA程序与数据库之间的桥梁
     *
     * @param rst
     * @param stmt 父类对象可以接收子类对象 - 多态
     * @param conn
     */
    public static void close(Connection conn,Statement stmt,ResultSet rst) {
        if (rst != null) {
            try {
                rst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 定义主方法，测试是否连接成功
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(DbUtil4MsSql.getConnection());
    }
}
