package am.ak.example;

import am.ak.example.Util.FtpUtil;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by karlen on 19.12.15.
 */
public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(FtpUtil.getPath()).process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().getHeader("CamelFileName");
            }
        }).to("/home/karlen/storage/out");
    }
}
