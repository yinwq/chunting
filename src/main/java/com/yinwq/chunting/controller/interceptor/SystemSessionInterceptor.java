package com.yinwq.chunting.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/3/18 9:50
 */
public class SystemSessionInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        ServletContext application = session.getServletContext();
        //未登录跳转登录页
        if(session.getAttribute("user") == null){
           /* PrintWriter out = response.getWriter();
            StringBuffer sb = new StringBuffer("<script type=\"text/javascript\" charset=\"UTF-8\">");
            sb.append("alert(\"你的账号被挤掉，或者没有登录，或者页面已经过期，请重新登录\")");
            sb.append("window.location.href='/login/toLogin.jhtml';");
            sb.append("</script>");
            out.print(sb.toString());
            out.close();*/
            response.sendRedirect("/login/toLogin.jhtml");
            return false;
        }else{    //已经登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
