package com.github;


import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Program Name
 *
 * Abstraction of a college course. Each course is uniquely identifiable by its course name.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class Course {
    /**
     * Maximum number of students allowed to be enrolled in a Course
     */
    protected final static int MAX_STUDENTS = 100;

    private String name;
    private Professor professor;
    private Teacher[] teachers;
    private Student[] students;

    /**
     * Constructs a Course object with the corresponding parameters as its name and a reference to the lead Professor.
     * Creates an array to contain at most 100 students enrolled in the course and ensures the Professor adds the course
     * to their list of courses.
     *
     * @param name Name of the Course to be offered.
     * @param professor A reference to the lead professor for the course.
     */
    public Course(String name, Professor professor) {
        //TODO: Initialize field variables for this Course object
        this.name = name;
        this.professor = professor;
        this.professor.addCourse(this);
        this.teachers = new Teacher[MAX_STUDENTS];
        this.students = new Student[MAX_STUDENTS];
    }

    /**
     * Adds student to the course. Throws AddToCourseException if the course is full, if student is null, or
     * if the student is already enrolled in the course
     *
     * @param student Student to be added to the Course
     * @throws AddToCourseException If the course is full, if student is null, or if the student is already enrolled in
     * the course
     */
    public void addStudent(Student student) throws AddToCourseException {
        //TODO: Add student to Course, if possible
        int studentCount = 0;
        for (int i=0;i<this.students.length;i++){
            if (this.students[i] == null){
                break;
            }
            studentCount++;
        }
        if (student == null || studentCount == MAX_STUDENTS){
            throw new AddToCourseException();
        }
        for (Student s: this.students){
            if (s != null) {
                if (s == student) {
                    throw new AddToCourseException();
                }
            }
        }
        for (int i=0;i<this.students.length;i++){
            if (this.students[i] == null){
                this.students[i] = student;
                break;
            }
        }
        //this.students[this.students.length] = student;

    }

    /**
     * Removes student from the course. Throws DropFromCourseException if student is null or if the student
     * is not enrolled in the course.
     *
     * @param student Student to be removed from the course
     * @throws DropFromCourseException If student is null or if the student is not enrolled in the course.
     */
    public void dropStudent(Student student)throws DropFromCourseException{
        //TODO: Remove student from Course, if possible
        if (student == null){
            throw new DropFromCourseException();
        }
        boolean flag = false;
        int index = -1;
        for (int i=0;i<this.students.length;i++){
            if (this.students[i]==student){
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int i=index;i<this.students.length-1;i++){
                this.students[i] = this.students[i+1];
            }
            this.students[this.students.length-1] = null;
        }
        else{
            throw new DropFromCourseException();
        }
    }

    /**
     * Adds teacher to the course. If the teachers array is full, then its size is doubled and the teacher is added.
     * A Teacher may teach the same course more than once (like having multiple sections). Throws AddToCourseException
     * if teacher is null. The teacher should add this course to their personal list of courses.
     *
     * @param teacher Teacher to be added to the Course
     * @throws AddToCourseException If the course is full or if teacher is null
     */
    public void addTeacher(Teacher teacher) throws AddToCourseException {
        //TODO: Add teacher to Course, if possible, and add Course to teacher's array of Courses.
        int teacherCount = 0;
        for (int i=0;i<this.teachers.length;i++){
            if (this.teachers[i] == null){
                break;
            }
            teacherCount++;
        }
        if (teacher == null || teacherCount == MAX_STUDENTS){
            throw new AddToCourseException();
        }
        for (int i=0;i<this.teachers.length;i++){
            if (this.teachers[i] == null){
                this.teachers[i] = teacher;
                break;
            }
        }
        //this.teachers[this.teachers.length] = teacher;
        teacher.addCourse(this);



//        for (Teacher t: this.teachers){
//            if (t != null) {
//                if (t == teacher) {
//                    throw new AddToCourseException();
//                }
//            }
//        }
    }

    /**
     * Removes teacher from the courses's array of teachers. If teacher teaches multiple instances of the
     * course, only one is removed. Throws DropFromCourseException if teacher is null or if teacher is not found.
     *
     * @param teacher Teacher to be added to the Course
     * @throws DropFromCourseException Uf teacher is null or if teacher is not found.
     */
    public void dropTeacher(Teacher teacher)throws DropFromCourseException{
        //TODO: Remove teacher from Course, if possible, and remove Course from teacher's array of Courses.
//        System.out.println("======");
//        for (Teacher t: this.teachers){
//            if (t != null) {
//                System.out.println(t.getName());
//            }
//            else{
//                System.out.println("null");
//            }
//        }
        if (teacher == null){
            throw new DropFromCourseException();
        }
        boolean flag = false;
        int index = -1;
        for (int i=0;i<this.teachers.length;i++){
            if (this.teachers[i] == teacher){
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int i=index;i<this.teachers.length-1;i++){
                this.teachers[i] = this.teachers[i+1];
            }
            this.teachers[this.teachers.length-1] = null;
        }
        else{
            throw new DropFromCourseException();
        }
        teacher.dropCourse(this);
    }

    /**
     * @return Reference to Professor leading this Course
     */
    public Professor getProfessor()
    {
        //TODO: Return a reference to the Professor for this course.
        return this.professor;
    }

    /**
     * Creates and returns a new array containing the list of Students. The new array should have a length equal to the
     * number of students currently enrolled in the course. Returns an array of length 0 if the course has no Students.
     *
     * @return A new array containing the Course's Students with no null elements.
     */
    public Student[] getRoster() {
        //TODO: Create and return a new array containing references to each Student in this course's Student array
        int count = 0;
        for (int i=0;i<this.students.length;i++){
            if (this.students[i] == null){
                break;
            }
            count++;
        }
        //System.out.println(count);
        Student[] studentArray = new Student[count];
        for (int i=0;i<count;i++){
            studentArray[i] = this.students[i];
        }
        return studentArray;
    }

    /**
     * @return The name of the Course
     */
    public String getName() {
        //TODO: Return the name of this course
        return this.name;
    }

    /**
     * Returns a new array containing the Courses's Teachers. The new array should have a length equal to the
     * number of Teachers currently teaching the course, duplicates included. Returns an array of length 0 if the course
     * has no Teachers.
     *
     * @return A new array containing the Course's Teachers with no null elements.
     */
    public Teacher[] getTeachers() {
        //TODO: Create and return a new array containing references to each Teacher in this course's Teacher array, including duplicates
        int count = 0;
        for (int i=0;i<this.teachers.length;i++){
            if (this.teachers[i] == null){
                break;
            }
            count++;
        }
        Teacher[] teacherArray = new Teacher[count];
        for (int i=0;i<count;i++){
            teacherArray[i] = this.teachers[i];
        }
        return teacherArray;
    }

    /**
     * Makes professor the Course professor and updates the old and new Professors involved accordingly.
     *
     * @param professor Reference to Professor object to be made the lead Professor of the course.
     */
    public void changeProfessor(Professor professor) {
        //TODO: Change the Professor for this Course and add/remove the course from the respective Professor's arrays of courses
        this.professor.dropCourse(this);
        this.professor = professor;
        this.professor.addCourse(this);
    }

    /**
     * Returns a String representation of the Course object. This method must exist, but will not be tested.
     *
     * @return String
     */
    public String toString() {
        return "";
    }
}
