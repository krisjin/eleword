package net.eleword.blog.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.eleword.blog.entity.User;
import net.eleword.blog.util.ConstantEnum;

import org.apache.log4j.Logger;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-4上午7:05:46
 */
public class LoginFilter implements Filter {

	protected final Logger logger = Logger.getLogger(this.getClass());

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
