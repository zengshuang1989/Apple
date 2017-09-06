
drop user 'apple'@'localhost';

/*
创建schema
*/
drop database if exists apple;
create database apple character set utf8;

/*
创建用户
*/
create user 'apple'@'localhost' identified by 'apple';
GRANT all privileges ON apple.* TO 'apple'@'localhost'; 

/*
使用schema
*/
use apple;

/*帐户表*/

DROP TABLE IF EXISTS account;
CREATE TABLE account (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  type VARCHAR(128) NOT NULL,
  balance DOUBLE NOT NULL,
  PRIMARY KEY (ID)
);

/*项目表*/

DROP TABLE IF EXISTS item;
CREATE TABLE item (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  pid INTEGER UNSIGNED,
  type VARCHAR(16) NOT NULL,
  PRIMARY KEY (ID)
);
/*
记录表
*/
DROP TABLE IF EXISTS record;
CREATE TABLE record (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  item_id INTEGER UNSIGNED NOT NULL,
  acct_id INTEGER UNSIGNED NOT NULL,
  amount DOUBLE NOT NULL,
  remark VARCHAR(4000),
  time DATETIME NOT NULL,
  PRIMARY KEY (id)
);
/*
转帐表
*/
DROP TABLE IF EXISTS transfer;
CREATE TABLE transfer (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  source_acct_id INTEGER UNSIGNED NOT NULL,
  target_acct_id INTEGER UNSIGNED NOT NULL,
  amount DOUBLE NOT NULL,
  remark VARCHAR(4000),
  time DATETIME NOT NULL,
  PRIMARY KEY (id)
);