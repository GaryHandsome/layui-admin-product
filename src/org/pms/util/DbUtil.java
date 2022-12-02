package org.pms.util;

import java.sql.*;

/**
 * 连接数据库的工具类
 *
 * @author zqx
 * @date 2022-12-02
 */
public class DbUtil {
    /**
     * 帐号
     */
    private static final String USERNAME = "root";
    /**
     * 密码
     */
    private static final String PASSWORD = "root";

    /**
     * 连接地址（服务器+数据库）
     */
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/layui_admin?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";

    /**
     *  驱动程序 : JDBC接口的实现 ，由数据库厂商提供
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    // 静态代码块 : 加载驱动程序
    static {
        // 第二：加载驱动程序
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动程序失败");
            e.printStackTrace();
        }
    }

    /**
     * 返回连接对象 - 建立连接数据库的桥梁
     * alt + enter
     */
    public static Connection getConnection() {
        // 第三：连接数据库，并返回连接对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("获取连接对象失败");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库对象，释放资源
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("关闭结果集对象失败");
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("关闭语句对象失败");
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭连接失败");
                e.printStackTrace();
            }
        }
    }

    /**
     * 定义主方法，测试是否连接成功
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(DbUtil.getConnection());
    }
}
