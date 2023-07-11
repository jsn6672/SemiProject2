-- User Table
CREATE TABLE IHUser (
    user_id VARCHAR(20) PRIMARY KEY
    
);

-- Review Table
create table ih_review (
    r_no number(3) PRIMARY KEY,
    r_name varchar2(20 char) not null,
    r_title varchar2(20 char) not null,
    r_starpoint decimal(2, 1) not null,
    r_review varchar2(200 char) not null,
    r_img varchar2(300 char),
    user_id VARCHAR(20),
    d_contentsid VARCHAR(40),
    FOREIGN KEY (user_id) REFERENCES IHUser(user_id)
    
);
drop table ih_review;

CREATE SEQUENCE ih_review_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

select * from ih_review;



create table ih_test(
    r_no number(3) PRIMARY KEY,
    r_name varchar2(20 char) not null,
    r_title varchar2(20 char) not null,
    r_starpoint decimal(2, 1) not null,
    r_review varchar2(200 char) not null,
    r_img varchar2(300 char)


);

select * from ih_test;

CREATE SEQUENCE ih_test_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE;



select  * from ih_test;