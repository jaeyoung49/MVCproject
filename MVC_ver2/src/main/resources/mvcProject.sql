-- 회원 등급 테이블
drop table grade;
create table grade(
gr_no number primary key, -- 등급 번호(PK)
gr_name varchar2(100) not null, -- 등급 이름
art_count_low number not null, -- 최소 게시글 갯수
re_count_low number not null -- 최소 댓글 갯수
)

select * from grade;
insert into grade(gr_no, gr_name, art_count_low, re_count_low)
values(1, '준회원', 0, 0);
insert into grade(gr_no, gr_name, art_count_low, re_count_low)
values(2, '정회원', 1, 1);
insert into grade(gr_no, gr_name, art_count_low, re_count_low)
values(3, '우수회원', 11, 11);
insert into grade(gr_no, gr_name, art_count_low, re_count_low)
values(4, 'VIP회원', 51, 51);
insert into grade(gr_no, gr_name, art_count_low, re_count_low)
values(5, '운영자', 0, 0);

-- 회원 테이블
drop table member;
create table member(
id varchar2(50) primary key, -- 회원 아이디(PK)
password varchar2(50) not null, -- 회원 비밀번호
name varchar2(50) not null, -- 회원 이름
sex varchar2(20) not null, -- 회원 성별
email varchar2(100) not null, -- 회원 이메일
nick varchar2(100) not null, -- 회원 닉네임
birthday varchar2(20) not null, -- 회원 생일
regdate date not null, -- 가입일
art_count number default 0, -- 게시글 갯수
re_count number default 0, -- 댓글 갯수
gr_no number default 1, -- 등급 번호(FK)
constraint fk_member foreign key(gr_no) references grade(gr_no) -- 등급 번호 참조
)

-- 글 카테고리 번호 시퀀스
drop sequence seq_art_category;
create sequence seq_art_category;
-- 글 카테고리 테이블
drop table art_category;
create table art_category(
art_cat_no number primary key, -- 글 카테고리 번호(PK)
art_cat_name varchar2(100) not null -- 글 카테고리 명
)

insert into art_category(art_cat_no, art_cat_name) values(seq_art_category.nextval, '에필로그');
insert into art_category(art_cat_no, art_cat_name) values(seq_art_category.nextval, '공지사항');
insert into art_category(art_cat_no, art_cat_name) values(seq_art_category.nextval, 'QnA');

-- 게시글 번호 시퀀스
drop sequence seq_article;
create sequence seq_article;

-- 답글 그룹번호 시퀀스
drop sequence seq_resp_group1;
create sequence seq_resp_group1;

-- 글 정보 테이블
drop table article;
create table article(
art_no number primary key, -- 게시글 번호(PK)
id varchar2(50) not null, -- 회원 아이디(FK)
art_cat_no number not null, -- 글 카테고리 번호(FK)
art_title varchar2(100) not null, -- 게시글 제목
art_content clob not null, -- 게시글 내용
art_date date not null, -- 등록날짜
art_hit number default 0, -- 조회수
resp_group number not null, -- 답글 그룹번호
resp_order number default 0 not null, -- 답글 순서
resp_step number default 0 not null, -- 답글 단계
constraint fk_article1 foreign key(id) references member(id), -- 회원 아이디 참조
constraint fk_article2 foreign key(art_cat_no) references art_category(art_cat_no) -- 글 카테고리 번호 참조
)

-- 화장품 카테고리 번호 시퀀스
drop sequence seq_cos_category;
create sequence seq_cos_category;

-- 화장품 카테고리 테이블 cosmetic_category
drop table cosmetic_category;
create table cosmetic_category(
cos_cat_no number primary key, -- 화장품 카테고리 번호(PK)
cos_cat_name varchar2(100) not null -- 화장품 카테고리 명
)
insert into cosmetic_category values(1, '립스틱');
insert into cosmetic_category values(2, '마스카라');

-- 후기 글 추가 정보 테이블
drop table epilogue;
create table epilogue(
art_no number not null, -- 게시글 번호(FK)
cos_cat_no number not null, -- 화장품 카테고리 번호(FK)
image_path varchar2(100), -- 이미지 경로
file_name varchar2(100), -- 파일 이름
file_ext varchar2(100), -- 파일 확장자
constraint fk_epilogue foreign key(art_no) references article(art_no), -- 게시글 번호 참조
constraint fk_epilogue2 foreign key(cos_cat_no) references cosmetic_category(cos_cat_no) -- 화장품 카테고리 번호 참조
)

-- 공지 글 추가 정보 테이블
drop table notice;
create table notice(
art_no number not null, -- 게시글 번호(FK)
priority number default 0, -- 상위 표시 여부 0:기본 1: 상위표시
constraint fk_notice foreign key(art_no) references article(art_no) -- 게시글 번호 참조
)

-- 댓글 번호 시퀀스
drop sequence seq_reply;
create sequence seq_reply;

-- 답글 그룹번호 시퀀스
drop sequence seq_re_resp_group;
create sequence seq_re_resp_group;

-- 댓글 정보 테이블
drop table reply;
create table reply(
re_no number primary key, -- 댓글 번호(PK)
id varchar2(100) not null, -- 회원 아이디(FK)
art_no number not null, -- 게시글 번호(FK)
re_content clob not null, -- 댓글 내용
re_date date not null, -- 댓글 작성일
re_resp_group number not null, -- 답글 그룹번호
re_resp_order number default 0 not null, -- 답글 순서
re_resp_step number default 0 not null, -- 답글 단계
constraint fk_reply foreign key(id) references member(id), -- 회원 아이디 참조
constraint fk_reply2 foreign key(art_no) references article(art_no) -- 게시글 번호 참조
)

------------------------------------------------------------------------------------------------------------------------------------ / 후순위