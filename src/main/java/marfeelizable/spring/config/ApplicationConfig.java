package marfeelizable.spring.config;

import java.util.Arrays;

import marfeelizable.crawler.Crawler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Crawler crawler() {
		System.out.println("here");
		return new Crawler(Arrays.asList(new String[] { "news", "noticias" }));
	}

}
