package com.learning.pglocator.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Entity
@Configuration
@ComponentScan
public class PG {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "player_Sequence")
    @SequenceGenerator(name = "player_Sequence", sequenceName = "PLAYER_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "owner_id", nullable = false)
        private Owner owner;
    @Column(name = "longitude")
    private Double longitude;
    @Bean
    public PG myPG()
    {
    	return new PG();
    }
    
	public PG() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public Owner getOwner() {
		return owner;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getLatitude() {
		return latitude;
	}


	@Column(name = "latitude")
	private Double latitude;
	

}
