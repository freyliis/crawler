package marfeelizable.data.model;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("url")
	private String url;

	@JsonProperty("rank")
	private String rank;

	public String getUrl() {
		return url;
	}

	public String getParsedUrl() throws URISyntaxException, MalformedURLException {
		final URI uri = new URI("http", url, null, null);
		return uri.toURL().toString();
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public PageDTO() {
		super();
	}

}
