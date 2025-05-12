-- 1. 데이터베이스 생성
CREATE DATABASE MUSTHAVE;

-- 2. 데이터베이스 선택
USE MUSTHAVE;


-- 3. 테이블 생성
CREATE TABLE MEMBER(
ID VARCHAR(10) NOT NULL,  					-- 아이디
PASS VARCHAR(10) NOT NULL,					-- 비밀번호
NAME VARCHAR(30) NOT NULL,					-- 이름
REGIDATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,	-- 가입 날짜
PRIMARY KEY(ID)
);


CREATE TABLE BOARD(
NUM INT NOT NULL AUTO_INCREMENT PRIMARY KEY,-- 게시판번호
TITLE VARCHAR(200) NOT NULL,-- 제목
CONTENT VARCHAR(2000) NOT NULL,-- 내용
ID VARCHAR(10) NOT NULL,-- ID
POSTDATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,-- 작성일자
VISITCOUNT INT-- 조회수
);

select *
from member;

INSERT INTO member (id, pass, name) VALUES ('musthave', '1234', '머스트해브');

SELECT * FROM member WHERE id='musthave' AND pass='1234';

INSERT INTO BOARD VALUES (NULL, '지금은 봄입니다', '봄의 왈츠', 'MUSTHAVE', sysdate(),0);

INSERT INTO board (title, content, id, postdate, visitcount)
VALUES ('지금은 여름입니다', '여름', 'MUSTHAVE', sysdate(), 0);

INSERT INTO member VALUES ("lallalla12", 1234, "정현정", sysdate());

SELECT *
FROM BOARD;


desc board;

DELETE
FROM BOARD 
WHERE NUM = 2;

CREATE DATABASE notice;

use notice;

CREATE TABLE MEMBER(
ID VARCHAR(10) NOT NULL,  					-- 아이디
PASS VARCHAR(10) NOT NULL,					-- 비밀번호
NAME VARCHAR(30) NOT NULL,					-- 이름
BIRTH DATE NOT NULL,						-- 생년월일
EMAIL VARCHAR(30) NOT NULL,					-- 이메일
PRIMARY KEY(ID)
);

CREATE TABLE BOARD(
NUM INT NOT NULL AUTO_INCREMENT PRIMARY KEY,			-- 게시판번호
TITLE VARCHAR(200) NOT NULL,							-- 제목
CONTENT VARCHAR(2000) NOT NULL,							-- 내용
ID VARCHAR(10) NOT NULL,								-- ID
POSTDATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP	-- 작성일자
);

Select *
from member;

Select *
from board;

-- 더미데이터 만들기
insert into board(title, content, id) values ('공지사항입니다,1', '관리자입니다.1', '관리자1');
insert into board(title, content, id) values ('공지사항입니다,2', '관리자입니다.2', '관리자2');
insert into board(title, content, id) values ('공지사항입니다,3', '관리자입니다.3', '관리자3');
insert into board (title, content, id)values ('공지사항입니다,4', '관리자입니다.4', '관리자4');
insert into board(title, content, id) values ('공지사항입니다,5', '관리자입니다.5', '관리자5');
insert into board(title, content, id) values ('공지사항입니다,6', '관리자입니다.6', '관리자6');
insert into board(title, content, id) values ('공지사항입니다,7', '관리자입니다.7', '관리자7');
insert into board(title, content, id) values ('공지사항입니다,8', '관리자입니다.8', '관리자8');
insert into board(title, content, id) values ('공지사항입니다,9', '관리자입니다.9', '관리자9');

desc member;

Select *
from member;

select *
from board;


set @rownum := 0;

SELECT @rownum := @rownum + 1 AS rownum, b.*
FROM (SELECT * FROM board) b, (SELECT @rownum := 0) r;


select *
from(
select @rownum := @rownum + 1 AS rownum, b.*
from board b,(select @rownum:=0) rownum
) rowboard
where rownum >= 1 and rownum <= 10;

-- 13장 테이블 생성 sql
-- 파일 업로드와 다운로드를 위한 테이블 생성
drop table myfile;
CREATE TABLE myfile (
    idx INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    cate VARCHAR(30),
    ofile VARCHAR(100) NOT NULL,
    sfile VARCHAR(30) NOT NULL,
    postdate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

desc myfile;

Select *
from myfile;

-- 14장 테이블 생성
CREATE TABLE mvcboard (
	idx INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	title VARCHAR(200) NOT NULL,
	content VARCHAR(2000) NOT NULL,
	postdate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	ofile VARCHAR(200),
	sfile VARCHAR(30),
	downcount INT(5) NOT NULL DEFAULT 0,
	pass VARCHAR(50) NOT NULL,
	visitcount INT NOT NULL DEFAULT 0
);

-- 더미 데이터 입력
INSERT INTO mvcboard (name, title, content, pass)
VALUES ('김유신', '자료실 제목1 입니다.', '내용', '1234');

INSERT INTO mvcboard (name, title, content, pass)
VALUES ('장보고', '자료실 제목2 입니다.', '내용', '1234');

INSERT INTO mvcboard (name, title, content, pass)
VALUES ('이순신', '자료실 제목3 입니다.', '내용', '1234');

INSERT INTO mvcboard (name, title, content, pass)
VALUES ('강감찬', '자료실 제목4 입니다.', '내용', '1234');

INSERT INTO mvcboard (name, title, content, pass)
VALUES ('대조영', '자료실 제목5 입니다.', '내용', '1234');

commit;

select *
from mvcboard;
