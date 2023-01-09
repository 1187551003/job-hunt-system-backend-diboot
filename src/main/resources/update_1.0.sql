-- 2023-01-07 11:32:05 by 刘长卿
ALTER TABLE `t_ods_recruit` MODIFY COLUMN `id` bigint auto_increment NOT NULL COMMENT 'ID';
-- 2023-01-07 11:32:05 by 刘长卿
ALTER TABLE `t_ods_recruit` ADD COLUMN `create_time` timestamp NULL COMMENT '创建时间' AFTER `position_type`;
-- 2023-01-07 11:32:05 by 刘长卿
ALTER TABLE `t_ods_recruit` ADD COLUMN `create_by` bigint COMMENT '创建人ID' AFTER `create_time`;
-- 2023-01-07 11:32:05 by 刘长卿
ALTER TABLE `t_ods_recruit` ADD COLUMN `update_time` timestamp NULL COMMENT '更新时间' AFTER `create_by`;
-- 2023-01-07 11:32:05 by 刘长卿
ALTER TABLE `t_ods_recruit` ADD COLUMN `update_by` bigint COMMENT '更新人ID' AFTER `update_time`;
-- 2023-01-07 11:32:05 by 刘长卿
ALTER TABLE `t_ods_recruit` ADD COLUMN `is_deleted` tinyint(1) COMMENT '逻辑删除' AFTER `update_by`;
-- 2023-01-07 12:27:39 by 刘长卿
ALTER TABLE `t_ods_recruit` MODIFY COLUMN `create_time` timestamp NULL COMMENT '创建时间' AFTER `position_type`;
-- 2023-01-07 12:27:39 by 刘长卿
ALTER TABLE `t_ods_recruit` MODIFY COLUMN `is_deleted` tinyint(1) DEFAULT 0 COMMENT '删除标记' AFTER `create_time`;
