package marfeelizable.crawler;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import marfeelizable.crawler.CrawlerControllerTest.TestConfiguration;
import marfeelizable.data.repository.CrawlerRecordRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfiguration.class })
@WebAppConfiguration
public class CrawlerControllerTest {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	Page[] pages;

	ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws IOException {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		final InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("pages.json");
		pages = mapper.readValue(resourceAsStream, Page[].class);
	}

	@Configuration
	@EnableWebMvc
	public static class TestConfiguration {

		@Bean
		public Crawler crawler() {
			return new Crawler();
		}

		@Bean
		public CrawlerRecordRepository crawlerRecordRepository() {
			return null;
		}

		@Bean
		public CrawlerService crawlerService() {
			return new CrawlerService();
		}

		@Bean
		public CrawlerController crawlerController() {
			return new CrawlerController();
		}

	}

	@Test
	public void crawlerTest() throws Exception {
		mockMvc.perform(post("/pages").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(Arrays.asList(pages)))).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
