-- ----------------------------
-- Table structure for `company`
-- ----------------------------
-- DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '公司id自增主键',
    `name` varchar NOT NULL   COMMENT '公司名称',  
    `province` varchar NOT NULL   COMMENT '省编码',  
    `city` varchar NOT NULL   COMMENT '市编码',  
    `county` varchar NOT NULL   COMMENT '县编码',  
    `finacing` varchar NOT NULL   COMMENT '融资规模',  
    `approved` varchar NOT NULL   COMMENT '认证状态',
    `freezed` varchar  NOT NULL  COMMENT '冻结状态',
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




-- ----------------------------
-- Table structure for `profession`
-- ----------------------------
-- DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
    `id` bigint(20) NOT NULL   AUTO_INCREMENT  COMMENT '职位id自增主键',
    `company_name` varchar(50) NOT NULL   COMMENT '公司名称',
    `company_Id` bigint(20) NOT NULL   COMMENT '公司id',
    `name` varchar(50) NOT NULL   COMMENT '职位名称',
    `category` varchar(2)   COMMENT '职业类别',
    `education` varchar(2)    COMMENT '学历要求',
    `experience` varchar(2)    COMMENT '工作经验',
    `compensation` varchar(2)    COMMENT '薪资',
    `responsibility` varchar(50)    COMMENT '岗位职责',
    `requisite` varchar(50)    COMMENT '必要条件',
    `boon` varchar(50)    COMMENT '公司福利',
    `status` varchar(2)     COMMENT '上架状态',
    `release_at` bigint(20)    COMMENT '上架时间',
    `recommend` varchar(2)  NOT NULL  COMMENT '推荐类型',
    `tag_id` varchar(20)    COMMENT '职业标签id',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人id',
    `update_by` bigint(20) NOT NULL   COMMENT '更新人id',
    `update_at` bigint(20) NOT NULL   COMMENT '数据更新时间',
    `create_at` bigint(20) NOT NULL   COMMENT '数据创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `companyTag`
-- ----------------------------
-- DROP TABLE IF EXISTS `companyTag`;
CREATE TABLE `companyTag` (
    `id` bigint(20)  NOT NULL   AUTO_INCREMENT  COMMENT '公司标签id自增主键',
    `company_id` bigint(20)  NOT NULL   COMMENT '公司id',
    `tag` varchar(20) NOT NULL   COMMENT '公司标签',
    `create_by` bigint(20) NOT NULL   COMMENT '创建人id',
    `update_by` bigint(20)  NOT NULL   COMMENT '更新人id',
    `update_at` bigint(20)  NOT NULL   COMMENT '数据更新时间',
    `create_at` bigint(20)  NOT NULL   COMMENT '数据创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




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




