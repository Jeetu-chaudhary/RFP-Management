package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Category;
import com.model.RFPList;
import com.model.RFPQuote;
import com.model.User;
import com.model.VendorCategoryMap;
import com.model.VendorRegister;
import com.service.Service;
import com.util.SessionFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	@SuppressWarnings("unused")
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		Service service = null;
		RequestDispatcher rd = null;
		User employee = null;
		Category cat = null;
		VendorRegister vd = null;
		String name = null;
		ServletContext contex = null;
		int vdId;

		if (uri.endsWith("login")) {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			service = SessionFactory.getService();
			User status = service.getByEmail(email);
			HttpSession session = request.getSession();

			if (status != null && status.getPassword().equals(password)) {
				// Admin Login
				if ("Admin".equals(status.getRole())) {
					session.setAttribute("admin", status);
					rd = request.getRequestDispatcher("../AdminWelcome.jsp");
				} else if ("Vendor".equals(status.getRole()) && status.getStatus()) {
					// Set the "vendor" attribute in the session

					session.setAttribute("vendor", status);

					// Forward the request to VendorWelcome.jsp
					rd = request.getRequestDispatcher("../VendorWelcome.jsp");
				} else
					rd = request.getRequestDispatcher("../wrongCredentials.jsp");

			} else {
				rd = request.getRequestDispatcher("../wrongCredentials.jsp");
			}

			rd.forward(request, response);
		}

