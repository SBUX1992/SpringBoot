SELECT COUNT(`uid`) FROM `board_user` WHERE `uid`='abcd';

SELECT SHA('1234');
SELECT SHA2('1234', 256);

SELECT * FROM `board_user` WHERE `uid`='a101' AND `pass`=SHA2('!q2w3e', 256);

SELECT a.*, b.`nick` FROM `board_article` AS a
JOIN `board_user` AS b ON a.uid = b.uid
WHERE `parent` = 0
ORDER BY `no` DESC
LIMIT 0, 10;


SELECT a.*, b.nick FROM `board_article` AS a
JOIN `board_user` AS b USING (`uid`)
WHERE `parent`=2 ORDER BY `no` ASC;




SELECT COUNT(`no`) FROM `board_article`;

INSERT INTO `board_article` (`title`, `content`, `uid`, `regip`, `rdate`)
SELECT `title`, `content`, `uid`, `regip`, `rdate` FROM `board_article`;

SELECT a.*, b.`name`, c.`proName` FROM `order` AS a 
JOIN `customer` AS b ON a.orderId = b.custId 
JOIN `product` AS c ON a.orderProduct = c.proNo;


"SELECT a.*, b.`nick` FROM `board_article` AS a 
JOIN `board_user` AS b ON a.uid = b.uid
WHERE `parent` = 0 AND `cate`='story'
ORDER BY `no` DESC



SELECT a.*, b.`fno`, b.`oriName`, b.`download`
FROM `board_article` AS a
LEFT JOIN `board_file` AS b
ON a.`no` = b.`parent`
WHERE `no`=5;

UPDATE `board_article` SET `hit` = `hit` + 1 WHERE `no`=2;

SELECT a.*, b.nick FROM `board_article` AS a
JOIN `board_uset` AS b USING(`uid`)
WHERE `parent` != 0 ORDER BY `no` DESC LIMIT 1;

UPDATE `board_article` SET `content`=?, `rdate`=NOW() WHERE `no`=?;



SELECT `no`, `title`, `rdate` FROM `board_article` where `cate`='grow' ORDER BY `no` DESC LIMIT 5



ALTER TABLE `board_user` ADD COLUMN `sessId` VARCHAR(100) UNIQUE;
ALTER TABLE `board_user` ADD COLUMN `sessLimitDate` DATETIME;
ALTER TABLE `board_user` DROP COLUMN `sessId`;
ALTER TABLE `board_user` DROP COLUMN `sessLimitDate`;



UPDATE `board_user` SET 
							`sessId`='A10121213XXX',
							`sessLimitDate`= DATE_ADD(NOW(), INTERVAL 3 DAY)
							WHERE
								`uid`='j101101';


SELECT * FROM `board_user` WHERE `sissID` = ? AND `sessLimitDate` > NOW();

UPDATE `board_user` SET `sessId=NULL, `sessLimitDate`=NULL
										
SELECT a.*, b.nick FROM `board_article` AS a
JOIN `board_user` AS b
ON a.uid = b.uid
WHERE `PARENT`=0 AND `title` LIKE '파일%' OR `nick` LIKE '파일%';

SELECT COUNT(`no`) FROM `board_article` AS a
JOIN `board_user` AS b
ON a.uid = b.uid
WHERE `parent`=0 AND
	(`title` LIKE '%?%' OR
	`nick` LIKE '%?%')
	ORDER BY `no` DESC
	LIMIT 40, 10;

SELECT * FROM `user2`;



select * from `user1`;



SELECT * FROM `km_product` WHERE `prodName` LIKE '%상품권%';

SELECT * FROM `km_product` WHERE `prodName` LIKE '%가구%' ORDER BY `prodNo` DESC LIMIT 10;

SELECT * FROM `km_product` ORDER BY `prodNo` DESC LIMIT 10;


ALTER TABLE `member` ADD COLUMN `pass` VARCHAR(255) AFTER `uid`;
ALTER TABLE `user1` ADD COLUMN `pass` VARCHAR(255) AFTER `uid`;
ALTER TABLE `user2` ADD COLUMN `pass` VARCHAR(255) AFTER `uid`;

SELECT SHA2('1234', 256);

ALTER TABLE `user2` ADD COLUMN `rdate` DATETIME;

CREATE TABLE `weather`(
	`col1` VARCHAR(10) COMMENT '지역명',
	`col2` VARCHAR(10) COMMENT '현재일기',
	`col3` VARCHAR(10) COMMENT '시정km',
	`col4` TINYINT COMMENT '운량 1/10',
	`col5` TINYINT COMMENT '중하운량',
	`col6` FLOAT COMMENT '현재기온',
	`col7` FLOAT COMMENT '이슬점온도',
	`col8` FLOAT COMMENT '체감온도',
	`col9` FLOAT COMMENT '일강수mm',
	`col10` FLOAT COMMENT '적설cm',
	`col11` TINYINT COMMENT '습도%',
	`col12` VARCHAR(10) COMMENT '풍향',
	`col13` FLOAT COMMENT '풍속m/s',
	`col14` FLOAT COMMENT '해면기압',
	`rdate` datetime
);