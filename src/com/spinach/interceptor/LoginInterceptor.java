package com.spinach.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	private HttpServletRequest request;
	private HttpSession session;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		if(session.getAttribute("customer") != null){
			return invocation.invoke();
		} else {
			return "relogin";
		}
	}
	
}
