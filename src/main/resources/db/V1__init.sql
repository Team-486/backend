create table road
(
    `id`              BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`            VARCHAR(255) NOT NULL,
    `start_spot_id`   BIGINT       NOT NULL,
    `end_spot_id`     BIGINT       NOT NULL,
    `smooth_photo`    VARCHAR(255) NOT NULL,
    `normal_photo`    VARCHAR(255) NOT NULL,
    `congested_photo` VARCHAR(255) NOT NULL
);

CREATE TABLE spot
(
    `id`        BIGINT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`      VARCHAR(255)    NOT NULL,
    `latitude`  DECIMAL(20, 17) NOT NULL,
    `longitude` DECIMAL(20, 17) NOT NULL
);