package com.spinach.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

public class ResultMessage extends StrutsResultSupport  {
	private static final long serialVersionUID = -5046390384916067270L;

	//private static Logger log = Logger.getLogger(ResultMessage.class);

	protected boolean prependServletContext = true;

	public ResultMessage() {
		super();
	}

	public ResultMessage(String location) {
		super(location);
	}

	public void setPrependServletContext(boolean prependServletContext) {
		this.prependServletContext = prependServletContext;
	}

	private static boolean isPathUrl(String url) {
		return (url.indexOf(':') == -1);
	}

	protected void doExecute(String finalLocation, ActionInvocation invocation)
			throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
		
		if (isPathUrl(finalLocation)) {
			if (!finalLocation.startsWith("/")) {
				String namespace = invocation.getProxy().getNamespace();
				if ((namespace != null) && (namespace.length() > 0)
						&& (!"/".equals(namespace))) {
					finalLocation = namespace + "/" + finalLocation;
				} else {
					finalLocation = "/" + finalLocation;
				}
			}
			if (prependServletContext && (request.getContextPath() != null)
					&& (request.getContextPath().length() > 0)) {
				finalLocation = request.getContextPath() + finalLocation;
			}
			finalLocation = response.encodeRedirectURL(finalLocation);
		}

		finalLocation = finalLocation.replace(",", "&");
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter out = response.getWriter();
		StringBuffer buffer = new StringBuffer();
		String message = "update success";
		boolean showalert = true;
		if(invocation.getResultCode().equalsIgnoreCase(ActionSupport.SUCCESS)) {
			message = "Update success";
		}
		else if(invocation.getResultCode().equalsIgnoreCase("successsave")) {
			message = "Add success";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("successdelete")) {
			message = "Delete success";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("uneditable")) {
        	message = "View only record";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("successlogin")) {
        	message = "Login Success";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("successlogout")) {
        	message = "Logout Success";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("sent")) {
        	message = "Password has been sent to your email.";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("exist")) {
        	message = "Already existed at least 1";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("fail")) {
        	message = "Data not found";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("error")) {
        	message = "Wrong account data";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("passworderror")) {
        	message = "Wrong Password";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("cartempty")) {
        	message = "No items in the cart";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("relogin")) {
        	message = "You have logged out";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("login-admin")) {
        	message = "Please login as Administrator";
		}
        else if(invocation.getResultCode().equalsIgnoreCase("deleteusererror")) {
        	message = "This user already has order records";
		}
		
		buffer.append("<script type=\"text/javascript\">");
		if(showalert) {
			   buffer.append("alert('" + message + "');");
		}
		buffer.append("location='" + finalLocation + "';");
		buffer.append("</script>");
		String s = buffer.toString();
		//if (log.isDebugEnabled()) {
		//	log.debug(s);
		//}
		out.println(s);
		out.flush();
		out.close();

	}
}
