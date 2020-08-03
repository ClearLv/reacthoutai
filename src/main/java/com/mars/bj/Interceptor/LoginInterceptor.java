package com.mars.bj.Interceptor;

import com.mars.bj.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变，shiro 验证失败
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        Subject subject = SecurityUtils.getSubject();
        // 使用 shiro 验证
        if (!subject.isAuthenticated()) {
            return false;
        }
        return true;


        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变，shiro 验证失败
//        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
//            response.setStatus(HttpStatus.NO_CONTENT.value());
//            return true;
//        }
//        Subject subject = SecurityUtils.getSubject();
//        if(!subject.isAuthenticated() && !subject.isRemembered()){
//            return false;
//        }
//        return true;


//        HttpSession session = request.getSession();
//        String contextPath = session.getServletContext().getContextPath();
//        System.out.println("context====>" + contextPath);
//        String url = request.getRequestURI();
//        System.out.println("url====>" + url);
//        url = StringUtils.remove(url ,contextPath+"/");
//        String page = url;
//        System.out.println(page);
//        String requirePages [] = new String[] {"index"};
//
//        if(begingWith(page , requirePages)){
//            User user = (User) session.getAttribute("user");
//            if(user == null){
//                response.sendRedirect("login");
//                return false;
//            }
//        }
//        return true;
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
