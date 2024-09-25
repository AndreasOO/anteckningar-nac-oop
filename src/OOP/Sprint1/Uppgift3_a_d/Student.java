package OOP.Sprint1.Uppgift3_a_d;

public class Student extends Person {
    private static int studentIDCounter = 1;

    private final int studentID;

    public Student(String firstName, String lastName, int age, String legalGender) {
        super(firstName, lastName, age, legalGender);
        this.studentID = studentIDCounter++;
    }

    public void printMe() {
        System.out.println(String.format("Student name: %s \n" +
                        "Student legal gender: %s \n" +
                        "Student ID: %d \n",
                super.getFullName(),
                super.getLegalGender(),
                this.getStudentID()));
    }





    public int getStudentID() {
        return studentID;
    }


    @Override
    public String toString() {
        return String.format("Student %s, ID: %d", super.getFullName(), studentID);
    }
}
