CREATE TABLE tb_order (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type_payment VARCHAR(255) NOT NULL,
    name_client VARCHAR(255) NOT NULL,
    ticket_name VARCHAR(255),
    total_purchase_price DOUBLE NOT NULL
);

CREATE TABLE tb_payment(
    id INT AUTO_INCREMENT PRIMARY KEY,
    payment_name VARCHAR(255) NOT NULL,
	name_client VARCHAR(255) NOT NULL,	
    total_value DOUBLE NOT NULL
);

CREATE TABLE tb_ticket(
    id INT AUTO_INCREMENT PRIMARY KEY,
    ticket_name VARCHAR (255) NOT NULL,
    ticket_description VARCHAR(1000) NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
);

CREATE TABLE tb_order_item(
   id INT AUTO_INCREMENT PRIMARY KEY,
   payment_id INT,
   ticket_id INT,
   FOREIGN KEY (payment_id) REFERENCES tb_payment(id),
   FOREIGN KEY (ticket_id) REFERENCES tb_ticket(id)
);

 