package org.example.g1101_1200.s1154_day_of_the_year;

/**
 * Альтернативное решение (более компактное)
 */
class Solution2 {
    public int dayOfYear(String date) {
        // Разбиваем строку на компоненты
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // Массив с накопленным количеством дней до начала каждого месяца
        // (для не високосного года)
        int[] cumulativeDays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int dayOfYear = cumulativeDays[month - 1] + day;

        // Добавляем дополнительный день для февраля и дальше в високосный год
        if (month > 2 && isLeapYear(year)) {
            dayOfYear++;
        }

        return dayOfYear;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
