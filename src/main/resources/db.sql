DROP DATABASE IF EXISTS hit_the_road;
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

INSERT INTO hit_the_road.supplies (name) VALUES ('Canivete Bear Grylls');
INSERT INTO hit_the_road.supplies (name) VALUES ('Catana');
INSERT INTO hit_the_road.supplies (name) VALUES ('Desodorizante');
INSERT INTO hit_the_road.supplies (name) VALUES ('Fruta da Época');
INSERT INTO hit_the_road.supplies (name) VALUES ('Garrafa de Água');
INSERT INTO hit_the_road.supplies (name) VALUES ('Lata de Atum');
INSERT INTO hit_the_road.supplies (name) VALUES ('Lata de Feijões');
INSERT INTO hit_the_road.supplies (name) VALUES ('Lata de Salsichas');
INSERT INTO hit_the_road.supplies (name) VALUES ('Papel Higiénico');
INSERT INTO hit_the_road.supplies (name) VALUES ('Preservativos');
INSERT INTO hit_the_road.supplies (name) VALUES ('Refresco de Cevada');
INSERT INTO hit_the_road.supplies (name) VALUES ('Repelente de Insectos');
INSERT INTO hit_the_road.supplies (name) VALUES ('Saco de Cama');
INSERT INTO hit_the_road.supplies (name) VALUES ('Toalhetes');