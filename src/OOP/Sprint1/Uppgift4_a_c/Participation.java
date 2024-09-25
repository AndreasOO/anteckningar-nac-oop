package OOP.Sprint1.Uppgift4_a_c;

public class Participation {
    private final Student student;
    private final Course course;

    Participation(Student student, Course course) {
        this.student = student;
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
