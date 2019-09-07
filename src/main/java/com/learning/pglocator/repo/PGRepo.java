package com.learning.pglocator.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.pglocator.model.PG;

@Repository
public interface PGRepo extends CrudRepository<PG,Long>{

	List<PG> findByOwnerId(Long id);
	
	
}
