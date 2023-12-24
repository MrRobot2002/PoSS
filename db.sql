-- Role Table
CREATE TABLE Role (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    permission INT NOT NULL
);


-- Tenant Table
CREATE TABLE Tenant (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(255),
    username VARCHAR(255) NOT NULL,
    password VARCHAR(500) NOT NULL,
    salt VARCHAR(500) NOT NULL
);

-- Employee Table
CREATE TABLE Employee (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    tenant_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES Role(id),
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- Loyalty Table
CREATE TABLE Loyalty (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    tenant_id INT NOT NULL,
    discount DECIMAL(10,2) NOT NULL CHECK (discount > 0 AND discount <= 100),
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- Customer Table
CREATE TABLE Customer (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    loyalty_id INT,
    tenant_id INT NOT NULL,
    FOREIGN KEY (loyalty_id) REFERENCES Loyalty(id),
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- Service Table
CREATE TABLE Service (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    currency INT NOT NULL,
    tenant_id INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- Product Table
CREATE TABLE Product (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    currency INT NOT NULL,
    tenant_id INT NOT NULL,
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- Discount Table
CREATE TABLE Discount (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    discount DECIMAL(10,2) NOT NULL CHECK (discount > 0 AND discount <= 100),
    tenant_id INT NOT NULL,
    FOREIGN KEY (tenant_id) REFERENCES Tenant(id)
);

-- Employee_Services Table
CREATE TABLE Employee_Services (
    employee_id INT NOT NULL,
    service_id INT NOT NULL,
    PRIMARY KEY (employee_id, service_id),
    FOREIGN KEY (employee_id) REFERENCES Employee(id),
    FOREIGN KEY (service_id) REFERENCES Service(id)
);

-- Booking Table
CREATE TABLE Booking (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    service_id INT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(id),
    FOREIGN KEY (customer_id) REFERENCES Customer(id),
    FOREIGN KEY (service_id) REFERENCES Service(id)
);

-- Order Table
CREATE TABLE `Order` (
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
CREATE TABLE OrderItem (
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

-- Payment Table
CREATE TABLE Payment (
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

-- Employee_Availability Table
CREATE TABLE Employee_Availability (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
);
