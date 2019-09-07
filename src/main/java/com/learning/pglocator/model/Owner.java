package com.learning.pglocator.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Entity
@Configuration
@ComponentScan
public class Owner {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "team_Sequence")
    @SequenceGenerator(name = "team_Sequence", sequenceName = "TEAM_SEQ")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "contact")
    private Integer contact; 
    public Long getId() {
		return id;
	}
	@Bean
	public Owner myOwner()
	{
		return new Owner();
	}
    public Owner() {
    }
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getContact() {
		return contact;
	}
	public void setContact(Integer contact) {
		this.contact = contact;
	}
	public List<PG> getPgList() {
		return pgList;
	}
	public void setPgList(List<PG> pgList) {
		this.pgList = pgList;
	}
	private Integer roleId;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "owner")
    private List<PG> pgList;
	


}
