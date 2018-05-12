import am.ak.validation.AppConfig;
import am.ak.validation.model.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by karlen on 5/27/17.
 */
public class ValidationTest {

    @Test
    public void customerValidationTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Customer bean = applicationContext.getBean(Customer.class);
        assertNotNull(bean);
    }
}
