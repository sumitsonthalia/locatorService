package com.learning.pglocator.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.learning.pglocator.model.Owner;

public interface OwnerRepo extends CrudRepository<Owner,Long>
{
	Optional<Owner> findById(Long id);
}
