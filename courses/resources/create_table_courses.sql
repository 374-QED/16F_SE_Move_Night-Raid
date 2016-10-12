<<<<<<< HEAD
\\in mysql commandline
\\change my.ini at secure_priv_file to secure_priv_file = "" run notepad at admin and find my.ini in C:\ProgramData\MySQL\...
\\make sure reset the database in order for it to change the setting
\\insert course_name.csv into cs374 database folder in MySQL
create database cs374;
use cs374;
create table cs374_anon (
Pidm varchar(10),
Term_Code varchar(10),
Banner_id varchar(10),
First_name varchar(225),
Last_name varchar(225),
Middle_name varchar(225),
Subject_Code varchar(10),
Course_number varchar(10),
Reg_STS_Code varchar(10),
Grade_Code varchar(2));

load data infile 'course_name.csv' into table cs374_anon columns terminated by ',' optionally enclosed by '"' escaped by '"' lines terminated by '\r\n' ignore 1 lines;
=======
 
>>>>>>> c0d40e569af50245f8aafc678a98f9cf5f35230e
