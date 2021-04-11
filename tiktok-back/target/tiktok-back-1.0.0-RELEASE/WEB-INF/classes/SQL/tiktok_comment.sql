create table tiktok_comment(
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	`user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '评论的用户id',
	`comment_id` varchar(32) NOT NULL DEFAULT '' COMMENT '评论的id',
	`content`  varchar(128) NOT NULL DEFAULT '' COMMENT '评论内容',
	`media_id` varchar(32) NOT NULL DEFAULT '' COMMENT '媒体的id',
	`create_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
	`update_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '更新时间',
	PRIMARY KEY(`id`),
	UNIQUE(`comment_id`),
	INDEX `index_media_id`(media_id),
	INDEX `index_user_id`(user_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='视频评论信息表';
