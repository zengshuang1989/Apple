package edu.zxy.apple.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Account {
	
	@Id
    @GeneratedValue
	private Integer id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private String type;
	
	private Integer roleId;
	
	private String remark;
	
	private BigDecimal totalFlowIn;
	
	private BigDecimal totalFlowOut;
	
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
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public Date getLastUpdatedDatetime() {
		return lastUpdatedDatetime;
	}

	
}

