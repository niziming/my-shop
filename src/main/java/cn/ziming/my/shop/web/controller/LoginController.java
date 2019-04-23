package cn.ziming.my.shop.web.controller;

import cn.ziming.my.shop.commons.constant.ConstantUtils;
import cn.ziming.my.shop.entity.User;
import cn.ziming.my.shop.service.UserService;
import cn.ziming.my.shop.commons.utils.TimeStampUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class LoginController {

    // 自动装配器 根据类自动装配
    @Autowired
    private UserService userService;
    /**
     * 跳转登陆界面
     *
     * @return String
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登陆逻辑
     *handle
     * @param email 用户邮箱
     * @param pwd   密码
     * @return String
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    // @RequestParam(required = true) 为true时意思为不可缺省
    public String login(@RequestParam(required = true) String email, String pwd, HttpServletRequest request) throws SQLException {

        User user = userService.login(email, pwd);
        String timestamp = TimeStampUtil.getTimeFormat();

        //登录失败
        if (user == null) {
            request.setAttribute(ConstantUtils.LOGIN_FAILED_MSG, "用户名或密码错误!");
            return login();
        }
        //登陆成功
        else {
            // 将登录信息放入session
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            request.getSession().setAttribute(ConstantUtils.TIMESTAMP, timestamp);
            // 明日任务,获取域对象传送user信息
            return "redirect:/main";
        }
    }
}
