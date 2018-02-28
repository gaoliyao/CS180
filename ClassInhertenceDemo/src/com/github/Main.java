package com.github;

public class Main extends Student {

	public Main(String name, String address, String course, String grade) {
		super(name, address, course, grade);
	}

	public static void main(String[] args) {
	    Student student = new Student("Mars", "1275", "CS180", "K");
	    System.out.println(student.getCourse());
	    System.out.println(student.getGrade());
	    System.out.println(student.getName());
	    System.out.println(student.getAddress());
		System.out.println(student.returnAmount(4));
		System.out.println((student instanceof Student));
    }
}
