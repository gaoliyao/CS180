package com.github;

import static org.junit.Assert.assertEquals;

public class Main {
    static String NAMES[]={"Josue","Sherrill","Genna","Debroah","Arielle",
            "Jeana","Anja Pendergraft","Jenae","Charlsie","Myrle","Luigi Mario",
            "Salina Freudenthal","Sonny","Luciano Cupit","Shameka Rakow","Charissa","Mario Mario",
            "Samira","Tamie","Daphine","Maud","Derick","Ronald McDonald",
            "Elinor","Afanador","Hermelinda", "Irmgard","Coleen","Toad",
            "Roger","Freddy","Mika Duane","Victory Soe","Mirtha","Saundra","Donky Kong",
            "Marissa","Lilia Kane","Jayne","Mariah","Ashleigh","Sherron Duffey",
            "Judith","Horace","Isidro","Elden","Carmelina Tisdale","Garrett Bohm",
            "Takako ","Annamaria","Ashton","Marquita","Tiffiny Saxon","Judy",
            "Kenisha","Yvonne","Frog Mario","Shawnta","Letha","Nena",
            "Klara","Morton","Agripina","Elfriede","Sheri","Michaele",
            "Ashely","Zoe","Danae","Shanna","Adrian","Valentine",
            "Fermina","Erika","Teofila","Lexie","Lenna","Rikki",
            "Mina","Neda","Estrella","Judy","Kurtis Gimenez","Hipolito",
            "Roselyn","Rebecca", "Ofelia","Annett","Raquel","Ericka",
            "Camie Jaime","Londa","Kaycee Rodrigues","Lucretia Greeno","Terrance","Shemika",
            "Fatima","Torie","Gillian","Suanne","Juana Beaudry","Freddie ",
            "Zenobia Bowersox","Glennis","Sripath","Kulinski","Dunsmore","Jacob",
            "Anna Payor","Rocky the Dog","Tuxen the Cat","Eiyu Stew Dent", "Runninata Names"};
    static String DEPARTMENT_CODES[]={"EDCI","CS","ENGR","MATH","SPAN","ITAL","AAS"};
    public static void main(String[] args) throws AddToCourseException {
        try {
            //Create a college
            String collegeName = "Norhall";
            int collegeTuition = 7;
            College college = new College(collegeName, collegeTuition);

            //Populate college with courses, select duplicate and add again
            Course duplicateCourse = null;
            for (int i = 0; i < College.MAX_COURSES - 1; i++) {
                String dept       = DEPARTMENT_CODES[i % DEPARTMENT_CODES.length];
                String courseNum  = Integer.toString(i * 100 + 5000);
                String courseName = dept + " " + courseNum;
                int numStudents   = i % Course.MAX_STUDENTS;
                if (i == 1) {
                    duplicateCourse = createCourse(numStudents, courseName);
                    college.addCourse(duplicateCourse);
                } else {
                    college.addCourse(createCourse(numStudents, courseName));
                }

            }
            college.addCourse(new Course(duplicateCourse.getName(),duplicateCourse.getProfessor()));

            //Count instances of the duplicate
            int instancesExpected = 1;
            int instancesActual   = 0;
            for (Course c: college.getCourses()) {
                if (c == null) continue;
                if (c.getName().equals(duplicateCourse.getName())) instancesActual++;
            }

            assertEquals("testAddDuplicateCourseToCollege::A course should not be able to be added to a College multiple times.",
                    instancesExpected, instancesActual);
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddDuplicateCourseToCollege::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }
    private static Course createCourse(int numberOfStudents, String courseName) throws AddToCourseException{
        if (numberOfStudents > Course.MAX_STUDENTS) numberOfStudents = Course.MAX_STUDENTS;

        String professorName   = NAMES[numberOfStudents];
        int professorAge       = numberOfStudents;
        String professorGender = "Unspecified";
        Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

        Course course = new Course(courseName, courseProfessor);
        for (int i = 0; i < numberOfStudents; i++) {
            String name = NAMES[Math.abs((i - 6) % NAMES.length)];
            int age = 23;
            String gender = "Unspecified";
            course.addStudent(new Student(name, age, gender));
        }
        return course;
    }
}
