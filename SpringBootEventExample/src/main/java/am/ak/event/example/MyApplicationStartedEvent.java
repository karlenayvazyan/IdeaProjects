package am.ak.event.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by karlen on 6/6/16.
 */
public class MyApplicationStartedEvent extends ApplicationStartedEvent {

    /**
     * Create a new {@link ApplicationStartedEvent} instance.
     *
     * @param application the current application
     * @param args        the arguments the application is running with
     */
    public MyApplicationStartedEvent(SpringApplication application, String[] args) {
        super(application, args);
    }
}
