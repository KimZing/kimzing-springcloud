CREATE TABLE IF NOT EXISTS `storage_file`
(
    `id`           int(11)      NOT NULL AUTO_INCREMENT COMMENT '存储文件ID',
    `name`         int(11)      NOT NULL COMMENT '文件名',
    `content_type` varchar(50)  NOT NULL COMMENT '文件类型',
    `url`          varchar(500) NOT NULL COMMENT '文件url',
    `bucket`       varchar(50)  NOT NULL COMMENT '存储桶',
    `deleted`      int(1)       NOT NULL DEFAULT 0 COMMENT '是否删除 0:未删除 1:已删除',
    `creator`      varchar(20)           DEFAULT NULL COMMENT '创建人',
    `modifier`     varchar(20)           DEFAULT NULL COMMENT '更新人',
    `create_time`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time`  datetime     NOT NUll DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    KEY `index_name` (`name`) USING BTREE COMMENT '文件名',
    KEY `index_content_type` (`content_type`) USING BTREE COMMENT '文件类型',
    KEY `index_url` (`url`) USING BTREE COMMENT '文件url',
    KEY `bucket` (`bucket`) USING BTREE COMMENT '存储桶',
    KEY `index_deleted` (`deleted`) USING BTREE COMMENT '是否删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT '文件存储信息';