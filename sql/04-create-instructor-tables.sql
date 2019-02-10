select SESSION_USER, CURRENT_USER;

set ROLE hbstudent;

create table if not exists instructor_detail (
	id SERIAL PRIMARY KEY,
	youtube_channel text,
	hobby text
);

drop table instructor;

create table if not exists instructor (
  id SERIAL PRIMARY KEY,
  first_name text,
  last_name text,
  email text,
  instructor_detail_id INTEGER REFERENCES instructor_detail(id) ON DELETE CASCADE
);

select * from student;

select * from instructor;

select * from instructor_detail;

truncate table instructor_detail cascade ;

select * from instructor i
inner join instructor_detail d on
d.id = i.instructor_detail_id;

delete from instructor_detail where id = 5;