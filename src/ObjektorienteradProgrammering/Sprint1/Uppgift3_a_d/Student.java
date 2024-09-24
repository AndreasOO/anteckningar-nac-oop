package ObjektorienteradProgrammering.Sprint1.Uppgift3_a_d;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int studentIDCounter = 1;

    private final List<Course> coursesTaken;
    private final int studentID;

    public Student(String firstName, String lastName, int age, String legalGender) {
        super(firstName, lastName, age, legalGender);
        this.studentID = studentIDCounter++;
        coursesTaken = new ArrayList<Course>();
    }

    public void printMe() {
        System.out.println(String.format("Student name: %s \n" +
                        "Student legal gender: %s \n" +
                        "Student ID: %d \n" +
                        "Courses taken: %s\n",
                super.getFullName(),
                super.getLegalGender(),
                this.getStudentID(),
                this.getCoursesTaken()));
    }

    public void addCourseTaken(Course courseToAdd) {
        coursesTaken.add(courseToAdd);
        courseToAdd.registerStudentToCourse(this);
    }

    public void removeCourseTaken(Course courseToRemove) {
        coursesTaken.remove(courseToRemove);
        courseToRemove.removeStudentFromCourse(this);
    }


    public int getStudentID() {
        return studentID;
    }

    public List<Course> getCoursesTaken() {
        return coursesTaken;
    }

    @Override
    public String toString() {
        return String.format("Student %s, ID: %d", super.getFullName(), studentID);
    }
}
