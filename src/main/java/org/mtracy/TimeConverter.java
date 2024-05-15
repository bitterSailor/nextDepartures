package org.mtracy;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {
    // Return time in h:mm a format
    public static String getTime () {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    // Converts time from api format to relative minutes
    public static int relativeMinutes (String time) {
        return (int) Duration.between(ZonedDateTime.now(), ZonedDateTime.parse(time)).toMinutes();
    }
}
