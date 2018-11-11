create table if not exists accounts
(
  id       bigint auto_increment,
  email    varchar(256) not null,
  password varchar(256) not null,
  role     varchar(256) null,
  constraint accounts_email_uindex
  unique (email),
  constraint accounts_id_uindex
  unique (id)
);

alter table accounts
  add primary key (id);

create table if not exists student_groups
(
  number      bigint auto_increment,
  course      bigint       null,
  description varchar(256) null,
  constraint student_groups_number_uindex
  unique (number)
);

alter table student_groups
  add primary key (number);

create table if not exists students
(
  number       bigint auto_increment,
  first_name   varchar(256) null,
  last_name    varchar(256) null,
  group_number bigint       null,
  account_id   bigint       null,
  constraint students_number_uindex
  unique (number),
  constraint students_accounts_id_fk
  foreign key (account_id) references accounts (id)
    on update cascade
    on delete cascade,
  constraint students_student_groups_number_fk
  foreign key (group_number) references student_groups (number)
    on update cascade
    on delete cascade
);

alter table students
  add primary key (number);

create table if not exists students_to_lessons
(
  id             bigint auto_increment
    primary key,
  visit          tinyint null,
  lesson_id      bigint  null,
  student_number bigint  null
)
  engine = MyISAM;

create index FK367vfk88jalq2ouh64mhie63h
  on students_to_lessons (student_number);

create index FK7i6tq5p2ysb2w0l9oxlcyvw5k
  on students_to_lessons (lesson_id);

create table if not exists teachers
(
  number     bigint auto_increment,
  first_name varchar(256) null,
  last_name  varchar(256) null,
  account_id bigint       null,
  constraint teachers_number_uindex
  unique (number),
  constraint teachers_accounts_id_fk
  foreign key (account_id) references accounts (id)
    on update cascade
    on delete cascade
);

alter table teachers
  add primary key (number);

create table if not exists lessons
(
  id             bigint auto_increment,
  time_start     timestamp    null,
  time_end       timestamp    null,
  description    varchar(256) null,
  room           varchar(256) null,
  type           varchar(256) null,
  teacher_number bigint       null,
  constraint lessons_id_uindex
  unique (id),
  constraint lessons_teachers_number_fk
  foreign key (teacher_number) references teachers (number)
    on update cascade
    on delete cascade
);

alter table lessons
  add primary key (id);

create table if not exists student_groups_to_lessons
(
  id           bigint auto_increment,
  group_number bigint null,
  lesson_id    bigint null,
  constraint student_groups_to_lessons_id_uindex
  unique (id),
  constraint student_groups_to_lessons_lessons_id_fk
  foreign key (lesson_id) references lessons (id)
    on update cascade
    on delete cascade,
  constraint student_groups_to_lessons_student_groups_number_fk
  foreign key (group_number) references student_groups (number)
    on update cascade
    on delete cascade
);

alter table student_groups_to_lessons
  add primary key (id);

