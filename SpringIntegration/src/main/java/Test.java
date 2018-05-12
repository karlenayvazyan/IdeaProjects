import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by karlen on 6/6/15.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("context.xml");
        // Simple Service
        TempConverter converter =
                ctx.getBean("simpleGateway", TempConverter.class);
        System.out.println(converter.fahrenheitToCelcius(68.0f));
        // Web Service
        converter  = ctx.getBean("wsGateway", TempConverter.class);
        System.out.println(converter.fahrenheitToCelcius(68.0f));
    }
}
