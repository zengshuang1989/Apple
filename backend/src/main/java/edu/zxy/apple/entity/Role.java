package edu.zxy.apple.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
    @GeneratedValue
	private Integer id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private String type;
	
	@FunctionCreationDatetime
	private Date createdDatetime;
	
	@FunctionLastUpdatedDatetime
	private Date lastUpdatedDatetime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatedDatetime() {
		return createdDatetime;
	}
	public Date getLastUpdatedDatetime() {
		return lastUpdatedDatetime;
	}
	
	
}
