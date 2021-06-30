




CREATE TABLE teacher_things (teacher_id serial PRIMARY KEY,	
					teacher_firstname text,
					teacher_lastname text,
					teacher_subject text, 
					teacher_rating int
					);
					
create table student_things (student_id serial primary key,
					student_firstname text,
					student_lastname text,
					student_rating int,
					student_comments text,
					teacher_id_fk int references teacher_things(teacher_id)
);


insert into teacher_things (teacher_firstname, teacher_lastname, teacher_subject, teacher_rating)
				values('John', 'Johnson', 'History', 2),
				('Kate', 'Kateson', 'Accounting', 4),
				('Janice', 'Cooper', 'Microbilogy', 4),
				('Phyllis', 'Howard', 'Calculus', 1),
				('Henry', 'Campbell', 'Introduction to Communication', 5),
				('Catherine', 'Henderson', 'Introduction to Criminal Justice', 5),
				('Nicholasm', 'Torres', 'Personal Fitness and Wellness', 3);
				
			
select * from teacher_things;

insert into student_things(student_id, student_firstname, student_lastname, student_rating, student_comments, teacher_id_fk)
values(705332,'Jana', 'Page', 3, 'Teacher was okay, nothing too bad but nothing too good just gotta ask the professor.', 1),
	  (894123,'Santiago', 'Chambers', 4, 'She did better than most, she tried at least.',2),
	  (665325,'Lauren', 'Pittman', 5, 'Great professor 10/10 would take again.',3),
	  (973181,'Dexter', 'Richardson', 3, 'She was okay',4),
	  (850153,'Kim', 'Wilson', 2,'' , 5),
	  (972321,'Katrina', 'Newman', 1, 'No idea why she got such a high rating, stay away.', 6),
	  (887733,'Lonnie', 'Manning', 2, 'Bad', 7);
	  
select * from student_things;	 
select student_firstname, student_lastname from student_things where student_idnumber = 973181;
drop table teacher_things;
drop table student_things;
Update student_things SET student_comments = 'Heck naw' , student_rating= 2 where student_id = 665325;
select student_comments, student_rating from student_things where student_id =665325;
select * from teacher_things order by teacher_rating desc;
	 