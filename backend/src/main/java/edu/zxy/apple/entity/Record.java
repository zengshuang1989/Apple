package edu.zxy.apple.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Record {
	@Id
    @GeneratedValue
	private Integer id;
	
	private Integer categoryId;
	private Integer flowoutAcctId;
	private Integer flowinAcctId;
	
	private BigDecimal money;
	
	private String remark;
	
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
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getFlowoutAcctId() {
		return flowoutAcctId;
	}
	public void setFlowoutAcctId(Integer flowoutAcctId) {
		this.flowoutAcctId = flowoutAcctId;
	}
	public Integer getFlowinAcctId() {
		return flowinAcctId;
	}
	public void setFlowinAcctId(Integer flowinAcctId) {
		this.flowinAcctId = flowinAcctId;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
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
