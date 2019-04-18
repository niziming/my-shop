package cn.ziming.my.shop.service.impl;

import cn.ziming.my.shop.commons.context.SpringContext;
import cn.ziming.my.shop.dao.UserDao;
import cn.ziming.my.shop.entity.User;
import cn.ziming.my.shop.service.UserService;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserDao userDao = (UserDao) new SpringContext().getSpringBean("userDao");

    @Test
    public void login() throws SQLException {
        // SpringContext springContext = new SpringContext();
        // UserDao userDao = (UserDao) springContext.getSpringBean("userDao");
        User user = new User("Adss", "sadf");
        User user1 = userDao.quireUserByUid(user);
        System.out.println(user1);

        /*
        未使用注入
         */
        // UserService userService = new UserServiceImpl();
        // User loginFail= null;
        // try {
        //     loginFail = userService.login("nihao", "sadf");
        //     User loginAdmin = userService.login("ziming@admin.com", "admin");
        //     User loginUser = userService.login("user@user.com", "user");
        //     System.out.println(loginFail);
        //     System.out.println(loginAdmin);
        //     System.out.println(loginUser);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        //

    }
}