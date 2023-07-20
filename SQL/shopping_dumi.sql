--테스트를 위한 더미데이터 생성

-- Member 테이블
INSERT INTO MEMBER (id, pwd, email, hp, name, lotaddr, etcaddr) 
VALUES ('bangry', '1111', 'bangry@gmail.com', '010-1234-5678', '홍재헌', '경기도 양주시 옥정동', '이젠아파트 101동 111호');
INSERT INTO MEMBER (id, pwd, email, hp, name, lotaddr, etcaddr) 
VALUES ('kimbang', '1111', 'kimbang@gmail.com', '010-1234-5678', '김재헌', '서울시 노원구', '이젠아파트 103동 114호');
INSERT INTO MEMBER (id, pwd, email, hp, name, lotaddr, etcaddr) 
VALUES ('choiheon', '1111', 'choiheon@gmail.com', '010-1234-5678', '최재헌', '경기도 의정부시 호원동', '아카데미아파트 301동 214호');

-- Category 테이블
INSERT INTO Category (catecode, catename)
VALUES (1, '여성');

-- Product 테이블
INSERT INTO Product (procode, catecode, proname, proprice, prosale, proinfo, proqty, prothumb, proimg) 
VALUES (procode_seq.nextval, 1, '미니 가방', '5000000', '4800000', '작고 세련된 작은 가방', 150, 'testImage1.png', 'testImage1.png,testImage2.png,testImage3.png');





