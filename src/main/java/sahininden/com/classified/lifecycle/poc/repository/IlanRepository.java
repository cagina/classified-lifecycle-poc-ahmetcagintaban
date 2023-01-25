package sahininden.com.classified.lifecycle.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sahininden.com.classified.lifecycle.poc.entity.Ilan;
import sahininden.com.classified.lifecycle.poc.enums.IlanCategory;
import sahininden.com.classified.lifecycle.poc.enums.IlanStatus;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface IlanRepository extends CrudRepository<Ilan, Id> {
	public List<Ilan> findByCategoryAndTitleAndDescription(IlanCategory cat, String title, String desc);

	public List<Ilan> findByStatusAndRepeated(IlanStatus status, Boolean rep);

	public Ilan findById(long id);

	long countByStatus(IlanStatus status);
}
