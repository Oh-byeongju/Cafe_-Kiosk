/*
ID : CAFE
��� : 1234
*/

DROP TABLE ����_�ֹ����;
DROP TABLE ����;
DROP TABLE �ֹ����;

DROP SEQUENCE ORDER_SEQ;
CREATE SEQUENCE ORDER_SEQ;

CREATE TABLE ����(
    �̸�  VARCHAR(20) NOT NULL,
    ����  INT  NOT NULL,
    ī���� VARCHAR(20) NOT NULL,
    ���� VARCHAR(20),
    ����� DATE,
    CONSTRAINT ck_Caffeine1 CHECK ( ī���� = '��'  OR ī���� = '��'),
    PRIMARY KEY(�̸�)
);

CREATE TABLE �ֹ����(
    �ֹ���ȣ INT,
    �ֹ��Ͻ� DATE,
    �հ� INT,
    ���忩�� VARCHAR(10),
    PRIMARY KEY(�ֹ���ȣ)
);

CREATE TABLE ����_�ֹ����(
    �̸� VARCHAR(20),
    �ֹ���ȣ INT,
    ���� INT,
    �ð� INT,
    CONSTRAINT PRI_KEY PRIMARY KEY(�̸�, �ֹ���ȣ),
    CONSTRAINT FOR_KEY FOREIGN KEY(�̸�) REFERENCES ����(�̸�),
    CONSTRAINT FOR_KEY2 FOREIGN KEY(�ֹ���ȣ) REFERENCES �ֹ����(�ֹ���ȣ)
);
   
-- ���� INSERT    
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

--SELECT * FROM ����;
--SELECT * FROM �ֹ����;
--SELECT * FROM ����_�ֹ����;

