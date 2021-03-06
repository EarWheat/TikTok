create table tiktok_user(
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	`user_id` varchar(32) NOT NULL DEFAULT 0 COMMENT '用户ID',
	`user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
	`password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
	`avatar` varchar(512) NOT NULL DEFAULT '' COMMENT '用户头像',
	`user_nickname` varchar(32) NOT NULL DEFAULT '' COMMENT '用户昵称',
	`create_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
	`update_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '更新时间',
	PRIMARY KEY(`id`),
	UNIQUE(`user_id`),
	INDEX `index_user_name`(user_name)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户基础信息表';


INSERT INTO tiktok_user(user_id, user_name, password, user_nickname, avatar) VALUES ("liuzhaolu", "liuzhaolu", "liuzhaolu123", "CallMeZero_", "outman");
INSERT INTO tiktok_user(user_id, user_name, password, user_nickname, avatar) VALUES ("苏檀儿", "苏檀儿", "liuzhaolu123", "苏檀儿", "http://img.7qile.com/ql202006/6474.jpg");

