package marfeelizable.crawler.thread;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.springframework.data.repository.CrudRepository;

import marfeelizable.crawler.Crawler;
import marfeelizable.data.model.CrawlerRecord;
import marfeelizable.page.PageParser;

public class CrawlerThread implements Runnable {

	private final Log logger = LogFactory.getLog(CrawlerThread.class);
	private final URL url;
	private final Crawler crawler;
	private final CrudRepository<CrawlerRecord, Long> crawlerRecordRepository;

	public CrawlerThread(URL url, Crawler crawler, CrudRepository<CrawlerRecord, Long> crawlerRecordRepository) {
		super();
		this.url = url;
		this.crawler = crawler;
		this.crawlerRecordRepository = crawlerRecordRepository;
	}

	@Override
	public void run() {
		try {
			final PageParser pagerParser = new PageParser(Jsoup.connect(url.toString()).get());
			final String pageTitle = pagerParser.getPageTitle();
			final Boolean isMarfeelizableResult = crawler.isMarfeelizable(pageTitle);
			final CrawlerRecord crawlerRecord = new CrawlerRecord(url.toString(), isMarfeelizableResult);
			crawlerRecordRepository.save(crawlerRecord);
		} catch (final IOException e) {
			logger.debug("Page does not exist", e);
			throw new RuntimeException(e);
		}
	}

}
