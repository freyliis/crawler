package marfeelizable.crawler;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Page implements Serializable {

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

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Page() {
		super();
	}

}
