package OOP.Sprint1.Uppgift4_a_c;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<>();


        String firstName = "Andy";
        String lastName = "Warhol";
        int age = 25;
        String legalGender = "Male";
        Student studentOne = new Student(firstName, lastName, age, legalGender);

        firstName = "Chrissy";
        lastName = "Maximus";
        age = 31;
        legalGender = "Female";
        Student studentTwo = new Student(firstName, lastName, age, legalGender);

        firstName = "Wierd";
        lastName = "Al";
        age = 44;
        legalGender = "Male";
        Student studentThree = new Student(firstName, lastName, age, legalGender);

        listOfStudents.add(studentOne);
        listOfStudents.add(studentTwo);
        listOfStudents.add(studentThree);


        firstName = "Priscilla";
        lastName = "Terraformer";
        age = 42;
        legalGender = "Female";
        Teacher teacher = new Teacher(firstName, lastName, age, legalGender);


        String courseName = "Java";
        String courseDescription = "Best course ever";
        Course courseOne = new Course(courseName, courseDescription);
        courseOne.setCourseTeacher(teacher);
        List<String> lessons = new ArrayList<>();
        lessons.add("Lesson 1");
        lessons.add("Lesson 2");
        lessons.add("Lesson 3");
        courseOne.setLessons(lessons);


        courseName = "C#";
        courseDescription = "Buuu you suck";
        Course courseTwo = new Course(courseName, courseDescription);
        courseTwo.setCourseTeacher(teacher);
        lessons = new ArrayList<>();
        lessons.add("Lesson 4");
        lessons.add("Lesson 5");
        lessons.add("Lesson 6");
        courseTwo.setLessons(lessons);


        courseName = "Python";
        courseDescription = "Too easy";
        Course courseThree = new Course(courseName, courseDescription);
        courseThree.setCourseTeacher(teacher);
        lessons = new ArrayList<>();
        lessons.add("Lesson 7");
        lessons.add("Lesson 8");
        lessons.add("Lesson 9");
        courseThree.setLessons(lessons);


        Participation participationOne = new Participation(studentOne, courseOne);
        Participation participationTwo = new Participation(studentOne, courseTwo);
        Participation participationThree = new Participation(studentOne, courseThree);

        Participation participationFour = new Participation(studentTwo, courseOne);
        Participation participationFive= new Participation(studentTwo, courseTwo);
        Participation participationSix = new Participation(studentTwo, courseThree);

        Participation participationSeven = new Participation(studentThree, courseOne);
        Participation participationEight = new Participation(studentThree, courseTwo);
        Participation participationNine = new Participation(studentThree, courseThree);


        List<Participation> listOfCourseParticipants = new ArrayList<>();
        listOfCourseParticipants.add(participationOne);
        listOfCourseParticipants.add(participationTwo);
        listOfCourseParticipants.add(participationThree);
        listOfCourseParticipants.add(participationFour);
        listOfCourseParticipants.add(participationFive);
        listOfCourseParticipants.add(participationSix);
        listOfCourseParticipants.add(participationSeven);
        listOfCourseParticipants.add(participationEight);
        listOfCourseParticipants.add(participationNine);


        CourseAdministrator courseAdmin = new CourseAdministrator();

        for (Participation participation : listOfCourseParticipants) {
            for (String lesson : participation.getCourse().getLessons()) {
                courseAdmin.addToAttendenceList(Attendance.getAttendance(participation, lesson));
            }
        }


        for (Attendance attendance : courseAdmin.getAttendenceList()) {
            System.out.println(attendance);
        }





    }


    
}
