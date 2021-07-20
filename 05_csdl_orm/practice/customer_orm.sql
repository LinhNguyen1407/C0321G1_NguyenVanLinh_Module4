create database customer_orm;
use customer_orm;

create table customer (
	id int primary key auto_increment,
    `name` varchar(45),
    email varchar(100),
    address varchar(255)
);

insert into customer
values
(1, 'Nam', 'nam@gmail.com', 'Đà Nẵng'),
(2, 'An', 'an@gmail.com', 'Hà Nội'),
(3, 'Lan', 'lan@gmail.com', 'Sài Gòn'),
(4, 'Hải', 'hai@gmail.com', 'Sài Gòn')
;