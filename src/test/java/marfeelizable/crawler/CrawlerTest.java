package marfeelizable.crawler;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CrawlerTest {

	
	@Test
	public void shouldNotThrowNullPonter() {
		Crawler crawler = new Crawler(new ArrayList<String>());
		Boolean isMarfeelizable = crawler.isMarfeelizable("news");
		Assert.assertThat(isMarfeelizable, CoreMatchers.notNullValue());
	}
	
	@Test
	public void shouldReturnTrueIfPageIsMarfeelizable() {
		Crawler crawler = new Crawler(Arrays.asList(new String[]{"news"}));
		Boolean isMarfeelizable = crawler.isMarfeelizable("news");
		Assert.assertThat(isMarfeelizable, CoreMatchers.is(true));
	}
	
	@Test
	public void shouldReturnFalseIfPageIsNotMarfeelizable() {
		Crawler crawler = new Crawler(Arrays.asList(new String[]{"news"}));
		Boolean isMarfeelizable = crawler.isMarfeelizable("test");
		Assert.assertThat(isMarfeelizable, CoreMatchers.is(false));
	}

}
