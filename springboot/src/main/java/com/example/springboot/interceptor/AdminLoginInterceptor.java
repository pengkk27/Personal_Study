package com.example.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            HttpSession session = request.getSession();
            String account = (String) session.getAttribute("admin");
            if (account != null) {
                return true;
            }
            response.sendRedirect("/adminLogin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
