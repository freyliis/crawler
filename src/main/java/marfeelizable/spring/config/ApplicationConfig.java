package marfeelizable.spring.config;

import java.util.Arrays;

import marfeelizable.crawler.Crawler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	private Log logger = LogFactory.getLog(ApplicationConfig.class);

	@Bean
	public Crawler crawler() {
		logger.debug("!!!!!!!!!!!!!!!!!!!here!!!!!!!!!!!!!!!!!!!!!");
		return new Crawler(Arrays.asList(new String[] { "news", "noticias" }));
	}

}
