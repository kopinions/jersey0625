CREATE TABLE products(
  id serial primary key,
  name varchar(255)
);


CREATE TABLE prices(
  id serial primary key,
  price numeric,
  product_id int references products
);
