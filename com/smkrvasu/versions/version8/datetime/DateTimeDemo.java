package com.smkrvasu.versions.version8.datetime;

import java.time.*;

public class DateTimeDemo {
    public static void main(String[] args) {
        // Current date and time
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        // Specific date
        LocalDate independenceDay = LocalDate.of(1947, Month.AUGUST, 15);
        System.out.println("Independence Day: " + independenceDay);

        // Working with time zones
        ZonedDateTime zoned = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Zoned DateTime: " + zoned);

        // Duration and Period
        Period period = Period.between(independenceDay, today);
        System.out.println("Years since Independence: " + period.getYears());

        // Instant
        Instant start = Instant.now();
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration.toNanos());
    }
}
