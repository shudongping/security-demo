package com.imooc.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author shudp
 * @create 2017/12/8.
 */
//@Component
public class TimeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timefilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("timefilter start");
        long start = new Date().getTime();
        chain.doFilter(request,response);
        System.out.println("timefilter 耗时:" + (new Date().getTime() - start));
        System.out.println("timefilter end");
    }

    @Override
    public void destroy() {
        System.out.println("timefilter destroy");
    }
}
