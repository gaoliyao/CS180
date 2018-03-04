package com.github;

/**
 * College
 *
 * Represents an abstraction of a college. Each college may have courses, professors, students, and teachers.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class College {

    /**
     * Maximum number of Courses allowed to be added to a College
     */
    protected static final int MAX_COURSES = 10;

    /**
     * Maximum number of Professors allowed to be hired by a College
     */
    protected static final int MAX_PROFESSORS = 5;

    /**
     * Maximum number of Teachers allowed to be hired by a College
     */
    protected static final int MAX_TEACHERS = 25;

    /**
     * Maximum number of Students allowed to be enrolled to a College
     */
    protected static final int MAX_STUDENTS = 500;


    private String name;
    private Professor[] professors;
    private Teacher[] teachers;
    private Student[] students;
    private Course[] courses;
    private int tuition;

    /**
     * Constructs a new College object with the corresponding parameters as field values, and new arrays of Professors,
     * Students, Teachers, and Courses limited by the corresponding MAX variables.
     *
     * @param name Name of the College to be created.
     * @param tuition Cost for students to attend.
     */
    public College(String name, int tuition) {
        //TODO: Initialize field variables for this College object
        this.name = name;
        this.tuition = tuition;
        this.courses = new Course[MAX_COURSES];
        this.professors = new Professor[MAX_PROFESSORS];
        this.teachers = new Teacher[MAX_TEACHERS];
        this.students = new Student[MAX_STUDENTS];
    }

    /**
     * Adds course to the College's array of courses. If the course is null, the course is already available at the
     * College, or the College cannot add more courses, nothing changes.
     *
     * @param course A course object to be added to the College's array of courses.
     */
    public void addCourse(Course course) {
        //TODO: Add the course to the courses array, if appropriate
        if (course == null){
            return ;
        }
        for (Course c: this.courses){
            if (c != null) {
                if (c.getName() == course.getName()) {
                    return;
                }
            }
        }
        for (int i=0;i<this.courses.length;i++){
            if (this.courses[i] == null){
                this.courses[i] = course;
                break;
            }
        }
        //this.courses[this.courses.length] = course;

    }

    /**
     * Adds professor to the College's array of Professors. If the Professor is null, the College cannot add more
     * Professors, or the Professor is already employed by the College, nothing changes.
     *
     * @param professor Professor to be added to the College's array of Professors
     */
    public void hireProfessor(Professor professor) {
        //TODO: Add the given professor to the professors array, if appropriate
        int profCount = 0;
        for (int i=0;i<this.professors.length;i++){
            if (this.professors[i] == null){
                break;
            }
            profCount++;
        }
        if (professor == null || profCount == MAX_PROFESSORS){
            return;
        }
        for (Professor p: this.professors){
            if (p != null) {
                if (p == professor) {
                    return;
                }
            }
        }
        for (int i=0;i<this.professors.length;i++){
            if (this.professors[i] == null){
                this.professors[i] = professor;
                break;
            }
        }
        //this.professors[this.professors.length] = professor;
    }

    /**
     * Adds teacher to the College's array of Teachers. If teacher is null, the College cannot add more Teachers,
     * or teacher is already employed by the College, nothing changes.
     *
     * @param teacher Teacher to be added to the College's array of teachers
     */
    public void hireTeacher(Teacher teacher) {
        //TODO: Add the given teacher to the teachers array, if appropriate
        int teacherCount = 0;
        for (int i=0;i<this.students.length;i++){
            if (this.students[i] == null){
                break;
            }
            teacherCount++;
        }
        if (teacher == null || teacherCount == MAX_TEACHERS){
            return;
        }
        for (Teacher t: this.teachers){
            if (t != null) {
                if (t == teacher) {
                    return;
                }
            }
        }
        for (int i=0;i<this.teachers.length;i++){
            if (this.teachers[i] == null){
                this.teachers[i] = teacher;
                break;
            }
        }
        //this.teachers[this.teachers.length] = teacher;
    }

    /**
     * Adds student to the College's array of students. If the student is null, the student is already enrolled at the
     * College, or the College cannot add more students, nothing changes.
     *
     * @param student A Student object to be added to the College's array of students.
     */
    public void addStudent(Student student) {
        //TODO: Add the student to the students array, if appropriate
        int studentCount = 0;
        for (int i=0;i<this.students.length;i++){
            if (this.students[i] == null){
                break;
            }
            studentCount++;
        }
        if (student == null || studentCount == MAX_STUDENTS){
            return;
        }
        for (Student s: this.students){
            if (s != null) {
                if (s == student) {
                    return;
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
     * Removes student from the College's array of Students. If the student is enrolled in any Courses, they should be
     * removed from these courses. If student is null or the student is not currently enrolled, nothing changes.
     *
     * *HINT* If you try to remove a student from a Course, an exception is thrown. Consider using a try-catch block.
     *
     * @param student Student to be removed from the College's array of students
     */
    public void dropStudent(Student student) {
        //TODO: Remove the given student from the students array and any courses, if appropriate
        int index = -1;
        boolean flag = false;
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
        try {
            for (Course c: this.courses){
                c.dropStudent(student);
            }
        } catch (Exception e){

        }
    }

    /**
     * Returns the net change in the colleges budget. Tuition per student will increase the net change, and payments for
     * Professors and Teachers according to both their base and per course salaries will decrease the net change.
     *
     * @return Net change in the College's funds
     */
    public int calculateNetBudgetChange() {
        //TODO: Calculate the change in budget (Total tuition - Professor Salaries - Teacher Salaries)
        int studentCount = 0;
//        for (int i=0;i<this.students.length;i++){
//            System.out.println(this.students[i]);
//        }
        for (int i=0;i<this.students.length;i++){
            if (this.students[i] == null){
                break;
            }
            studentCount++;
        }
        int totalTuition = studentCount * this.tuition;
        int profSalaries = 0;
        for (Professor p: this.professors){
            if (p != null) {
                int profCourseCount = 0;
                for (int i=0;i<p.getCourses().length;i++){
                    if (p.getCourses()[i] == null){
                        break;
                    }
                    profCourseCount++;
                }
                profSalaries += p.getBaseSalary() + p.getPerCourseSalary() * profCourseCount;
            }
        }
        int teacherSalaries = 0;
        for (Teacher t: this.teachers){
            if (t != null) {
                int teaCourseCount = 0;
                for (int i=0;i<t.getCourses().length;i++){
                    if (t.getCourses()[i] == null){
                        break;
                    }
                    teaCourseCount++;
                }
                teacherSalaries += t.getBaseSalary() + t.getPerCourseSalary() * teaCourseCount;
            }
        }
        return totalTuition - profSalaries - teacherSalaries;
    }

    /**
     * @return A reference to the array of courses offered by this College.
     */
    public Course[] getCourses()
    {
        //TODO: Return the array of Courses.
        return this.courses;
    }

    /**
     * @return A reference to the array of Teachers employed by this College.
     */
    public Teacher[] getTeachers()
    {
        //TODO: Return the array of Teachers
        return this.teachers;
    }

    /**
     * @return A reference to the array of Professors employed by this College.
     */
    public Professor[] getProfessors()
    {
        //TODO: Return the array of Professors
        return this.professors;
    }

    /**
     * @return A reference to the array of Students enrolled at this College.
     */
    public Student[] getStudents()
    {
        //TODO: Return the array of Professors
        return this.students;
    }

    /**
     * @return The name of the College object
     */
    public String getName() {
        //TODO: Return the name of the College object
        return this.name;
    }

    /**
     * @return The tuition charged per student
     */
    public int getTuition() {
        //TODO: Return the tuition of the College object
        return this.tuition; // I wish
    }
}
