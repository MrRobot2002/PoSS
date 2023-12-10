CREATE TABLE users (
    user_id INT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

CREATE TABLE roles (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(255) UNIQUE NOT NULL,
    permissions TEXT
);

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);


CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock_level INT NOT NULL
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


CREATE TABLE order_items (
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    PRIMARY KEY (order_id, product_id)
);


CREATE TABLE payments (
    payment_id INT PRIMARY KEY,
    order_id INT,
    amount DECIMAL(10, 2) NOT NULL,
    payment_type VARCHAR(50) NOT NULL,
    payment_state VARCHAR(50) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);


CREATE TABLE services (
    service_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    availability BOOLEAN NOT NULL
);


CREATE TABLE service_bookings (
    booking_id INT PRIMARY KEY,
    service_id INT,
    customer_id INT,
    employee_id INT,
    booking_time TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (service_id) REFERENCES services(service_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);