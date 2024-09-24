package ObjektorienteradProgrammering.Sprint1.Uppgift3_a_d;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private final List<Course> coursesTaught;

    public Teacher(String firstName, String lastName, int age, String legalGender) {
        super(firstName, lastName, age, legalGender);
        coursesTaught = new ArrayList<>();
    }


    public void printMe() {
        System.out.println(String.format("Teacher name: %s \n" +
                        "Teacher legal gender: %s \n" +
                        "Courses taught: %s\n",
                super.getFullName(),
                super.getLegalGender(),
                this.getCoursesTaught()));
    }

    public void addCourseTaught(Course courseToAdd) {
        coursesTaught.add(courseToAdd);
        courseToAdd.setCourseTeacher(this);
    }

    public void removeCourseTaught(Course courseToRemove) {
        coursesTaught.remove(courseToRemove);
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    @Override
    public String toString() {
        return String.format("Teacher: %s", super.getFullName());
    }
}
