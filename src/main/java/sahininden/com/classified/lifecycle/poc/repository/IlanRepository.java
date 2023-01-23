package sahininden.com.classified.lifecycle.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sahininden.com.classified.lifecycle.poc.entity.Ilan;

import javax.persistence.Id;

@Repository
public interface IlanRepository extends CrudRepository<Ilan, Id> { }
