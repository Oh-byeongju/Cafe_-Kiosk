/*
ID : CAFE
비번 : 1234
*/

drop table 커피;
drop table 차;
drop table 에이드;

select * from 커피;
select * from 에이드;
select * from 차;

CREATE TABLE 커피(
    이름  VARCHAR(20) NOT NULL,
    가격  INT  NOT NULL,
    카페인 VARCHAR(20) NOT NULL,
    등록일 DATE,
    CONSTRAINT ck_Caffeine1 CHECK ( 카페인 = '무'  OR 카페인 = '유'),
    PRIMARY KEY(이름)
);

CREATE TABLE 에이드(
    이름 VARCHAR(20) NOT NULL,
    가격 INT NOT NULL,
    카페인 VARCHAR(20) NOT NULL,
    등록일 DATE,
    CONSTRAINT ck_Caffeine2 CHECK ( 카페인 = '무'  OR 카페인 = '유'),
    PRIMARY KEY(이름)
);

CREATE TABLE 차(
    이름 VARCHAR(20) NOT NULL,
    가격 INT NOT NULL,
    카페인 VARCHAR(20) NOT NULL,
    등록일 DATE,
    CONSTRAINT ck_Caffeine3 CHECK ( 카페인 = '무'  OR 카페인 = '유'),
    PRIMARY KEY(이름)
);

INSERT INTO 커피 VALUES ('아메리카노', '1500', '유', '2021-12-05');
INSERT INTO 커피 VALUES ('에스프레소', '1500', '유', '2021-12-05');
INSERT INTO 커피 VALUES ('카페라떼', '2000', '유', '2021-12-05');
INSERT INTO 커피 VALUES ('바닐라라떼', '3000', '유', '2021-12-05');

INSERT INTO 에이드 VALUES ('레몬에이드', '3000', '무', '2021-12-05');
INSERT INTO 에이드 VALUES ('청포도에이드', '3000', '무', '2021-12-05');
INSERT INTO 에이드 VALUES ('자몽에이드', '3000', '무', '2021-12-05');
INSERT INTO 에이드 VALUES ('체리콕', '3000', '무', '2021-12-05');

INSERT INTO 차 VALUES ('아이스티', '2000', '무', '2021-12-05');
INSERT INTO 차 VALUES ('유자차', '2500', '무', '2021-12-05');
INSERT INTO 차 VALUES ('캐모마일', '2500', '무', '2021-12-05');
INSERT INTO 차 VALUES ('페퍼민트', '2500', '무', '2021-12-05');