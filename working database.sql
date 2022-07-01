CREATE TABLE person
(
  person_ID INT NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  PRIMARY KEY (person_ID)
);
INSERT INTO person VALUES(1,'Ahmed','Ali');
INSERT INTO person VALUES(2,'Mohamed','Samir');
INSERT INTO person VALUES(3,'Fady','Nour');
INSERT INTO person VALUES(4,'Mohamed','Ahmed');
INSERT INTO person VALUES(5,'Abdelrahman','El-Sayed');
INSERT INTO person VALUES(6,'Adel','Khaled');

CREATE TABLE _Admin
(
  person_ID INT NOT NULL,
  admin_username VARCHAR(50) NOT NULL,
  admin_password VARCHAR(50) NOT NULL,
  PRIMARY KEY (person_ID),
  FOREIGN KEY (person_ID) REFERENCES person(person_ID)
);
INSERT INTO _Admin VALUES(2,'Mohamed123','Samir4231');
INSERT INTO _Admin VALUES(3,'Fady123','Nour4231');


CREATE TABLE category
(
  Category_ID INT NOT NULL,
  Category_Name VARCHAR(50) NOT NULL,
  PRIMARY KEY (Category_ID)
);
INSERT INTO category VALUES(1,'Computer Accessory');
INSERT INTO category VALUES(2,'Computer Accessory');
INSERT INTO category VALUES(3,'Computer Accessory');
INSERT INTO category VALUES(4,'Smart phones');

CREATE TABLE Information
(
  Info_ID INT NOT NULL,
  Address VARCHAR(50) NOT NULL,
  PRIMARY KEY (Info_ID)
);
INSERT INTO Information VALUES(1,'Ain Shams');
INSERT INTO Information VALUES(2,'El-Abaseya');
INSERT INTO Information VALUES(3,'Nasr City');
INSERT INTO Information VALUES(4,'El-Salam City');
INSERT INTO Information VALUES(5,'El-Qobba Bridge');
INSERT INTO Information VALUES(6,'Badr City');

CREATE TABLE Personal_Info
(
  Info_ID INT NOT NULL,
  Gender VARCHAR(10) NOT NULL,
  Phone INT NOT NULL,
  Email VARCHAR(50) NOT NULL,
  PRIMARY KEY (Info_ID),
  FOREIGN KEY (Info_ID) REFERENCES Information(Info_ID)
);
INSERT INTO Personal_Info VALUES(1,'Male',0122365857,'Ahmed4231@yahoo.com');
INSERT INTO Personal_Info VALUES(2,'Male',0125365057,'Moahmed31@yahoo.com');
INSERT INTO Personal_Info VALUES(3,'Male',0115366057,'Fady123@yahoo.com');
INSERT INTO Personal_Info VALUES(4,'Male',0115366906,'MohamedAhmed21@yahoo.com');
INSERT INTO Personal_Info VALUES(5,'Male',0115397906,'Abdelrahman4231@yahoo.com');
INSERT INTO Personal_Info VALUES(6,'Male',0115743790,'Adel431@yahoo.com');

CREATE TABLE supplier
(
  person_ID INT NOT NULL,
  Info_ID INT NOT NULL,
  PRIMARY KEY (person_ID),
  FOREIGN KEY (person_ID) REFERENCES person(person_ID),
  FOREIGN KEY (Info_ID) REFERENCES Personal_Info(Info_ID)
);
INSERT INTO supplier VALUES(1,1);
INSERT INTO supplier VALUES(4,4);

CREATE TABLE customer
(
  person_ID INT NOT NULL,
  personal_Info_ID INT NOT NULL,
  customer_username VARCHAR(50) NOT NULL,
  customer_password VARCHAR(50) NOT NULL,
  Balance INT ,
  PRIMARY KEY (person_ID),
  FOREIGN KEY (person_ID) REFERENCES person(person_ID),
  FOREIGN KEY (personal_Info_ID) REFERENCES Personal_Info(Info_ID)
);
INSERT INTO customer VALUES(1,1,'Ahmed123','Ali4231',1000);
INSERT INTO customer VALUES(4,4,'Moahmed123','Ahmed4231',2000);
INSERT INTO customer VALUES(5,5,'Abdelrahman123','El-Sayed4231',3000);
INSERT INTO customer VALUES(6,6,'Adel123','Khaled4231',4000);


