/*
ID : CAFE
��� : 1234
*/

drop table ����;

select * from ����;

CREATE SEQUENCE BER_SEQ;
DROP SEQUENCE BER_SEQ;

CREATE TABLE ����(
    �̸�  VARCHAR(20) NOT NULL,
    ����  INT  NOT NULL,
    ī���� VARCHAR(20) NOT NULL,
    ���� VARCHAR(20),
    ����� DATE,
    CONSTRAINT ck_Caffeine1 CHECK ( ī���� = '��'  OR ī���� = '��'),
    PRIMARY KEY(�̸�)
);


INSERT INTO ���� VALUES ('�Ƹ޸�ī��', '1500', '��', 'Ŀ��', '2021-12-05');
INSERT INTO ���� VALUES ('����������', '1500', '��', 'Ŀ��', '2022-06-10');
INSERT INTO ���� VALUES ('ī���', '2000', '��', 'Ŀ��', '2022-03-05');
INSERT INTO ���� VALUES ('�ٴҶ��', '3000', '��', 'Ŀ��', '2022-01-03');

INSERT INTO ���� VALUES ('�����̵�', '3000', '��', '���̵�', '2022-03-02');
INSERT INTO ���� VALUES ('û�������̵�', '3000', '��', '���̵�', '2021-10-23');
INSERT INTO ���� VALUES ('�ڸ����̵�', '3000', '��', '���̵�', '2021-11-29');
INSERT INTO ���� VALUES ('ü����', '3000', '��', '���̵�', '2022-03-11');

INSERT INTO ���� VALUES ('���̽�Ƽ', '2000', '��', '��', '2022-01-23');
INSERT INTO ���� VALUES ('������', '2500', '��', '��', '2021-12-22');
INSERT INTO ���� VALUES ('ĳ����', '2500', '��', '��', '2021-04-21');
INSERT INTO ���� VALUES ('���۹�Ʈ', '2500', '��', '��', '2021-05-20');