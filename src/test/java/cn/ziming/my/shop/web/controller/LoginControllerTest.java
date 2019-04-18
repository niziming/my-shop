package cn.ziming.my.shop.web.controller;

import cn.ziming.my.shop.commons.context.SpringContext;
import cn.ziming.my.shop.entity.User;
import cn.ziming.my.shop.service.UserService;
import org.junit.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LoginControllerTest extends HttpServlet {
    @Test
    public void doPost() {
        SpringContext springContext = new SpringContext();
        UserService userService = (UserService) springContext.getSpringBean("userService");
        try {
            User login = userService.login("ziming@admin.com", "admin");
            System.out.println(login);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}