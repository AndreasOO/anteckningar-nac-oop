package OOP.Sprint2.Uppgift11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class VideoTapeTimerTest {


    VideoTapeTimer videoTapeTimer49 = new VideoTapeTimer(100,50,"10:00", "10:49");
    VideoTapeTimer videoTapeTimer50 = new VideoTapeTimer(100,50,"10:00", "10:50");
    VideoTapeTimer videoTapeTimer51 = new VideoTapeTimer(100,50,"10:00", "10:51");

    VideoTapeTimer videoTapeTimerMismatch = new VideoTapeTimer(50,100,"10:00", "09:49");


    @Test
    void calculateIfRoomForTVProgram() {
        assertFalse(videoTapeTimer49.calculateIfRoomForTVProgram());
        assertTrue(videoTapeTimer50.calculateIfRoomForTVProgram());
        assertTrue(videoTapeTimer51.calculateIfRoomForTVProgram());

        assertFalse(videoTapeTimerMismatch.calculateIfRoomForTVProgram());
    }

}