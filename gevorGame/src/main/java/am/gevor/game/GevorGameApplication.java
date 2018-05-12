package am.gevor.game;

import am.gevor.game.interceptor.AuthenticationInterceptor;
import am.gevor.game.util.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableWebMvc
public class GevorGameApplication extends WebMvcConfigurerAdapter {

	@Bean
	public FileUtils fileUtils() {
		return new FileUtils();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthenticationInterceptor()).excludePathPatterns("/login", "/logout", "/rest");
	}

	public static void main(String[] args) {
		SpringApplication.run(GevorGameApplication.class, args);
	}
}
