create table rentshop_data(
	shop_no			number(3) primary key,
	shop_placename	varchar2(30) not null,
	shop_jibun		varchar2(200) not null,
	shop_doro		varchar2(200) not null,
	shop_longitude	number(20,17) not null,
	shop_latitude	number(20,17) not null,
	shop_url		varchar2(200) not null,
	shop_grade_avg		number(4,2) not null,
	shop_grade_cnt	number(3) not null
    );

    create sequence rentshop_data_seq;
    
    insert into rentshop_data values(rentshop_data_seq.nextval,'렌트카샵', '지번', '도로명', 12.123456789123, 123.123456789123,'http://test.com',5,10);
    
    select * from rentshop_data;
    
    drop table rentshop_data;
    drop sequence rentshop_data_seq;
    
    select * from RENTSHOP_DATA where shop_jibun like '%서%';
    
    delete from RENTSHOP_DATA where shop_no = 1;
    
    select * from RENTSHOP_DATA where shop_no = 5;
    
    
    
    
    