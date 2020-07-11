CREATE TABLE IF NOT EXISTS `user`
(
    `id`          int(11)        NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username`    varchar(20)    NOT NULL COMMENT '用户名',
    `email`       varchar(50)    NOT NULL COMMENT '邮箱',
    `age`         int(2)         NOT NULL COMMENT '年龄',
    `amount`      decimal(10, 2) NOT NULL COMMENT '金额',
    `gender`      varchar(10)    NOT NULL COMMENT '性别',
    `deleted`     int(1)         NOT NULL DEFAULT 0 COMMENT '是否删除 0:未删除 1:已删除',
    `creator`     varchar(20)             DEFAULT NULL COMMENT '创建人',
    `modifier`    varchar(20)             DEFAULT NULL COMMENT '更新人',
    `create_time` datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime       NOT NUll DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    KEY `index_gender` (`gender`) USING BTREE COMMENT '性别',
    KEY `index_username` (`username`) USING BTREE COMMENT '用户名',
    KEY `index_deleted` (`deleted`) USING BTREE COMMENT '是否删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT '用户信息';
