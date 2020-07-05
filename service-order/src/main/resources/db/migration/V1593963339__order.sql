CREATE TABLE IF NOT EXISTS `order`
(
    `id`          int(11)        NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    `user_id`    varchar(20)    NOT NULL COMMENT '用户ID',
    `total_price`         int(2)         NOT NULL COMMENT '订单总价',
    `status`      varchar(10)    NOT NULL COMMENT '状态',
    `deleted`      int(1)    NOT NULL DEFAULT 0 COMMENT '是否删除 0:未删除 1:已删除',
    `creator`     varchar(20)             DEFAULT NULL COMMENT '创建人',
    `modifier`    varchar(20)             DEFAULT NULL COMMENT '更新人',
    `create_time` datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime       NOT NUll DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    KEY `index_user_id` (`user_id`) USING BTREE COMMENT '用户ID',
    KEY `index_status` (`status`) USING BTREE COMMENT '订单状态',
    KEY `index_deleted` (`deleted`) USING BTREE COMMENT '是否删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT '订单信息';
