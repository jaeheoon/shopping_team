--�׽�Ʈ�� ���� ���̵����� ����

-- Member ���̺�
INSERT INTO MEMBER (id, pwd, email, hp, name, lotaddr, etcaddr) 
VALUES ('bangry', '1111', 'bangry@gmail.com', '010-1234-5678', 'ȫ����', '��⵵ ���ֽ� ������', '��������Ʈ 101�� 111ȣ');
INSERT INTO MEMBER (id, pwd, email, hp, name, lotaddr, etcaddr) 
VALUES ('kimbang', '1111', 'kimbang@gmail.com', '010-1234-5678', '������', '����� �����', '��������Ʈ 103�� 114ȣ');
INSERT INTO MEMBER (id, pwd, email, hp, name, lotaddr, etcaddr) 
VALUES ('choiheon', '1111', 'choiheon@gmail.com', '010-1234-5678', '������', '��⵵ �����ν� ȣ����', '��ī���̾���Ʈ 301�� 214ȣ');

-- Category ���̺�
INSERT INTO Category (catecode, catename)
VALUES (1, '����');

-- Product ���̺�
INSERT INTO Product (procode, catecode, proname, proprice, prosale, proinfo, proqty, prothumb, proimg) 
VALUES (procode_seq.nextval, 1, '�̴� ����', '5000000', '4800000', '�۰� ���õ� ���� ����', 150, 'testImage1.png', 'testImage1.png,testImage2.png,testImage3.png');





