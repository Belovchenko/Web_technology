CREATE TABLE IF NOT EXISTS Student (
	student_id SERIAL PRIMARY KEY,
	student_name text NOT NULL,
	study_year int NOT NULL,
	group_num int NOT NULL,
	study_stream int NOT NULL
);

CREATE TABLE IF NOT EXISTS Teacher (
	teacher_id SERIAL PRIMARY KEY,
	teacher_name text NOT NULL
);

CREATE TABLE IF NOT EXISTS Course (
	course_id SERIAL PRIMARY KEY,
	course_name text NOT NULL,
	coverage int NOT NULL,
	year int NOT NULL
);

CREATE TABLE IF NOT EXISTS Auditorium (
	auditorium_num int PRIMARY KEY,
	coverage int NOT NULL
);

CREATE TABLE IF NOT EXISTS Study_Class (
	class_id SERIAL PRIMARY KEY,
	course_id int REFERENCES Course ON DELETE CASCADE ON UPDATE CASCADE,
	teacher_id int REFERENCES Teacher ON DELETE CASCADE ON UPDATE CASCADE,
	auditorium_num int REFERENCES Auditorium ON DELETE CASCADE ON UPDATE CASCADE,
	time timestamp
);

CREATE TABLE IF NOT EXISTS CourseStudent_Info (
	course_id int REFERENCES Course ON DELETE CASCADE ON UPDATE CASCADE,
	student_id int REFERENCES Student ON DELETE CASCADE ON UPDATE CASCADE,
	course_sem int NOT NULL,
	PRIMARY KEY (course_id, student_id)
);

CREATE TABLE IF NOT EXISTS CourseTeacher_Info (
	course_id int REFERENCES Course ON DELETE CASCADE ON UPDATE CASCADE,
	teacher_id int REFERENCES Teacher ON DELETE CASCADE ON UPDATE CASCADE,
	course_sem int NOT NULL,
	PRIMARY KEY (course_id, teacher_id)
);
