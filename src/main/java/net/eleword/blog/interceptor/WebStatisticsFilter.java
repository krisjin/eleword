package net.eleword.blog.interceptor;

import net.eleword.blog.entity.WebStatistics;
import net.eleword.blog.service.WebStatisticsService;
import net.eleword.blog.util.HttpUtils;
import net.eleword.blog.util.SpringContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
public class WebStatisticsFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getServletPath().lastIndexOf("htm") != -1 && !req.getServletPath().startsWith("/admin")) {
            String ip = HttpUtils.getIp(req);
            String url = HttpUtils.getBasePath(req) + req.getServletPath();
            Date date = new Date();

            WebStatisticsService wss = SpringContextHolder.getBean("webStatisticsService");
            WebStatistics ws = new WebStatistics(ip, url, date);
            wss.add(ws);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {

    }

}

