
package net.eleword.blog.interceptor;

import net.eleword.blog.action.LoginAction;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
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
		
		Action action =(Action)invocation.getAction();
		
		if(action instanceof LoginAction){
			return invocation.invoke();
		}
		
		if(invocation.getInvocationContext().getSession().get("USER_SESSION")==null){
			System.out.println("session out");
			return "loginPage";
		}
		return invocation.invoke();
	}

}

