# RFP Management System
### Introduction
"RFP Management" is a comprehensive system facilitating the issuance and management of Requests for Proposals (RFPs) by companies or government agencies. Vendors register on the platform to access RFPs issued by the company. They can submit quotes for consideration, subject to company approval. The system ensures full and open competition while allowing companies to evaluate both responsiveness to specifications and cost-effectiveness. The admin panel enables companies to review all quotes submitted by vendors, streamlining the RFP process efficiently.

Implementation of RFP Management System: 
There are Three Module in it:
1.	Login and Registration
2.	Admin Panel
3.	Vendors Panel
### 1.	Login page: 
The login page should be the first screen you encounter when accessing the system. you will see fields to enter your credentials. There will typically be two fields: one for your username/email and the other for your password. Ensure that the information you provide is accurate and matches the credentials associated with your account. Once you have entered your credentials, click on the "Login" button. The system will then validate your credentials.  If the credentials provided are correct and match those stored in the system, you will be successfully logged in. You will then be redirected to the appropriate dashboard or landing page based on your user type. 
 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/70e3e6a5-6ef8-4f7f-a68b-83a0bca3f19a)


If the credentials provided are incorrect or do not match any existing accounts, you will receive an error message.
 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/05fcc5f9-c099-4e19-b38b-90b505eddf0d)


### Vendor Registration:
The vendor registration page facilitates the registration process for vendors, ensuring that their data is securely stored and managed separately. Vendors are allowed to register within the active categories of Requests for Proposals (RFPs). Once vendors have submitted their information, it undergoes an approval process by the admin. Only after the admin has reviewed and approved the vendor's data can they gain access to the system through their login credentials. This ensures a controlled and secure environment, where only verified vendors can participate in the system's operations.
 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/b4b49ec4-6cb1-498d-99a8-26a127565b41)


### 2.Admin Panel:
In the admin panel, there will user name and logout button in the right-up corner. On the left side of the home page, there will be a few tabs there which are given below:
•	Home
•	Vendors List
•	RFP List
•	RFP Quotes
•	Categorie
1.	Home Page: page will be the welcome page of the admin.
 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/29eecaad-b173-4f5b-8a79-c0cb3c85797c)


2.	Vendor List:
 Vendor will get list in descending order according to created date. Admins review and approve vendors here. It offers an overview of registered vendors awaiting approval, ensuring adherence to standards before granting system access.
 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/103ffe31-4fee-4f4c-a4bf-a5d747400c1e)


3.	RFP List: Admins manage new and existing RFPs, creating new ones and taking action on existing ones. They have the authority to close RFPs as needed.
 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/6031a9ef-4ea0-4e1a-9e37-bcf6d90e6bcb)

4.	Create RFP: After clicking "Add RFP," the RFP creation form opens, providing fields for entering essential details and specifications required for the Request for Proposal.
 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/2376433a-2464-4e75-9fc4-0cf43b1038a0)


When creating an RFP, it's crucial to select the appropriate category to which the RFP belongs. 
![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/d3d1392d-864d-4320-8d74-a7847668b2c5)

5.	RFP Quotes: This section displays all quotes submitted by vendors, arranged in descending order based on their creation date. Each quote is listed with its corresponding RFP ID and Quote ID for easy reference.

 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/493b824d-24b3-4ccc-b878-d16bc3b190bc)

6.	Categories: All categories are listed here in descending order of creation date. Admins can create new categories and manage existing ones, activating or deactivating them as required. This facilitates organized categorization and ensures efficient management of the system's offerings.

 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/eeefddce-aa14-4e27-b35c-ab86ada9118d)

7.	Create Categories: This section features fields for category name selection and status toggling between active and inactive. Two buttons, "Submit" and "Cancel," enable easy category creation or cancellation, streamlining the process for administrators.
 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/e4ef1d17-2ff4-4d83-8504-ba2eb9978752)



### 3.Vendors Panel:
Home page will be the welcome page of the admin.
![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/2b940e0e-bcd2-4533-9e3f-aa34f2bce3dd)

 
•	RFP List: Here, RFPs matching vendors' categories are displayed. Vendors can apply once per RFP; afterward, the apply button disappears. This ensures fair application processes and prevents duplicate submissions, facilitating efficient vendor engagement with relevant opportunities.
 ![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/97993fd0-2f54-40b5-837a-73c9f0a954b0)

After clicking 'Apply' on the RFP list page, a form appears. Vendors provide necessary data and submit it. Admins can then view submitted quotes on the quote list, facilitating streamlined communication and evaluation of vendor proposals.
 
![image](https://github.com/Jeetu-chaudhary/RFP-Management/assets/112170073/fed04a92-1e35-4c29-8e76-f9fe973e0192)



## Database Code

create database as below:

```bash
 

create database VelocityPrjdb;
use velocityPrjdb;

create table RFP_categories(
	categories_id int not null primary key AUTO_INCREMENT,
	categories_name varchar(100),
	status boolean
	);
    alter table rfp_categories add create_date date;
   
create table RFP_user_details(
user_id int not null primary key auto_increment,
first_name varchar(50) not null ,
last_name  varchar(50) not null ,
email varchar(100) not null ,
password varchar(100)not null, 
role varchar(10) not null,
status boolean
);
   
create table RFP_vendor_detail(
user_id int not null primary key,
first_name varchar(50) not null ,
last_name  varchar(50) not null ,
email varchar(100) not null ,
password varchar(100)not null ,
revenue DECIMAL(10, 2) NOT NULL,
No_of_employee int not null ,
GST_No varchar(15) not null ,
PAN_No varchar(10) not null ,
phone_No varchar(15) not null ,
create_date date,
foreign key(user_id) references RFP_user_details(user_id) on delete cascade
);
 alter table RFP_vendor_detail add status boolean;



CREATE TABLE vendor_category_map (
    map_id INT AUTO_INCREMENT PRIMARY KEY,
    vendor_id INT,
    category_id INT,
    FOREIGN KEY (vendor_id) REFERENCES  RFP_vendor_detail(user_id),
    FOREIGN KEY (category_id) REFERENCES RFP_categories (categories_id),
    unique key(vendor_id,category_id)
);



create table RFP_list(
RFP_No int not null primary key auto_increment,
Title varchar(500),
Lastdate date,
minAmount DECIMAL(10, 2) ,
maxAmount DECIMAL(10, 2) ,
Item_Description varchar(1000),
Quantity  int,
category_id int,
aminStatus boolean default true,
 vendorStatus boolean default false,
 create_date date,

foreign key(category_id) references RFP_categories(categories_id) on delete cascade
);


create table RFP_quotes(
quoteId int not null primary key auto_increment,
vendor_id int not null ,
vendor_price DECIMAL(10, 2),
Item_Description varchar(1000),
Quantity int,
total_cost DECIMAL(10, 2),
RFP_No int ,
create_date date,
foreign key(vendor_id) references RFP_vendor_detail(user_id) on delete cascade,
foreign key(RFP_No) references RFP_list(RFP_No) on delete cascade
);
 

INSERT INTO RFP_categories (categories_name, status, create_date)
VALUES 
('Finance', 1, '2024-03-28'),
('Healthcare', 1, '2024-03-28'),
('Construction', 1, '2024-03-28');


INSERT INTO RFP_user_details (first_name, last_name, email, password, role, status) VALUES
('John', 'Doe', 'john@example.com', 'password123', 'Admin', true);










```
    
