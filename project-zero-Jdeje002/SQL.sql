// customer table 
 create table customer(
 customer_Id Serial Primary key,
 name1 varchar(50),
 name2 varchar(50),
 password varchar(25),
 balance real,
 approved varchar(50)
);

//employee table

create table employee(
 customer_Id Serial Primary key,
 name1 varchar(50),
 password varchar(25)
);

// joint account table
Create table jointAccount(
customer_id serial primary Key,
mainAccountHolder varchar(50),
secondaryAccountHolder varchar(50),
password varchar(50),
balance real,
accountApproved varchar(50)
);