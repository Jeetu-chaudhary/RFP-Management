package com.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "RFP_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id")
    private Long categoriesId;

    @Column(name = "categories_name")
    private String categoryName;

    @Column(name = "status")
    private boolean status;
    
    public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="create_date")
    private Date createDate;

    // Getters and Setters

    public Long getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Long categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Category [categoriesId=" + categoriesId + ", categoryName=" + categoryName + ", status=" + status
				+ ", createDate=" + createDate + "]";
	}
    
}
