--�׽�Ʈ�� ���� ���̵����� ����

-- Member ���̺�
INSERT INTO MEMBER (id, passwd, name, birthday, regdate)
VALUES ('bangry', '1111', 'ȫ����', '1982-05-24', '2023-05-23');
INSERT INTO MEMBER (id, passwd, name, birthday, regdate)
VALUES ('kimbang', '1111', '������', '2000-05-24', '2022-03-03');
INSERT INTO MEMBER (id, passwd, name, birthday, regdate)
VALUES ('choiheon', '1111', '������', '1974-05-24', '2023-04-13');

-- Category ���̺�
INSERT INTO Category (catecode, catename)
VALUES (1, '����');

-- Product ���̺�
INSERT INTO Product (procode, catecode, proname, proprice, prosale, proinfo, proqty, prothumb, proimg) 
VALUES (procode_seq.nextval, 1, '�̴� ����', '5000000', '4800000', '�۰� ���õ� ���� ����', 150, 'testImage1.png', 'testImage1.png,testImage2.png,testImage3.png');

-- product_ord ���̺�
INSERT INTO product_ord (ordercode, userid, name, addr, etcaddr, memo, orderdate, totalprice, status, hp)
VALUES (ordercode_seq.nextval, 'bangry', 'ȫ����', '��⵵ ���ֽ� ������', '��������Ʈ 101�� 111ȣ', '�� �տ� ���ּ���', sysdate, 10000000, 1, '010-1234-5678');

-- product_out ���̺�
INSERT INTO product_out (pocode, ordercode, procode, amount, status, outdate)
VALUES (pocode_seq.nextval, 2, 27, 4, 1, SYSDATE);

-- cart ���̺�
INSERT INTO cart (cartcode, userid, procode, amount, ischecked, ispaid)
VALUES (cartcode_seq.nextval, 'bangry', 27, 4, 1, 1);

-- product_qna ���̺�
INSERT INTO product_qna (qnacode, procode, qnatitle, qnacont, qnadate, qnaauth)
VALUES (qnacode_seq.nextval, 27, '������ �̻��ؿ�', '������ �ִ� �����̶� �ʹ� �޶��', sysdate, 'choiheon');

-- product_qna_re ���̺�
INSERT INTO product_qna_re (recode, qnacode, recont, redate)
VALUES (recode_seq.nextval, 4, '���� ��ǰ�� ������ �ٸ� �� �ֽ��ϴ�', sysdate);

-- product_rev ���̺�
INSERT INTO product_rev (revcode, procode, revcont, revauth, revdate)
VALUES (revcode_seq.nextval, 27, '������ �ʹ� �̻���', 'ȫ����', sysdate);

-- pay ���̺�
INSERT INTO pay (paycode, ordercode, payprice, payment, ispaid, isrefund)
VALUES (paycode_seq.nextval, 2, 10000000, 1, 1, 1);

-- notice ���̺�
INSERT INTO notice (noticode, notititle, noticont, notidate, notiauth)
VALUES (noticode_seq.nextval, 'ȯ��, ��ȯ ���� ����', 'ȯ���� �Ұ��ϰ� ��ȯ�� ������ �̳��Դϴ�', sysdate, '������');

commit;






















