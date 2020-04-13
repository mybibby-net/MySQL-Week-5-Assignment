CREATE database IF NOT EXISTS pizza;

use pizza;

DROP TABLE IF EXISTS pizzas;

CREATE TABLE pizzas (
	id int NOT NULL auto_increment,
	pizzaName varchar(50) NOT NULL,
	PRIMARY KEY (id)
);