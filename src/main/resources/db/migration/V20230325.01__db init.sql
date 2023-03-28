CREATE
DATABASE IF NOT EXISTS `waste-management`;
USE
`waste-management`;

CREATE TABLE `user`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime     DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `updated_at` datetime     DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL,
    `name`       varchar(255) NOT NULL,
    `phone_no`   varchar(255) NOT NULL,
    `password`   varchar(255) NOT NULL,
    `role`       varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `waste_generator`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime     DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `updated_at` datetime     DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL,
    `address`    varchar(255) NULL,
    `city`       varchar(255) NULL,
    `state`      varchar(255) NULL,
    `pincode`    int(11) NULL,
    `fk_user_id` int(11) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `waste_collector`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime     DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `updated_at` datetime     DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL,
    `vehicle_no`       varchar(255) NOT NULL,
    `pincode`   int(11) NOT NULL,
    `fk_user_id` int(11) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `waste_facilitator`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime     DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `updated_at` datetime     DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL,
    `joining_date` date DEFAULT NULL,
    `fk_facility_id` int(11) NOT NULL,
    `fk_user_id` int(11) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `govt_official`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime     DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `updated_at` datetime     DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL,
    `department`  varchar(255) NOT NULL,
    `pincode_csv` varchar(255) NOT NULL,
    `fk_user_id` int(11) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `waste_facility`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime     DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `updated_at` datetime     DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL,
    `address`    varchar(255) NULL,
    `city`       varchar(255) NULL,
    `state`      varchar(255) NULL,
    `pincode`    int(11) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `waste`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime     DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `updated_at` datetime     DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL,
    `type`       varchar(255) NOT NULL,
    `amount_in_gms`   double NOT NULL,
    `generated_by`   int(11) NOT NULL,
    `generated_at`   datetime NOT NULL,
    `collected_by`   int(11) NOT NULL,
    `collected_at`   datetime NOT NULL,
    `processed_by`   int(11) NOT NULL,
    `processed_at`   datetime NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `air_quality`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime     DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `updated_at` datetime     DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL,
    `record_date` datetime NOT NULL,
    `index`   double NOT NULL,
    `fk_facility_id` int(11) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `admin`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime     DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `updated_at` datetime     DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL,
    `level` int(11) NOT NULL,
    `fk_user_id` int(11) NOT NULL,
    PRIMARY KEY (`id`)
);
