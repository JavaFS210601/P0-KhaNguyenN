package com.revature.ratings;

import java.util.List;

import com.revature.selection.Student;

public interface StudentDaoInterface {

	List<Student> getStudentRatings();

	void addReview(Student student);


	void removeReview(int student_idnumber, String firstname, String lastname);
	
	
	void changeReview(String firstname, String lastname, String comment,int student_ratingnumber, int student_idnumber);
  
}
