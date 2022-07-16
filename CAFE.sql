/*
ID : CAFE
비번 : 1234
*/

drop table 음료;

select * from 음료;

CREATE SEQUENCE BER_SEQ;
DROP SEQUENCE BER_SEQ;

CREATE TABLE 음료(
    이름  VARCHAR(20) NOT NULL,
    가격  INT  NOT NULL,
    카페인 VARCHAR(20) NOT NULL,
    종류 VARCHAR(20),
    등록일 DATE,
    CONSTRAINT ck_Caffeine1 CHECK ( 카페인 = '무'  OR 카페인 = '유'),
    PRIMARY KEY(이름)
);


INSERT INTO 음료 VALUES ('아메리카노', '1500', '유', '커피', '2021-12-05');
INSERT INTO 음료 VALUES ('에스프레소', '1500', '유', '커피', '2022-06-10');
INSERT INTO 음료 VALUES ('카페라떼', '2000', '유', '커피', '2022-03-05');
INSERT INTO 음료 VALUES ('바닐라라떼', '3000', '유', '커피', '2022-01-03');

INSERT INTO 음료 VALUES ('레몬에이드', '3000', '무', '에이드', '2022-03-02');
INSERT INTO 음료 VALUES ('청포도에이드', '3000', '무', '에이드', '2021-10-23');
INSERT INTO 음료 VALUES ('자몽에이드', '3000', '무', '에이드', '2021-11-29');
INSERT INTO 음료 VALUES ('체리콕', '3000', '무', '에이드', '2022-03-11');

INSERT INTO 음료 VALUES ('아이스티', '2000', '무', '차', '2022-01-23');
INSERT INTO 음료 VALUES ('유자차', '2500', '무', '차', '2021-12-22');
INSERT INTO 음료 VALUES ('캐모마일', '2500', '무', '차', '2021-04-21');
INSERT INTO 음료 VALUES ('페퍼민트', '2500', '무', '차', '2021-05-20');