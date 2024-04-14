create table road
(
    `id`                    bigint          not null primary key auto_increment,
    `name`                  varchar(255)    not null,
    `smooth_photo`          varchar(255),
    `normal_photo`          varchar(255),
    `stagnant_photo`        varchar(255),
    `start_point_latitude`  decimal(20, 17) not null,
    `start_point_longitude` decimal(20, 17) not null,
    `end_point_latitude`    decimal(20, 17) not null,
    `end_point_longitude`   decimal(20, 17) not null
);