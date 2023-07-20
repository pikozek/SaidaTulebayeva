insert into users(name, orderList) values('Pikozek', '1, 2');
insert into users(name, orderList) values('Ayau', '3');
insert into users(name, orderList) values('Ayashite', '4, 6');
insert into users(name, orderList) values('Botashite', '5');
--delete from users where id = 1;
----product list
insert into products(name, price) values('Cake', 8000); --1
insert into products(name, price) values('Cupcake', 500); --2
insert into products(name, price) values('Apple Pie', 2500); --3
insert into products(name, price) values('Cheesecake', 7000); --4
insert into products(name, price) values('Chocolate brownie', 6050); --5
insert into products(name, price) values('Cookies', 200); --6
insert into products(name, price) values('Creme caramel', 1500);--7
insert into products(name, price) values('Pudding', 2000); --8
--order list
insert into orders(userID, productList) values(1, '7, 2');
insert into orders(userID, productList) values(1, '1, 4, 5');
insert into orders(userID, productList) values(2, '4, 6');
insert into orders(userID, productList) values(3, '3');
insert into orders(userID, productList) values(3, '3, 8');
insert into orders(userID, productList) values(4, '1, 2');
