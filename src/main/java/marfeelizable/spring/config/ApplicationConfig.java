package marfeelizable.spring.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import marfeelizable.crawler.Crawler;
import marfeelizable.crawler.thread.CrawlerThreadPool;

@Configuration
@ComponentScan(basePackages = { "marfeelizable.crawler" })
@EnableWebMvc
public class ApplicationConfig {

	@Bean
	public Crawler crawler() {
		return new Crawler(Arrays.asList(new String[] { "news", "noticias" }));
	}

	@Bean
	public CrawlerThreadPool crawlerThreadPool() {
		return new CrawlerThreadPool(5, 10, 5000);
	}

}
