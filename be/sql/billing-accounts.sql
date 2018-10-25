CREATE TABLE `billing_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1

create table lessons
(
  date        date                 not null,
  teacher     varchar(50)          null,
  room        varchar(10)          null,
  subject     varchar(10)          null,
  who         varchar(10)          null,
  id          bigint               null,
  lesson_type enum ('0', '1', '2') not null,
  time        varchar(12)          null,
  constraint lessons_id_uindex
  unique (id)
);

