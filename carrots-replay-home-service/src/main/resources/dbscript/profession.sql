-- ----------------------------
-- Table structure for `profession`
-- ----------------------------
-- DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '职位id自增主键',  
    `company_name` varchar NOT NULL   COMMENT '公司名称',  
    `company_Id` bigint NOT NULL   COMMENT '公司id',  
    `name` varchar NOT NULL   COMMENT '职位名称',  
    `category` varchar    COMMENT '职业类别',  
    `education` varchar    COMMENT '学历要求',  
    `experience` varchar    COMMENT '工作经验',  
    `compensation` varchar    COMMENT '薪资',  
    `responsibility` varchar    COMMENT '岗位职责',  
    `requisite` varchar    COMMENT '必要条件',  
    `boon` varchar    COMMENT '公司福利',  
    `status` bigint  NOT NULL  COMMENT '上架状态',
    `release_at` bigint    COMMENT '上架时间',  
    `recommend` varchar  NOT NULL  COMMENT '推荐类型',
    `tag_id` varchar    COMMENT '职业标签id',  
    `create_by` bigint NOT NULL   COMMENT '创建人id',  
    `update_by` bigint NOT NULL   COMMENT '更新人id',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





