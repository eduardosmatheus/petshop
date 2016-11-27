create database petshop;

use petshop;

create table breeds(
  id int not null auto_increment primary key,
  description varchar(255)
);

create table especies(
  id int not null auto_increment primary key,
  description varchar(255)
);

create table people(
  id int not null auto_increment primary key,
  cpf varchar(255),
  name varchar(255),
  phone varchar(32),
  email varchar(255)
);

create table animals(
  id int not null auto_increment primary key,
  person_id int not null,
  FOREIGN KEY(person_id) references people(id),
  breed_id int not null,
  FOREIGN KEY(breed_id) references breeds(id),
  especie_id int not null,
  FOREIGN KEY(especie_id) references especies(id),
  name varchar(255),
  birthday date,
  observations varchar(255)
);
