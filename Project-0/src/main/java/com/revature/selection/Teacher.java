package com.revature.selection;

public class Teacher {
	
	private int teacher_id;
	private String teacher_firstname;
	private String teacher_lastname;
	private String teacher_subject;
	private int teacher_rating;
	private String forLook = "==========================================================";

	
	
	
	
	public Teacher(int teacher_id, String teacher_firstname, String teacher_lastname, String teacher_subject, int teacher_rating) {
		super();
		this.teacher_firstname = teacher_firstname;
		this.teacher_lastname = teacher_lastname;
		this.teacher_id = teacher_id;
		this.teacher_subject = teacher_subject;
		this.teacher_rating = teacher_rating;
		
	}
	

	public Teacher(String teacher_firstname, String teacher_lastname, String teacher_subject, int teacher_rating) {
		super();
		this.teacher_firstname = teacher_firstname;
		this.teacher_lastname = teacher_lastname;
		this.teacher_subject = teacher_subject;
		this.teacher_rating = teacher_rating;
		
	}
	
	
	@Override
	public String toString() {
		return "Teacher" + forLook + "\nTeacher_id=" + teacher_id + "\n" + teacher_firstname + " " + teacher_lastname 
				+ "\n" + teacher_subject + "\nTeacher rating " + teacher_rating + "\n\n";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teacher_firstname == null) ? 0 : teacher_firstname.hashCode());
		result = prime * result + teacher_id;
		result = prime * result + ((teacher_lastname == null) ? 0 : teacher_lastname.hashCode());
		result = prime * result + teacher_rating;
		result = prime * result + ((teacher_subject == null) ? 0 : teacher_subject.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (teacher_firstname == null) {
			if (other.teacher_firstname != null)
				return false;
		} else if (!teacher_firstname.equals(other.teacher_firstname))
			return false;
		if (teacher_id != other.teacher_id)
			return false;
		if (teacher_lastname == null) {
			if (other.teacher_lastname != null)
				return false;
		} else if (!teacher_lastname.equals(other.teacher_lastname))
			return false;
		if (teacher_rating != other.teacher_rating)
			return false;
		if (teacher_subject == null) {
			if (other.teacher_subject != null)
				return false;
		} else if (!teacher_subject.equals(other.teacher_subject))
			return false;
		return true;
	}


	public Teacher() {
		super();
	}


	public int getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}


	public String getTeacher_firstname() {
		return teacher_firstname;
	}


	public void setTeacher_firstname(String teacher_firstname) {
		this.teacher_firstname = teacher_firstname;
	}


	public String getTeacher_lastname() {
		return teacher_lastname;
	}


	public void setTeacher_lastname(String teacher_lastname) {
		this.teacher_lastname = teacher_lastname;
	}


	public String getTeacher_subject() {
		return teacher_subject;
	}


	public void setTeacher_subject(String teacher_subject) {
		this.teacher_subject = teacher_subject;
	}


	public int getTeacher_rating() {
		return teacher_rating;
	}


	public void setTeacher_rating(int teacher_rating) {
		this.teacher_rating = teacher_rating;
	}


}
