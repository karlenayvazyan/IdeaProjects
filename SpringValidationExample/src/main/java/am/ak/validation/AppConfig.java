package am.ak.validation;

import am.ak.validation.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by karlen on 5/27/17.
 */
@Configuration
public class AppConfig {

    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        return customer;
    }
}
