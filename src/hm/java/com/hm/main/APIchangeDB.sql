create table hotelGrade_test(
d_contentsid varchar2(40 char) primary key,
d_title varchar2(100 char) not null,
d_reviewcnt number(3),
d_gradeavg number(5,3) 
);

drop table hotelgrade_test cascade constraint purge;

insert into HOTELgrade_test values 
('adfas','테스트제목','0','0');

SELECT * FROM hotelGrade_test WHERE d_title = '몬딱쉼터';

select * from hotelGrade_test WHERE d_title like '%스카이%';

select * from user_constraints where constraint_name = 'SYS_C007838';