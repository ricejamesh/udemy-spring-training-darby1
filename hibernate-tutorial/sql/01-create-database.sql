-- Run these commands to create the default database.

-- Note: CREATE DATABASE needs to be executed individually.

DO
$do$
BEGIN
   IF NOT EXISTS (
      SELECT                       -- SELECT list can stay empty for this
      FROM   pg_catalog.pg_roles
      WHERE  rolname = 'hbstudent') THEN

      CREATE ROLE hbstudent LOGIN PASSWORD 'hbstudent' CREATEDB;
   END IF;
END
$do$;

set ROLE 'hbstudent';

create database "hb_student_tracker";

-- SELECT * FROM   pg_catalog.pg_roles;
-- drop role hbstudent;

-- select SESSION_USER, CURRENT_USER;
-- reset ROLE;

-- drop database hb_student_tracker;

