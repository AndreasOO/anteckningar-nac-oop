package OOP.Sprint1.Uppgift3_a_d;

public class Course {
    String nameOfCourse;
    String courseDescription;
    Teacher courseTeacher;


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
