package net.eleword.blog.interceptor;

import net.eleword.blog.entity.User;
import net.eleword.blog.util.ConstantEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author krisjin
 * @date 2014-2-4上午7:05:46
 */
public class LoginFilter implements Filter {

    protected final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (request.getServletPath().indexOf("/admin/login.htm") != -1 || request.getServletPath().indexOf("/admin/signin.htm") != -1) {
            chain.doFilter(request, response);
            return;
        }

        User user = (User) request.getSession().getAttribute(ConstantEnum.USER_SESSION.toString());
        if (user == null) {
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
            response.sendRedirect(basePath + "/admin/login.htm");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }

}