//		if (uri.endsWith("login")) {
//			String email = request.getParameter("email");
//			String password = SessionFactory.getHashedValue(request.getParameter("password"));
//			service = SessionFactory.getService();
//			User status = service.getByEmail(email);
//
//			if (status != null && status.getPassword().equals(password)) {
//				rd = request.getRequestDispatcher("../AdminWelcome.jsp");
//				System.out.println(status);
//			}
//
//			else {
//				VendorRegister st = service.getVendorByEmail(email);
//				if (st != null && st.getPassword().equals(password)) {
//					System.out.println(st);
//					ServletContext contex = request.getServletContext();
//
//					name = st.getFirstName();
//					vdId = st.getCategoryId();
//
//					contex.setAttribute("vendor", st);
//					rd = request.getRequestDispatcher("../VendorWelcome.jsp");
//				} else
//					rd = request.getRequestDispatcher("../index.jsp");
//			}
//			rd.forward(request, response);
//		}

		if (uri.endsWith("addUser")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			service = SessionFactory.getService();
			employee = new User();
			employee.setFirstName(firstName);
			employee.setEmail(email);
			employee.setLastName(lastName);
			employee.setPassword(password);

			String status = service.add(employee);
			System.out.println(status);
			if ("success".equals(status))
				rd = request.getRequestDispatcher("../success.jsp");
			else
				rd = request.getRequestDispatcher("../failure.jsp");
			rd.forward(request, response);
		}
		if (uri.endsWith("addVendorQuote")) {
			String vendorPriceStr = request.getParameter("vendorPrice");
			String itemDes = request.getParameter("itemDes");
			String quantityStr = request.getParameter("quantity");
			String totalCostStr = request.getParameter("totalCost");
			int rfpId = Integer.parseInt(request.getParameter("rfpId"));

			HttpSession session = request.getSession(false);
			User vendor = (User) session.getAttribute("vendor");
			int id = vendor.getUserId();

			service = SessionFactory.getService();
			RFPQuote rfpQuote = new RFPQuote();
			LocalDate currentDate = LocalDate.now();
			Date sqlDate = Date.valueOf(currentDate);
			rfpQuote.setCreateDate(sqlDate);
			rfpQuote.setItemDescription(itemDes);
			rfpQuote.setQuantity(Integer.parseInt(quantityStr)); // Parse quantity to integer
			rfpQuote.setRfpNo(rfpId);
			rfpQuote.setVendorId(id);
			rfpQuote.setVendorPrice(new BigDecimal(vendorPriceStr)); // Parse vendorPrice to BigDecimal
			rfpQuote.setTotalCost(new BigDecimal(totalCostStr)); // Parse totalCost to BigDecimal
			String status = service.addRFPQuote(rfpQuote);

			RFPList temp = service.getRFPListById(rfpId);
			temp.setVendorStatus(!temp.isVendorStatus());
			service.updateRFPList(temp);

			System.out.println(status);

			if ("success".equals(status)) {
				String body = "<html><body style='font-family: Arial, sans-serif;'>";
				body += "<p>Dear Admin,</p>";
				body += "<p>A vendor has requested for quotes on our portal.</p>";
				body += "<p>Please review the details of the request and take necessary actions accordingly.</p>";
				body += "<p>The details of the requested quotes are as follows:</p>";
				body += "<p><strong>Vendor Name:</strong> " + vendor.getFirstName() + "</p>";
				body += "<p><strong>Item Description:</strong> " + itemDes + "</p>";
				body += "<p><strong>Quantity:</strong> " + quantityStr + "</p>";
				body += "<p><strong>Total Cost:</strong> " + totalCostStr + "</p>";

				body += "<p>If you have any questions or need further information, feel free to contact the vendor directly.</p>";
//				body += "<p>Best regards,<br>";
//				body += "Your Admin</p>";
				body += "</body></html>";

				SessionFactory.SendMail("RFP Management", "jitendrasingh25889@gmail.com",
						"demoemaild81523672@gmail.com", "Quote Received  !", body, true, "fxqz gjdr jlza kxas");

				rd = request.getRequestDispatcher("./vendorRFP");
			} else
				rd = request.getRequestDispatcher("../failure.jsp");
			rd.forward(request, response);
		}

		if (uri.endsWith("addRFPList"))

		{
			String title = request.getParameter("itemName");
			String[] vendorData = request.getParameterValues("vendorData");
			String itemDescription = request.getParameter("itemDescription");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			BigDecimal minPrice = new BigDecimal(request.getParameter("minPrice"));
			BigDecimal maxPrice = new BigDecimal(request.getParameter("maxPrice"));

			String lastDateStr = request.getParameter("lastDate");
			java.util.Date lastDate = null;
			if (lastDateStr != null && !lastDateStr.isEmpty()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					lastDate = dateFormat.parse(lastDateStr);
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// Handle null or empty lastDateStr appropriately
				// For example, you could set a default value or display an error message
			}

			int categories = Integer.parseInt(request.getParameter("categories"));
			service = SessionFactory.getService();

			RFPList rfpList = new RFPList();
			LocalDate currentDate = LocalDate.now();
			Date sqlDate = Date.valueOf(currentDate);
			rfpList.setCreateDate(sqlDate);
			rfpList.setTitle(title);
			rfpList.setItemDescription(itemDescription);
			rfpList.setLastDate(new Date(lastDate.getTime())); // Convert java.util.Date to java.sql.Date
			rfpList.setMinAmount(minPrice);
			rfpList.setMaxAmount(maxPrice);
			rfpList.setQuantity(quantity);
			rfpList.setCategoryId(categories);
			rfpList.setVendorStatus(true);
			rfpList.setAminStatus(true);

			String s = service.addRFPList(rfpList);
			System.out.println(s);

			List<String> VendorMail = new ArrayList<>();

			if (vendorData != null) {
				String emailPattern = "email=([\\w\\.-]+)@([\\w\\.-]+)";
				Pattern pattern = Pattern.compile(emailPattern);
				for (String vD : vendorData) {
					Matcher matcher = pattern.matcher(vD);
					if (matcher.find()) {
						String email = matcher.group(1); // Extracted email
						VendorMail.add(email + "@gmail.com");
					} else {
						System.out.println("Email not found in the string.");
					}

				}

			}
			String body = "<html><body style='font-family: Arial, sans-serif;'>";
			body += "<p>Dear Vendor,</p>";
			body += "<p>We're excited to inform you that a new request for proposal (RFP) has been created on our portal.</p>";
			body += "<p>You are invited to review the details of the RFP and submit your proposal accordingly. This is a great opportunity for you to showcase your expertise and offer your services to meet the requirements outlined in the RFP.</p>";
			body += "<p>The details of the RFP are as follows:</p>";
			// Include specific details of the RFP such as title, description, deadline,
			// etc.

			// Example:
			body += "<p><strong>RFP Title:</strong>" + title + "</p>";
			body += "<p><strong>Description:</strong> " + itemDescription + "</p>";
			body += "<p><strong>Deadline:</strong> " + sqlDate + "</p>";

			body += "<p>If you have any questions or need clarification regarding the RFP, feel free to contact the administrator or the person listed as the point of contact for this RFP.</p>";
			body += "<p>We appreciate your participation and look forward to receiving your proposal.</p>";
			body += "<p>Best regards,<br>";
			body += "Admin</p>";
			body += "</body></html>";
			for (String email : VendorMail) {
				SessionFactory.SendMail("RFP Management Admin", email, "demoemaild81523672@gmail.com", "RFP Received !",
						body, true, "fxqz gjdr jlza kxas");

			}

			if ("success".equals(s))
				rd = request.getRequestDispatcher("./listRFP");
			else
				rd = request.getRequestDispatcher("../failure.jsp");
			rd.forward(request, response);
		}

		if (uri.endsWith("addCategory")) {
			String categoryName = request.getParameter("categoryName");
			String status = request.getParameter("status");
			boolean sts = "active".equals(status);

			service = SessionFactory.getService();
			cat = new Category();
			Category catCheck = new Category();
			catCheck = service.getCatByCategoryName(categoryName);
			if (catCheck != null) {
				rd = request.getRequestDispatcher("./listCategories");
			} else {
				LocalDate currentDate = LocalDate.now();
				Date sqlDate = Date.valueOf(currentDate);
				cat.setCreateDate(sqlDate);
				cat.setCategoryName(categoryName);
				cat.setStatus(sts);

				String s = service.addCat(cat);
				System.out.println(s);

				if ("success".equals(s))
					rd = request.getRequestDispatcher("./listCategories");
				else
					rd = request.getRequestDispatcher("../failure.jsp");
			}
			rd.forward(request, response);
		}

		if (uri.endsWith("addVendor")) {

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			BigDecimal revenue = BigDecimal.valueOf(Integer.parseInt(request.getParameter("revenue")));
			int numEmployees = Integer.parseInt(request.getParameter("numEmployees"));
			String gstNo = request.getParameter("gstNo");
			String panNo = request.getParameter("panNo");
			String phone = request.getParameter("phone");
			String[] categoryValues = request.getParameterValues("categories");
			List<Integer> categoryIds = new ArrayList<>();

			// for collecting category id
			if (categoryValues != null) {
				Pattern pattern = Pattern.compile("categoriesId=(\\d+)");

				for (String categoryValue : categoryValues) {
					Matcher matcher = pattern.matcher(categoryValue);

					while (matcher.find()) {
						int categoryId = Integer.parseInt(matcher.group(1));
						categoryIds.add(categoryId);
					}
				}
			}

			for (int id : categoryIds)
				System.out.println(id + "  ");

			service = SessionFactory.getService();
			VendorRegister data = service.getVendorByEmail(email);
			if (data != null) {
				// vendor email already exists
				rd = request.getRequestDispatcher("../failure.jsp");
				request.setAttribute("failureReason", "Email id already exists in database");
				rd.forward(request, response);
			} else {

				User newUser = new User();
				newUser.setFirstName(firstName);
				newUser.setLastName(lastName);
				newUser.setEmail(email);
				newUser.setPassword(password);
				newUser.setRole("Vendor");
				newUser.setStatus(false);

				System.out.println("Adding to rfp user table");
				service.add(newUser);

				int newVendorUserId = service.getRFPUserIdByEmail(email);
				System.out.println("fetched newVendorUserid :: " + newVendorUserId);

				LocalDate currentDate = LocalDate.now();
				Date sqlDate = Date.valueOf(currentDate);

				vd = new VendorRegister();
				vd.setUserId(newVendorUserId);
				vd.setFirstName(firstName);
				vd.setCreateDate(sqlDate);
				vd.setLastName(lastName);
				vd.setEmail(email);
				vd.setPassword(password);
				vd.setRevenue(revenue);
				vd.setNumberOfEmployee(numEmployees);
				vd.setGstNumber(gstNo);
				vd.setPanNumber(panNo);
				vd.setPhoneNumber(phone);

				String s = service.addVendor(vd);

// save vendor category Map  data
				for (int ids : categoryIds) {
					VendorCategoryMap vcm = new VendorCategoryMap();
					vcm.setVendor(newVendorUserId);
					vcm.setCategories(ids);
					String vcmStatus = service.addVendorCategoryMap(vcm);
					System.out.println(vcmStatus);
				}

				System.out.println(s);

				if ("success".equals(s)) {
					String body = "<html><body style='font-family: Arial, sans-serif;'>";
					body += "<p>Dear " + firstName + ",</p>";
					body += "<p>Thank you for registering with our RFP Management System!</p>";
					body += "<p>We're thrilled to have you on board. With our platform, you can efficiently manage your request for proposal processes, collaborate with your team members, and gain valuable insights to optimize your strategies.</p>";
					body += "<p>If you have any questions or need assistance, please don't hesitate to reach out to our support team.</p>";
					body += "<p>Once again, welcome aboard, and thank you for choosing our RFP Management System!</p>";
					body += "<p>Best regards,<br>";
					body += "Admin<br>";

					SessionFactory.SendMail("RFP", email, "demoemaild81523672@gmail.com", "Registration Successful !",
							body, true, "fxqz gjdr jlza kxas");
					rd = request.getRequestDispatcher("../login.jsp");

				} else
					rd = request.getRequestDispatcher("../failure.jsp");
			}
			rd.forward(request, response);

		}

		if (uri.endsWith("vRegisterPage")) {
			service = SessionFactory.getService();
			List<Category> allcat;
			allcat = service.listAllCat();
			System.out.println(allcat);
			request.setAttribute("allcat", allcat);
			rd = request.getRequestDispatcher("../register_vendor.jsp");
			rd.forward(request, response);
		}
		if (uri.endsWith("listRFP")) {
			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("admin"));
			if (session != null && session.getAttribute("admin") != null) {
				service = SessionFactory.getService();
				List<RFPList> lstRFP;
				lstRFP = service.listAdinRFP();
				System.out.println(lstRFP);
				request.setAttribute("rfp", lstRFP);
				rd = request.getRequestDispatcher("../AdminRFPlist.jsp");

			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}

			rd.forward(request, response);
		}
		if (uri.endsWith("listAdminQuote")) {

			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("admin"));
			if (session != null && session.getAttribute("admin") != null) {

				service = SessionFactory.getService();
				List<RFPQuote> lstQt;
				lstQt = service.listAdminQuote();
				System.out.println(lstQt);
				request.setAttribute("rfp", lstQt);
				rd = request.getRequestDispatcher("../AdminRFquotes.jsp");

			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}

			rd.forward(request, response);
		}
		if (uri.endsWith("listAdminCat")) {

			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("admin"));
			if (session != null && session.getAttribute("admin") != null) {
				service = SessionFactory.getService();
				List<Category> lstCat;
				lstCat = service.listAllCat();
				System.out.println(lstCat);
				request.setAttribute("cat", lstCat);
				rd = request.getRequestDispatcher("../AdminCategory.jsp");

			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}
			rd.forward(request, response);
		}
		if (uri.endsWith("listVendor")) {
			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("admin"));
			if (session != null && session.getAttribute("admin") != null) {
				service = SessionFactory.getService();
				List<VendorRegister> lstvd;
				lstvd = service.listAllVendor();
				System.out.println(lstvd);
				request.setAttribute("vd", lstvd);
				rd = request.getRequestDispatcher("../AdminVendors.jsp");

			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}

			rd.forward(request, response);
		}
		if (uri.endsWith("listCategories")) {
			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("admin"));
			if (session != null && session.getAttribute("admin") != null) {

				service = SessionFactory.getService();
				List<Category> lstCat;
				lstCat = service.listAllCat();
				System.out.println(lstCat);
				request.setAttribute("cat", lstCat);
				rd = request.getRequestDispatcher("../AdminCategory.jsp");
			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}
			rd.forward(request, response);
		}
		if (uri.endsWith("changeCatSts")) {
			int id = Integer.parseInt(request.getParameter("catId"));
			service = SessionFactory.getService();
			Long lid = (long) id;
			Category temp = service.getAllCatById(lid);
			boolean x = temp.isStatus();
			x = x ? false : true;
			temp.setStatus(x);

			System.out.println(temp);
			service.updateCategory(temp);

			rd = request.getRequestDispatcher("./listCategories");
			rd.forward(request, response);
		}
		if (uri.endsWith("changeVendorSts")) {
			int id = Integer.parseInt(request.getParameter("VendorId"));
			service = SessionFactory.getService();
			VendorRegister temp = service.getVendorById(id);
			User user = service.getUserById(id);
			Boolean x = temp.isStatus();
			x = x ? false : true;
			temp.setStatus(x);
			user.setStatus(x);
			System.out.println(temp);
			service.updateVendor(temp);
			service.updateUser(user);

			rd = request.getRequestDispatcher("./listVendor");
			rd.forward(request, response);
		}
		if (uri.endsWith("changeRFPListSts")) {
			int id = Integer.parseInt(request.getParameter("id"));
			service = SessionFactory.getService();

			RFPList temp = service.getRFPListById(id);
			boolean x = temp.isAminStatus();
			x = x ? false : true;
			temp.setAminStatus(x);

			System.out.println(temp);
			service.updateRFPList(temp);

			rd = request.getRequestDispatcher("./listRFP");
			rd.forward(request, response);
		}
		if (uri.endsWith("vendorApplyrfp")) {
			int id = Integer.parseInt(request.getParameter("id"));
			service = SessionFactory.getService();

			System.out.println(id);
			request.setAttribute("name", id);
			rd = request.getRequestDispatcher("../VendorRFPform.jsp");
			rd.forward(request, response);
		}

		if (uri.endsWith("addCreateRFP")) {

			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("admin"));
			if (session != null && session.getAttribute("admin") != null) {

				service = SessionFactory.getService();
				List<Category> lstCat;
				lstCat = service.listAllCat();
				System.out.println(lstCat);
				request.setAttribute("allCat", lstCat);
				rd = request.getRequestDispatcher("../AdminCreateRFP.jsp");
			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}

			rd.forward(request, response);
		}
		if (uri.endsWith("adminSelectCatForRFP")) {
			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("admin"));
			if (session != null && session.getAttribute("admin") != null) {

				int categories = Integer.parseInt(request.getParameter("categories"));
				service = SessionFactory.getService();
				List<VendorRegister> lstCat;

				lstCat = service.getAllVendorByCatId(categories);
				System.out.println(lstCat);
				if (lstCat == null)
					rd = request.getRequestDispatcher("../AdminCreateRFP.jsp");
				else {
					request.setAttribute("allVendor", lstCat);
					request.setAttribute("catId", categories);
					rd = request.getRequestDispatcher("../AdminCreateRFPform.jsp");
				}

			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}

			rd.forward(request, response);
		}

		if (uri.endsWith("vendorRFP")) {

			service = SessionFactory.getService();
			List<RFPList> lstRFP;

			// Retrieve the VendorRegister object from the session
			HttpSession session = request.getSession(false); // Get existing session, do not create if it doesn't exist
			User vendor = (User) session.getAttribute("vendor");

			int userId = vendor.getUserId();

			lstRFP = service.getRFPListByUserID(userId);

			System.out.println(lstRFP);
			request.setAttribute("rfp", lstRFP);
			request.setAttribute("name", name);
			rd = request.getRequestDispatcher("../VendorRFquotes.jsp");

			rd.forward(request, response);
		}

		if (uri.endsWith("adminWelcomePage")) {
			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("admin"));
			if (session != null && session.getAttribute("admin") != null) {
				rd = request.getRequestDispatcher("../AdminWelcome.jsp");
			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}

			rd.forward(request, response);
		}
		if (uri.endsWith("showCatPage")) {
			HttpSession session = request.getSession(false);
			System.out.println(session.getAttribute("admin"));
			if (session != null && session.getAttribute("admin") != null) {
				rd = request.getRequestDispatcher("../addCategory.jsp");
			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}
			rd.forward(request, response);
		}
		if (uri.endsWith("vendorWelcomePage")) {
			HttpSession session = request.getSession(false); // Get existing session, do not create if it doesn't exist

			// Check if the user is logged in
			session.removeAttribute("admin");

			System.out.println(session.getAttribute("vendor"));
			if (session != null && session.getAttribute("vendor") != null) {
				rd = request.getRequestDispatcher("../VendorWelcome.jsp");
			} else {
				// User is not logged in or session is null, forward to VendorWelcome.jsp
				rd = request.getRequestDispatcher("../login.jsp");
			}
			rd.forward(request, response);
		}
		if (uri.endsWith("logout")) {

			HttpSession session = request.getSession(false); // Get existing session, do not create if it doesn't exist
			if (session != null && session.getAttribute("admin") != null) {
				// User is logged in, proceed with logout
				session.removeAttribute("admin"); // Remove the 'vendor' attribute from session
				session.invalidate(); // Invalidate the session
				// Redirect user to the login page or any other page as needed
				rd = request.getRequestDispatcher("../login.jsp"); // Redirect to login page
			} else if (session != null && session.getAttribute("vendor") != null) {
				// User is logged in, proceed with logout
				session.removeAttribute("vendor"); // Remove the 'vendor' attribute from session
				session.invalidate(); // Invalidate the session
				// Redirect user to the login page or any other page as needed
				rd = request.getRequestDispatcher("../login.jsp"); // Redirect to login page
			} else {
				// User is not logged in, redirect to login page
				rd = request.getRequestDispatcher("../login.jsp"); // Redirect to login page
			}
			rd.forward(request, response);
		}

	}

}
