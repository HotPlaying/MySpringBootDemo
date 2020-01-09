package com.training.mysites;

import com.training.mysites.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserIntercepter implements HandlerInterceptor {
    String[] res = {".js", ".css", ".htm", "/login", "/error", "jpg", "gif", "png"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();
        for (String s : res) {
            if (path.endsWith(s)) {
                return HandlerInterceptor.super.preHandle(request, response, handler);
            }
        }
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user==null || user.getUid()==null ||user.getUid()<=0) {
            //转向登录页面
            response.sendRedirect("/login");
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
