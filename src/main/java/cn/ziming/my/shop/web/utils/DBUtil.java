package cn.ziming.my.shop.web.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;
    // 三大组件
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    static {
        try{
            InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            // 配置properties键值对
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            pwd = properties.getProperty("pwd");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        try {
            // 加载驱动
            Class.forName(driver);
            // 建立连接
            conn = DriverManager.getConnection(url, user, pwd);
            return conn;
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void getClose(){
        /*
        rs close
         */
        try{
            if(rs != null){
                rs.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        /*
        ps close
         */
        try{
            if(ps != null){
                ps.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        /*
        conn close
         */
        try{
            if(conn!=null){
                conn.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}