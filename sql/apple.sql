
/* 创建schema */
drop   database if exists apple;
create database apple character set utf8;

/* 创建用户 */
drop   user 'banana'@'localhost';
create user 'banana'@'localhost' identified by 'banana';
GRANT all privileges ON apple.* TO 'banana'@'localhost'; 

/* 使用schema */
use apple;

/* 人员机构表 */
DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id     INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name   VARCHAR(128)     NOT NULL,
  type   VARCHAR(32)      NOT NULL,
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  PRIMARY KEY (ID)
);

/* 帐户表 */
DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id        INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name      VARCHAR(128)     NOT NULL,
  type      VARCHAR(32)      NOT NULL,
  role_id   INTEGER UNSIGNED,
  remark    VARCHAR(4000),
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  PRIMARY KEY (ID)
);

/* 分类表：收入，支出，转账 */
DROP TABLE IF EXISTS category;
CREATE TABLE category (
  id     INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pid    INTEGER UNSIGNED,
  name   VARCHAR(128) NOT NULL,
  type   VARCHAR(32) NOT NULL,
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  PRIMARY KEY (ID)
);

/* 记录表 */
DROP TABLE IF EXISTS record;
CREATE TABLE record (
  id INTEGER        UNSIGNED NOT NULL AUTO_INCREMENT,
  category_id       INTEGER UNSIGNED NOT NULL,
  flowout_acct_id   INTEGER UNSIGNED,
  flowin_acct_id    INTEGER UNSIGNED,
  money DOUBLE      NOT NULL,
  remark            VARCHAR(4000),
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  PRIMARY KEY (id)
);
