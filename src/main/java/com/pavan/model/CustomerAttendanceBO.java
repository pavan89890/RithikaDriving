package com.pavan.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "t_customer_attendance")
public class CustomerAttendanceBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "CLASS_DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date classDate;

	@Column(name = "IN_TIME")
	private String inTime;

	@Column(name = "OUT_TIME")
	private String outTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_ID")
	private CustomerBO customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getClassDate() {
		return classDate;
	}

	public void setClassDate(Date classDate) {
		this.classDate = classDate;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public CustomerBO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBO customer) {
		this.customer = customer;
	}
}