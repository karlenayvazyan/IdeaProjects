package am.ak.mybatis.listener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by karlen on 03.05.16.
 */
public class Initializer implements ServletContextListener {

    private static WebApplicationContext applicationContext;

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext context = servletContextEvent.getServletContext();

        applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public static WebApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
