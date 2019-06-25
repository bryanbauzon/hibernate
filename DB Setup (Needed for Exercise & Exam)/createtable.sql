
create schema training; 

drop table training.ACCOUNT;
drop table training.CUSTOMER;


create table training.CUSTOMER (
    CUSTOMERID bigint generated always as identity not null, 
    VERSION int not null,
    LASTNAME varchar(50),
    FIRSTNAME varchar(50),
    ADDRESS1 varchar(100),
    ADDRESS2 varchar(100),
    CITY varchar(50),
    STATE varchar(50),
    ZIP varchar(10),
    COUNTRY varchar(50),
    primary key (CUSTOMERID)
);

create table training.ACCOUNT (
    ACCOUNTID bigint generated always as identity not null, 
    VERSION int not null,
    CUSTOMERID bigint not null,
    TYPE varchar(1),
    BALANCE double,
    primary key (ACCOUNTID),
    constraint FK_ACCOUNT_1 foreign key (CUSTOMERID) references training.CUSTOMER (CUSTOMERID)
);
