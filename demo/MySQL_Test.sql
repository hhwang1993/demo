
------------------------------------------------------------------

-- users_database.stock
CREATE TABLE users_database.stock (
    id bigint(20) unsigned not null auto_increment comment 'Id',
    stock_name varchar(32)  comment '股票名稱',
    stock_no  int(10)  comment '股票代碼',
    update_time datetime comment '更新時間',  
    create_time datetime  default current_timestamp comment '建立時間',
    primary key (id),
    unique (stock_name)
)  engine=innodb default charset=utf8 comment='股票資料表';  

insert into users_database.stock (stock_name, stock_no, update_time, create_time) values ('玉山',	 8996, '2020-12-28 13:18:8', '2020-12-18 13:8:8');
insert into users_database.stock (stock_name, stock_no, update_time, create_time) values ('中信',	 8997, '2020-12-28 13:19:8', '2020-12-18 13:8:8');
insert into users_database.stock (stock_name, stock_no, update_time, create_time) values ('元大',	 8998, '2020-12-28 13:20:8', '2020-12-18 13:8:8');
insert into users_database.stock (stock_name, stock_no, update_time, create_time) values ('新光',	 8999, '2020-12-28 13:28:8', '2020-12-18 13:8:8');
------------------------------------------------------------------

-- users_database.price  
create table users_database.price  
(  
    id bigint(20) unsigned not null auto_increment,
    stock_id bigint(20) not null comment '股票Id',
    /* 交易日期  取代成 交易時間, 節省儲存空間  */
    trade_time datetime not null default current_timestamp comment '交易時間',
    trade_price decimal(10,2) not null comment '交易價格',
    quantity bigint(20) not null comment '交易量',
    update_time datetime comment '更新時間', 
    create_time datetime not null default current_timestamp comment '建立時間',
    primary key (id),
    key price_trade_time_idx (trade_time) using btree
)engine=innodb default charset=utf8 comment='價格資料表';  

insert into users_database.price (stock_id, trade_time, trade_price, quantity, update_time , create_time) 
values (1, '2020-12-18 13:20:8', 2, 4, '2020-12-18 13:22:8', '2020-12-18 13:20:8');
insert into users_database.price (stock_id, trade_time, trade_price, quantity, update_time , create_time) 
values (2, '2020-12-18 14:26:8', 6, 8, '2020-12-18 14:28:8', '2020-12-18 14:26:8');
insert into users_database.price (stock_id, trade_time, trade_price, quantity, update_time , create_time) 
values (3, '2020-12-18 14:26:8', 6, 8, '2020-12-18 14:28:8', '2020-12-18 14:26:8');
insert into users_database.price (stock_id, trade_time, trade_price, quantity, update_time , create_time) 
values (4, '2020-12-18 14:26:8', 6, 8, '2020-12-18 14:28:8', '2020-12-18 14:26:8');
insert into users_database.price (stock_id, trade_time, trade_price, quantity, update_time , create_time) 
values (5, '2020-10-23 13:28:8', 6, 8, '2020-12-18 14:28:8', '2020-12-18 14:26:8');
------------------------------------------------------------------