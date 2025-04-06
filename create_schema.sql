CREATE DATABASE newtestdb;

create table newtestdb.employees (
    id int auto_increment primary key,
    username varchar(50) not null,
    email varchar(100) not null,
    password varchar(100) not null,
    role enum ('admin', 'employee') default 'employee' null,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    constraint email unique (email),
    constraint username unique (username)
);

create table newtestdb.attendance (
    id int auto_increment primary key,
    employee_id int not null,
    time_in datetime not null,
    time_out datetime null,
    date date not null,
    constraint attendance_ibfk_1 foreign key (employee_id) references newtestdb.employees (id)
);

create index employee_id on testdb.attendance (employee_id);