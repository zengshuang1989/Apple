/* 参与角色 */
delete from role where id in (1, 2, 3, 4, 5);
insert into role
       (id, name,       type) 
values (1,  '中国银行', 'INSTITUTION'),
       (2,  '工商银行', 'INSTITUTION'),
       (3,  '邮政银行', 'INSTITUTION'),
       (4,  '小明',     'OUTSIDER'),
       (5,  '姐姐',     'FAMILY');

/* 账户 */
delete from account where id in (1, 2, 3, 4, 5, 6);
insert into account
       (id, name,         type,          role_id, remark) 
values (1, '我的现金',    'CASH',        NULL,    NULL),
       (2, '我的工商卡',  'SAVINGS',     3,       '工资卡'),
       (3, '我的邮政卡',  'SAVINGS',     3,       NULL),
       (4, '我的中行卡',  'CREDIT_CARD', 1,       NULL),
       (5, '微信',        'ONLINE',      NULL,    NULL),
       (6, '支付宝',      'ONLINE',      NULL,    NULL);


/* 收支分类 */
delete from category where id in (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
insert into category
       ( id,   pid,  name,       type) 
values ( '1',   '',  '职业工薪', 'INCOME'),
       ( '2',  '1',  '工资',     'INCOME'),
       ( '3',  '1',  '奖金',     'INCOME'),
       ( '4',   '',  '人情收入', 'INCOME'),
       ( '5',  '4',  '红包',     'INCOME'),
       ( '6',  '4',  '礼金',     'INCOME'),
       ( '7',   '',  '餐费',     'EXPENSES'),
       ( '8',  '7',  '早餐',     'EXPENSES'),
       ( '9',  '7',  '中餐',     'EXPENSES'),
       ('10',  '7',  '晚餐',     'EXPENSES'),
       ('11',   '',  '服装鞋帽', 'EXPENSES'),
       ('12',  '11', '衣服',     'EXPENSES'),
       ('13',  '11', '鞋类',     'EXPENSES');
