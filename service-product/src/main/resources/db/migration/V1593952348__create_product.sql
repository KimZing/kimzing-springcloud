CREATE TABLE IF NOT EXISTS `product`
(
    `id`             int(11)        NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    `title`          varchar(14)    NOT NULL COMMENT '商品标题',
    `sub_title`      varchar(28) COMMENT '商品副标题',
    `price`          decimal(10, 2) NOT NULL COMMENT '价格',
    `image`          varchar(100)   NOT NULL COMMENT '商品主图',
    `album_images`   varchar(500) COMMENT '专辑图片，以逗号分割',
    `sales`          int                     DEFAULT 0 COMMENT '销量',
    `stock`          int                     DEFAULT 0 COMMENT '库存',
    `low_stock`      int COMMENT '库存预警值',
    `keywords`       varchar(255) COMMENT '关键字',
    `detail_pc`      text COMMENT 'PC端网页详情',
    `detail_mobile`  text COMMENT '移动端网页详情',
    `publish_status` varchar(15)             DEFAULT 'UNPUBLISHED' COMMENT '上架状态：UNPUBLISHED->下架；PUBLISHED->上架',
    `deleted`        int(1)         NOT NULL DEFAULT 0 COMMENT '是否删除 0:未删除 1:已删除',
    `creator`        varchar(20)             DEFAULT NULL COMMENT '创建人',
    `modifier`       varchar(20)             DEFAULT NULL COMMENT '更新人',
    `create_time`    datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time`    datetime       NOT NUll DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    KEY `index_stock` (`stock`) USING BTREE COMMENT '库存',
    KEY `index_low_stock` (`low_stock`) USING BTREE COMMENT '告警库存',
    KEY `index_publish_status` (`publish_status`) USING BTREE COMMENT '发布状态',
    KEY `index_deleted` (`deleted`) USING BTREE COMMENT '是否删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT '商品信息';

