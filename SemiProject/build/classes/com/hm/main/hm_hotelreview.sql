create table hotelR_test(
	r_no number(3) primary key,
	r_username varchar2(10 char) not null,
	r_content varchar2(10 char) not null,
	r_contentname varchar2(20 char) not null,
	r_starpoint decimal(3, 1) not null,
	r_review varchar2(400 char) not null,
	r_img varchar2(300 char) 
);

DROP TABLE hotelR_test;

create sequence hotelR_test_seq;

insert into hotelR_test values
(hotelR_test_seq.nextval,'phm','숙박','마빈','4.5','정말 죽여줘요','누락 새끼야');	

select * from hotelR_test;
