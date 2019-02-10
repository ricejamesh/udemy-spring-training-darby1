select SESSION_USER, CURRENT_USER;

set ROLE hbstudent;

drop  table course;

create table if not exists course (
  id SERIAL PRIMARY KEY,
  title text CONSTRAINT title_unique UNIQUE,
  instructor_id integer REFERENCES instructor(id)
);
