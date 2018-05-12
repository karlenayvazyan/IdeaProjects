package am.ak.mybatis.util;

import am.ak.mybatis.listener.Initializer;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by karlen on 03.05.16.
 */
public class BeanProvider {

    private static volatile BeanProvider beanProvider = null;

    private WebApplicationContext beanFactory;

    private BeanProvider() {
        beanFactory = Initializer.getApplicationContext();
    }

    public static BeanProvider getInstance() {
        if (beanProvider == null) {
            synchronized (BeanProvider.class) {
                if (beanProvider == null) {
                    beanProvider = new BeanProvider();
                }
            }
        }
        return beanProvider;
    }

    public <T> T getBean(Class<T> t, String name) {
        return (T) beanFactory.getBean(t, name);
    }

    public <T> T getBean(Class<T> t) {
        return (T) beanFactory.getBean(t);
    }

    public <T> T getBean(String name) {
        return (T) beanFactory.getBean(name);
    }
}
