-- SQLBook: Code
SET NAMES utf8;
SET time_zone = '+02:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';


CREATE DATABASE IF NOT EXISTS localhost;

-- role Table
CREATE TABLE IF NOT EXISTS localhost.Role (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    permission INT NOT NULL
);

-- tenant Table
CREATE TABLE IF NOT EXISTS localhost.Tenant (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(255),
    username VARCHAR(255) NOT NULL,
    password VARCHAR(500) NOT NULL,
    salt VARCHAR(500) NOT NULL
);

-- employee Table
CREATE TABLE IF NOT EXISTS localhost.Employee (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    tenant_id INT NOT NULL,
    short_code VARCHAR(255),
    FOREIGN KEY (role_id) REFERENCES Role(id),
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- loyalty Table
CREATE TABLE IF NOT EXISTS localhost.Loyalty (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    tenant_id INT NOT NULL,
    discount DECIMAL(10,2) NOT NULL CHECK (discount > 0 AND discount <= 100),
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- customer Table
CREATE TABLE IF NOT EXISTS localhost.Customer (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    loyalty_id INT,
    tenant_id INT NOT NULL,
    FOREIGN KEY (loyalty_id) REFERENCES Loyalty(id),
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- service Table
CREATE TABLE IF NOT EXISTS localhost.Service (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    duration INT,
    amount DECIMAL(10,2) NOT NULL,
    currency INT NOT NULL,
    tenant_id INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- product Table
CREATE TABLE IF NOT EXISTS localhost.Product (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    currency INT NOT NULL,
    tenant_id INT NOT NULL,
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- discount Table
CREATE TABLE IF NOT EXISTS localhost.Discount (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    discount DECIMAL(10,2) NOT NULL CHECK (discount > 0 AND discount <= 100),
    tenant_id INT NOT NULL,
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- Booking Table
CREATE TABLE IF NOT EXISTS localhost.Booking (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    employee_id INT NOT NULL,
    service_status INT NOT NULL,
    customer_id INT NOT NULL,
    service_id INT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(id),
    FOREIGN KEY (customer_id) REFERENCES Customer(id),
    FOREIGN KEY (service_id) REFERENCES Service(id)
);

-- order Table
CREATE TABLE IF NOT EXISTS localhost.`Order` (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    employee_id INT NOT NULL,
    status INT NOT NULL,
    discount_id INT,
    tips DECIMAL(10,2),
    tenant_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customer(id),
    FOREIGN KEY (employee_id) REFERENCES Employee(id),
    FOREIGN KEY (discount_id) REFERENCES Discount(id),
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- OrderItem Table
CREATE TABLE IF NOT EXISTS localhost.OrderItem (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    category INT NOT NULL,
    service_id INT,
    product_id INT,
    quantity INT NOT NULL,
    details VARCHAR(1000),
    FOREIGN KEY (order_id) REFERENCES `Order`(id),
    FOREIGN KEY (service_id) REFERENCES Service(id),
    FOREIGN KEY (product_id) REFERENCES Product(id),
    CHECK ((service_id IS NOT NULL AND product_id IS NULL) OR (service_id IS NULL AND product_id IS NOT NULL))
);

-- payment Table
CREATE TABLE IF NOT EXISTS localhost.Payment (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    order_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    currency INT NOT NULL,
    state INT NOT NULL,
    type INT NOT NULL,
    date TIMESTAMP NOT NULL,
    tenant_id INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES `Order`(id),
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- tax Table
CREATE TABLE IF NOT EXISTS localhost.Tax (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    percent DECIMAL(10,2) NOT NULL CHECK (percent > 0 AND percent <= 100),
    tenant_id INT NOT NULL,
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);





INSERT INTO localhost.`Product` (`id`, `name`, `quantity`, `amount`, `currency`, `tenant_id`) VALUES
(1,	'Coca-Cola',	8,	2.99,	0,	1),
(2,	'Fanta',	8,	1.99,	0,	1),
(3,	'Sprite',	5,	1.99,	0,	1);

INSERT INTO localhost.`Role` (`id`, `name`, `permission`) VALUES
(1,	'Admin',	0),
(2,	'loyalty and Inventory Manager',	1),
(3,	'Inventory Manager',	2),
(4,	'loyalty Manager',	3),
(5,	'Regular employee',	4);

INSERT INTO localhost.`Service` (`id`, `name`, `duration`, `amount`, `currency`, `tenant_id`, `description`) VALUES
(1,	'Man Haircut', 60,	10.99,	0,	1,	'stylish haircut'),
(2, 'Women Haircut', 90, 15.99, 0, 1, 'elegant and trendy'),
(3, 'Children Haircut', 30, 8.50, 0, 1, 'fun and quick'),
(4, 'Beard Trim', 30, 7.99, 0, 1, 'neat and precise'),
(5, 'Hair Coloring', 120, 35.00, 0, 1, 'professional coloring');

-- password: username + '123'
INSERT INTO localhost.`Tenant` (`name`, `email`, `phone`, `username`,  `password`, `salt`) VALUES
('Demo1', 'demo1@localhost.com', '+37065431233', 'demotenant1', 'efb6a081a3531f304bdb810a000ae7c763d91e95d2661d9c0a0224c56379b9d7', 'f9b4f7f9e50ef5fbdb72988b3e035ad1'),
('Demo2', 'demo2@localhost.com', '+37065431234', 'demotenant2', '43759c4caefa2f81c1928341c0431416c93bdeb2e614ea87b49e34790d2fded4', 'ca7aa7f0b0489416f5c61a85755cebae'),
('Demo3', 'demo3@localhost.com', '+37065431235', 'demotenant3', '40af274e4e8540145cef64468c7818482f023ba3888dc407caa4cac5933e38a2', 'af6be135a7f32fe128f45ee11eac5476'),
('Demo4', 'demo4@localhost.com', '+37065431236', 'demotenant4', 'fa4102b3f3b282acfcb39eef925053bc8c5e9fd41a9ff69f4d18f8b00dc07312', '10b2600ff3bc28befb9ba3eee140001e');


