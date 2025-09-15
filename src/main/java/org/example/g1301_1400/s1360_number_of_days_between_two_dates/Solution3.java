package org.example.g1301_1400.s1360_number_of_days_between_two_dates;

/**
 * Более оптимизированная версия ручного расчета
 */
class Solution3 {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(calculateDaysFromEpoch(date1) - calculateDaysFromEpoch(date2));
    }

    private int calculateDaysFromEpoch(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int totalDays = day;

        // Добавляем дни за месяцы
        for (int m = 1; m < month; m++) {
            totalDays += getDaysInMonth(m, year);
        }

        // Добавляем дни за годы
        for (int y = 1970; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        return totalDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }
}
