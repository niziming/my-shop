package cn.ziming.my.shop.web.utils;

import org.junit.Test;

import java.sql.*;

public class DBUtilTest {

    @Test
    public void getConn(){
        String sql = "select * from lg_user where uid = 1";

        Connection coon = DBUtil.getConn();
        System.out.println(coon);
        PreparedStatement ps= null;
        try {
            ps = coon.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()){
                String test = resultSet.getString("uname");
                System.out.println(test);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}