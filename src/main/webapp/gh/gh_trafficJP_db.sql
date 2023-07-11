create table jp_rentshop_data(
	shop_no			number(3) primary key,
	shop_placename	varchar2(200) not null,
	shop_jibun		varchar2(200) not null,
	shop_doro		varchar2(200) not null,
	shop_longitude	number(20,17) not null,
	shop_latitude	number(20,17) not null,
	shop_url		varchar2(200) not null,
	shop_grade_avg		number(4,2) not null,
	shop_grade_cnt	number(3) not null
    );

    select * from jp_rentshop_data;
    
    drop table jp_rentshop_data cascade constraint purge;