/*
ID : CAFE
��� : 1234
*/

drop table Ŀ��;
drop table ��;
drop table ���̵�;

select * from Ŀ��;
select * from ���̵�;
select * from ��;

CREATE TABLE Ŀ��(
    �̸�  VARCHAR(20) NOT NULL,
    ����  INT  NOT NULL,
    ī���� VARCHAR(20) NOT NULL,
    ����� DATE,
    CONSTRAINT ck_Caffeine1 CHECK ( ī���� = '��'  OR ī���� = '��'),
    PRIMARY KEY(�̸�)
);

CREATE TABLE ���̵�(
    �̸� VARCHAR(20) NOT NULL,
    ���� INT NOT NULL,
    ī���� VARCHAR(20) NOT NULL,
    ����� DATE,
    CONSTRAINT ck_Caffeine2 CHECK ( ī���� = '��'  OR ī���� = '��'),
    PRIMARY KEY(�̸�)
);

CREATE TABLE ��(
    �̸� VARCHAR(20) NOT NULL,
    ���� INT NOT NULL,
    ī���� VARCHAR(20) NOT NULL,
    ����� DATE,
    CONSTRAINT ck_Caffeine3 CHECK ( ī���� = '��'  OR ī���� = '��'),
    PRIMARY KEY(�̸�)
);

INSERT INTO Ŀ�� VALUES ('�Ƹ޸�ī��', '1500', '��', '2021-12-05');
INSERT INTO Ŀ�� VALUES ('����������', '1500', '��', '2021-12-05');
INSERT INTO Ŀ�� VALUES ('ī���', '2000', '��', '2021-12-05');
INSERT INTO Ŀ�� VALUES ('�ٴҶ��', '3000', '��', '2021-12-05');

INSERT INTO ���̵� VALUES ('�����̵�', '3000', '��', '2021-12-05');
INSERT INTO ���̵� VALUES ('û�������̵�', '3000', '��', '2021-12-05');
INSERT INTO ���̵� VALUES ('�ڸ����̵�', '3000', '��', '2021-12-05');
INSERT INTO ���̵� VALUES ('ü����', '3000', '��', '2021-12-05');

INSERT INTO �� VALUES ('���̽�Ƽ', '2000', '��', '2021-12-05');
INSERT INTO �� VALUES ('������', '2500', '��', '2021-12-05');
INSERT INTO �� VALUES ('ĳ����', '2500', '��', '2021-12-05');
INSERT INTO �� VALUES ('���۹�Ʈ', '2500', '��', '2021-12-05');