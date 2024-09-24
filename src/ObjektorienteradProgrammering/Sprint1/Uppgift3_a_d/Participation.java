package ObjektorienteradProgrammering.Sprint1.Uppgift3_a_d;

public class Participation {
    private Student student;
    private Course course;

    Participation(Student student, Course course) {
        this.student = student;
        this.course = course;
    }






    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return String.format("Student: %s, Course: %s", student, course);
    }
}
