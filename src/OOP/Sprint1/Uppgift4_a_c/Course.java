package OOP.Sprint1.Uppgift4_a_c;

import java.time.LocalDate;
import java.util.List;

public class Course {
    private String nameOfCourse;
    private String courseDescription;
    private Teacher courseTeacher;
    private List<String> lessons;


    Course(String nameOfCourse, String courseDescription) {
        this.nameOfCourse = nameOfCourse;
        this.courseDescription = courseDescription;
    }


    public void printMe() {
        System.out.println(String.format("Name of course: %s \n" +
                        "Course description: %s \n" +
                        "Course teacher: %s\n",
                this.nameOfCourse,
                this.courseDescription,
                this.courseTeacher));
    }

    public List<String> getLessons() {
        return lessons;
    }

    public void setLessons(List<String> lessons) {
        this.lessons = lessons;
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

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public String getCourseDescription() {
        return courseDescription;
    }


    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    @Override
    public String toString() {
        return String.format("%s  --- %s", this.nameOfCourse, this.courseDescription);
    }
}
