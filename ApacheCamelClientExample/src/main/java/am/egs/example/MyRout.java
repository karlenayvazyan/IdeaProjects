package am.egs.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by karlen on 6/1/16.
 */
@Component
public class MyRout extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .convertBodyTo(String.class)
                .to("http://localhost:8080/");
    }
}
