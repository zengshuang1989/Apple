package edu.zxy.apple.entity;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Record {
	private int id;
	private int categoryId;
	private int flowoutAcctId;
	private int flowinAcctId;
	private double money;
	private Date time;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getFlowoutAcctId() {
		return flowoutAcctId;
	}
	public void setFlowoutAcctId(int flowoutAcctId) {
		this.flowoutAcctId = flowoutAcctId;
	}
	public int getFlowinAcctId() {
		return flowinAcctId;
	}
	public void setFlowinAcctId(int flowinAcctId) {
		this.flowinAcctId = flowinAcctId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
