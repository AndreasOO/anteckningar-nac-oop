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
        for (Participation participation : listOfCourseParticipants) {
            if (participation.getStudent().equals(studentOne)) {
                courses.add(participation.getCourse());
            }
        }
        return courses;
    }


    public void addToAttendanceList(Attendance attendance) {
        attendenceList.add(attendance);
    }


    public List<Attendance> getAttendenceList() {
        return attendenceList;
    }

}


