package matin.sample.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * matin sample web application 실행 class
 *
 * @author matin
 */
@ControllerAdvice
@RestControllerAdvice
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class SampleWebApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(SampleWebApp.class);
	}

	/**
	 *
	 * @param args
	 *            전달인자
	 */
	public static void main(final String[] args) {
		SpringApplication.run(SampleWebApp.class, args);
	}
}
