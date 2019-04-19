package cn.ziming.my.shop.service.impl;

import cn.ziming.my.shop.commons.context.SpringContext;
import cn.ziming.my.shop.dao.UserDao;
import cn.ziming.my.shop.entity.User;
import cn.ziming.my.shop.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    // 注入
    private UserDao userDao = new SpringContext().getBean("userDao");

    @Override
    public User login(String email, String pwd) throws SQLException {
        // SpringContext springContext = new SpringContext();
        // UserDao userDao = (UserDao) springContext.getBean("userDao");

        // User qurireUser = new User(email, pwd);
        // UserDao userDao = new UserDaoImpl();
        // User user = null;
        // try {
        //     user = userDao.quireUserByUid(qurireUser);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        return userDao.quireUserByUid(new User(email, pwd));
    }

    public void sayHi()  {
        System.out.println("Hello spring");
    }

    public static void main(String[] args) {
    }
}
