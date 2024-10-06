package OOP.Sprint2.Uppgift11;

public class Main {
    public static void main(String[] args) {
        VideoTapeTimer timer = new VideoTapeTimer(100, 50, "10:00", "10:49");
        System.out.println(timer.calculateIfRoomForTVProgram());
    }
}
