insert into notice(a_no) select a_no from article where a_c_no=1;

create sequence videourl_seq;
drop table videourl
create table videourl(
no number primary key,
title varchar2(500) not null,
url_info varchar2(300) not null,
url_link varchar2(2000) not null,
regdate date not null
)
select a.a_no, a.a_title, m.nickname, to_char(a.a_regdate,'yyyy-mm-dd'), a.hit, c.c_c_name from member m, article a, epilogue e, c_category c where m.id=a.id and a.a_no=e.a_no and e.c_c_no=c.c_c_no and a.a_c_no=1 and (a.a_title LIKE '%test%')


select a.a_no, a.a_title, m.nickname, to_char(a.a_regdate,'yyyy-mm-dd') as "date", a.hit, c.c_c_name from member m, article a, epilogue e, c_category c
where m.id=a.id and a.a_no=e.a_no and e.c_c_no=c.c_c_no and a.a_c_no=1 and (a.a_content LIKE '%?%') 

select a.a_no, a.a_title, m.nickname, to_char(a.a_regdate,'yyyy-mm-dd') as 'date', a.hit, c.c_c_name from member m, article a, epilogue e, c_category c 
where m.id=a.id and a.a_no=e.a_no and e.c_c_no=c.c_c_no and a.a_c_no=1 and e.c_c_no=1
			


select rnum, no, title, a_date, hit, priority, nickname from(
					select row_number() over(order by a.a_no desc) as rnum, a.a_no as no, a.a_title as title,
					to_char(a.a_regdate,'yyyy-mm-dd') as a_date, a.hit as hit, n.priority as priority
					from article a, notice n, member m where a.a_no=n.a_no and a_c_no=2) where rnum between 1 and 5"
					

-- 공지리스트(우선)					
select rnum, art_no, art_title, id, art_date, art_hit, priority
from(
	select row_number() over(order by a.art_no desc) as rnum, a.art_no, a.art_title, a.id
	to_char(a.art_date,'yyyy-mm-dd') as art_date, a.art_hit, n.priority
	from article a, notice n
	where a.art_no=n.art_no and art_cat_no=2
)
where priority=1
 
-- 공지리스트(일반)
select rnum, art_no, art_title, id, art_date, art_hit, priority 
from(
	select row_number() over(order by a.art_no desc) as rnum, a.art_no, a.art_title, a.id
	to_char(a.art_date,'yyyy-mm-dd') as art_date, a.art_hit, n.priority
	from article a, notice n
	where a.art_no=n.art_no and art_cat_no=2
)
where rnum between ? and ?
					
-- 로그인								
select m.id, m.name, m.nick, g.gr_name 
from grade g,member m 
where id=? and password=? and g.gr_no=m.gr_no					
					
-- 공지글 상세정보
select a.id, a.art_title, a.art_content,
	to_char(a.art_date, 'yyyy.mm.dd hh24:mi:ss') as art_date, a.art_hit, n.priority
from article a, notice n 
where a.art_no=n.art_no and a.art_no=1
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					