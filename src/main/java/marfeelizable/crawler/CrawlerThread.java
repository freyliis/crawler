package marfeelizable.crawler;

import java.io.IOException;

import marfeelizable.data.model.CrawlerRecord;
import marfeelizable.data.repository.CrawlerRecordRepository;
import marfeelizable.page.PageParser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;

public class CrawlerThread implements Runnable {

	private Log logger = LogFactory.getLog(CrawlerThread.class);
	@Autowired
	private Crawler crawler;
	private String url;
	@Autowired
	private CrawlerRecordRepository crawlerRecordRepository;

	public CrawlerThread(String url) {
		super();
		this.url = url;
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
