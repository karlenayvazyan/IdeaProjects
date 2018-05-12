import am.ak.integration.TestClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by karlen on 7/2/17.
 */
@Configuration
public class SpringContext {

    @Bean
    public TestClass test() {
        return new TestClass();
    }
}
