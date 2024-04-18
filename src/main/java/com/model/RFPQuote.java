package com.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "RFP_quotes")
public class RFPQuote {

   @Id
   @Column(name="quoteId")
   private int quoteId;
   
    public int getQuoteId() {
	return quoteId;
}

public void setQuoteId(int quoteId) {
	this.quoteId = quoteId;
}

	@Column(name = "vendor_id")
    private int vendorId;

    public BigDecimal getVendorPrice() {
		return vendorPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	@Column(name = "vendor_price", length = 20)
    private BigDecimal vendorPrice;

    @Column(name = "Item_Description", length = 1000)
    private String itemDescription;

    @Column(name = "Quantity", length = 20)
    private int quantity;

    @Column(name = "total_cost", length = 20)
    private BigDecimal totalCost;

    public void setVendorPrice(BigDecimal vendorPrice) {
		this.vendorPrice = vendorPrice;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	@Column(name = "RFP_No")
    private int rfpNo;

    @Column(name="create_date")
    private Date createDate;
    // Constructors, getters, and setters

    public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public RFPQuote() {
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    

  

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    public int getRfpNo() {
        return rfpNo;
    }

    public void setRfpNo(int rfpNo) {
        this.rfpNo = rfpNo;
    }



	@Override
	public String toString() {
		return "RFPQuote [quoteId=" + quoteId + ", vendorId=" + vendorId + ", vendorPrice=" + vendorPrice
				+ ", itemDescription=" + itemDescription + ", quantity=" + quantity + ", totalCost=" + totalCost
				+ ", rfpNo=" + rfpNo + ", vendorDetail="  + ", rfp=" + ", createDate=" + createDate
				+ "]";
	}
    
}
