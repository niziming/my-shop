package cn.ziming.my.shop.web.controller;

import cn.ziming.my.shop.commons.context.SpringContext;
import cn.ziming.my.shop.entity.User;
import cn.ziming.my.shop.service.UserService;
import cn.ziming.my.shop.web.utils.CookieUtils;
import cn.ziming.my.shop.web.utils.TimeStampUtil;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@Controller
@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {
    // 注入
    private UserService userService = new SpringContext().getBean("userService");
    private final String COOKIE_NAME_INFO = "userInfo";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 记住我? 自动填充密码
        // String userInfo = CookieUtils.getCookieValue(req, COOKIE_NAME_INFO);
        // if (userInfo != null){
        //     String[] userInfoArray = userInfo.split(":");
        //     String email = userInfoArray[0];
        //     String pwd = userInfoArray[1];
        //     req.setAttribute("email", email);
        //     req.setAttribute("pwd", pwd);
        // }
        // req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 编码设置
        response.setCharacterEncoding("UTF-8");
        // SpringContext springContext = new SpringContext();
        // UserService userService = (UserService) springContext.getSpringBean("userService");

        // 前端传来的值
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        boolean isRemember = request.getParameter("isRemember") == null ? false : true;

        System.out.println(isRemember);

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
                if (isRemember){
                    // 用户信息存储一周
                    CookieUtils.setCookie(request, response, "COOKIE_NAME_INFO", String.format("%s:%s", email, pwd),7*24*60*60);
                }
                session.setAttribute("user", user);
                session.setAttribute("timestamp", timeStamp);
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
