package com.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "vendor_category_map")
public class VendorCategoryMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "map_id")
	private Long mapId;

	@Column(name = "vendor_id")
	private int vendor;
	
	@Column(name = "category_id")
	private int  categories;


	public Long getMapId() {
		return mapId;
	}

	public void setMapId(Long mapId) {
		this.mapId = mapId;
	}

	public int getVendor() {
		return vendor;
	}

	public void setVendor(int vendor) {
		this.vendor = vendor;
	}

	public int getCategories() {
		return categories;
	}

	public void setCategories(int categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "VendorCategoryMap [mapId=" + mapId + ", vendor=" + vendor + ", categories=" + categories + "]";
	}

	

	



}
