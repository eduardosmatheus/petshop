CREATE TABLE employeer (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  cpf  VARCHAR(255) not NULL,
  name  VARCHAR(255) not NULL,
  phone  VARCHAR(255) not NULL,
  email  VARCHAR(255) not NULL,
  PRIMARY KEY(id)
);

CREATE TABLE customer (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name  VARCHAR(255) not NULL,
  cpf  VARCHAR(255) not NULL,
  phone  VARCHAR(255) not NULL,
  email  VARCHAR(255) not NULL,
  PRIMARY KEY(id)
);

CREATE TABLE itens (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  description  VARCHAR(255) not NULL,
  price DECIMAL NULL,
  stock_amount FLOAT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE especies (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  description  VARCHAR(255) not NULL,
  PRIMARY KEY(id)
);

CREATE TABLE breeds (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name  VARCHAR(255) not NULL,
  PRIMARY KEY(id)
);

CREATE TABLE appointment_config (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  employeer_id INTEGER UNSIGNED NOT NULL,
  entryTime BIGINT NULL,
  lunchTime BIGINT NULL,
  entryTimeAfterLunch BIGINT NULL,
  homeTime BIGINT NULL,
  PRIMARY KEY(id),
  INDEX appointment_config_FKIndex1(employeer_id),
  FOREIGN KEY(employeer_id)
    REFERENCES employeer(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE animal (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  especies_id INTEGER UNSIGNED NOT NULL,
  breeds_id INTEGER UNSIGNED NOT NULL,
  customer_id INTEGER UNSIGNED NOT NULL,
  name  VARCHAR(255) not NULL,
  birth DATE NULL,
  obs  VARCHAR(255) not NULL,
  PRIMARY KEY(id),
  INDEX animal_FKIndex1(customer_id),
  INDEX animal_FKIndex2(breeds_id),
  INDEX animal_FKIndex3(especies_id),
  FOREIGN KEY(customer_id)
    REFERENCES customer(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(breeds_id)
    REFERENCES breeds(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(especies_id)
    REFERENCES especies(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE appointments (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  animal_id INTEGER UNSIGNED NOT NULL,
  appointment_config_id INTEGER UNSIGNED NOT NULL,
  date DATE NULL,
  entryTime BIGINT NULL,
  outTime BIGINT NULL,
  obs  VARCHAR(255) not NULL,
  PRIMARY KEY(id),
  INDEX appointments_FKIndex1(appointment_config_id),
  INDEX appointments_FKIndex2(animal_id),
  FOREIGN KEY(appointment_config_id)
    REFERENCES appointment_config(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(animal_id)
    REFERENCES animal(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE service_order (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  appointments_id INTEGER UNSIGNED NOT NULL,
  access_key  VARCHAR(255) not NULL,
  price DECIMAL NULL,
  PRIMARY KEY(id),
  INDEX service_order_FKIndex1(appointments_id),
  FOREIGN KEY(appointments_id)
    REFERENCES appointments(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE itens_service_orders (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  itens_id INTEGER UNSIGNED NOT NULL,
  service_order_id INTEGER UNSIGNED NOT NULL,
  amount FLOAT NULL,
  unit_price DECIMAL NULL,
  PRIMARY KEY(id),
  INDEX itens_service_orders_FKIndex1(service_order_id),
  INDEX itens_service_orders_FKIndex2(itens_id),
  FOREIGN KEY(service_order_id)
    REFERENCES service_order(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(itens_id)
    REFERENCES itens(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);
