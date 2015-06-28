package marfeelizable.crawler.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class CrawlerThreadPool implements ApplicationListener<ContextClosedEvent> {

	private final ExecutorService threadPoolExecutor;

	public CrawlerThreadPool(int corePoolSize, int maxPoolSize, long keepAliveTime) {
		super();
		threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
	}

	public ExecutorService getThreadPoolExecutor() {
		return threadPoolExecutor;
	}

	public void onApplicationEvent(ContextClosedEvent event) {
		threadPoolExecutor.shutdown();
	}

}
