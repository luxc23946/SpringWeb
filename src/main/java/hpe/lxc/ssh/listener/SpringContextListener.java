package hpe.lxc.ssh.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextListener implements ServletContextListener {
	
    public void contextDestroyed(ServletContextEvent arg0)  { }

    public void contextInitialized(ServletContextEvent arg0) {
    	//1. 获取 Spring 配置文件的名称. 
    	ServletContext servletContext = arg0.getServletContext();
    	String config = servletContext.getInitParameter("configLocation");
    	
    	//1. 创建 IOC 容器
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    	
    	//2. 把 IOC 容器放在 ServletContext 的一个属性中. 
    	servletContext.setAttribute("ApplicationContext", ctx);
    }
	
}
