package matin.sample.webapp;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
@EntityScan(basePackages = { "matin.sample.webapp" })
@EnableJpaRepositories(basePackages = { "matin.sample.webapp" })
@EnableAutoConfiguration
@SpringBootApplication
@ConfigurationProperties(value = "classpath:sample.webapp.yml")
@ImportResource(locations = {"classpath:spring/root-context.xml"})
public class SampleWebApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(SampleWebApp.class);
	}

	/**
	 * H2 Database console 설정
	 *
	 * @return h2 database console
	 */
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
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
