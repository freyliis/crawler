package marfeelizable.crawler;

import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import marfeelizable.crawler.thread.CrawlerThread;
import marfeelizable.crawler.thread.CrawlerThreadPool;
import marfeelizable.data.repository.CrawlerRecordRepository;

@Component
public class CrawlerService {

	@Autowired
	private CrawlerRecordRepository crawlerRecordRepository;
	@Autowired
	private Crawler crawler;
	@Autowired
	private CrawlerThreadPool crawlerThreadPool;

	public void processPages(List<URL> pages) {

		for (final URL page : pages) {
			crawlerThreadPool.getThreadPoolExecutor()
					.execute(new CrawlerThread(page, crawler, crawlerRecordRepository));
		}
	}

}
