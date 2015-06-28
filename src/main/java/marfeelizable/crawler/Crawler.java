package marfeelizable.crawler;

import java.util.Collections;
import java.util.List;

public class Crawler {

	private List<String> marfeelizableWords;

	public Crawler(List<String> marfeelizableWords) {
		super();
		this.marfeelizableWords = Collections.unmodifiableList(marfeelizableWords);
	}

	public Boolean isMarfeelizable(String string) {
		return marfeelizableWords.contains(string);
	}

	public Crawler() {
		super();
	}

}
