insert into account (account_id, email, password, role) values (1, 'fdas0@dagondesign.com', 'aZvFWeQRR8I', 'student');
insert into account (account_id, email, password, role) values (2, 'desplin1@chron.com', 'PpNhDMWWd', 'teacher');
insert into account (account_id, email, password, role) values (3, 'rfiller2@mozilla.org', 'MSQOAy', 'student');
insert into account (account_id, email, password, role) values (4, 'ngreetham3@craigslist.org', '0U0pN9WJ0', 'student');
insert into account (account_id, email, password, role) values (5, 'gmacenzy4@techcrunch.com', 'VQnjlj1u9CZ', 'student');
insert into account (account_id, email, password, role) values (6, 'pmcdool5@sourceforge.net', 'byIVUMap', 'student');
insert into account (account_id, email, password, role) values (7, 'drobjents6@uol.com.br', 'tmoR9v', 'student');
insert into account (account_id, email, password, role) values (8, 'nforlonge7@businessinsider.com', 'uS1JHDPWYPXI', 'teacher');
insert into account (account_id, email, password, role) values (9, 'llonergan8@about.me', 'paRB6pHjshf', 'teacher');
insert into account (account_id, email, password, role) values (10, 'sscorton9@unesco.org', 'O7gKFjg', 'teacher');
insert into account (account_id, email, password, role) values (11, 'fgodbalda@comsenz.com', 'sxp6Q2PC1FJU', 'student');
insert into account (account_id, email, password, role) values (12, 'pprestonb@weebly.com', 'ild9Cj2oNb', 'teacher');
insert into account (account_id, email, password, role) values (13, 'eseinec@reuters.com', 'uzQ1X6a4TV', 'teacher');
insert into account (account_id, email, password, role) values (14, 'pdroverd@last.fm', 'hMCv80BT', 'student');
insert into account (account_id, email, password, role) values (15, 'ccolquytee@myspace.com', 'D5UbKesBY5u', 'teacher');
insert into account (account_id, email, password, role) values (16, 'ledgarsf@amazon.com', '73FoFJPWox', 'admin');
insert into account (account_id, email, password, role) values (17, 'cfollisg@sciencedaily.com', 'dWANXrNLE', 'student');
insert into account (account_id, email, password, role) values (18, 'jjellingsh@163.com', 'GoOcT3gR', 'student');
insert into account (account_id, email, password, role) values (19, 'efiski@salon.com', 'mwDzDbig', 'student');
insert into account (account_id, email, password, role) values (20, 'pspearj@flavors.me', 'zJYkp5ZBDd', 'student');

insert into teacher (teacher_id, name, surname, account_id) values (1, 'Karissa', 'Rays', 2);
insert into teacher (teacher_id, name, surname, account_id) values (2, 'Antonio', 'Lethbrig', 8);
insert into teacher (teacher_id, name, surname, account_id) values (3, 'Yard', 'Lowndsbrough', 9);
insert into teacher (teacher_id, name, surname, account_id) values (4, 'Lucienne', 'Brook', 10);
insert into teacher (teacher_id, name, surname, account_id) values (5, 'Reamonn', 'Paddefield', 12);
insert into teacher (teacher_id, name, surname, account_id) values (6, 'Marge', 'Towe', 13);
insert into teacher (teacher_id, name, surname, account_id) values (7, 'Marrissa', 'Dunbleton', 15);

insert into student_group (group_id, course, description) values (1, 2, 'AI');
insert into student_group (group_id, course, description) values (2, 2, 'FAI');
insert into student_group (group_id, course, description) values (3, 3, 'BAI');
/*first group*/
insert into student (student_id, group_id, account_id, name, surname) values (1, 1, 1, 'Ozzie', 'Torrijos');
insert into student (student_id, group_id, account_id, name, surname) values (2, 1, 3, 'Doy', 'Piller');
insert into student (student_id, group_id, account_id, name, surname) values (3, 1, 4, 'Renault', 'Jenner');
insert into student (student_id, group_id, account_id, name, surname) values (4, 1, 5, 'Moll', 'O''Dea');
/*second group*/
insert into student (student_id, group_id, account_id, name, surname) values (5, 2, 6, 'Imojean', 'Hartley');
insert into student (student_id, group_id, account_id, name, surname) values (6, 2, 7, 'Consuela', 'Vodden');
insert into student (student_id, group_id, account_id, name, surname) values (7, 2, 11, 'Marven', 'Heinsh');
insert into student (student_id, group_id, account_id, name, surname) values (8, 2, 14, 'Carlo', 'Raeburn');
/*third group*/
insert into student (student_id, group_id, account_id, name, surname) values (9, 3, 17, 'Care', 'Dicky');
insert into student (student_id, group_id, account_id, name, surname) values (10, 3, 18, 'Sandie', 'Eisold');
insert into student (student_id, group_id, account_id, name, surname) values (11, 3, 19, 'Christiane', 'Nannizzi');
insert into student (student_id, group_id, account_id, name, surname) values (12, 3, 20, 'Cordelia', 'MacGee');

insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) VALUES (1,'2018-11-1 12:00','2018-11-1 13:00','LAI','Lection',1,'632-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (2,'2018-11-1 12:00','2018-11-1 13:00','SAI','Lection',1,'62-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (3,'2018-11-1 13.10','2018-11-1 15.10','SAI','Laboratory',2,'603-5');/*
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (4,'2018-11-1 13.10','2018-11-1 15.10','FAI','Laboratory',4,'603-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (5,'2018-11-1 15.20','2018-11-1 16.20','FAI','Laboratory',3,'603-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (6,'2018-11-1 15.20','2018-11-1 16.20','DAI','Laboratory',4,'7-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (7,'2018-11-1 16.30','2018-11-1 17.20','LAI','Practical',2,'63-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (8,'2018-11-1 16.30','2018-11-1 17.20','LAI','Practical',3,'7-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (9,'2018-11-1 16.30','2018-11-1 17.20','FAI','Practical',4,'637-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (10,'2018-11-1 17.40','2018-11-1 18.50','DAI','Practical',5,'1-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (11,'2018-11-1 17.40','2018-11-1 18.50','LAI','Practical',6,'607-2');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (12,'2018-11-1 17.40','2018-11-1 18.50','DAI','Practical',3,'603-4');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (13,'2018-11-1 17.40','2018-11-1 18.50','LAI','Practical',3,'611-5');
insert into lesson(lesson_id, time_start, time_end, description, lesson_type, teacher_id, room) Values (14,'2018-11-1 17.40','2018-11-1 18.50','FAI','Practical',2,'622-5');*/

insert into group_to_lesson (entry_id, group_id, lesson_id) values (1,1,1);
insert into group_to_lesson (entry_id, group_id, lesson_id) values (2,2,1);
insert into group_to_lesson (entry_id, group_id, lesson_id) values (3,1,3);


insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 1,1,1,false );
insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 2,2,1,false );
insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 3,3,1,false );
insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 4,4,1,false );

insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 5,5,1,false );
insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 6,6,1,false );
insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 7,7,1,false );
insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 9,8,1,false );

insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 10,1,3,false );
insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values (11,2,3,false );
insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 12,3,3,false );
insert into student_to_lesson (entry_id, student_id, lesson_id, visit) values ( 13,4,3,false );









