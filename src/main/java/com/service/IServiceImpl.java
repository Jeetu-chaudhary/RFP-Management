package com.service;

import java.util.List;

import com.dao.Dao;
import com.model.Category;
import com.model.RFPList;
import com.model.RFPQuote;
import com.model.User;
import com.model.VendorCategoryMap;
import com.model.VendorRegister;
import com.util.SessionFactory;

public class IServiceImpl implements Service {

	private Dao dao;

	public IServiceImpl() {
		dao = SessionFactory.getDao();
	}

	@Override
	public String add(User emp) {
		return dao.add(emp);
	
	}
	
	@Override
	public String addCat(Category cat) {
		return dao.addCat(cat);
	}
	
	public String addVendor(VendorRegister vd) {
		return dao.addVendor(vd);
	};
	public User getByEmail(String email) {
		return dao.getByEmail(email);
	};
	 
    public VendorRegister getVendorByEmail(String email) {
    	return dao.getVendorByEmail(email);
    }	

	
	@Override
	public List<VendorRegister> listAllVendor() {
		return dao.getAllVendor();
	}
	public List<Category> listAllCat(){
		return dao.getAllCat();
	};
	public List<RFPList> listAdinRFP(){
		return dao.listAdinRFP();
	};
 public	List<RFPQuote> listAdminQuote(){
	 return dao.listAdminQuote();
 };
 public Category getAllCatById(Long id) {
	return dao.getAllCatById(id);
 };
 public void updateCategory(Category category) {
	 dao.updateCategory(category);
 }
 
 public List<VendorRegister> getAllVendorByCatId(int categories){
	 return dao.getAllVendorByCatId(categories);
 }
 public String addRFPList(RFPList rfpList) {
	 return dao.addRFPList(rfpList);
 };
public String addRFPQuote(RFPQuote rfpQuote) {
	return dao.addRFPQuote(rfpQuote);
};
public List<RFPList> getRFPListByUserID(int userId){
	return dao.getRFPListUserID(userId);
};
public VendorRegister getVendorById(int lid) {;
  return dao.getVendorById(lid);
}
public void updateVendor(VendorRegister temp) {
	dao.updateVendor(temp);
};
public RFPList getRFPListById(int id) {
	return dao.getRFPListById(id);
};
public void updateRFPList(RFPList temp) {
	 dao.updateRFPList(temp);
};
public int getRFPUserIdByEmail(String email){
	return dao.getRFPUserIdByEmail(email);
};
 public String addVendorCategoryMap(VendorCategoryMap vcm) {
	return dao.addVendorCategoryMap(vcm);
};
public User getUserById(int id) {
	return dao.getUserById(id);
};
public void updateUser(User user) {
	dao.updateUser(user);
};
public Category getCatByCategoryName(String categoryName) {
	return dao.getCatByCategoryName(categoryName);
};

}
