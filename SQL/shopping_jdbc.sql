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
  '큰 가방',
  '5000000',
  '크고 튼튼한 가방',
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
		   VALUES (2, '중간 가방', '5000000', '은근히 큰 가방', 'Prada', 1, 'testImage1.png', 5);
       
DELETE From team.product;
       
SELECT * FROM team.product
WHERE proname = '중간 가방';

SELECT * FROM team.product;

commit;