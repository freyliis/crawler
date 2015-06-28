package marfeelizable.crawler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import marfeelizable.spring.config.DbConfig;

public class CrawlerApp {
	

	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				DbConfig.class);
		CrawlerController controller = (CrawlerController) context.getBean("crawlerController");
		controller.run();
		
	}

}
