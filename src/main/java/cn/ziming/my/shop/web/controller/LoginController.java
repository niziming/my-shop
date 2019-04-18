package cn.ziming.my.shop.web.controller;

import cn.ziming.my.shop.commons.context.SpringContext;
import cn.ziming.my.shop.entity.User;
import cn.ziming.my.shop.service.UserService;
import cn.ziming.my.shop.web.utils.TimeStampUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {
    // 注入
    private UserService userService = (UserService) new SpringContext().getSpringBean("userService");

    // @Override
    // protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //     try {
    //         User admin = userService.login("ziming@admin.com", "admin");
    //         System.out.println(admin);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 编码设置
        response.setCharacterEncoding("UTF-8");
        // SpringContext springContext = new SpringContext();
        // UserService userService = (UserService) springContext.getSpringBean("userService");

        // 前端传来的值
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        // 时间戳
        String timeStamp =  TimeStampUtil.getTimeFormat();
        // 创建一个session
        HttpSession session = request.getSession();

        /*
        使用注入
         */
        try {
            User user = userService.login(email, pwd);
            if (user == null) {
                request.setAttribute("msg", "用户名或密码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                session.setAttribute("user", user);
                request.setAttribute("timestamp", timeStamp);
                // 请求转发
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
        下面是没有使用注入的方法
         */
        // try {
        //     UserService userService = new UserServiceImpl();
        //     User user = userService.login(email, pwd);
        //     // 登陆失败的处理
        //     if (user == null) {
        //         request.getRequestDispatcher("/fail.jsp").forward(request, response);
        //     } else {
        //         session.setAttribute("user", user);
        //         session.setAttribute("timestamp", timeStamp);
        //         // 请求转发
        //         request.getRequestDispatcher("/success.jsp").forward(request, response);
        //     }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    }
}
