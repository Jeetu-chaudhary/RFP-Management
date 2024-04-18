package com.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "RFP_list")
public class RFPList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RFP_No")
    private int rfpNo;

    @Column(name = "Title", length = 500)
    private String title;

    @Column(name = "Lastdate")
    private Date lastDate;

    @Column(name = "minAmount")
    private BigDecimal minAmount;

    @Column(name = "maxAmount")
    private BigDecimal maxAmount;

    @Column(name = "Item_Description", length = 1000)
    private String itemDescription;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "aminStatus")
    private boolean aminStatus = true;

    @Column(name = "vendorStatus")
    private boolean vendorStatus = false;
    
    @Column(name="create_date")
    private Date createDate;

    public RFPList() {
    }

    public RFPList(String title, Date lastDate, BigDecimal minAmount, BigDecimal maxAmount, String itemDescription, int quantity, int categoryId) {
        this.title = title;
        this.lastDate = lastDate;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

	public int getRfpNo() {
		return rfpNo;
	}

	public void setRfpNo(int rfpNo) {
		this.rfpNo = rfpNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}

	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isAminStatus() {
		return aminStatus;
	}

	public void setAminStatus(boolean aminStatus) {
		this.aminStatus = aminStatus;
	}

	public boolean isVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(boolean vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "RFPList [rfpNo=" + rfpNo + ", title=" + title + ", lastDate=" + lastDate + ", minAmount=" + minAmount
				+ ", maxAmount=" + maxAmount + ", itemDescription=" + itemDescription + ", quantity=" + quantity
				+ ", categoryId=" + categoryId + ", aminStatus=" + aminStatus + ", vendorStatus=" + vendorStatus
				+ ", createDate=" + createDate + "]";
	}

    // Getters and setters
}
