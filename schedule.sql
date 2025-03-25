CREATE TABLE `scheduler` (
    `id` BIGINT	NOT NULL auto_increment primary key,
    `name`	VARCHAR(20)	NULL,
    `contents`	VARCHAR(255)	NULL,
    `password`	VARCHAR(20)	NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL
);

