package ObjektorienteradProgrammering.Sprint1.Uppgift3_a_d;

public class Main {
    public static void main(String[] args) {
        String firstName = "Andy";
        String lastName = "Warhol";
        int age = 25;
        String legalGender = "Male";


        Student studentOne = new Student(firstName, lastName, age, legalGender);
        studentOne.printMe();


        firstName = "Chrissy";
        lastName = "Maximus";
        age = 31;
        legalGender = "Female";

        Student studenTwo = new Student(firstName, lastName, age, legalGender);
        studenTwo.printMe();



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

        studentOne.addCourseTaken(courseOne);
        studentOne.printMe();

        teacher.addCourseTaught(courseOne);

        courseOne.printMe();

        teacher.printMe();





    }
}
