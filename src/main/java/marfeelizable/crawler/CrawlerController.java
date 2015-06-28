package marfeelizable.crawler;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import marfeelizable.data.dto.PageDTO;

@Controller
public class CrawlerController {

	@Autowired
	CrawlerService crawlerService;

	@RequestMapping(value = "/pages", method = RequestMethod.POST, headers = { "Accept=application/json" }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> postPages(@RequestBody List<PageDTO> pages) {
		List<URL> urls;
		try {
			urls = getUrls(pages);
		} catch (MalformedURLException | URISyntaxException e) {
			return ResponseEntity.badRequest().build();
		}
		crawlerService.processPages(urls);
		return ResponseEntity.ok().build();
	}

	private List<URL> getUrls(List<PageDTO> pages) throws URISyntaxException, MalformedURLException {
		final List<URL> urls = new LinkedList<URL>();
		for (final PageDTO page : pages) {
			final URI uri = new URI("http", page.getUrl(), null, null);
			urls.add(uri.toURL());
		}
		return urls;
	}
}
