INSERT INTO product (
  procode,
  catecode,
  proname,
  proprice,
  proinfo,
  proimg,
  probrand,
  procount
) VALUES (
  1,
  1,
  'ū ����',
  '5000000',
  'ũ�� ưư�� ����',
  'testImage1.png',
  'Prada',
  4
);

INSERT INTO product (
		    procode,
		    catecode,
		    proname,
		    proprice,
		    proimg,
		    proinfo,
		    probrand,
		    procount)
		   VALUES (2, '�߰� ����', '5000000', '������ ū ����', 'Prada', 1, 'testImage1.png', 5);
       
DELETE From team.product;
       
SELECT * FROM team.product
WHERE proname = '�߰� ����';

SELECT * FROM team.product;

commit;