package ObjektorienteradProgrammering.Sprint1.Uppgift3_a_d;

import java.util.ArrayList;
import java.util.List;

public class Course {
    String nameOfCourse;
    String courseDescription;
    List<Student> studentsTakingCourse = new ArrayList<>();
    Teacher courseTeacher;


    Course(String nameOfCourse, String courseDescription) {
        this.nameOfCourse = nameOfCourse;
        this.courseDescription = courseDescription;
    }


    public void printMe() {
        System.out.println(String.format("Name of course: %s \n" +
                        "Course description: %s \n" +
                        "Students taking course: %s\n" +
                        "Course teacher: %s\n",
                this.nameOfCourse,
                this.courseDescription,
                this.studentsTakingCourse,
                this.courseTeacher));
    }


    public void registerStudentToCourse(Student student) {
        studentsTakingCourse.add(student);
    }

    public void removeStudentFromCourse(Student student) {
        studentsTakingCourse.remove(student);
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setStudentsTakingCourse(List<Student> studentsTakingCourse) {
        this.studentsTakingCourse = studentsTakingCourse;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public List<Student> getStudentsTakingCourse() {
        return studentsTakingCourse;
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    @Override
    public String toString() {
        return String.format("%s  --- %s", this.nameOfCourse, this.courseDescription);
    }
}
