create database PTTK;

use pttk;

create table tblCategory (
	id int auto_increment,
    name varchar(255),
    image varchar(255),
    description varchar(255),
    primary key(id)
);
create table tblPayment(
	id int auto_increment,
    type varchar(255),
    primary key(id)
);

create table tblSupplier(
	id int auto_increment,
    name varchar(255),
    contactName varchar(255),
    phoneNum varchar(20),
    email varchar(255),
    address varchar(255),
    description varchar(255),
    primary key(id)
);
create table tblStaff(
	id int auto_increment,
    name varchar(255),
    address varchar(255),
    phoneNum varchar(20),
    email varchar(255),
    username varchar(50) unique,
    password varchar(50),
    position varchar(255),
    primary key(id)
);
create table tblCustomer(
	id int auto_increment,
    username varchar(50) unique,
    password varchar(50),
    name varchar(255),
    phoneNum varchar(20),
    email varchar(255),
    address varchar(255),
    description varchar(255),
    primary key(id)
);
create table tblImportBill(
	id int auto_increment,
    date date,
    total double,
    supplierid int,
    staffid int,
    paymentMethodid int,
    primary key(id),
    foreign key(supplierid) references tblSupplier(id),
    foreign key(staffid) references tblStaff(id),
    foreign key(paymentMethodid) references tblPayment(id)
);
create table tblProduct (
	id int auto_increment,
    name varchar(255),
    unitPrice double,
    nbr_sold int,
    nbr_left int,
    description varchar(5000),
    size int,
    color varchar(50),
    image varchar(255),
    categoryid int,
    primary key (id),
	foreign key (categoryid) references tblCategory(id)
);
create table tblShoppingCart(
	id int auto_increment,
    paymentStat varchar(2),
    total double,
    customerid int, 
    primary key(id),
    foreign key(customerid) references tblCustomer(id)
);

create table tblCartItem(
	id int auto_increment,
    quantity int,
    total double,
    description varchar(255),
    productid int,
    shoppingcartid int,
    primary key(id),
    foreign key(productid) references tblProduct(id),
    foreign key(shoppingcartid) references tblShoppingCart(id)
);

create table tblVoucher(
	id int auto_increment,
    code varchar(255),
    discount int,
    status varchar(2),
    description varchar(255),
    primary key(id)
);
create table tblShipper(
	id int auto_increment,
    name varchar(255),
    phoneNum varchar(20),
    companyName varchar(100),
    address varchar(100),
    description varchar(255),
    primary key(id)
);

create table tblImportBillDetail(
	id int auto_increment,
    quantity int, 
    total double,
    description varchar(255),
    importbillid int,
    productid int, 
    primary key(id),
    foreign key(importbillid) references tblImportBill(id),
    foreign key(productid) references tblProduct(id)
);
create table tblOrderBill(
	id int auto_increment,
    date date,
    total double,
    bill_type varchar(10),
    description varchar(255),
    ship_to varchar(255),
    payment_stat varchar(10),
    ship_stat varchar(10),
    voucherid int,
    paymentid int,
    staffid int,
    shoppingcartid int,
    customerid int,
    shipperid int,       
    primary key(id),
    foreign key(voucherid) references tblVoucher(id),
    foreign key(paymentid) references tblPayment(id),
    foreign key(staffid) references tblStaff(id),
    foreign key(shoppingcartid) references tblShoppingCart(id),
    foreign key(customerid) references tblCustomer(id),
    foreign key(shipperid) references tblShipper(id)
);





insert into tblPayment(type) values ('Bank Transfer');
insert into tblPayment(type) values ('Cash');
insert into tblPayment(type) values ('COD');
insert into tblCategory(name, image, description) values ('Tivi', '', '');

