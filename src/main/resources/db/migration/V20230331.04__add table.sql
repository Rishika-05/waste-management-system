CREATE TABLE `air_quality`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT,
    `created_at`     datetime     DEFAULT NULL,
    `created_by`     varchar(255) DEFAULT NULL,
    `updated_at`     datetime     DEFAULT NULL,
    `updated_by`     varchar(255) DEFAULT NULL,
    `record_date`    date     DEFAULT NULL,
    `index`          float        DEFAULT NULL,
    `fk_facility_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);