package OOP.Sprint1.Uppgift4_a_c;

import java.util.ArrayList;
import java.util.List;

public class CourseAdministrator {
    private List<Attendance> attendenceList;

    CourseAdministrator() {
        attendenceList = new ArrayList<>();
    }



    public List<Course> getCoursesTakenByStudent
            (Student studentOne, List<Participation> listOfCourseParticipants) {
        List<Course> courses = new ArrayList<>();
        System.out.println("Courses taken by " + studentOne.toString());
        for (Participation participation : listOfCourseParticipants) {
            if (participation.getStudent().equals(studentOne)) {
                System.out.println(participation.getCourse());
                courses.add(participation.getCourse());
            }
        }
        System.out.println("\n");
        return courses;
    }

    public List<List<Course>> getCoursesTakenBySeveralStudents(List<Student> listOfStudents, List<Participation> listOfCourseParticipants) {
        List<List<Course>> coursesNested = new ArrayList<>();
        for (Student student : listOfStudents) {
            coursesNested.add(getCoursesTakenByStudent(student, listOfCourseParticipants));
        }
        return coursesNested;
    }


    public void addToAttendenceList(Attendance attendance) {
        attendenceList.add(attendance);
    }

    public Attendance markAttendance(Participation participation, String lesson) {
        return Attendance.getAttendance(participation, lesson);
    }
    public Attendance markAbsence(Participation participation, String lesson) {
        return Attendance.getAbsence(participation, lesson);
    }

    public List<Attendance> getAttendenceList() {
        return attendenceList;
    }

    public void setAttendenceList(List<Attendance> attendenceList) {
        this.attendenceList = attendenceList;
    }
}


