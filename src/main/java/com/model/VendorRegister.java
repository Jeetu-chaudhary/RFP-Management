package com.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "RFP_vendor_detail")
public class VendorRegister {

    @Id
    @Column(name = "user_id") 
    private int userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "revenue", nullable = false)
    private BigDecimal revenue;

    @Column(name = "No_of_employee", nullable = false)
    private int numberOfEmployee;

    @Column(name = "GST_No", nullable = false)
    private String gstNumber;

    @Column(name = "PAN_No", nullable = false)
    private String panNumber;

    @Column(name = "phone_No", nullable = false)
    private String phoneNumber;

    
    @Column(name="status")
    private boolean status;
    
    @Column(name="create_date")
    private Date createDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "VendorRegister [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", revenue=" + revenue + ", numberOfEmployee=" + numberOfEmployee
				+ ", gstNumber=" + gstNumber + ", panNumber=" + panNumber + ", phoneNumber=" + phoneNumber + ", status="
				+ status + ", createDate=" + createDate + "]";
	}

  
}
