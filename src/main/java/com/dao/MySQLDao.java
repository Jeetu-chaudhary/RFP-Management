package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Category;
import com.model.RFPList;
import com.model.RFPQuote;
import com.model.User;
import com.model.VendorCategoryMap;
import com.model.VendorRegister;
import com.util.HibernateUtil;

public class MySQLDao implements Dao {
	private Session session;
	private Transaction transaction = null;
	private boolean flag;
	private String status = "failure";

	public MySQLDao() {
		session = HibernateUtil.getSession();
	}

	@Override
	public String add(User emp) {
		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					flag = true;
					status = "success";
					session.persist(emp);
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			}
		}
		return status;
	}

	@Override
	public String addCat(Category cat) {
		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					flag = true;
					status = "success";
					session.persist(cat);
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			}
		}
		return status;

	}

	@Override
	public String addVendor(VendorRegister vd) {
		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					flag = true;
					status = "success";
					session.persist(vd);
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			}
		}
		return status;

	}

	public String addRFPList(RFPList rfpList) {
		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					flag = true;
					status = "success";
					session.persist(rfpList);
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			}
		}
		return status;

	}

	@Override
	public String addVendorCategoryMap(VendorCategoryMap vcm) {
		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					flag = true;
					status = "success";
					session.persist(vcm);
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			}
		}
		return status;

	}

	public String addRFPQuote(RFPQuote rfpQuote) {
		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					flag = true;
					status = "success";
					session.persist(rfpQuote);
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			}
		}
		return status;

	}

	@Override
	public User getByEmail(String email) {
		User user = null;
		try {
			if (session != null) {
				// Query to retrieve user by email
				Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
				query.setParameter("email", email);
				user = query.uniqueResult();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		return user;
	}

	@Override
	public List<RFPList> getRFPListUserID(int userId) {
		List<RFPList> rfps = new ArrayList<>();
		try {
			if (session != null) {
				// Query to retrieve RFPList entities by user ID using join operation
				Query<RFPList> query = session.createQuery(
						"SELECT r FROM RFPList r JOIN VendorCategoryMap vcm ON r.categoryId = vcm.categories WHERE vcm.vendor = :userId",
						RFPList.class);
				query.setParameter("userId", userId);
				rfps = query.getResultList();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close session if needed
		}
		return rfps;
	}

	@Override
	public VendorRegister getVendorByEmail(String email) {
		VendorRegister vendor = null;
		try {
			if (session != null) {
				// Query to retrieve user by email
				Query<VendorRegister> query = session.createQuery("FROM VendorRegister WHERE email = :email",
						VendorRegister.class);
				query.setParameter("email", email);
				vendor = query.uniqueResult();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		return vendor;
	}

	@Override
	public int getRFPUserIdByEmail(String email) {
		User user = null;
		try {
			if (session != null) {
				// Query to retrieve user by email
				Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
				query.setParameter("email", email);
				user = query.uniqueResult();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		return user.getUserId();
	}

	@Override
	public List<VendorRegister> getAllVendorByCatId(int categoryId) {
		List<VendorRegister> vendor = null;
		try {
			if (session != null) {
				// Query to retrieve vendors by category ID
				Query<VendorRegister> query = session
						.createQuery("SELECT v FROM VendorRegister v JOIN VendorCategoryMap vc ON v.userId = vc.vendor "
								+ "WHERE vc.categories = :categoryId", VendorRegister.class);
				query.setParameter("categoryId", categoryId);
				vendor = query.getResultList();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// If required, perform cleanup tasks here
		}
		return vendor;
	}

	@Override
	public List<VendorRegister> getAllVendor() {
		List<VendorRegister> vdrList = null;
		try {
			if (session != null) {
				Query<VendorRegister> query = session
						.createQuery("FROM com.model.VendorRegister ORDER BY createDate DESC");
				vdrList = query.getResultList();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vdrList;
	}

	@Override
	public List<Category> getAllCat() {
		List<Category> catList = null;
		try {
			if (session != null) {
				Query<Category> query = session.createQuery("FROM com.model.Category ORDER BY createDate DESC");
				catList = query.getResultList();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catList;
	}

	@Override
	public Category getAllCatById(Long id) {
		Category emp = new Category();
		try {
			if (session != null) {
				emp = session.get(Category.class, id);
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return emp;
	}

	@Override
	public Category getCatByCategoryName(String categoryName) {
		Category emp = new Category();
		try {
			if (session != null) {
				Query<Category> query = session.createQuery("FROM Category WHERE lower(categoryName) = lower(:name)",
						Category.class);
				query.setParameter("name", categoryName.toLowerCase());
				emp = query.uniqueResult();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return emp;
	}

	@Override
	public RFPList getRFPListById(int id) {
		RFPList emp = new RFPList();
		try {
			if (session != null) {
				emp = session.get(RFPList.class, id);
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return emp;
	}

	@Override
	public VendorRegister getVendorById(int lid) {
		VendorRegister emp = new VendorRegister();
		try {
			if (session != null) {
				emp = session.get(VendorRegister.class, lid);
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return emp;
	}

	@Override
	public User getUserById(int id) {
		User emp = new User();
		try {
			if (session != null) {
				emp = session.get(User.class, id);
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return emp;
	}

	@Override
	public void updateCategory(Category category) {
		try {
			if (session != null) {
				Transaction tx = session.beginTransaction();
				session.update(category);
				tx.commit();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close session or handle it appropriately
		}
	}

	@Override
	public void updateRFPList(RFPList temp) {
		try {
			if (session != null) {
				Transaction tx = session.beginTransaction();
				session.update(temp);
				tx.commit();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close session or handle it appropriately
		}
	}

	@Override
	public void updateVendor(VendorRegister temp) {
		try {
			if (session != null) {
				Transaction tx = session.beginTransaction();
				session.update(temp);
				tx.commit();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close session or handle it appropriately
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			if (session != null) {
				Transaction tx = session.beginTransaction();
				session.update(user);
				tx.commit();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close session or handle it appropriately
		}
	}

	@Override
	public List<RFPList> listAdinRFP() {
		List<RFPList> rfpList = null;
		try {
			if (session != null) {
				Query<RFPList> query = session.createQuery("FROM com.model.RFPList ORDER BY createDate DESC");
				rfpList = query.getResultList();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rfpList;
	}

	@Override
	public List<RFPQuote> listAdminQuote() {
		List<RFPQuote> rfpList = null;
		try {
			if (session != null) {
				Query<RFPQuote> query = session.createQuery("FROM com.model.RFPQuote ORDER BY createDate DESC");
				rfpList = query.getResultList();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rfpList;
	}
}
