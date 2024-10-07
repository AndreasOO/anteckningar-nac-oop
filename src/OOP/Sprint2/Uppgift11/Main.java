package OOP.Sprint2.Uppgift11;

import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        try {
            VideoTapeTimer timer = new VideoTapeTimer(100, 50, "10:00", "10:49");
            System.out.println(timer.calculateIfRoomForTVProgram());
        } catch (DateTimeParseException e) {
            System.out.println("Incorrect time format, please input in digital format HH:MM");
        }
    }
}
