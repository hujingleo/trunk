-- ----------------------------
-- Table structure for `article`
-- ----------------------------
-- DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT '文章id',
    `type` varchar(2) NOT NULL   COMMENT '类型',
    `title` varchar(20) NOT NULL   COMMENT '标题',
    `img` varchar(1000) NOT NULL   COMMENT '图片',
    `url` varchar(1000)    COMMENT '链接',
    `industry` varchar(2)    COMMENT '行业',
    `status` varchar(2) NOT NULL   COMMENT '状态',
    `author` varchar(20)  NOT NULL   COMMENT '创建者',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人id',
    `update_by` bigint(20) NOT NULL   COMMENT '更新人id',
    `update_at` bigint(20) NOT NULL   COMMENT '数据更新时间',
    `create_at` bigint(20) NOT NULL   COMMENT '数据创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





