package am.ak.event.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class SpringBootEventExampleApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringBootEventExampleApplication.class);
		springApplication.addListeners(new ApplicationListener<MyApplicationStartedEvent);
		springApplication.run(args);
	}
}
