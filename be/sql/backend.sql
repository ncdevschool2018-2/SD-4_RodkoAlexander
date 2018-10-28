use backend;



drop table group_to_lesson;
drop table student_to_lesson;
drop table lesson;
drop table student;
drop table student_group;
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

  teacher_id int unsigned not null
    primary key,
  name varchar(255),
  surname varchar(255),
  account_id int unsigned not null,
  CONSTRAINT teachers_accounts_account_id_fk FOREIGN KEY (account_id) REFERENCES account (account_id)
);

create table student_group
(
  group_id    int unsigned not null
    primary key,
  course      int          not null,
  description varchar(255) not null
);
CREATE TABLE student
(
  student_id int unsigned not null primary key ,
  group_id int unsigned NOT NULL,
  account_id int unsigned NOT NULL,
  name varchar(255),
  surname varchar(255),
  CONSTRAINT students_student_groups_group_id_fk FOREIGN KEY (group_id) REFERENCES student_group (group_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT students_accounts_account_id_fk FOREIGN KEY (account_id) REFERENCES account (account_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE lesson
(
  lesson_id int unsigned not null primary key ,
  time_start timestamp NOT NULL,
  time_end timestamp NOT NULL,
  description varchar(255) NOT NULL,
  lesson_type varchar(255) NOT NULL,
  teacher_id int unsigned NOT NULL,
  room varchar(255),
  CONSTRAINT lessons_teachers_teacher_id_fk FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE group_to_lesson
(
  entry_id int unsigned not null primary key ,
  group_id int unsigned NOT NULL,
  lesson_id int unsigned NOT NULL,
  CONSTRAINT groups_to_lessons_student_groups_group_id_fk FOREIGN KEY (group_id) REFERENCES student_group (group_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT groups_to_lessons_lessons_id_fk FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE student_to_lesson
(
entry_id int unsigned not null primary key ,
    student_id int unsigned NOT NULL,
    lesson_id int unsigned NOT NULL,
    visit bool,
    CONSTRAINT students_to_lessons_students_student_id_fk FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT students_to_lessons_lessons_id_fk FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id) ON DELETE CASCADE ON UPDATE CASCADE
);