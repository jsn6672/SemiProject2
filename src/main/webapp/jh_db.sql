create table jh_account(
    a_name varchar2(20 char) not null,
    a_id varchar2(20 char) primary key,
    a_pw varchar2(20 char) not null,
    a_birth number(1) not null,
    a_gender varchar2(5 char) not null,
    a_addr varchar2(100 char) not null
    a_question varchar2(500 char) not null,
    a_question_number number(1,2) notn ull
);

select * from jh_account;

insert into jh_account values('정재환','jh','1004','1','male','빨간색','1');