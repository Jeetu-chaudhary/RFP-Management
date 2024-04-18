package com.dao;

import java.util.List;

import com.model.Category;
import com.model.RFPList;
import com.model.RFPQuote;
import com.model.User;
import com.model.VendorCategoryMap;
import com.model.VendorRegister;

public interface Dao {
	String add(User emp);
	String addCat(Category cat);
	String addVendor(VendorRegister vd);
	 User getByEmail(String email) ;
	 
	 VendorRegister getVendorByEmail(String email);
	 List<VendorRegister> getAllVendor();

	List<Category> getAllCat();
	List<RFPList> listAdinRFP();
	List<RFPQuote> listAdminQuote();
	
	Category getAllCatById(Long id);
	List<VendorRegister> getAllVendorByCatId(int categories);
	String addRFPList(RFPList rfpList);
	String addRFPQuote(RFPQuote rfpQuote);
	List<RFPList> getRFPListUserID(int userId);
	void updateCategory(Category category);
	VendorRegister getVendorById(int lid);
	void updateVendor(VendorRegister temp);
	RFPList getRFPListById(int id);
	void updateRFPList(RFPList temp);
	int getRFPUserIdByEmail(String email);
	String addVendorCategoryMap(VendorCategoryMap vcm);
	User getUserById(int id);
	void updateUser(User user);
	Category getCatByCategoryName(String categoryName);
}
