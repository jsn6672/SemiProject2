create table login_test(
l_id varchar2(20 char) primary key,
l_username varchar2(20 char) not null,
l_pw varchar2(20 char) not null
);

create sequence login_test_seq;

insert into login_test values ('hmin0701','박하민', 'park0701');

 DROP TABLE login_test cascade constraint purge;

select * from login_test;
