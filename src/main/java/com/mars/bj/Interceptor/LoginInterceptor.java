package com.mars.bj.Interceptor;

import com.mars.bj.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        System.out.println("context====>" + contextPath);
        String url = request.getRequestURI();
        System.out.println("url====>" + url);
        url = StringUtils.remove(url ,contextPath+"/");
        String page = url;
        System.out.println(page);
        String requirePages [] = new String[] {"index"};

        if(begingWith(page , requirePages)){
            User user = (User) session.getAttribute("user");
            if(user == null){
                response.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    private boolean begingWith(String page , String [] requirePages){
        boolean result = false;
        for(String rePage : requirePages){
            if(rePage == page){
                result = true;
            }
        }
        return  result;
    }
}
