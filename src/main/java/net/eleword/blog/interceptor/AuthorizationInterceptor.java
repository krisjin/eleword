
package net.eleword.blog.interceptor;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-4上午7:05:46
 */
@Controller("loginInter")
public class AuthorizationInterceptor extends AbstractInterceptor  {

	public String intercept(ActionInvocation invocation) throws Exception {
		
		if(invocation.getInvocationContext().getSession().get("userId")==null){
			System.out.println("session out");
			return "loginPage";
		}
		System.out.println("-------------------------next");
		return invocation.invoke();
	}

}

