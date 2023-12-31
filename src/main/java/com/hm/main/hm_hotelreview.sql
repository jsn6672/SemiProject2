create table hotelR_test(
	r_no number(3) primary key,
	r_cid varchar2(30 char) not null,
	r_id varchar2(10 char) not null,
	r_title varchar2(20 char) not null,
	r_reviewname varchar2(20 char) not null,
	r_grade decimal(3, 1) not null,
	r_text varchar2(400 char) not null,
	r_img varchar2(300 char) 
);

DROP TABLE hotelR_test cascade constraint purge;

create sequence hotelR_test_seq;

insert into hotelR_test values 
(hotelR_test_seq.nextval,'CNTS_000000000018706','phm','마빈','마빈 이용 후기','4.5','정말 좋아요','',sysdate);	

select * from hotelR_test;

alter table hotelR_test add r_date date;

update hotelR_test set r_date = SYSDATE;

alter table hotelR_test add r_date date default sysdate;

select * from hotelR_test;





