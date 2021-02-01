package br.com.bmo.course;

public class Course {

	private String name;
	private int studentsQnt;
	
	public Course(String name, int students) {	
		this.name = name;
		this.studentsQnt = students;
	}

	public String getName() {
		return name;
	}

	public int getStudentsQnt() {
		return studentsQnt;
	}
	
}
