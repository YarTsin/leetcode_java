package org.example.g1301_1400.s1360_number_of_days_between_two_dates;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Использование Java Date API
 */
class Solution2 {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);

        long daysBetween = Math.abs(ChronoUnit.DAYS.between(d1, d2));
        return (int) daysBetween;
    }
}