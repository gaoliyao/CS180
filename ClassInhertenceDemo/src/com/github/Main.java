package com.github;

public class Main {

    public static void main(String[] args) {
	    Student student = new Student("Mars", "1275", "CS180", "K");
	    System.out.println(student.getCourse());
	    System.out.println(student.getGrade());
	    System.out.println(student.getName());
	    System.out.println(student.getAddress());
    }
}
