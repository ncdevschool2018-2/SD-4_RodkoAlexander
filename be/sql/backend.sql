use backend;

drop table groups_to_lessons;
drop table students_to_lessons;
drop table lessons;
drop table student;
drop table student_groups;
drop table teacher;
drop table account;





create table account
(
  account_id int unsigned not null
    primary key,
  email      varchar(255) not null,
  password   varchar(255) not null,
  role       varchar(255) not null
);
CREATE TABLE teacher
(
  name varchar(255),
  surname varchar(255),
  account_id int unsigned not null,
  CONSTRAINT teachers_accounts_account_id_fk FOREIGN KEY (account_id) REFERENCES account (account_id)
);
CREATE UNIQUE INDEX teachers_teacher_id_uindex ON teacher (account_id);
create table student_groups
(
  group_id    int unsigned not null
    primary key,
  course      int          not null,
  description varchar(255) not null
);
CREATE TABLE student
(
  group_id int unsigned NOT NULL,
  student_id int unsigned NOT NULL,
  name varchar(255),
  surname varchar(255),
  CONSTRAINT students_student_groups_group_id_fk FOREIGN KEY (group_id) REFERENCES student_groups (group_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT students_accounts_account_id_fk FOREIGN KEY (student_id) REFERENCES account (account_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE lessons
(
  account_id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
  time_start timestamp NOT NULL,
  time_end timestamp NOT NULL,
  description varchar(255) NOT NULL,
  lesson_type enum('0', '1', '2') NOT NULL,
  account_id int unsigned NOT NULL,
  room varchar(255),
  CONSTRAINT lessons_teachers_teacher_id_fk FOREIGN KEY (account_id) REFERENCES teacher (account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE UNIQUE INDEX lessons_id_uindex ON lessons (account_id);

CREATE TABLE groups_to_lessons
(
  group_id int unsigned NOT NULL,
  lesson_id int unsigned NOT NULL,
  CONSTRAINT groups_to_lessons_student_groups_group_id_fk FOREIGN KEY (group_id) REFERENCES student_groups (group_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT groups_to_lessons_lessons_id_fk FOREIGN KEY (lesson_id) REFERENCES lessons (account_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE students_to_lessons
(
    student_id int unsigned NOT NULL,
    lesson_id int unsigned NOT NULL,
    visit bool,
    CONSTRAINT students_to_lessons_students_student_id_fk FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT students_to_lessons_lessons_id_fk FOREIGN KEY (lesson_id) REFERENCES lessons (account_id) ON DELETE CASCADE ON UPDATE CASCADE
)