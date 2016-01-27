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
	
	//ͨ��springע��
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
	
	//��ȡcookkie
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
	
	//����cookie
	protected void saveCookie(String name, String value, int maxAge)
	{
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
}
