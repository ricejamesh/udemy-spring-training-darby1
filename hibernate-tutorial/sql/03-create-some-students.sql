set ROLE hbstudent;

insert INTO student (first_name,	last_name, email) VALUES
    ('Daffy', 'Duck', 'Daffy.Duck@disney.com'),
    ('Mickey', 'Mouse', 'Mickey.Mouse@disney.com'),
    ('Pluto', 'Dog', 'Pluto.Dog@disney.com');

select * from student;