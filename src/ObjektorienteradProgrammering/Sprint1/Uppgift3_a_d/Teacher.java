package ObjektorienteradProgrammering.Sprint1.Uppgift3_a_d;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    public Teacher(String firstName, String lastName, int age, String legalGender) {
        super(firstName, lastName, age, legalGender);

    }


    public void printMe() {
        System.out.println(String.format("Teacher name: %s \n" +
                        "Teacher legal gender: %s \n",
                super.getFullName(),
                super.getLegalGender()));
    }

    public void addCourseTaught(Course courseToAdd) {
        courseToAdd.setCourseTeacher(this);
    }


    @Override
    public String toString() {
        return String.format("Teacher: %s", super.getFullName());
    }
}
