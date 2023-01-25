package sahininden.com.classified.lifecycle.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sahininden.com.classified.lifecycle.poc.entity.LogIlanTable;
import javax.persistence.Id;
import java.util.List;

@Repository
public interface LogIlanTableRepository extends CrudRepository<LogIlanTable, Id> {
	public List<LogIlanTable> findByIlanId(long id);
}
