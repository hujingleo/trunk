-- ----------------------------
-- Table structure for `companyTag`
-- ----------------------------
-- DROP TABLE IF EXISTS `companyTag`;
CREATE TABLE `companyTag` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '公司标签id自增主键',  
    `company_id` bigint NOT NULL   COMMENT '公司id',  
    `tag` varchar NOT NULL   COMMENT '公司标签',  
    `create_by` bigint NOT NULL   COMMENT '创建人id',  
    `update_by` bigint NOT NULL   COMMENT '更新人id',  
    `update_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `create_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





