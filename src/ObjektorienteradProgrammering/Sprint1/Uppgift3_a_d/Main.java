package ObjektorienteradProgrammering.Sprint1.Uppgift3_a_d;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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



        firstName = "Priscilla";
        lastName = "Terraformer";
        age = 42;
        legalGender = "Female";
        Teacher teacher = new Teacher(firstName, lastName, age, legalGender);
        teacher.printMe();

        String courseName = "Java";
        String courseDescription = "Best course ever";
        Course courseOne = new Course(courseName, courseDescription);
        courseOne.printMe();

        courseName = "C#";
        courseDescription = "Buuu you suck";
        Course courseTwo = new Course(courseName, courseDescription);
        courseTwo.printMe();

        courseName = "Python";
        courseDescription = "Too easy";
        Course courseThree = new Course(courseName, courseDescription);
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


        List<Participation> list1 = new ArrayList<>();
        list1.add(participationOne);
        list1.add(participationTwo);
        list1.add(participationThree);





    }
}
