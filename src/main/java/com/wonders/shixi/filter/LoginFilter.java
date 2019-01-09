package com.wonders.shixi.filter;

import com.wonders.shixi.pojo.Reader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器
 *
 * @author 邱家锦
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Reader user = (Reader) session.getAttribute("reader");
        String uri = request.getRequestURI().toString();
        if(uri.equals("/login.jsp")||uri.equals("/register.jsp")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        //自动登录
        boolean isRedirect=false;
        switch (user.getRole()) {
            case 2:
                break;
            case 1:
                if (uri.equals("/index.jsp") ||uri.equals(request.getContextPath()+"/")) {
                    response.sendRedirect(request.getContextPath() + "/admin.jsp");
                    isRedirect=true;
                }
                break;
            case 0:
                if (uri.equals("/admin.jsp")) {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                    isRedirect=true;
                }
                break;
        }
        if(!isRedirect){
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
