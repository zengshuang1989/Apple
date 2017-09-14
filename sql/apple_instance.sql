
delete from role where id in (1,2,3,4,5);
insert into role(id,name,type) values (1,'中国银行','机构');
insert into role(id,name,type) values (2,'工商银行','机构');
insert into role(id,name,type) values (3,'邮政银行','机构');
insert into role(id,name,type) values (4,'小明','往来人员');
insert into role(id,name,type) values (5,'姐姐','家庭成员');

delete from account where id in (1,2,3,4,5,6);
insert into account(id,name,type,role_id,remark) values (1,'我的现金','现金',NULL,NULL);
insert into account(id,name,type,role_id,remark) values (2,'我的工商卡','卡折',3,'工资卡');
insert into account(id,name,type,role_id,remark) values (3,'我的邮政卡','卡折',3,NULL);
insert into account(id,name,type,role_id,remark) values (4,'我的中行卡','信用卡',1,NULL);
insert into account(id,name,type,role_id,remark) values (5,'微信','第三方储值',NULL,NULL);
insert into account(id,name,type,role_id,remark) values (6,'支付宝','第三方储值',NULL,NULL);


delete from category where id in (1,2,3,4,5,6,7,8,9,10,11,12,13);
insert into category(id,pid,name,type) values ('1','','职业工薪','收入');
insert into category(id,pid,name,type) values ('2','1','工资','收入');
insert into category(id,pid,name,type) values ('3','1','资金','收入');
insert into category(id,pid,name,type) values ('4','','人情收入','收入');
insert into category(id,pid,name,type) values ('5','4','红包','收入');
insert into category(id,pid,name,type) values ('6','4','礼金','收入');
insert into category(id,pid,name,type) values ('7','','餐费','支出');
insert into category(id,pid,name,type) values ('8','7','早餐','支出');
insert into category(id,pid,name,type) values ('9','7','中餐','支出');
insert into category(id,pid,name,type) values ('10','7','晚餐','支出');
insert into category(id,pid,name,type) values ('11','','服装鞋帽','支出');
insert into category(id,pid,name,type) values ('12','11','衣服','支出');
insert into category(id,pid,name,type) values ('13','11','鞋类','支出');



