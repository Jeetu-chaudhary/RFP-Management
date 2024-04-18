package com.service;

import java.math.BigDecimal;
import java.util.List;

import com.model.Category;
import com.model.RFPList;
import com.model.RFPQuote;
import com.model.User;
import com.model.VendorCategoryMap;
import com.model.VendorRegister;

public interface Service {
	String add(User emp);
	String addCat(Category cat);
	

	
	String addVendor(VendorRegister vd);
	String addRFPList(RFPList rfpList);
	String addRFPQuote(RFPQuote rfpQuote);
	
	List<VendorRegister> listAllVendor();
	List<Category> listAllCat();
	List<RFPList> listAdinRFP();
	List<RFPQuote> listAdminQuote();
	List<VendorRegister> getAllVendorByCatId(int categories);
	List<RFPList> getRFPListByUserID(int userId);
	
	Category getAllCatById(Long id);
	User getByEmail(String email);
	VendorRegister getVendorByEmail(String email);
	VendorRegister getVendorById(int lid);
	RFPList getRFPListById(int id);
	
	void updateCategory(Category category);
	void updateVendor(VendorRegister temp);
	void updateRFPList(RFPList temp);
	int  getRFPUserIdByEmail(String email);
	String addVendorCategoryMap(VendorCategoryMap vcm);
	User getUserById(int id);
	void updateUser(User user);
	Category getCatByCategoryName(String categoryName);

}
