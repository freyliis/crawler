package marfeelizable.page;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageParser {

	private static final Logger logger = LoggerFactory.getLogger(PageParser.class);
	private final Document document;

	public PageParser(Document document) {
		this.document = document;
	}

	public String getPageTitle() {
		final Element title = document.getElementsByTag("title").first();
		if (title != null) {
			return title.text();
		} else {
			logger.debug("No title tag, returning empty String");
			return "";
		}
	}
}
