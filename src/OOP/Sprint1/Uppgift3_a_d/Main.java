package OOP.Sprint1.Uppgift3_a_d;

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
        teacher.printMe();

        String courseName = "Java";
        String courseDescription = "Best course ever";
        Course courseOne = new Course(courseName, courseDescription);
        courseOne.setCourseTeacher(teacher);
        courseOne.printMe();

        courseName = "C#";
        courseDescription = "Buuu you suck";
        Course courseTwo = new Course(courseName, courseDescription);
        courseTwo.setCourseTeacher(teacher);
        courseTwo.printMe();

        courseName = "Python";
        courseDescription = "Too easy";
        Course courseThree = new Course(courseName, courseDescription);
        courseThree.setCourseTeacher(teacher);
        courseThree.printMe();


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


        printCoursesTakenByStudent
                (studentOne, listOfCourseParticipants);


        printTeacherAndStudentsTakingCourse(courseOne, listOfCourseParticipants);


        System.out.println("BIG PRINT FUNCTION");
        printCoursesTakenBySeveralStudents(listOfStudents, listOfCourseParticipants);

    }

    private static void printTeacherAndStudentsTakingCourse(Course courseOne, List<Participation> listOfCourseParticipants) {
        System.out.println("Course teacher in " + courseOne.toString() +": " + courseOne.getCourseTeacher());
        System.out.println("Students taking " + courseOne.getNameOfCourse() + ":");
        for (Participation participation : listOfCourseParticipants) {
            if (participation.getCourse().equals(courseOne)) {
                System.out.println(participation.getStudent());
            }
        }
        System.out.println("\n");
    }

    private static void printCoursesTakenByStudent
            (Student studentOne, List<Participation> listOfCourseParticipants) {
        System.out.println("Courses taken by " + studentOne.toString());
        for (Participation participation : listOfCourseParticipants) {
            if (participation.getStudent().equals(studentOne)) {
                System.out.println(participation.getCourse());
            }
        }
        System.out.println("\n");
    }

    private static void printCoursesTakenBySeveralStudents(List<Student> listOfStudents, List<Participation> listOfCourseParticipants) {
        for (Student student : listOfStudents) {
            printCoursesTakenByStudent(student, listOfCourseParticipants);
        }
    }
    
}