-- �ֹ���� INSERT
INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-07', '6000', '����'); -- �Ƹ� ����, ���������� ����, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-09', '6500', '����');-- �Ƹ� ����, ī��� ����, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'1','2000');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-10', '6000', '����');-- �Ƹ� 4��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'4','1500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-11', '10000', '����');-- ī��� 2��, �����̵� ����, û�������̵� ����
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'2','2000');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-14', '9000', '����');-- �Ƹ޸�ī�� 2��, ���������� 2��, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-16', '9000', '����');-- �ٴҶ�� 3��
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'3','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-19', '10000', '����');-- ī��� 2��, �����̵� ����, �ڸ����̵� ����
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'2','2000');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-21', '6000', '����');-- �Ƹ�2��, ü���� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-22', '7500', '����');-- �Ƹ�2��, ���������� ����, �����̵� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-24', '6000', '����'); -- ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-26', '7500', '����'); -- �Ƹ޸�ī�� ����, ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-27', '7500', '����'); -- ������ 3��
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-28', '7500', '����'); -- ĳ���� 3��
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-03-29', '7500', '����'); -- ���۹�Ʈ 3��
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-01', '7000', '����'); -- �����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-02', '7000', '����'); -- û�������̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-03', '7000', '����'); -- �ڸ����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-04', '7000', '����'); -- ü���� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-07', '13000', '����'); -- �Ƹ޸�ī�� 4��, û�������̵� ����, ���̽�Ƽ 2�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'4','1500');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-09', '13000', '����'); -- �Ƹ޸�ī�� 2��, �����̵� 2��, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-12', '13000', '����'); -- �Ƹ޸�ī�� 2��, �ڸ����̵� 2��, ���̽�Ƽ 2�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-14', '10000', '����'); -- ���̽�Ƽ 5��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'5','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-15', '13000', '����'); -- �Ƹ޸�ī�� 6��, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'6','1500');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-17', '15000', '����'); -- �Ƹ޸�ī�� ����, ü���� 2��, ������ 3�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-19', '15000', '����'); -- �Ƹ޸�ī�� ����, �����̵� 2��, ĳ���� 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-21', '15000', '����'); -- �Ƹ޸�ī�� ����, û�������̵� 2��, ���۹�Ʈ 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-23', '9000', '����'); -- �Ƹ޸�ī�� 2��, ���������� 2��, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-24', '8000', '����'); -- ī��� 4��
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'4','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-25', '7500', '����'); -- ������ ����, ĳ���� ����, ���۹�Ʈ ����
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'1','2500');
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'1','2500');
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'1','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-27', '9000', '����'); -- �����̵� ����, �ڸ����̵� ����, ü���� ����
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-28', '9000', '����'); -- û�������̵� 3��
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'3','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-04-30', '8000', '����'); -- ���̽�Ƽ 4��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'4','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-02', '6000', '����'); -- �Ƹ� ����, ���������� ����, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-04', '6500', '����');-- �Ƹ� ����, ī��� ����, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'1','2000');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-05', '6000', '����');-- �Ƹ� 4��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'4','1500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-07', '10000', '����');-- ī��� 2��, �����̵� ����, û�������̵� ����
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'2','2000');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-09', '9000', '����');-- �Ƹ޸�ī�� 2��, ���������� 2��, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-11', '9000', '����');-- �ٴҶ�� 3��
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'3','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-13', '10000', '����');-- ī��� 2��, �����̵� ����, �ڸ����̵� ����
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'2','2000');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-14', '13000', '����'); -- �Ƹ޸�ī�� 2��, �ڸ����̵� 2��, ���̽�Ƽ 2�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-15', '10000', '����'); -- ���̽�Ƽ 5��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'5','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-17', '13000', '����'); -- �Ƹ޸�ī�� 6��, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'6','1500');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-18', '15000', '����'); -- �Ƹ޸�ī�� ����, ü���� 2��, ������ 3�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-19', '15000', '����'); -- �Ƹ޸�ī�� ����, �����̵� 2��, ĳ���� 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-21', '15000', '����'); -- �Ƹ޸�ī�� ����, û�������̵� 2��, ���۹�Ʈ 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-23', '9000', '����'); -- �Ƹ޸�ī�� 2��, ���������� 2��, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-24', '8000', '����'); -- ī��� 4��
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'4','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-25', '7500', '����'); -- ������ ����, ĳ���� ����, ���۹�Ʈ ����
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'1','2500');
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'1','2500');
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'1','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-25', '9000', '����'); -- �����̵� ����, �ڸ����̵� ����, ü���� ����
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-26', '9000', '����'); -- û�������̵� 3��
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'3','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-26', '8000', '����'); -- ���̽�Ƽ 4��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'4','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-27', '6000', '����');-- �Ƹ�2��, ü���� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-28', '7500', '����');-- �Ƹ�2��, ���������� ����, �����̵� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-30', '6000', '����'); -- ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-05-31', '7500', '����'); -- �Ƹ޸�ī�� ����, ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-01', '7500', '����'); -- ������ 3��
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-02', '7500', '����'); -- ĳ���� 3��
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-02', '7500', '����'); -- ���۹�Ʈ 3��
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-03', '7000', '����'); -- �����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-05', '7000', '����'); -- û�������̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-05', '7000', '����'); -- �ڸ����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-06', '7000', '����'); -- ü���� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-07', '13000', '����'); -- �Ƹ޸�ī�� 4��, û�������̵� ����, ���̽�Ƽ 2�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'4','1500');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-07', '13000', '����'); -- �Ƹ޸�ī�� 2��, �����̵� 2��, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-09', '13000', '����'); -- �Ƹ޸�ī�� 2��, �ڸ����̵� 2��, ���̽�Ƽ 2�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-11', '10000', '����'); -- ���̽�Ƽ 5��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'5','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-11', '13000', '����'); -- �Ƹ޸�ī�� 6��, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'6','1500');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-12', '15000', '����'); -- �Ƹ޸�ī�� ����, ü���� 2��, ������ 3�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-14', '15000', '����'); -- �Ƹ޸�ī�� ����, �����̵� 2��, ĳ���� 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-14', '15000', '����'); -- �Ƹ޸�ī�� ����, û�������̵� 2��, ���۹�Ʈ 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-15', '9000', '����'); -- �Ƹ޸�ī�� 2��, ���������� 2��, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-15', '8000', '����'); -- ī��� 4��
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'4','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-17', '7500', '����'); -- ������ ����, ĳ���� ����, ���۹�Ʈ ����
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'1','2500');
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'1','2500');
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'1','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-18', '9000', '����'); -- �����̵� ����, �ڸ����̵� ����, ü���� ����
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-18', '9000', '����'); -- û�������̵� 3��
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'3','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-19', '8000', '����'); -- ���̽�Ƽ 4��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'4','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-19', '6000', '����'); -- �Ƹ� ����, ���������� ����, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-20', '6500', '����');-- �Ƹ� ����, ī��� ����, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'1','2000');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-21', '6000', '����');-- �Ƹ� 4��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'4','1500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-22', '10000', '����');-- ī��� 2��, �����̵� ����, û�������̵� ����
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'2','2000');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-23', '9000', '����');-- �Ƹ޸�ī�� 2��, ���������� 2��, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-23', '9000', '����');-- �ٴҶ�� 3��
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'3','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-23', '10000', '����');-- ī��� 2��, �����̵� ����, �ڸ����̵� ����
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'2','2000');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-24', '6000', '����');-- �Ƹ�2��, ü���� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-25', '7500', '����');-- �Ƹ�2��, ���������� ����, �����̵� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-25', '6000', '����'); -- ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-26', '7500', '����'); -- �Ƹ޸�ī�� ����, ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-27', '7500', '����'); -- ������ 3��
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-27', '7500', '����'); -- ĳ���� 3��
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-28', '7500', '����'); -- ���۹�Ʈ 3��
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-29', '7000', '����'); -- �����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-29', '7000', '����'); -- û�������̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-06-30', '7000', '����'); -- �ڸ����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-01', '7000', '����'); -- ü���� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-01', '13000', '����'); -- �Ƹ޸�ī�� 4��, û�������̵� ����, ���̽�Ƽ 2�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'4','1500');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-01', '13000', '����'); -- �Ƹ޸�ī�� 2��, �����̵� 2��, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-02', '9000', '����'); -- û�������̵� 3��
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'3','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-02', '8000', '����'); -- ���̽�Ƽ 4��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'4','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-03', '6000', '����');-- �Ƹ�2��, ü���� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-03', '7500', '����');-- �Ƹ�2��, ���������� ����, �����̵� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-03', '6000', '����'); -- ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-05', '7500', '����'); -- �Ƹ޸�ī�� ����, ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-05', '7500', '����'); -- ������ 3��
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-07', '7500', '����'); -- ĳ���� 3��
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-07', '7500', '����'); -- ���۹�Ʈ 3��
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-07', '7000', '����'); -- �����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-08', '7000', '����'); -- û�������̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-08', '7000', '����'); -- �ڸ����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-09', '7000', '����'); -- ü���� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-10', '13000', '����'); -- �Ƹ޸�ī�� 4��, û�������̵� ����, ���̽�Ƽ 2�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'4','1500');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-10', '7500', '����');-- �Ƹ�2��, ���������� ����, �����̵� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-10', '6000', '����'); -- ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-11', '7500', '����'); -- �Ƹ޸�ī�� ����, ���̽�Ƽ 3��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'3','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-12', '7500', '����'); -- ������ 3��
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-12', '7500', '����'); -- ĳ���� 3��
INSERT INTO "����_�ֹ����" VALUES('ĳ����',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-13', '7500', '����'); -- ���۹�Ʈ 3��
INSERT INTO "����_�ֹ����" VALUES('���۹�Ʈ',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-13', '7000', '����'); -- �����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-13', '7000', '����'); -- û�������̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-14', '7000', '����'); -- �ڸ����̵� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-14', '7000', '����'); -- ü���� ����, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-15', '13000', '����'); -- �Ƹ޸�ī�� 4��, û�������̵� ����, ���̽�Ƽ 2�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'4','1500');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-15', '13000', '����'); -- �Ƹ޸�ī�� 2��, �����̵� 2��, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-15', '13000', '����'); -- �Ƹ޸�ī�� 2��, �ڸ����̵� 2��, ���̽�Ƽ 2�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-16', '10000', '����'); -- ���̽�Ƽ 5��
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'5','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-16', '13000', '����'); -- �Ƹ޸�ī�� 6��, ���̽�Ƽ 2��
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'6','1500');
INSERT INTO "����_�ֹ����" VALUES('���̽�Ƽ',ORDER_SEQ.CURRVAL,'2','2000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-17', '15000', '����'); -- �Ƹ޸�ī�� ����, ü���� 2��, ������ 3�� 
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'1','1500');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'2','3000');
INSERT INTO "����_�ֹ����" VALUES('������',ORDER_SEQ.CURRVAL,'3','2500');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-17', '10000', '����');-- ī��� 2��, �����̵� ����, û�������̵� ����
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'2','2000');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('û�������̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-18', '9000', '����');-- �Ƹ޸�ī�� 2��, ���������� 2��, �ٴҶ�� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('����������',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-18', '9000', '����');-- �ٴҶ�� 3��
INSERT INTO "����_�ֹ����" VALUES('�ٴҶ��',ORDER_SEQ.CURRVAL,'3','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-18', '10000', '����');-- ī��� 2��, �����̵� ����, �ڸ����̵� ����
INSERT INTO "����_�ֹ����" VALUES('ī���',ORDER_SEQ.CURRVAL,'2','2000');
INSERT INTO "����_�ֹ����" VALUES('�����̵�',ORDER_SEQ.CURRVAL,'1','3000');
INSERT INTO "����_�ֹ����" VALUES('�ڸ����̵�',ORDER_SEQ.CURRVAL,'1','3000');

INSERT INTO �ֹ���� VALUES(ORDER_SEQ.NEXTVAL,'2022-07-19', '6000', '����');-- �Ƹ�2��, ü���� ����
INSERT INTO "����_�ֹ����" VALUES('�Ƹ޸�ī��',ORDER_SEQ.CURRVAL,'2','1500');
INSERT INTO "����_�ֹ����" VALUES('ü����',ORDER_SEQ.CURRVAL,'1','3000');

COMMIT;
