package com.apress.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class SpringBootSimpleApplication implements /*CommandLineRunner,*/ ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger
			(SpringBootSimpleApplication.class);

	public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(SpringBootSimpleApplication.class);
//		application.setBanner(
//				(environment, aClass, printStream) -> printStream.print("\n\n\tThis is my own banner!\n\n".toUpperCase()));
//		application.run(args);
		Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
		new SpringApplicationBuilder(SpringBootSimpleApplication.class)
//				.bannerMode(Banner.Mode.OFF)
//				.logStartupInfo(false)
				.listeners(applicationEvent -> log.info("###" + applicationEvent.getClass().getCanonicalName()))
//				.sources(SpringBootSimpleApplication.class)
				.run(args);
	}

	@Bean
	String info() {
		return "Just a simple String bean";
	}

	@Autowired
	String info;

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		log.info("## > ApplicationRunner Implementation...");
		log.info("Accessing the Info bean: " + info);
		applicationArguments.getNonOptionArgs().forEach(file -> log.info(file));
	}

	@Bean
	CommandLineRunner myMethod() {
		return args -> {
			log.info("## > CommandLineRunner Implementation...");
			log.info("Accessing the Info bean: " + info);
			for(String arg : args)
				log.info(arg);
		};
	}

//	@Override
//	public void run(String... strings) throws Exception {
//		log.info("## > CommandLineRunner Implementation...");
//		log.info("Accessing the Info bean: " + info);
//		for(String arg : strings)
//			log.info(arg);
//	}
}

@Component
class MyComponent {

	private static final Logger log = LoggerFactory.getLogger(MyComponent.class);


	@Autowired
	public MyComponent(ApplicationArguments args) {
		boolean enable = args.containsOption("enable");
		if (enable) {
			log.info("## > You are enable!");
		}
		List<String> _args = args.getNonOptionArgs();
		log.info("## > extra args ...");
		if(!_args.isEmpty())
			_args.forEach(file -> log.info(file));
	}
}