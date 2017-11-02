package edu.zxy.apple.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Formula;


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
	
	@FunctionCreationDatetime
	private Date createdDatetime;
	
	@FunctionLastUpdatedDatetime
	private Date lastUpdatedDatetime;
	
	@Formula(value = "(select sum(t.money) from record t where t.flowin_acct_id = id)")
	private BigDecimal totalFlowIn;
	
	@Formula(value = "(select sum(t.money) from record t where t.flowout_acct_id = id)")
	private BigDecimal totalFlowOut;
	
	@Formula(value = "totalFlowIn-totalFlowOut")
	private BigDecimal balance;
	
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

	public BigDecimal getTotalFlowIn() {
		return totalFlowIn;
	}

	public BigDecimal getTotalFlowOut() {
		return totalFlowOut;
	}

	public BigDecimal getBalance() {
		return balance;
	}


}