insert into tblProduct(name, unitPrice, nbr_sold, nbr_left, description, size, color, image, categoryid) 
values ('Smart UHD Tivi LG 43 inch 4K 43UP7550PTC - Model 2021 - Miễn phí lắp đặt', 
'11850000', '96', '69',
'Miễn phí cho nội thành HCM (Quận 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, Tân Bình, Tân Phú, Phú Nhuận, Bình Thạnh, Gò Vấp, Quận 9, 12, Thủ Đức, Bình Tân, Hóc Môn) 
và nội thành Hà Nội (Quận Ba Đình, Quận Bắc Từ Liêm, Quận Cầu Giấy, Quận Hà Đông, Quận Hai Bà Trưng, Quận Hoàn Kiếm, Quận Hoàng Mai, Quận Long Biên, Quận Nam Từ Liêm, 
Quận Tây Hồ, Quận Thanh Xuân, Quận Đống Đa.).Chi phí vật tư: Nhân viên sẽ thông báo phí vật tư (ống đồng, dây điện v.v...) khi khảo sát lắp đặt (Bảng kê xem tại ảnh 2). 
Khách hàng sẽ thanh toán trực tiếp cho nhân viên kỹ thuật sau khi việc lắp đặt hoàn thành - chi phí này sẽ không hoàn lại trong bất cứ trường hợp nào.', 55 ,'', '', 1);

update tblProduct set image = '43UP7550PTC.jfif' where id = 1;
update tblProduct set image = '50UP7720PTC.jfif' where id = 2;

insert into tblProduct(name, unitPrice, nbr_sold, nbr_left, description, size, color, image, categoryid) 
values ('Smart UHD Tivi LG 50 Inch 4K 50UP7720PTC - Model 2021 - Miễn phí lắp đặt', 
'14590000', '9', '6',
'Miễn phí cho nội thành HCM (Quận 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, Tân Bình, Tân Phú, Phú Nhuận, Bình Thạnh, Gò Vấp, Quận 9, 12, Thủ Đức, Bình Tân, Hóc Môn) 
và nội thành Hà Nội (Quận Ba Đình, Quận Bắc Từ Liêm, Quận Cầu Giấy, Quận Hà Đông, Quận Hai Bà Trưng, Quận Hoàn Kiếm, Quận Hoàng Mai, Quận Long Biên, Quận Nam Từ Liêm, 
Quận Tây Hồ, Quận Thanh Xuân, Quận Đống Đa.).Chi phí vật tư: Nhân viên sẽ thông báo phí vật tư (ống đồng, dây điện v.v...) khi khảo sát lắp đặt (Bảng kê xem tại ảnh 2). 
Khách hàng sẽ thanh toán trực tiếp cho nhân viên kỹ thuật sau khi việc lắp đặt hoàn thành - chi phí này sẽ không hoàn lại trong bất cứ trường hợp nào.', 50 ,'', '', 1);

insert into tblProduct(name, unitPrice, nbr_sold, nbr_left, description, size, color, image, categoryid) 
values ('Smart UHD Tivi LG 55 inch 4K 55UP7550PTC - Model 2021 - Miễn phí lắp đặt', 
'16390000', '18', '92',
'Miễn phí cho nội thành HCM (Quận 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, Tân Bình, Tân Phú, Phú Nhuận, Bình Thạnh, Gò Vấp, Quận 9, 12, Thủ Đức, Bình Tân, Hóc Môn) 
và nội thành Hà Nội (Quận Ba Đình, Quận Bắc Từ Liêm, Quận Cầu Giấy, Quận Hà Đông, Quận Hai Bà Trưng, Quận Hoàn Kiếm, Quận Hoàng Mai, Quận Long Biên, Quận Nam Từ Liêm, 
Quận Tây Hồ, Quận Thanh Xuân, Quận Đống Đa.).Chi phí vật tư: Nhân viên sẽ thông báo phí vật tư (ống đồng, dây điện v.v...) khi khảo sát lắp đặt (Bảng kê xem tại ảnh 2). 
Khách hàng sẽ thanh toán trực tiếp cho nhân viên kỹ thuật sau khi việc lắp đặt hoàn thành - chi phí này sẽ không hoàn lại trong bất cứ trường hợp nào.', 55 ,'', '55UP7550PTC.png', 1);

insert into tblProduct(name, unitPrice, nbr_sold, nbr_left, description, size, color, image, categoryid) 
values ('Smart OLED TV LG 55 inch 4K OLED55B1PTA - Model 2021 - Miễn phí lắp đặt', 
'28900000', '3', '10',
'Miễn phí cho nội thành HCM (Quận 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, Tân Bình, Tân Phú, Phú Nhuận, Bình Thạnh, Gò Vấp, Quận 9, 12, Thủ Đức, Bình Tân, Hóc Môn) 
và nội thành Hà Nội (Quận Ba Đình, Quận Bắc Từ Liêm, Quận Cầu Giấy, Quận Hà Đông, Quận Hai Bà Trưng, Quận Hoàn Kiếm, Quận Hoàng Mai, Quận Long Biên, Quận Nam Từ Liêm, 
Quận Tây Hồ, Quận Thanh Xuân, Quận Đống Đa.).Chi phí vật tư: Nhân viên sẽ thông báo phí vật tư (ống đồng, dây điện v.v...) khi khảo sát lắp đặt (Bảng kê xem tại ảnh 2). 
Khách hàng sẽ thanh toán trực tiếp cho nhân viên kỹ thuật sau khi việc lắp đặt hoàn thành - chi phí này sẽ không hoàn lại trong bất cứ trường hợp nào.', 55 ,'', 'OLED55B1PTA.png', 1);

insert into tblProduct(name, unitPrice, nbr_sold, nbr_left, description, size, color, image, categoryid) 
values ('Smart FHD Tivi LG 32 Inch 32LM575BPTC ThinQ AI - Model 2021 - Miễn phí lắp đặt', 
'16390000', '44', '89',
'Miễn phí cho nội thành HCM (Quận 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, Tân Bình, Tân Phú, Phú Nhuận, Bình Thạnh, Gò Vấp, Quận 9, 12, Thủ Đức, Bình Tân, Hóc Môn) 
và nội thành Hà Nội (Quận Ba Đình, Quận Bắc Từ Liêm, Quận Cầu Giấy, Quận Hà Đông, Quận Hai Bà Trưng, Quận Hoàn Kiếm, Quận Hoàng Mai, Quận Long Biên, Quận Nam Từ Liêm, 
Quận Tây Hồ, Quận Thanh Xuân, Quận Đống Đa.).Chi phí vật tư: Nhân viên sẽ thông báo phí vật tư (ống đồng, dây điện v.v...) khi khảo sát lắp đặt (Bảng kê xem tại ảnh 2). 
Khách hàng sẽ thanh toán trực tiếp cho nhân viên kỹ thuật sau khi việc lắp đặt hoàn thành - chi phí này sẽ không hoàn lại trong bất cứ trường hợp nào.', 55 ,'', '32LM575BPTC.png', 1);

insert into tblCustomer(username, password, name, phoneNum, email, address, description)
values ('hieudx', '123456', 'Do Hieu', '0976199402', 'hieudx1', 'Hoang Mai, Ha Noi', '');

insert into tblPayment(type) values ('COD');
insert into tblPayment(type) values ('Bank Transfer');

insert into tblVoucher(code, discount, status, description) values ('1234abcd', '10', 'S', '');

SELECT * FROM tblPayment;

insert into tblImportBill(date, total, Supplierid, Staffid, PaymentMethodid) values ('2021-11-25', '10000000', '2', '1', '1');

insert into tblImportBillDetail(quantity, total, description, importbillid, productid) values (2, '5000000', '', 4, 2);
insert into tblImportBillDetail(quantity, total, description, importbillid, productid) values (1, '5000000', '', 4, 3);

select count(*) from tblimportbilldetail where importbillid = 2;
select sum(total), a.supplierid, s.name, s.address, count(a.id) importTimes from tblimportbill a, tblsupplier s where date > '2021-11-01' and date < '2021-11-30' and s.id = a.supplierid group by a.supplierid;
select * from tblimportbill where date > '2021-11-01' and date < '2021-11-30'
