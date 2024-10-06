package OOP.Sprint2.Uppgift11;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class VideoTapeTimer {
    private int videoTapeLengthInMinutes;
    private int videoTapeCurrentUsedLengthInMinutes;
    LocalTime timeStart;
    LocalTime timeEnd;

    public VideoTapeTimer(int videoTapeLengthInMinutes,
                          int videoTapeCurrentUsedLengthInMinutes,
                          String inputTimeTVProgramStart,
                          String inputTimeTVProgramEnd) {

        this.videoTapeLengthInMinutes = videoTapeLengthInMinutes;
        this.videoTapeCurrentUsedLengthInMinutes = videoTapeCurrentUsedLengthInMinutes;

        try {
            this.timeStart = LocalTime.parse(inputTimeTVProgramStart);
            this.timeEnd = LocalTime.parse(inputTimeTVProgramEnd);
        } catch (DateTimeParseException e) {
            System.out.println("Incorrect time format, please input in digital format HH:MM");
        }
    }



    public boolean calculateIfRoomForTVProgram() {
        if (videoTapeCurrentUsedLengthInMinutes > videoTapeLengthInMinutes) {
            return false;
        }
        if (timeStart.isAfter(timeEnd)) {
            return false;
        }

        int tapeLeft = videoTapeLengthInMinutes-videoTapeCurrentUsedLengthInMinutes;

        return Duration.between(timeStart, timeEnd).toSeconds()/60 >= tapeLeft;
    }

}
