package com.ujiuye.prometion.utils;

import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.service.EmployeeService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private EmployeeService employeeService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//       获取uri
        String uri=request.getRequestURI();
        String[] openURI={"js","img","images","fonts","css","auth","/WEB-INF/html/"};
        for (String openuri : openURI) {//只要uri中包括一个数据就行
            if (uri.contains(openuri)){
               return true;
            }
        }
//        uri被拦截，判断有没有登录
        Object login_user = request.getSession().getAttribute("LOGIN_USER");
        if (login_user!= null){
            return true;
        }
//        没有登录，查看Cooike，看之前是否存了cooike，有cookie就登录
        String username=null;
        Cookie[] cookies=request.getCookies();
        if (cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("username")){
                    username=cookie.getValue();
                }
            }
        }
//        判断有没有找到username
        if (username!=null){
            Employee employee = employeeService.getByUserName(username);
            request.getSession().setAttribute("LOGIN_USER",employee);
            return true;
        }
//        跳转到登录页面
        response.sendRedirect("/auth/tologin");

        return false;
    }

}
