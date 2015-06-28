package marfeelizable.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CrawlerRecord {

	@Id
	private String pageUrl;
	private Boolean isMarfeelizableResult;

	public CrawlerRecord(String pageUrl, Boolean isMarfeelizableResult) {
		super();
		this.pageUrl = pageUrl;
		this.isMarfeelizableResult = isMarfeelizableResult;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public Boolean getIsMarfeelizableResult() {
		return isMarfeelizableResult;
	}

	public CrawlerRecord() {
		super();
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public void setIsMarfeelizableResult(Boolean isMarfeelizableResult) {
		this.isMarfeelizableResult = isMarfeelizableResult;
	}

}
