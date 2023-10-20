INSERT INTO tb_ticket (name, ticket_description, price, quantity) VALUES ('The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 9.99, 1);
INSERT INTO tb_ticket (name, ticket_description, price, quantity) VALUES ('The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 8.99, 4);
INSERT INTO tb_ticket (name, ticket_description, price, quantity) VALUES ('Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', 7.49, 3);
INSERT INTO tb_ticket (name, ticket_description, price, quantity) VALUES ('BATMAN The Dark Knight', 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.', 11.99, 2);

INSERT INTO tb_payment (type, name_client, total_value) VALUES ('CREDIT_CARD', 'João Vitor', 9.99);
INSERT INTO tb_payment (type, name_client, total_value) VALUES ('PIX', 'Maria', 8.99);
INSERT INTO tb_payment (type, name_client, total_value) VALUES ('DEBIT_CARD', 'Zé', 7.49);
INSERT INTO tb_payment (type, name_client, total_value) VALUES ('PIX', 'Jailson', 11.99);

INSERT INTO tb_order_item (payment_id, ticket_id) VALUES (1, 1);
INSERT INTO tb_order_item (payment_id, ticket_id) VALUES (2, 2);
INSERT INTO tb_order_item (payment_id, ticket_id) VALUES (3, 3);
INSERT INTO tb_order_item (payment_id, ticket_id) VALUES (4, 4);

INSERT INTO tb_order (name_client, ticket_name, total_purchase_price, type) VALUES ('João Vitor', 'The Shawshank Redemption', 9.99, 'CREDIT_CARD');
INSERT INTO tb_order (name_client, ticket_name, total_purchase_price, type) VALUES ('Maria', 'The Godfather', 8.99, 'PIX');
INSERT INTO tb_order (name_client, ticket_name, total_purchase_price, type) VALUES ('Zé', 'Pulp Fiction', 7.49, 'DEBIT_CARD');
INSERT INTO tb_order (name_client, ticket_name, total_purchase_price, type) VALUES ('Jailson', 'BATMAN The Dark Knight', 11.99, 'PIX');

