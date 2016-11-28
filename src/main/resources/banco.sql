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

create table person_animals(
  person_id int not null,
  foreign key(person_id) references people(id),
  animal_id int not null,
  foreign key(animal_id) references animals(id),
);

create table diary_config(
  id int not null auto_increment primary key,
  agenda int not null,
  person_id int not null,
  FOREIGN KEY(person_id) references people(id),
  hours_capacity int
);

create table schedule(
  id int not null auto_increment primary key,
  diary_config_id int not null,
  foreign key(diary_config_id) references diary_config(id),
  schedule_date date,
  schedule_time smallint,
  animal_id int not null,
  foreign key(animal_id) references animal(id),
  observations varchar(255)
);

create table orders(
  id int not null auto_increment primary key,
  access_key varchar(255),
  schedule_id int not null,
  foreign key(schedule_id) references schedule(id),
  animal_id int not null,
  foreign key(animal_id) references animal(id),
  price float
);

create table medicines(
  id int not null auto_increment primary key,
  identification varchar(255),
  description varchar(255),
  item_type int not null,
  price float
);

create table orders_items(
  id int not null auto_increment primary key,
  order_id int not null,
  foreign key(order_id) references orders(id),
  item_id int not null,
  foreign key(item_id) references medicines(id),
  quantity int,
  unitary_price float,
  total float
);
