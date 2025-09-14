package org.example.g1101_1200.s1185_day_of_the_week;

/**
 * Решение с использованием известного anchor дня
 * Подход: Используем известный день недели для определенной даты и вычисляем разницу
 */
class Solution3 {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // Используем 1 января 1971 года как anchor (пятница)
        int anchorDay = 1;
        int anchorMonth = 1;
        int anchorYear = 1971;
        int anchorDayOfWeek = 5; // 1 января 1971 - пятница (Friday = 5)

        // Вычисляем общее количество дней от anchor даты до заданной даты
        int totalDays = calculateDaysSinceAnchor(day, month, year, anchorDay, anchorMonth, anchorYear);

        // Вычисляем день недели
        int dayIndex = (anchorDayOfWeek + totalDays) % 7;
        return daysOfWeek[dayIndex];
    }

    private int calculateDaysSinceAnchor(int day, int month, int year, int anchorDay, int anchorMonth, int anchorYear) {
        int totalDays = 0;

        // Добавляем дни за полные годы
        for (int y = anchorYear; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // Добавляем дни за месяцы в текущем году
        for (int m = 1; m < month; m++) {
            totalDays += getDaysInMonth(m, year);
        }

        // Добавляем дни в текущем месяце
        totalDays += day - anchorDay;

        return totalDays;
    }

    private int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
