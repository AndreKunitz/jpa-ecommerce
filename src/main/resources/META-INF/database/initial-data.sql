insert into product (id, name, price, description) values (1, 'Kindle', 499.0, 'Meet the new Kindle, now with adjustable recessed lighting that lets you read indoors or outdoors, any time of day.');
insert into product (id, name, price, description) values (3, 'Camera GoPro Hero 7', 1400.0, 'Twice the performance.');

insert into client (id, name) values (1, 'André Kunitz');
insert into client (id, name) values (2, 'John Doe');

insert into orders (id, client_id, order_date, total, status) values (1, 1, sysdate(), 100.0, 'AWAITING');

insert into order_line_item (id, order_id, product_id, product_price, quantity) values (1, 1, 1, 5.0, 2);

