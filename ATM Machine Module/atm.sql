create database ATM;
use atm;
create table Customer(
CustomerId int (10) ,
Name varchar(20) not null ,
Account_No int (10) not null ,
Phone_No int (10) not null,
Address varchar(50) not null,
Email varchar(20) not null ,
Date_Of_Birth int(8) not null ,
primary key (CustomerId)
);
create table Account_Info(
Account_No int (10) not null ,
Balance int (6) not null ,
Card_No int (10) not null ,
PIN int (4) not null ,
primary key(Card_No)
);

insert into Customer(CustomerId,Cust_Name,Account_No,Phone_No,Address,Email,DOB) 
values(9891,'Durga',54321,1234567890,'delhi','durga@abc.com',
'1997-02-11');

insert into Customer(CustomerId,Cust_Name,Account_No,Phone_No,Address,Email,DOB) 
values(9892,'Ravi',54322,1234567891,'delhi','ravi@abc.com',
'1967-05-16');

insert into Customer(CustomerId,Cust_Name,Account_No,Phone_No,Address,Email,DOB) 
values(9893,'Kamal',54323,1234567892,'jaipur','kamal@abc.com',
'1857-12-31');

insert into Customer(CustomerId,Cust_Name,Account_No,Phone_No,Address,Email,DOB) 
values(9894,'Rahul',54324,1234567893,'kashipur','rahul@xxx.com',
'1995-09-28');

insert into Account_info(Account_No,Balance,Card_NO,PIN) values (54321,5000.45,45911520,4591);
insert into Account_info(Account_No,Balance,Card_NO,PIN) values (54322,8000.95,45911521,4592);
insert into Account_info(Account_No,Balance,Card_NO,PIN) values (54323,90000.85,45911522,4593);
insert into Account_info(Account_No,Balance,Card_NO,PIN) values (54324,75.75,45911523,4594);