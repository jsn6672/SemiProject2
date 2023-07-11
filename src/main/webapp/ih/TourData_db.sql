create table TourData(
    d_contentsid varchar2(40) primary key,
    d_title varchar2(30 char) not null,
    d_address varchar2(100 char),
    d_roadaddress varchar2(100 char),
    d_introduction varchar2(400 char) not null,
    d_phoneno varchar2(50 char),
    d_alltag varchar2(300 char),
    d_imgpath varchar2(300 char),
    d_tourcount number(3),
    d_gradeavg number(5, 3)
);

drop table TourData;


insert into TourData values('cnt_2010201','성산일출뽕', '제주도턱별시', '백두한라길', '절경이넹', '010-1234-5027', '#셀카#제쥬','wjfiaiw.jpg', 12, 2.231 );


SELECT * FROM TourData;


