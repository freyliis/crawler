package marfeelizable.crawler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import marfeelizable.data.repository.CrawlerRecordRepository;

@Component
public class CrawlerController {

	@Autowired
	private CrawlerRecordRepository crawlerRecordRepository;
	@Autowired
	private Crawler crawler;

	public void run() {

		final int corePoolSize = 5;
		final int maxPoolSize = 10;
		final long keepAliveTime = 5000;

		final ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

		threadPoolExecutor.execute(new CrawlerThread("http://www.c-and-a.com/", crawler, crawlerRecordRepository));
		threadPoolExecutor.shutdown();
	}

}
