package OOP.Sprint1.Uppgift4_a_c;

import java.time.LocalDate;

public class Attendance {
    private Participation participation;
    private int studentID;
    private Course course;
    private String lesson;
    private boolean attended;
    private LocalDate attendanceCheckTakenAt;

    private Attendance(Participation participation) {
        this.studentID = participation.getStudent().getStudentID();
        this.course = participation.getCourse();
    }

    public static Attendance getAttendance(Participation participation, String lesson) {
        Attendance attendance = new Attendance(participation);
        attendance.lesson = lesson;
        attendance.attended = true;
        attendance.attendanceCheckTakenAt = LocalDate.now();
        return attendance;
    }

    public static Attendance getAbsence(Participation participation,String lesson) {
        Attendance attendance = new Attendance(participation);
        attendance.lesson = lesson;
        attendance.attended = false;
        attendance.attendanceCheckTakenAt = LocalDate.now();
        return attendance;
    }

    @Override
    public String toString() {
        return "Attendance of " +
                "student with ID: " + studentID +
                " in course: " + course.getNameOfCourse() +
                " for lesson: '" + lesson + '\'' +
                " is attended: " + attended +
                " -- attendance check was taken at: " + attendanceCheckTakenAt;
    }
}
