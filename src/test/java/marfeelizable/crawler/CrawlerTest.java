package marfeelizable.crawler;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CrawlerTest {

	@Test
	public void shouldNotThrowNullPonter() {
		final Crawler crawler = new Crawler(new ArrayList<String>());
		final Boolean isMarfeelizable = crawler.isMarfeelizable("news");
		Assert.assertThat(isMarfeelizable, CoreMatchers.notNullValue());
	}

	@Test
	public void shouldReturnTrueIfPageIsMarfeelizable() {
		final Crawler crawler = new Crawler(Arrays.asList(new String[] { "news" }));
		final Boolean isMarfeelizable = crawler.isMarfeelizable("news");
		Assert.assertThat(isMarfeelizable, CoreMatchers.is(true));
	}

	@Test
	public void shouldReturnFalseIfPageIsNotMarfeelizable() {
		final Crawler crawler = new Crawler(Arrays.asList(new String[] { "news" }));
		final Boolean isMarfeelizable = crawler.isMarfeelizable("test");
		Assert.assertThat(isMarfeelizable, CoreMatchers.is(false));
	}

}
