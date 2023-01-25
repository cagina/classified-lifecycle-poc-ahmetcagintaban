package sahininden.com.classified.lifecycle.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sahininden.com.classified.lifecycle.poc.entity.LongestRequestLog;
import javax.persistence.Id;

@Repository
public interface LongestRequestLogRepository extends CrudRepository<LongestRequestLog, Id> { }
