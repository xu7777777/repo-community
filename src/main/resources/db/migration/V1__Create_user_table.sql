
-- auto-generated definition
create table USER
(
	ID int AUTO_INCREMENT primary key not null,
	NAME VARCHAR(50),
	ACCOUNT_ID VARCHAR(50),
	TOKEN VARCHAR(50),
	GMT_CREATE BIGINT,
	GMT_MODIFY BIGINT
)
;