# TODO 修改业务表名
CREATE TABLE IF NOT EXISTS `user`
(
#   id为固定字段，请勿修改
    `id`          int(11)        NOT NULL AUTO_INCREMENT COMMENT '用户ID',
#   TODO 业务字段开始===================>
    `username`    varchar(20)    NOT NULL COMMENT '用户名',
    `email`       varchar(50)    NOT NULL COMMENT '邮箱',
    `age`         int(2)         NOT NULL COMMENT '年龄',
    `amount`      decimal(10, 2) NOT NULL COMMENT '金额',
    `gender`      varchar(10)    NOT NULL COMMENT '性别',
#   TODO 业务字段结束<===================
#   以下为公共字段，请勿修改
    `deleted`     int(1)         NOT NULL DEFAULT 0 COMMENT '是否删除 0:未删除 1:已删除',
    `creator`     varchar(20)             DEFAULT NULL COMMENT '创建人',
    `modifier`    varchar(20)             DEFAULT NULL COMMENT '更新人',
    `create_time` datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime       NOT NUll DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
#   TODO 建表时要将添加必要索引
    KEY `index_deleted` (`deleted`) USING BTREE COMMENT '是否删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
#   TODO 修改业务描述
    COMMENT '用户信息';
