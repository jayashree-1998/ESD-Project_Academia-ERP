
create table Employee(
	employee_id smallint UNSIGNED AUTO_INCREMENT,
	first_name varchar(30) NOT NULL,
	last_name varchar(30),
	email varchar(30) UNIQUE NOT NULL,
	title varchar(10),
	password varchar(4),
	photograph_path varchar(30),
	department_id smallint UNSIGNED,
	constraint pk_Employee PRIMARY KEY (employee_id)
);

create table Department(
	department_id smallint UNSIGNED AUTO_INCREMENT,
	name varchar(30) NOT NULL,
	capacity smallint NOT NULL,
	constraint pk_Department PRIMARY KEY (department_id)
);

create table Specialization(
	specialization_id smallint UNSIGNED AUTO_INCREMENT,
	code varchar(5) UNIQUE NOT NULL ,
	name varchar(100) NOT NULL,
	description varchar(30),
	year varchar(4) NOT NULL,
	credits_required smallint UNSIGNED NOT NULL,
	constraint pk_Specialization PRIMARY KEY (specialization_id)
);
	

create table Student(
	student_id smallint UNSIGNED AUTO_INCREMENT,
	roll_number varchar(9) NOT NULL,
	first_name varchar(30) NOT NULL,
	last_name varchar(30),
	email varchar(30) NOT NULL,
	photograph_path varchar(30),
	cgpa float(3,1) NOT NULL DEFAULT '0.0',
	total_credits smallint UNSIGNED NOT NULL,
	graduation_year varchar(4),
	specialization_id smallint UNSIGNED,
	UNIQUE(roll_number,email),
	constraint pk_Student PRIMARY KEY (student_id)
);


insert into Department(name,capacity) VALUES
('Administration',40),
('Faculty',50),
('Placement',20),
('Finance',30),
('Security',30);


insert into Employee(first_name,last_name,email,title,password,photograph_path,department_id) VALUES
('Muralidhara','V N','murali@iiitb.ac.in','Mr.','123',null,2),
('Nirmala','Desai','nirmala@iiitb.ac.in','Ms.','123',null,1),
('Viswanath','G','viswanath@iiitb.ac.in','Mr.','123',null,2),
('Neelam','Sinha','neelam@iiitb.ac.in','Ms.','123',null,2),
('Roshani','G','roshani@iiitb.ac.in','Ms.','123',null,3),
('Priyanka','Das','priyanka@iiitb.ac.in','Ms.','123',null,2);

insert into Specialization(code,name,description,year,credits_required) VALUES
('AIML','Artificial Intelligence and Machine Learning',null,'2022',20),
('CS','Computer Science and Theory',null,'2022',24),
('NC','Networking and Communication',null,'2022',20);

insert into Student(roll_number,first_name,last_name,email,photograph_path,cgpa,total_credits,graduation_year,specialization_id) VALUES
('MT2022051','Ginny','Weasely','ginny@iiitb.ac.in',null,10,20,2024,1),
('MT2022052','Harry','Potter','harry@iiitb.ac.in',null,9,20,2023,1),
('MT2022053','Hermoine','Granger','hermoine@iiitb.ac.in',null,8,20,2023,1),
('MT2022054','Fred','Weasely','fred@iiitb.ac.in',null,10,20,2023,2),
('MT2022055','George','Weasely','george@iiitb.ac.in',null,7,20,2024,1),
('MT2022056','Ronald','Weasely','ron@iiitb.ac.in',null,8,20,2023,1),
('MT2022057','Charlie','Weasely','charlie@iiitb.ac.in',null,7,20,2022,3);

alter table Employee
	add constraint fk_super_ssn FOREIGN KEY (department_id) REFERENCES Department(department_id);

alter table Student
	add constraint fk_specialization FOREIGN KEY (specialization_id) REFERENCES Specialization(specialization_id);


create table Course(
	course_id smallint UNSIGNED AUTO_INCREMENT,
	course_code varchar(10) NOT NULL UNIQUE,
	name varchar(100) NOT NULL,
	description varchar(50),
	year varchar(10) NOT NULL,
	term smallint UNSIGNED NOT NULL,
	credits smallint UNSIGNED NOT NULL,
	capacity smallint UNSIGNED NOT NULL,
	employee_id smallint UNSIGNED,
	constraint pk_Course PRIMARY KEY (course_id)
);

create table Course_Schedule(
	schedule_id smallint UNSIGNED AUTO_INCREMENT,
	time varchar(20) NOT NULL,
	day varchar(20) NOT NULL,
	room varchar(20) NOT NULL,
	building varchar(10),
	course_id smallint UNSIGNED,
	constraint pk_Course_Schedule PRIMARY KEY (schedule_id)
);

insert into Course(course_code,name,description,year,term,credits,capacity,employee_id) VALUES
('AI-511','Machine Learning',null,'2022',1,4,150,4),
('AI-512','Maths for ML',null,'2022',1,4,150,3),
('CS-411','Algorithms',null,'2022',1,4,150,1),
('AI-412','Data Visualization',null,'2022',1,4,150,6),
('AI-523','Artificial Intelegence',null,'2022',1,4,150,4);

insert into Course_Schedule(time,day,room,building,course_id) VALUES
('09:30','MON','103','R',1),
('09:30','WED','103','R',1),
('09:30','FRI','103','R',1),
('02:00','WED','103','R',2),
('02:00','THU','102','R',5),
('11:15','FRI','102','R',5),
('02:00','TUE','203','A',4),
('11:15','MON','203','A',4),
('02:00','FRI','203','R',3);

alter table Course
	add constraint fk_emp_id FOREIGN KEY (employee_id) REFERENCES Employee(employee_id);

alter table Course_Schedule
	add constraint fk_course_id FOREIGN KEY (course_id) REFERENCES Course(course_id);

Create table Course_Specialization (course_id smallint UNSIGNED NOT NULL,specialization_id smallint UNSIGNED NOT NULL);

alter table Course_Specialization add constraint fk_course_spec FOREIGN KEY (course_id) REFERENCES Course (course_id);

alter table Course_Specialization add constraint fk_course_specs FOREIGN KEY (specialization_id) REFERENCES Specialization (specialization_id);

insert into Course_Specialization(course_id,specialization_id) VALUES (1,1), (2,1), (3,2), (4,1),(5,1);

create table Student_Course(
	std_course_id smallint UNSIGNED AUTO_INCREMENT,
	student_id smallint UNSIGNED NOT NULL, course_id smallint UNSIGNED NOT NULL,
	constraint pk_Stud_Course PRIMARY KEY (std_course_id)

);

alter table Student_Course add constraint fk_stud_course FOREIGN KEY (course_id) REFERENCES Course (course_id);

alter table Student_Course add constraint fk_stude_courses FOREIGN KEY (student_id) REFERENCES Student (student_id);

insert into Student_Course(student_id,course_id) VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(2,4),(3,1),(3,4),(3,5),(4,1),(4,3),(4,5);

