package marfeelizable.crawler;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.springframework.data.repository.CrudRepository;

import marfeelizable.data.model.CrawlerRecord;
import marfeelizable.data.model.PageDTO;
import marfeelizable.page.PageParser;

public class CrawlerThread implements Runnable {

	private final Log logger = LogFactory.getLog(CrawlerThread.class);
	private final PageDTO page;
	private final Crawler crawler;
	private final CrudRepository<CrawlerRecord, String> crawlerRecordRepository;

	public CrawlerThread(PageDTO page, Crawler crawler, CrudRepository<CrawlerRecord, String> crawlerRecordRepository) {
		super();
		this.page = page;
		this.crawler = crawler;
		this.crawlerRecordRepository = crawlerRecordRepository;
	}

	public void run() {
		try {
			final PageParser pagerParser = new PageParser(Jsoup.connect(page.getParsedUrl()).get());
			final String pageTitle = pagerParser.getPageTitle();
			final Boolean isMarfeelizableResult = crawler.isMarfeelizable(pageTitle);
			final CrawlerRecord crawlerRecord = new CrawlerRecord(page.getParsedUrl(), isMarfeelizableResult);
			crawlerRecordRepository.save(crawlerRecord);
		} catch (final IOException e) {
			logger.debug("Page does not exist", e);
			throw new RuntimeException(e);
		} catch (final URISyntaxException e) {
			logger.debug("Page address is wrong", e);
			throw new RuntimeException(e);
		}
	}

}