CREATE TABLE Item
(
  Item_ID INT NOT NULL,
  Admin_ID INT NOT NULL,
  Supplier_ID INT NOT NULL,
  Price INT NOT NULL,
  Item_name VARCHAR(50) NOT NULL,
  Address VARCHAR(50) NOT NULL,
  Weight INT NOT NULL,
  Quantitiy INT NOT NULL,
  PRIMARY KEY (Item_ID),
  FOREIGN KEY (Admin_ID) REFERENCES _Admin(person_ID),
  FOREIGN KEY (Supplier_ID) REFERENCES supplier(person_ID)
);
INSERT INTO Item VALUES(1,2,1,500,'Camera','Nasr City',10,50);
INSERT INTO Item VALUES(2,2,1,600,'Harddisk','Ain Shams',5,120);
INSERT INTO Item VALUES(3,3,4,700,'Mouse','El-Abaseya',2,55);
INSERT INTO Item VALUES(4,3,4,650,'iPhone','Badr City',5,30);

CREATE TABLE Billing_Info
(
  Info_ID INT NOT NULL,
  customer_ID INT NOT NULL,
  Credit_Card_ID INT NOT NULL,
  Billing_Date DATE NOT NULL,
  PRIMARY KEY (Info_ID),
  FOREIGN KEY (Info_ID) REFERENCES Information(Info_ID),
  FOREIGN KEY (customer_ID) REFERENCES customer(person_ID)
);
INSERT INTO Billing_Info VALUES(1,1,75998553,6/2/2022);
INSERT INTO Billing_Info VALUES(2,4,98998553,4/6/2022);
INSERT INTO Billing_Info VALUES(3,5,45848553,6/4/2022);
INSERT INTO Billing_Info VALUES(4,6,13998576,2/7/2022);



CREATE TABLE Cart
(
  Cart_ID INT NOT NULL,
  Item_ID INT NOT NULL,
  customer_ID INT NOT NULL,
  Products_number INT NOT NULL,
  Total_Price INT NOT NULL,
  PRIMARY KEY (Cart_ID),
  FOREIGN KEY (Item_ID) REFERENCES Item(Item_ID),
  FOREIGN KEY (customer_ID) REFERENCES customer(person_ID)
);
INSERT INTO Cart VALUES(1,1,1,1,500);
INSERT INTO Cart VALUES(2,2,4,2,1200);
INSERT INTO Cart VALUES(3,3,5,2,1400);
INSERT INTO Cart VALUES(4,4,6,1,650); 

CREATE TABLE _Order
(
  _Order_ID INT NOT NULL,
   customer_ID INT NOT NULL,
  _Order_No INT NOT NULL,
  _date DATE NOT NULL,
  shipped__by VARCHAR(50) NOT NULL,
  Shipped_Date DATE NOT NULL,
  PRIMARY KEY (_Order_ID),
  FOREIGN KEY (customer_ID) REFERENCES customer(person_ID)
);
INSERT INTO _Order VALUES(1,1,20,6/1/2022,'JAPAN',7/1/2022);
INSERT INTO _Order VALUES(2,4,21,4/5/2022,'CANDA',5/5/2022);
INSERT INTO _Order VALUES(3,5,24,6/3/2022,'USA',7/3/2022);
INSERT INTO _Order VALUES(4,6,31,2/6/2022,'CHINA',3/6/2022);


CREATE TABLE Order_Details
(
  _Order_ID INT NOT NULL,
  Item_ID INT NOT NULL,
  Price INT NOT NULL,
  Quantity INT NOT NULL,
  PRIMARY KEY (_Order_ID),
  FOREIGN KEY (_Order_ID) REFERENCES _Order(_Order_ID),
  FOREIGN KEY (Item_ID) REFERENCES Item(Item_ID)
);
INSERT INTO Order_Details VALUES(1,1,500,1);
INSERT INTO Order_Details VALUES(2,2,1200,2);
INSERT INTO Order_Details VALUES(3,3,1400,2);
INSERT INTO Order_Details VALUES(4,4,650,1);

CREATE TABLE Belongs_to
(
  Item_ID INT NOT NULL,
  Category_ID INT NOT NULL,
  PRIMARY KEY (Item_ID, Category_ID),
  FOREIGN KEY (Item_ID) REFERENCES Item(Item_ID),
  FOREIGN KEY (Category_ID) REFERENCES category(Category_ID)
);
INSERT INTO Belongs_to VALUES(1,1);
INSERT INTO Belongs_to VALUES(2,2);
INSERT INTO Belongs_to VALUES(3,3);
INSERT INTO Belongs_to VALUES(4,4);