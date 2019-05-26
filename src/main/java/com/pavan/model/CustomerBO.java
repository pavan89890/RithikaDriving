package com.pavan.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "t_customer")
public class CustomerBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CAREOF")
	private String careOf;

	@Column(name = "AGE")
	private Float age;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ADMISSION_DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date admissionDate;

	@Column(name = "TOTAL_FEE")
	private Float totalFee;

	@Column(name = "FEE_PAID")
	private Float feePaid;

	@Column(name = "BALANCE")
	private Float balance;

	@Column(name = "STATUS")
	private String status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<CustomerAttendanceBO> customerAttendance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCareOf() {
		return careOf;
	}

	public void setCareOf(String careOf) {
		this.careOf = careOf;
	}

	public Float getAge() {
		return age;
	}

	public void setAge(Float age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Float getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Float totalFee) {
		this.totalFee = totalFee;
	}

	public Float getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(Float feePaid) {
		this.feePaid = feePaid;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CustomerAttendanceBO> getCustomerAttendance() {
		return customerAttendance;
	}

	public void setCustomerAttendance(List<CustomerAttendanceBO> customerAttendance) {
		this.customerAttendance = customerAttendance;
	}
}