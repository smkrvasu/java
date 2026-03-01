package com.smkrvasu.versions.version14;

import java.time.DayOfWeek;

public class SwitchExpressions {
    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;

        int opening;
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                opening = 9;
                break;
            case SATURDAY:
            case SUNDAY:
                opening = 10;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.out.println(opening);

        opening = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 9;
            case SATURDAY, SUNDAY -> 10;
            default -> throw new IllegalArgumentException();
        };
        System.out.println(opening);

        String schedule = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Open 9 AM - 6 PM";
            case SATURDAY, SUNDAY -> {
                System.out.println("Short hours on weekend");
                yield "Open 10 AM - 3 PM";
            }
            default -> throw new IllegalArgumentException();
        };
        System.out.println(schedule);
    }
}
