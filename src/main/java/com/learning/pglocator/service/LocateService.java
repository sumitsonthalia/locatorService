package com.learning.pglocator.service;

import java.util.List;

import com.learning.pglocator.model.PG;
import com.learning.pglocator.model.PGAndOwner;

public interface LocateService {

	List<PGAndOwner> getAllNearPg(Double lon,Double lat,Double radius);
	List<PG> getPgByOwnerId(Long ownerId);
	
	
}
