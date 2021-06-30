package com.revature.selection;


public class Student {

	
	private int student_id;
	private String student_firstname;
	private String student_lastname;
	private int student_rating;
	private String student_comments;
	private int teacher_id_fk;
	private String forLook = "==========================================================";
	
	
	
	public Student(int student_id, String student_firstname, String student_lastname, int student_rating, String student_comments,
			int teacher_id_fk) {
		super();
		this.setStudent_id((student_id));
		this.setStudent_firstname((student_firstname));
		this.setStudent_lastname((student_lastname));
		this.setStudent_rating((student_rating));
		this.setStudent_comments((student_comments));
		this.setTeacher_id_fk((teacher_id_fk));
		
	}
	
	public Student(String student_firstname, String student_lastname, int student_rating, String student_comments,
			int teacher_id_fk) {
		super();
		this.setStudent_firstname((student_firstname));
		this.setStudent_lastname((student_lastname));
		this.setStudent_rating((student_rating));
		this.setStudent_comments((student_comments));
		this.setTeacher_id_fk((teacher_id_fk));
		
	}

	public Student () {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((student_comments == null) ? 0 : student_comments.hashCode());
		result = prime * result + ((student_firstname == null) ? 0 : student_firstname.hashCode());
		result = prime * result + student_id;
		result = prime * result + ((student_lastname == null) ? 0 : student_lastname.hashCode());
		result = prime * result + student_rating;
		result = prime * result + teacher_id_fk;
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
		Student other = (Student) obj;
		if (student_comments == null) {
			if (other.student_comments != null)
				return false;
		} else if (!student_comments.equals(other.student_comments))
			return false;
		if (student_firstname == null) {
			if (other.student_firstname != null)
				return false;
		} else if (!student_firstname.equals(other.student_firstname))
			return false;
		if (student_id != other.student_id)
			return false;
		if (student_lastname == null) {
			if (other.student_lastname != null)
				return false;
		} else if (!student_lastname.equals(other.student_lastname))
			return false;
		if (student_rating != other.student_rating)
			return false;
		if (teacher_id_fk != other.teacher_id_fk)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return student_id + " Student" + forLook + "\nTeacher_id=" + teacher_id_fk + "\n" + student_firstname + " " +student_lastname 
				+ "\n \n" + student_comments + "\nTeacher rating " + student_rating + "\n\n";
	}
	
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_firstname() {
		return student_firstname;
	}

	public void setStudent_firstname(String student_firstname) {
		this.student_firstname = student_firstname;
	}

	public String getStudent_lastname() {
		return student_lastname;
	}

	public void setStudent_lastname(String student_lastname) {
		this.student_lastname = student_lastname;
	}

	public int getStudent_rating() {
		return student_rating;
	}

	public void setStudent_rating(int student_rating) {
		this.student_rating = student_rating;
	}

	public String getStudent_comments() {
		return student_comments;
	}

	public void setStudent_comments(String student_comments) {
		this.student_comments = student_comments;
	}

	public int getTeacher_id_fk() {
		return teacher_id_fk;
	}

	public void setTeacher_id_fk(int teacher_id_fk) {
		this.teacher_id_fk = teacher_id_fk;
	}
	
	
	
	
	
	
}
