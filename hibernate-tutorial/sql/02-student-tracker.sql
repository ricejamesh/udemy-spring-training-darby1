select SESSION_USER, CURRENT_USER;

set ROLE hbstudent;

create table if not exists student (
	id SERIAL PRIMARY KEY,
	first_name text,
	last_name text,
	email text
);

select * from student;