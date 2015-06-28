package marfeelizable.crawler;

import java.util.ArrayList;
import java.util.List;

public class Crawler {

	private List<String> marfeelizableWords = new ArrayList<String>();

	public Crawler(List<String> marfeelizableWords) {
		super();
		this.marfeelizableWords = marfeelizableWords;
	}

	public Boolean isMarfeelizable(String string) {
		return marfeelizableWords.contains(string);
	}

	public Crawler() {
		super();
	}

}
