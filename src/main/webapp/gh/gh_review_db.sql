create table rent_review(
	rent_review_no	number(3) primary key,
	rent_shop_no	number(3) not null,
	rent_id		varchar2(20) not null,
	rent_grade	number(4,2) not null,
	rent_date	date not null,
	rent_car	varchar2(100) not null,
	rent_review	varchar2(500) not null,
	rent_img	varchar2(200) not null
);

create sequence rent_review_seq;

insert into rent_review values(rent_review_seq.nextval,'1','gh','5',sysdate,'모닝','좋아요','img');



select * from rent_review;

drop table	rent_review cascade constraint purge;

    drop sequence rent_review_seq;