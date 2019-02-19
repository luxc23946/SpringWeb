package hpe.lxc.ssh.servlet;

import hpe.lxc.ssh.beans.Person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public TestServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		//1. �� application ������еõ� IOC ����������
		//����ԭ����ServletContextListener���IOC����
//		ServletContext servletContext = getServletContext();
//		ApplicationContext ctx = (ApplicationContext) servletContext.getAttribute("ApplicationContext");
		
		
		
		//2.1�ֶ����������ȡ
        //ApplicationContext ctx=(ApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		

      //2.2����Springde ServletContextListener ���IOC
		ApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        
		
		Person person = ctx.getBean(Person.class);
		System.out.println(person.hashCode());
		person.hello();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}