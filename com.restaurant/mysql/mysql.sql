create database javaConnectTest;
use javaConnectTest;


create table admin(
	id int not null auto_increment primary key,
    name varchar(20) not null,
    username varchar(100) not null unique,
    password varchar(100) not null,
    role varchar(100) default "staff",
    phone varchar(20)
);
alter table admin
add constraint UNIQUE_username  unique (username);
insert into admin (name,username,password,role,phone)
values ("Vu Cong Hau","hauvu", "123123","admin","012341231");
insert into admin (name,username,password,role,phone)
values ("Na Na","nana", "123123","staff","051284091");
insert into admin (name,username,password,role,phone)
values ("Long","long", "123123","admin","031323421");
insert into admin (name,username,password,role,phone)
values ("Hung","hung", "123123","staff","0923953421");

create table dish(
	id int not null auto_increment primary key,
	name varchar(20) not null,
    price DECIMAL(10, 2) not null,
    category varchar(20),
    image mediumblob
);

INSERT INTO dish (name, price, category) VALUES ('Spaghetti Bolognese', 12.99, 'Italian');
INSERT INTO dish (name, price, category) VALUES ('Chicken Tikka Masala', 15.99, 'Indian');
INSERT INTO dish (name, price, category) VALUES ('Caesar Salad', 8.99, 'Salad');
INSERT INTO dish (name, price, category) VALUES ('Coffee', 2.99, 'Beverage');
INSERT INTO dish (name, price, category) VALUES ('Iced Tea', 1.99, 'Beverage');
INSERT INTO dish (name, price, category) VALUES ('Orange Juice', 3.49, 'Beverage');

