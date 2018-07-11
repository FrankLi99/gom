--  在未开发注册页面之前插入一条测试数据alter
insert into t_user(id,email, name , password , reg_ip  ,  reg_date t_user)
values(0,'frank@gmail.com','frank','202cb962ac59075b964b07152d234b70','127.0.0.1',sysdate());

insert into t_loginfo(user_id,login_ip,login_date)
select id,reg_ip,reg_date from t_user



insert  into `t_items`(`id`,`name`,`price`,`detail`,`pic`,`createtime`)
values (1,'台式机',3000.0,'该电脑质量非常好！！！！',NULL,'2015-02-03 13:22:53'),
(2,'笔记本',6000.0,'笔记本性能好，质量好！！！！！',NULL,'2015-02-09 13:22:57'),
(3,'背包',200.0,'名牌背包，容量大质量好！！！！',NULL,'2015-02-06 13:23:02');

insert  into `t_orders`(`id`,`user_id`,`number`,`createtime`,`note`)
values (3,1,'1000010','2015-02-04 13:22:35',NULL),
(4,1,'1000011','2015-02-03 13:22:41',NULL)

insert  into `t_orderdetail`(`id`,`orders_id`,`items_id`,`items_num`)
values (1,3,1,1),
(2,3,2,3),
(3,4,3,4),
(4,4,2,3);