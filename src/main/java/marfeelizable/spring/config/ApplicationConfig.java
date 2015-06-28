package marfeelizable.spring.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import marfeelizable.crawler.Crawler;

@Configuration
@ComponentScan(basePackages = { "marfeelizable.crawler" })
@EnableWebMvc
public class ApplicationConfig extends WebMvcConfigurerAdapter {

	@Bean
	public Crawler crawler() {
		return new Crawler(Arrays.asList(new String[] { "news", "noticias" }));
	}

}
