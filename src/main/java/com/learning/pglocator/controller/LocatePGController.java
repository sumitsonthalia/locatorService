package com.learning.pglocator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.pglocator.model.PGAndOwner;
import com.learning.pglocator.service.LocateServiceImpl;

@RestController
public class LocatePGController {
	@Autowired
	LocateServiceImpl locateServiceImpl;
	
	@RequestMapping(value="/PGs/{lon}/{lat}/{rad}",method=RequestMethod.GET)
	public List<PGAndOwner> findPG(@PathVariable Double lon,@PathVariable Double lat,@PathVariable Double rad)
	{

		
		List<PGAndOwner> pgList =locateServiceImpl.getAllNearPg(lon, lat, rad);
		return pgList;
		
	}

}
