package cn.ziming.my.shop.dao.impl;

import cn.ziming.my.shop.dao.UserDao;
import cn.ziming.my.shop.entity.User;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void quireUserByUid() {
        User user = new User("ziming@admin.com","admin");
        UserDao userDao = new UserDaoImpl();
        User user1 = null;
        try {
            user1 = userDao.quireUserByUid(user);
            System.out.println(user1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}