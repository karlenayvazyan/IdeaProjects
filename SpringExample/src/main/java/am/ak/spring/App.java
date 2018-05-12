package am.ak.spring;

import am.ak.spring.data.service.PetStoreServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"daos.xml", "services.xml"});
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        notNull(applicationContext, "Application context null");
        PetStoreServiceImpl petStoreService = applicationContext.getBean("petStoreService", PetStoreServiceImpl.class);
        notNull(petStoreService, "petStoreService null");
        PetStoreServiceImpl a = applicationContext.getBean("a", PetStoreServiceImpl.class);
        notNull(a, "A is null");
        PetStoreServiceImpl b = applicationContext.getBean("b", PetStoreServiceImpl.class);
        notNull(b, "B is null");
    }
}