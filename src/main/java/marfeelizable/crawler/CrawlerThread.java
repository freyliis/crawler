package marfeelizable.crawler;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.springframework.data.repository.CrudRepository;

import marfeelizable.data.model.CrawlerRecord;
import marfeelizable.page.PageParser;

public class CrawlerThread implements Runnable {

	private Log logger = LogFactory.getLog(CrawlerThread.class);
	private String url;
	private Crawler crawler;
	private CrudRepository<CrawlerRecord, String> crawlerRecordRepository;

	public CrawlerThread(String url, Crawler crawler, CrudRepository<CrawlerRecord, String> crawlerRecordRepository) {
		super();
		this.url = url;
		this.crawler = crawler;
		this.crawlerRecordRepository = crawlerRecordRepository;
	}

	public void run() {
		try {
			System.out.println(crawler);
			PageParser pagerParser = new PageParser(Jsoup.connect(url).get());
			String pageTitle = pagerParser.getPageTitle();
			Boolean isMarfeelizableResult = crawler.isMarfeelizable(pageTitle);
			CrawlerRecord crawlerRecord = new CrawlerRecord(url,
					isMarfeelizableResult);
			crawlerRecordRepository.save(crawlerRecord);
		} catch (IOException e) {
			logger.debug("Page does not exist", e);
			throw new RuntimeException(e);
		}
	}

}
