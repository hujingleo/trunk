-- ----------------------------
-- Table structure for `company`
-- ----------------------------
-- DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '公司id,自增主键',  
    `name` varchar NOT NULL   COMMENT '公司名称',  
    `province` varchar NOT NULL   COMMENT '省编码',  
    `city` varchar NOT NULL   COMMENT '市编码',  
    `county` varchar NOT NULL   COMMENT '县编码',  
    `finacing` varchar NOT NULL   COMMENT '融资规模',  
    `approved` bigint NOT NULL  COMMENT '认证状态',
    `freezed` bigint  NOT NULL  COMMENT '冻结状态',
    `logo` varchar NOT NULL   COMMENT '公司logo',  
    `slogan` varchar NOT NULL   COMMENT '公司标语',
    `total_num` bigint NOT NULL   COMMENT '公司人数',  
    `summary` varchar NOT NULL   COMMENT '公司介绍',  
    `industry` varchar NOT NULL   COMMENT '公司行业',  
    `phone` bigint    COMMENT '公司电话',  
    `address` varchar    COMMENT '地址',  
    `map` varchar    COMMENT '公司地图',
    `mail` varchar   COMMENT '公司邮箱',
    `profession_count` bigint    COMMENT '在招职位数',  
    `product_name` varchar    COMMENT '产品名称',  
    `product_logo` varchar    COMMENT '产品logo',  
    `product_solgan` varchar    COMMENT '产品标语',  
    `product_summary` varchar    COMMENT '产品简介',  
    `approved_at` bigint    COMMENT '认证时间',  
    `release_at` bigint    COMMENT '最新职位上架时间',  
    `create_by` bigint NOT NULL   COMMENT '创建人id',  
    `update_by` bigint NOT NULL   COMMENT '更新人id',  
    `create_at` bigint NOT NULL   COMMENT '数据更新时间',  
    `update_at` bigint NOT NULL   COMMENT '数据创建时间',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





