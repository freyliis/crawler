package marfeelizable.page;

import java.io.IOException;

import org.hamcrest.CoreMatchers;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PageParserTest {
	
	@Mock
	private Document document;
	@Mock
	private Elements elements;
	@Mock
	private Element element;

	@Test
	public void shouldReturnNotNullPageTitle() throws IOException {
		Mockito.when(document.getElementsByTag("title")).thenReturn(elements);
		Mockito.when(elements.first()).thenReturn(element);
		Mockito.when(element.text()).thenReturn("test");
		PageParser pageParser = new PageParser(document);
		String title = pageParser.getPageTitle();
		Assert.assertThat(title, CoreMatchers.notNullValue());
	}
	
	
	@Test
	public void shouldReturnEmptyStringWhenThereIsNoTitle() throws IOException {
		Mockito.when(document.getElementsByTag("title")).thenReturn(elements);
		Mockito.when(elements.first()).thenReturn(null);
		PageParser pageParser = new PageParser(document);
		String title = pageParser.getPageTitle();
		Assert.assertThat(title, CoreMatchers.is(""));
	}
}
