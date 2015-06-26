package marfeelizable.crawler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import marfeelizable.spring.config.ApplicationConfig;
import marfeelizable.spring.config.DbConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CrawlerController {



	public static void main(String[] args) {

		CrawlerController controller = new CrawlerController();
		controller.run();
	}

	private void run() {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				DbConfig.class);
		//crawler = (Crawler) context.getBean("crawler");
		int corePoolSize = 5;
		int maxPoolSize = 10;
		long keepAliveTime = 5000;


		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
				corePoolSize, maxPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

		threadPoolExecutor.execute(new CrawlerThread("http://www.c-and-a.com/"));
		threadPoolExecutor.shutdown();
	}

}
