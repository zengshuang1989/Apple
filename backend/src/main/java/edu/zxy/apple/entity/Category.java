package edu.zxy.apple.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
    @GeneratedValue
	private Integer id;
	
	private Integer pid;
	
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
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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
