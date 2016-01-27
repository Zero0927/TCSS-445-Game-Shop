package action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import service.ServiceManager;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport
implements ServletRequestAware, ServletResponseAware {
	
	protected ServiceManager serviceManager;
	protected Map<String, String> cookies;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	//通过spring注入
	public void setServiceManager(ServiceManager serviceManager)
	{
		this.serviceManager = serviceManager;
	}

	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}
	
	//获取cookkie
	protected String getCookieValue(String name)
	{
		Cookie cookies[] = request.getCookies();
		if (cookies != null)
		{
			for (Cookie cookie : cookies)
			{
				if (!cookie.getName().equals(name))
					continue;
				return cookie.getValue();
			}
		}
		return null;
	}
	
	//保存cookie
	protected void saveCookie(String name, String value, int maxAge)
	{
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
}
