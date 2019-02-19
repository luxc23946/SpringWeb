package hpe.lxc.ssh.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextListener implements ServletContextListener {
	
    public void contextDestroyed(ServletContextEvent arg0)  { }

    public void contextInitialized(ServletContextEvent arg0) {
    	//1. ��ȡ Spring �����ļ�������. 
    	ServletContext servletContext = arg0.getServletContext();
    	String config = servletContext.getInitParameter("configLocation");
    	
    	//1. ���� IOC ����
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    	
    	//2. �� IOC �������� ServletContext ��һ��������. 
    	servletContext.setAttribute("ApplicationContext", ctx);
    }
	
}
