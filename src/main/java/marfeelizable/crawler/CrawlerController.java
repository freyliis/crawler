package marfeelizable.crawler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import marfeelizable.data.model.PageDTO;

@Controller
public class CrawlerController {

	@Autowired
	CrawlerService crawlerService;

	@RequestMapping(value = "/pages", method = RequestMethod.POST, headers = { "Accept=application/json" }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void postPages(@RequestBody List<PageDTO> pages) {
		crawlerService.processPages(pages);
	}
}
