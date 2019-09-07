package com.learning.pglocator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.learning.pglocator.model.PG;
import com.learning.pglocator.model.PGAndOwner;
import com.learning.pglocator.repo.OwnerRepo;
import com.learning.pglocator.repo.PGRepo;

@Configuration
@ComponentScan
public class LocateServiceImpl implements LocateService {
	
	@Autowired
	private PGRepo pgRepo;
	
	@Autowired
	private OwnerRepo ownerRepo;
	
	public LocateServiceImpl() {
		super();
	}

	@Bean
	public LocateServiceImpl mylocate()
	{
		return new LocateServiceImpl();
	}

	@Override
	public List<PGAndOwner> getAllNearPg(Double lon, Double lat, Double radius) {
		// TODO Auto-generated method stub
		List<PGAndOwner>  pgList= new ArrayList<PGAndOwner>();
		List<PG> tempList = (List<PG>) pgRepo.findAll();
		if(tempList.isEmpty()==true)
		{
			pgList.add(new PGAndOwner(0,0));
			return pgList;
		}
		else
		{
			for(PG pg:tempList)
			{
				Double d=distance(pg.getLatitude(), pg.getLongitude(), lat, lon,"KM");
				if(radius.compareTo(d)>=0)
				{
					pgList.add(new PGAndOwner(pg.getId(),pg.getOwner().getId()));
				}
			}
		}
		return pgList;
	}

	@Override
	public List<PG> getPgByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		List<PG> pgList = pgRepo.findByOwnerId(ownerId);
		if(pgList.isEmpty()==true)
		{
			
			pgList.add(new PG());
			return pgList;
		}
		else
		{
			return pgList;
		}
		
	}
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit == "K") {
				dist = dist * 1.609344;
			} else if (unit == "N") {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}
}
