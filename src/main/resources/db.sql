CREATE DATABASE hit_the_road;
USE hit_the_road;

create table preferences
(
  id int not null auto_increment
    primary key,
  userID int null,
  name varchar(128) null
)
;

create table supplies
(
  id int not null auto_increment
    primary key,
  name char(50) null,
  constraint name
  unique (name)
)
;

create table user
(
  id int not null auto_increment
    primary key,
  username char(50) null,
  password char(50) null,
  email char(50) null,
  constraint username
  unique (username)
)
;

