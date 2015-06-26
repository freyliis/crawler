package marfeelizable.data.repository;

import marfeelizable.data.model.CrawlerRecord;

import org.springframework.data.repository.CrudRepository;

public interface CrawlerRecordRepository extends
		CrudRepository<CrawlerRecord, String> {

}
