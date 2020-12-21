package com.zhixi.util;

import java.sql.*;

/**
 * @author zhangzhixi
 */
public class DBManger {
    static String url = "jdbc:mysql://localhost:3306/demo";
    static String user = "root";
    static String password = "zhixi158";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {


        Connection con = DriverManager.getConnection(url, user, password);
        return con;


    }

    public static void dbClose1(Statement st, Connection con) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    /**关闭资源*/
    public static void dbClose(ResultSet rs, Statement st, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        dbClose1(st, con);
    }
}
