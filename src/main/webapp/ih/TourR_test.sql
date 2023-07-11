create table TourR_test(
    r_no number(3) primary key,
    r_name varchar2(20 char) not null,
    r_title varchar2(20 char) not null,
    r_content varchar2(10 char) not null,
    r_starpoint decimal(3, 1) not null,
    r_review varchar2(200 char) not null,
    r_img varchar2(300 char)
);
create sequence TourR_test_seq;

insert into TourR_test values(TourR_test_seq.nextval,'인후', '조아요', '관광', 4.2, '재밌어요','NULL');




select * from TourR_Test ;


select * from ih_test where r_title = '상추자포구';