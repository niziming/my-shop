package cn.ziming.my.shop.web.interceptor;

import cn.ziming.my.shop.commons.constant.ConstantUtils;
import cn.ziming.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 以login结尾的请求
        if (modelAndView.getViewName().endsWith("login")){
            User user = (User) request.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (user != null){
                response.sendRedirect("/main");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
