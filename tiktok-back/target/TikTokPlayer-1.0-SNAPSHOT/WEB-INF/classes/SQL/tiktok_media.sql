create table tiktok_media(
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	`user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '发表视频的用户id',
	`media_id` varchar(32) NOT NULL DEFAULT '' COMMENT '媒体的id',
	`resource`  varchar(128) NOT NULL DEFAULT '' COMMENT '内容源',
	`create_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
	`update_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '更新时间',
	PRIMARY KEY(`id`),
	UNIQUE(`media_id`),
	INDEX `index_media_id`(media_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='视频信息表';

INSERT INTO tiktok_media (user_id, media_id, resource) VALUES ("liuzhaolu", "liuzhaolu_media_1", "https://mp4.vjshi.com/2020-03-13/575bf5e035a1c0b1c820b03f99e99ce6.mp4");
INSERT INTO tiktok_media (user_id, media_id, resource) VALUES ("liuzhaolu", "liuzhaolu_media_2", "https://mp4.vjshi.com/2019-12-10/5bcb45461c10a929ab0ddab665ba9ef5.mp4");
INSERT INTO tiktok_media (user_id, media_id, resource) VALUES ("liuzhaolu", "liuzhaolu_media_3", "https://mp4.vjshi.com/2019-12-09/5ef77dc687c0fb13e0fb6242b50074e1.mp4");
