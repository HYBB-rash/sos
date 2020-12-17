CREATE DATABASE SOS;
USE SOS;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
                      id int(11) unsigned not null auto_increment,
                      username varchar(255) default null,
                      password varchar(255) default null,
                      salt varchar(255) default null,
                      primary key (id)
) ENGINE = InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET = utf8;

insert into user(username, password) values ('admin', '123');

DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
                          id int(11) unsigned not null auto_increment,
                          userId int(11) unsigned not null,
                          name varchar(20) default null ,
                          sex varchar(4) default null ,
                          address varchar(100) default null,
                          phone varchar(30) default null,
                          company varchar(50) default null,
                          primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS survey;
CREATE TABLE survey (
                        id int(32) unsigned not null auto_increment,
                        userId int(11) not null ,
                        title varchar(255) default null,
                        instruction varchar(255) default null,
                        status int(10) not null ,
                        day DATETIME default null ,
                        count int(12) unsigned not null,
                        primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO survey values (null ,3, '我的第一个测试问卷', '这是一些说明：这是我的一份测试问卷，用于开发和测试后端', 0, NOW(), 28);
INSERT INTO survey values (null ,3, '我的第二个测试问卷', '这是一些说明：这是我的二份测试问卷，用于开发和测试后端', 1, NOW(), 35);
INSERT INTO survey values (null ,3, '我的第三个测试问卷', '这是一些说明：这是我的三份测试问卷，用于开发和测试后端', 2, NOW(), 63);

INSERT INTO survey values (null ,4, '我的第4个测试问卷', '这是一些说明：这是我的4份测试问卷，用于开发和测试后端', 0, NOW(), 567);
INSERT INTO survey values (null ,4, '我的第5个测试问卷', '这是一些说明：这是我的5份测试问卷，用于开发和测试后端', 1, NOW(), 22);
INSERT INTO survey values (null ,4, '我的第6个测试问卷', '这是一些说明：这是我的6份测试问卷，用于开发和测试后端', 2, NOW(), 27);

INSERT INTO survey values (null ,5, '我的第7个测试问卷', '这是一些说明：这是我的7份测试问卷，用于开发和测试后端', 0, NOW(), 2124);
INSERT INTO survey values (null ,5, '我的第8个测试问卷', '这是一些说明：这是我的8份测试问卷，用于开发和测试后端', 1, NOW(), 67);
INSERT INTO survey values (null ,5, '我的第9个测试问卷', '这是一些说明：这是我的9份测试问卷，用于开发和测试后端', 2, NOW(), 21);

DROP TABLE IF EXISTS detail;
CREATE TABLE detail (
                        id int(11) unsigned not null auto_increment,
                        surveyId int(11) not null ,
                        question varchar(255) default null,
                        type int(10) not null ,
                        choices varchar(255) default null,
                        primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO detail values (null, 1, '如果这是一道单选题，你认为做的怎么样？', 0, '很好%非常好%一般%很垃圾%');
INSERT INTO detail values (null, 1, '如果这是一道多选题，你认为做的怎么样', 1, '色彩应该丰富些%动画可以做的好看一些%效率可以高一些%弄得再好看一些%');
INSERT INTO detail values (null, 1, '如果这是一道评价题，你认为做的怎么样', 2, null);
INSERT INTO detail values (null, 1, '如果这是一道评分题，你会打几分？', 3, null);

INSERT INTO detail values (null, 2, '如果这是一道单选题，你认为做的怎么样？', 0, '很好%非常好%一般%很垃圾%');
INSERT INTO detail values (null, 2, '如果这是一道多选题，你认为做的怎么样', 1, '色彩应该丰富些%动画可以做的好看一些%效率可以高一些%弄得再好看一些%');
INSERT INTO detail values (null, 2, '如果这是一道评价题，你认为做的怎么样', 2, null);

INSERT INTO detail values (null, 3, '如果这是一道单选题，你认为做的怎么样？', 0, '很好%非常好%一般%很垃圾%');
INSERT INTO detail values (null, 3, '如果这是一道多选题，你认为做的怎么样', 1, '色彩应该丰富些%动画可以做的好看一些%效率可以高一些%弄得再好看一些%');
INSERT INTO detail values (null, 3, '如果这是一道评分题，你会打几分？', 3, null);

INSERT INTO detail values (null, 4, '如果这是一道单选题，你认为做的怎么样？', 0, '很好%非常好%一般%很垃圾%');
INSERT INTO detail values (null, 4, '如果这是一道评价题，你认为做的怎么样', 2, null);
INSERT INTO detail values (null, 4, '如果这是一道评分题，你会打几分？', 3, null);

INSERT INTO detail values (null, 5, '如果这是一道多选题，你认为做的怎么样', 1, '色彩应该丰富些%动画可以做的好看一些%效率可以高一些%弄得再好看一些%');
INSERT INTO detail values (null, 5, '如果这是一道评价题，你认为做的怎么样', 2, null);
INSERT INTO detail values (null, 5, '如果这是一道评分题，你会打几分？', 3, null);

INSERT INTO detail values (null, 6, '如果这是一道单选题，你认为做的怎么样？', 0, '很好%非常好%一般%很垃圾%');
INSERT INTO detail values (null, 6, '如果这是一道多选题，你认为做的怎么样', 1, '色彩应该丰富些%动画可以做的好看一些%效率可以高一些%弄得再好看一些%');
INSERT INTO detail values (null, 6, '如果这是一道评价题，你认为做的怎么样', 2, null);

INSERT INTO detail values (null, 7, '如果这是一道单选题，你认为做的怎么样？', 0, '很好%非常好%一般%很垃圾%');
INSERT INTO detail values (null, 7, '如果这是一道评价题，你认为做的怎么样', 2, null);
INSERT INTO detail values (null, 7, '如果这是一道评分题，你会打几分？', 3, null);

INSERT INTO detail values (null, 8, '如果这是一道多选题，你认为做的怎么样', 1, '色彩应该丰富些%动画可以做的好看一些%效率可以高一些%弄得再好看一些%');
INSERT INTO detail values (null, 8, '如果这是一道评价题，你认为做的怎么样', 2, null);
INSERT INTO detail values (null, 8, '如果这是一道评分题，你会打几分？', 3, null);

INSERT INTO detail values (null, 9, '如果这是一道单选题，你认为做的怎么样？', 0, '很好%非常好%一般%很垃圾%');
INSERT INTO detail values (null, 9, '如果这是一道多选题，你认为做的怎么样', 1, '色彩应该丰富些%动画可以做的好看一些%效率可以高一些%弄得再好看一些%');
INSERT INTO detail values (null, 9, '如果这是一道评分题，你会打几分？', 3, null);

DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
                        id int(11) unsigned not null auto_increment,
                        surveyId int(11) not null,
                        detailId int(11) not null ,
                        ans int(11) default null,
                        multi varchar(255) default null,
                        context varchar(255) default null,
                        rate int(11) default null,
                        primary key (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO answer VALUES (null, 1, 1, 1, null, null, null);
INSERT INTO answer VALUES (null, 1, 2, null, '1,2,3,4', null, null);
INSERT INTO answer VALUES (null, 1, 3, null, null, '我没什么可以说的', null);
INSERT INTO answer VALUES (null, 1, 4, null, null, null, 5);

INSERT INTO answer VALUES (null, 2, 5, 1, null, null, null);
INSERT INTO answer VALUES (null, 2, 6, null, '1,2,3,4', null, null);
INSERT INTO answer VALUES (null, 2, 7, null, null, '我没什么可以说的', null);

INSERT INTO answer VALUES (null, 3, 8, 1, null, null, null);
INSERT INTO answer VALUES (null, 3, 9, null, '1,2,3,4', null, null);
INSERT INTO answer VALUES (null, 3, 10, null, null, null, 5);

INSERT INTO answer VALUES (null, 4, 11, 1, null, null, null);
INSERT INTO answer VALUES (null, 4, 12, null, null, '我没什么可以说的', null);
INSERT INTO answer VALUES (null, 4, 13, null, null, null, 5);

INSERT INTO answer VALUES (null, 5, 14, null, '1,2,3,4', null, null);
INSERT INTO answer VALUES (null, 5, 15, null, null, '我没什么可以说的', null);
INSERT INTO answer VALUES (null, 5, 16, null, null, null, 5);

INSERT INTO answer VALUES (null, 6, 17, 1, null, null, null);
INSERT INTO answer VALUES (null, 6, 18, null, '1,2,3,4', null, null);
INSERT INTO answer VALUES (null, 6, 19, null, null, '我没什么可以说的', null);

INSERT INTO answer VALUES (null, 7, 20, 1, null, null, null);
INSERT INTO answer VALUES (null, 7, 21, null, null, '我没什么可以说的', null);
INSERT INTO answer VALUES (null, 7, 22, null, null, null, 5);

INSERT INTO answer VALUES (null, 8, 23, null, '1,2,3,4', null, null);
INSERT INTO answer VALUES (null, 8, 24, null, null, '我没什么可以说的', null);
INSERT INTO answer VALUES (null, 8, 25, null, null, null, 5);

INSERT INTO answer VALUES (null, 9, 26, 1, null, null, null);
INSERT INTO answer VALUES (null, 9, 27, null, '1,2,3,4', null, null);
INSERT INTO answer VALUES (null, 9, 28, null, null, null, 5);