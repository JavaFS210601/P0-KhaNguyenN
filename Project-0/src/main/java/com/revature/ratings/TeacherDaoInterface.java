package com.revature.ratings;

import java.util.List;

import com.revature.selection.Teacher;



public interface TeacherDaoInterface {
	
	

	
List<Teacher> getTeachersRatings();
	

List<Teacher> getTeacherLower();//geet list in asc order


List<Teacher> getTeacherHigher();//Get list in desc order


	
}
